# Android Architecture Guide - MVI vs MVVM

## Table of Contents

1. [Overview](#overview)
2. [Clean Architecture Foundation](#clean-architecture-foundation)
3. [MVVM Pattern](#mvvm-pattern)
4. [MVI Pattern](#mvi-pattern)
5. [Comparison & Decision Guide](#comparison--decision-guide)
6. [Folder Structure](#folder-structure)
7. [File Purpose & Examples](#file-purpose--examples)
8. [Migration Guide](#migration-guide)

---

## Overview

This project uses **Clean Architecture** as the foundation with two presentation patterns:

- **MVVM (Model-View-ViewModel)**: Traditional reactive pattern for simpler screens
- **MVI (Model-View-Intent)**: Unidirectional data flow for complex state management

Both patterns share the same **Domain** and **Data** layers, differing only in the **Presentation**
layer implementation.

---

## Clean Architecture Foundation

### Three-Layer Architecture

```
┌─────────────────────────────────────────────┐
│         PRESENTATION LAYER                  │
│  (UI, ViewModels, States, Events)          │
│  - Android Framework                        │
│  - Jetpack Compose                          │
│  - ViewModels (MVVM/MVI)                    │
└──────────────┬──────────────────────────────┘
               │ depends on
               ↓
┌─────────────────────────────────────────────┐
│           DOMAIN LAYER                      │
│  (Business Logic, Use Cases, Models)       │
│  - Pure Kotlin                              │
│  - No Android Dependencies                  │
│  - Repository Interfaces                    │
└──────────────┬──────────────────────────────┘
               │ implemented by
               ↓
┌─────────────────────────────────────────────┐
│            DATA LAYER                       │
│  (Repository Impl, API, Database)          │
│  - Retrofit, Room                           │
│  - DTOs, Entities                           │
│  - Data Sources                             │
└─────────────────────────────────────────────┘
```

### Layer Responsibilities

| Layer            | Responsibility        | Dependencies       | Contains                                         |
|------------------|-----------------------|--------------------|--------------------------------------------------|
| **Presentation** | UI & State Management | Domain             | Screens, ViewModels, States, Events, Composables |
| **Domain**       | Business Logic        | None (Pure Kotlin) | Models, Repository Interfaces, Use Cases         |
| **Data**         | Data Operations       | Domain             | Repository Impl, API, DAO, DTOs, Entities        |

---

## MVVM Pattern

### What is MVVM?

**Model-View-ViewModel** is a reactive pattern where:

- **Model**: Data layer (Domain models, Repository)
- **View**: UI layer (Composables)
- **ViewModel**: Presentation logic and state holder

### MVVM Data Flow

```
┌──────────┐        observes        ┌──────────────┐
│   View   │ ←─────────────────────→│  ViewModel   │
│ (Screen) │    calls methods       │              │
└──────────┘                        └───────┬──────┘
                                           │ uses
                                           ↓
                                    ┌──────────────┐
                                    │   Use Case   │
                                    └───────┬──────┘
                                           │ uses
                                           ↓
                                    ┌──────────────┐
                                    │  Repository  │
                                    └──────────────┘
```

### MVVM File Structure

```
feature/profile/
├── data/
│   ├── repository/
│   │   └── ProfileRepositoryImpl.kt
│   ├── remote/
│   │   ├── dto/
│   │   │   └── ProfileDto.kt
│   │   └── ProfileApi.kt
│   └── local/
│       ├── entity/
│       │   └── ProfileEntity.kt
│       └── ProfileDao.kt
├── domain/
│   ├── model/
│   │   └── Profile.kt
│   ├── repository/
│   │   └── ProfileRepository.kt
│   └── usecase/
│       ├── GetUserProfileUseCase.kt
│       └── UpdateProfileUseCase.kt
└── presentation/
    ├── profile/                      # MVVM Structure
    │   ├── ProfileViewModel.kt       # State management & business logic
    │   ├── ProfileScreen.kt          # Composable UI
    │   ├── ProfileUiState.kt         # UI state data class (optional)
    │   └── ProfileUiAction.kt        # One-time UI actions (optional)
    └── components/
        └── ProfileCard.kt
```

### MVVM Files Explained

#### 1. ProfileViewModel.kt

**Purpose**: Manages UI state, handles user actions, and coordinates with use cases

```kotlin
@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUserProfileUseCase: GetUserProfileUseCase,
    private val updateProfileUseCase: UpdateProfileUseCase
) : ViewModel() {

    // State holders - private mutable, public immutable
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState = _uiState.asStateFlow()

    // One-time UI actions (navigation, toasts, snackbars)
    private val _uiAction = Channel<ProfileUiAction>()
    val uiAction = _uiAction.receiveAsFlow()

    init {
        loadProfile()
    }

    // Public methods for user actions
    fun loadProfile() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            getUserProfileUseCase().collect { resource ->
                _uiState.update {
                    when (resource) {
                        is Resource.Loading -> it.copy(isLoading = true)
                        is Resource.Success -> it.copy(
                            isLoading = false,
                            profile = resource.data,
                            error = null
                        )
                        is Resource.Error -> it.copy(
                            isLoading = false,
                            error = resource.message
                        )
                    }
                }
            }
        }
    }

    fun updateName(name: String) {
        _uiState.update { it.copy(profile = it.profile?.copy(name = name)) }
    }

    fun saveProfile() {
        viewModelScope.launch {
            val profile = _uiState.value.profile ?: return@launch

            updateProfileUseCase(profile).collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        _uiAction.send(ProfileUiAction.ShowSuccess("Profile updated"))
                    }
                    is Resource.Error -> {
                        _uiAction.send(ProfileUiAction.ShowError(resource.message))
                    }
                    else -> Unit
                }
            }
        }
    }
}
```

**Key Points**:

- Exposes StateFlow for continuous state
- Uses Channel for one-time actions
- Public methods for each user action
- Coordinates with use cases, not repositories directly

#### 2. ProfileUiState.kt

**Purpose**: Immutable data class representing the complete UI state

```kotlin
data class ProfileUiState(
    val profile: Profile? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isEditing: Boolean = false
)
```

**Key Points**:

- Immutable (val, not var)
- Default values for all properties
- Represents EVERYTHING the UI needs
- Single source of truth

#### 3. ProfileUiAction.kt

**Purpose**: One-time events that don't belong in state (navigation, toasts)

```kotlin
sealed interface ProfileUiAction {
    data class ShowSuccess(val message: String) : ProfileUiAction
    data class ShowError(val message: String) : ProfileUiAction
    data object NavigateBack : ProfileUiAction
    data class NavigateToSettings(val userId: String) : ProfileUiAction
}
```

**Key Points**:

- Sealed interface for type safety
- Used for navigation, dialogs, toasts, snackbars
- Consumed once by the UI
- Does not persist in state

#### 4. ProfileScreen.kt

**Purpose**: Composable that observes ViewModel and renders UI

```kotlin
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    onNavigateToSettings: (String) -> Unit,
    onNavigateBack: () -> Unit
) {
    // Observe state with lifecycle awareness
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    // Handle one-time UI actions
    LaunchedEffect(Unit) {
        viewModel.uiAction.collect { action ->
            when (action) {
                is ProfileUiAction.ShowSuccess -> {
                    // Show snackbar
                }
                is ProfileUiAction.ShowError -> {
                    // Show error dialog
                }
                ProfileUiAction.NavigateBack -> onNavigateBack()
                is ProfileUiAction.NavigateToSettings -> {
                    onNavigateToSettings(action.userId)
                }
            }
        }
    }

    // Stateless content composable
    ProfileContent(
        uiState = uiState,
        onNameChange = viewModel::updateName,
        onSaveClick = viewModel::saveProfile,
        onBackClick = onNavigateBack
    )
}

@Composable
private fun ProfileContent(
    uiState: ProfileUiState,
    onNameChange: (String) -> Unit,
    onSaveClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        when {
            uiState.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            uiState.error != null -> {
                ErrorView(message = uiState.error)
            }
            uiState.profile != null -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(16.dp)
                ) {
                    TextField(
                        value = uiState.profile.name,
                        onValueChange = onNameChange,
                        label = { Text("Name") }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = onSaveClick,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Save Profile")
                    }
                }
            }
        }
    }
}
```

**Key Points**:

- Stateful composable (top level) gets ViewModel
- Stateless composable (content) receives state and callbacks
- LaunchedEffect for one-time action collection
- collectAsStateWithLifecycle for lifecycle awareness

### When to Use MVVM

✅ **Use MVVM for**:

- Simple list screens
- Detail/View screens with minimal interaction
- Forms with 2-5 fields
- Basic CRUD operations
- Straightforward data display

❌ **Avoid MVVM for**:

- Complex multi-step workflows
- Screens with many user interactions
- Real-time collaborative features
- Complex state machines
- Undo/redo functionality

---

## MVI Pattern

### What is MVI?

**Model-View-Intent** is a unidirectional data flow pattern where:

- **Model**: UI State (single immutable state)
- **View**: UI layer (Composables)
- **Intent**: User actions/events

### MVI Data Flow

```
┌──────────┐     Events      ┌──────────────┐
│   View   │ ───────────────→│  ViewModel   │
│ (Screen) │                 │              │
│          │ ←───────────────│  State Flow  │
└──────────┘     State       └───────┬──────┘
                                     │
                                     │ Effects
                                     ↓
                              ┌──────────────┐
                              │   Channel    │
                              │  (One-time)  │
                              └──────────────┘
```

**Flow**:

1. User triggers an Event (Intent)
2. ViewModel processes Event
3. ViewModel updates State immutably
4. View reacts to new State
5. Side Effects emitted via Channel

### MVI File Structure

```
feature/dashboard/
├── data/
│   └── ... (same as MVVM)
├── domain/
│   └── ... (same as MVVM)
└── presentation/
    ├── dashboard/                    # MVI Structure
    │   ├── DashboardViewModel.kt     # Event processor & state manager
    │   ├── DashboardScreen.kt        # Composable UI
    │   ├── DashboardState.kt         # Single immutable state
    │   ├── DashboardEvent.kt         # Sealed interface for user actions
    │   └── DashboardEffect.kt        # One-time side effects
    └── components/
        ├── DashboardCard.kt
        └── FilterSheet.kt
```

### MVI Files Explained

#### 1. DashboardState.kt

**Purpose**: Single immutable data class representing the entire screen state

```kotlin
data class DashboardState(
    val items: List<Item> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val error: String? = null,
    val searchQuery: String = "",
    val selectedFilter: Filter = Filter.ALL,
    val sortOrder: SortOrder = SortOrder.DATE_DESC,
    val pagination: PaginationState = PaginationState()
)

data class PaginationState(
    val currentPage: Int = 0,
    val hasMorePages: Boolean = true,
    val isLoadingMore: Boolean = false
)

enum class Filter { ALL, ACTIVE, COMPLETED, ARCHIVED }
enum class SortOrder { DATE_ASC, DATE_DESC, NAME_ASC, NAME_DESC }
```

**Key Points**:

- Single state object for entire screen
- Immutable with default values
- Nested data classes for complex state
- Enums for fixed options

#### 2. DashboardEvent.kt

**Purpose**: Sealed interface representing all possible user actions

```kotlin
sealed interface DashboardEvent {
    // Data loading
    data object Refresh : DashboardEvent
    data object LoadMore : DashboardEvent
    data object RetryLoadItems : DashboardEvent

    // Search & Filter
    data class SearchQueryChanged(val query: String) : DashboardEvent
    data class FilterSelected(val filter: Filter) : DashboardEvent
    data class SortOrderChanged(val sortOrder: SortOrder) : DashboardEvent

    // Item interactions
    data class ItemClicked(val itemId: String) : DashboardEvent
    data class ItemLongPressed(val itemId: String) : DashboardEvent
    data class ItemDeleted(val itemId: String) : DashboardEvent
    data class ItemStarred(val itemId: String, val starred: Boolean) : DashboardEvent

    // Batch operations
    data class ItemsSelected(val itemIds: List<String>) : DashboardEvent
    data object ClearSelection : DashboardEvent
    data object DeleteSelected : DashboardEvent

    // Navigation
    data object AddNewItemClicked : DashboardEvent
    data object SettingsClicked : DashboardEvent
}
```

**Key Points**:

- Sealed interface for exhaustive when
- Descriptive names (past tense or present)
- Data objects for simple events
- Data classes for events with parameters

#### 3. DashboardEffect.kt

**Purpose**: One-time side effects that don't belong in state

```kotlin
sealed interface DashboardEffect {
    // Navigation
    data class NavigateToDetail(val itemId: String) : DashboardEffect
    data class NavigateToEdit(val itemId: String) : DashboardEffect
    data object NavigateToAddItem : DashboardEffect
    data object NavigateToSettings : DashboardEffect
    data object NavigateBack : DashboardEffect

    // User feedback
    data class ShowSnackbar(val message: String) : DashboardEffect
    data class ShowToast(val message: String) : DashboardEffect
    data class ShowError(val message: String, val action: String? = null) : DashboardEffect

    // Dialogs
    data class ShowDeleteConfirmation(val itemId: String) : DashboardEffect
    data object ShowFilterSheet : DashboardEffect

    // System actions
    data class ShareItem(val itemId: String) : DashboardEffect
    data class OpenUrl(val url: String) : DashboardEffect
}
```

**Key Points**:

- One-time events consumed by UI
- Navigation, dialogs, toasts, snackbars
- System actions (share, open URL)
- Not persisted in state

#### 4. DashboardViewModel.kt

**Purpose**: Processes events, manages state, and emits effects

```kotlin
@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase,
    private val deleteItemUseCase: DeleteItemUseCase,
    private val starItemUseCase: StarItemUseCase
) : ViewModel() {

    // Single state holder
    private val _state = MutableStateFlow(DashboardState())
    val state = _state.asStateFlow()

    // One-time effects
    private val _effect = Channel<DashboardEffect>()
    val effect = _effect.receiveAsFlow()

    init {
        loadItems()
    }

    // Single entry point for all user actions
    fun onEvent(event: DashboardEvent) {
        when (event) {
            is DashboardEvent.Refresh -> refresh()
            is DashboardEvent.LoadMore -> loadMore()
            is DashboardEvent.RetryLoadItems -> loadItems()

            is DashboardEvent.SearchQueryChanged -> updateSearchQuery(event.query)
            is DashboardEvent.FilterSelected -> updateFilter(event.filter)
            is DashboardEvent.SortOrderChanged -> updateSortOrder(event.sortOrder)

            is DashboardEvent.ItemClicked -> handleItemClick(event.itemId)
            is DashboardEvent.ItemDeleted -> deleteItem(event.itemId)
            is DashboardEvent.ItemStarred -> starItem(event.itemId, event.starred)

            is DashboardEvent.AddNewItemClicked -> navigateToAddItem()
            is DashboardEvent.SettingsClicked -> navigateToSettings()
        }
    }

    // Private state update methods
    private fun loadItems() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }

            getItemsUseCase(
                filter = _state.value.selectedFilter,
                sortOrder = _state.value.sortOrder,
                page = 0
            ).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _state.update { it.copy(isLoading = true) }
                    }
                    is Resource.Success -> {
                        _state.update {
                            it.copy(
                                items = resource.data,
                                isLoading = false,
                                error = null,
                                pagination = it.pagination.copy(
                                    currentPage = 0,
                                    hasMorePages = resource.data.size >= 20
                                )
                            )
                        }
                    }
                    is Resource.Error -> {
                        _state.update {
                            it.copy(
                                isLoading = false,
                                error = resource.message
                            )
                        }
                        _effect.send(
                            DashboardEffect.ShowError(
                                message = resource.message,
                                action = "Retry"
                            )
                        )
                    }
                }
            }
        }
    }

    private fun refresh() {
        viewModelScope.launch {
            _state.update { it.copy(isRefreshing = true) }
            // Reload data...
            _state.update { it.copy(isRefreshing = false) }
        }
    }

    private fun updateSearchQuery(query: String) {
        _state.update { it.copy(searchQuery = query) }
        // Debounce and search...
    }

    private fun handleItemClick(itemId: String) {
        viewModelScope.launch {
            _effect.send(DashboardEffect.NavigateToDetail(itemId))
        }
    }

    private fun deleteItem(itemId: String) {
        viewModelScope.launch {
            deleteItemUseCase(itemId).collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        _state.update {
                            it.copy(items = it.items.filter { item -> item.id != itemId })
                        }
                        _effect.send(DashboardEffect.ShowSnackbar("Item deleted"))
                    }
                    is Resource.Error -> {
                        _effect.send(DashboardEffect.ShowError(resource.message))
                    }
                    else -> Unit
                }
            }
        }
    }

    private fun navigateToAddItem() {
        viewModelScope.launch {
            _effect.send(DashboardEffect.NavigateToAddItem)
        }
    }
}
```

**Key Points**:

- Single `onEvent()` method as entry point
- Private methods for each event handler
- Immutable state updates with `copy()`
- Effects sent via Channel
- All business logic in ViewModel, not UI

#### 5. DashboardScreen.kt

**Purpose**: Composable that sends events and observes state

```kotlin
@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel(),
    onNavigateToDetail: (String) -> Unit,
    onNavigateToAddItem: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    // Observe state
    val state by viewModel.state.collectAsStateWithLifecycle()

    // Snackbar state
    val snackbarHostState = remember { SnackbarHostState() }

    // Collect effects
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is DashboardEffect.NavigateToDetail -> {
                    onNavigateToDetail(effect.itemId)
                }
                is DashboardEffect.NavigateToAddItem -> {
                    onNavigateToAddItem()
                }
                is DashboardEffect.NavigateToSettings -> {
                    onNavigateToSettings()
                }
                is DashboardEffect.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(effect.message)
                }
                is DashboardEffect.ShowError -> {
                    snackbarHostState.showSnackbar(
                        message = effect.message,
                        actionLabel = effect.action
                    )
                }
            }
        }
    }

    // Stateless content
    DashboardContent(
        state = state,
        onEvent = viewModel::onEvent,
        snackbarHostState = snackbarHostState
    )
}

@Composable
private fun DashboardContent(
    state: DashboardState,
    onEvent: (DashboardEvent) -> Unit,
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dashboard") },
                actions = {
                    IconButton(onClick = { onEvent(DashboardEvent.SettingsClicked) }) {
                        Icon(Icons.Default.Settings, "Settings")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onEvent(DashboardEvent.AddNewItemClicked) }
            ) {
                Icon(Icons.Default.Add, "Add")
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Search bar
            SearchBar(
                query = state.searchQuery,
                onQueryChange = { query ->
                    onEvent(DashboardEvent.SearchQueryChanged(query))
                }
            )

            // Filters
            FilterRow(
                selectedFilter = state.selectedFilter,
                onFilterSelected = { filter ->
                    onEvent(DashboardEvent.FilterSelected(filter))
                }
            )

            // Items list
            when {
                state.isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                state.error != null -> {
                    ErrorView(
                        message = state.error,
                        onRetry = { onEvent(DashboardEvent.RetryLoadItems) }
                    )
                }
                state.items.isEmpty() -> {
                    EmptyView(message = "No items found")
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(
                            items = state.items,
                            key = { it.id }
                        ) { item ->
                            ItemCard(
                                item = item,
                                onClick = { onEvent(DashboardEvent.ItemClicked(item.id)) },
                                onStarClick = { starred ->
                                    onEvent(DashboardEvent.ItemStarred(item.id, starred))
                                },
                                onDeleteClick = {
                                    onEvent(DashboardEvent.ItemDeleted(item.id))
                                }
                            )
                        }

                        // Load more
                        if (state.pagination.hasMorePages) {
                            item {
                                LoadMoreButton(
                                    isLoading = state.pagination.isLoadingMore,
                                    onClick = { onEvent(DashboardEvent.LoadMore) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
```

**Key Points**:

- Single `onEvent` callback for all interactions
- UI only sends events, no business logic
- Declarative UI based on state
- Effects handled in LaunchedEffect

### When to Use MVI

✅ **Use MVI for**:

- Complex dashboards with filters, sorting, search
- Multi-step forms or wizards
- Real-time collaborative features
- Complex state machines
- Screens with many user interactions
- Features requiring undo/redo
- Time-travel debugging needs

❌ **Avoid MVI for**:

- Simple static content screens
- Basic list/detail views
- Minimal user interaction
- Read-only views

---

## Comparison & Decision Guide

### Side-by-Side Comparison

| Aspect                   | MVVM                | MVI                 |
|--------------------------|---------------------|---------------------|
| **Complexity**           | Lower               | Higher              |
| **Learning Curve**       | Easier              | Steeper             |
| **Boilerplate**          | Less                | More                |
| **State Management**     | Multiple StateFlows | Single State object |
| **Testability**          | Good                | Excellent           |
| **Time Travel Debug**    | No                  | Yes                 |
| **State Predictability** | Good                | Excellent           |
| **Undo/Redo**            | Difficult           | Easy                |
| **Best For**             | Simple screens      | Complex screens     |

### Decision Flowchart

```
Start
  │
  ├─ Is the screen a simple list/detail view?
  │   └─ YES → Use MVVM
  │
  ├─ Does it have 5+ user interactions?
  │   └─ YES → Use MVI
  │
  ├─ Does it need undo/redo?
  │   └─ YES → Use MVI
  │
  ├─ Is it a multi-step form?
  │   └─ YES → Use MVI
  │
  ├─ Does it have complex filters/sorting/search?
  │   └─ YES → Use MVI
  │
  └─ Default → Use MVVM
```

### Real-World Examples

#### Use MVVM For:

1. **Profile Screen**: Display user info, edit name/email
2. **Settings Screen**: Toggle switches, select preferences
3. **Item Detail**: Show item details, edit fields
4. **Simple List**: Display list with pull-to-refresh
5. **Login/Signup**: Basic forms with validation

#### Use MVI For:

1. **Dashboard**: Search, filter, sort, pagination, bulk actions
2. **Shopping Cart**: Add/remove items, quantities, coupons
3. **Task Manager**: Drag-drop, filters, batch operations
4. **Chat Screen**: Real-time messages, typing indicators
5. **Form Wizard**: Multi-step with validation, navigation

---

## Folder Structure

### Complete Project Structure

```
app/src/main/java/com/{package}/
│
├── core/                                    # Shared across all features
│   ├── common/
│   │   ├── Resource.kt                      # Result wrapper (Loading/Success/Error)
│   │   ├── UiEvent.kt                       # Common UI events
│   │   └── Extensions.kt                    # Kotlin extensions
│   │
│   ├── database/
│   │   ├── AppDatabase.kt                   # Room database
│   │   └── TypeConverters.kt                # Room type converters
│   │
│   ├── network/
│   │   ├── ApiClient.kt                     # Retrofit instance
│   │   ├── AuthInterceptor.kt               # Auth token interceptor
│   │   └── WebSocketClient.kt               # WebSocket client
│   │
│   ├── datastore/
│   │   └── PreferencesManager.kt            # DataStore preferences
│   │
│   └── di/                                  # Dependency Injection
│       ├── AppModule.kt                     # Application dependencies
│       ├── DatabaseModule.kt                # Database dependencies
│       └── NetworkModule.kt                 # Network dependencies
│
├── feature/                                 # Feature modules
│   │
│   ├── auth/                               # Authentication feature
│   │   ├── data/
│   │   │   ├── repository/
│   │   │   │   └── AuthRepositoryImpl.kt
│   │   │   ├── remote/
│   │   │   │   ├── dto/
│   │   │   │   │   ├── LoginRequestDto.kt
│   │   │   │   │   └── LoginResponseDto.kt
│   │   │   │   └── AuthApi.kt
│   │   │   └── local/
│   │   │       └── TokenDao.kt
│   │   │
│   │   ├── domain/
│   │   │   ├── model/
│   │   │   │   └── User.kt
│   │   │   ├── repository/
│   │   │   │   └── AuthRepository.kt
│   │   │   └── usecase/
│   │   │       ├── LoginUseCase.kt
│   │   │       └── LogoutUseCase.kt
│   │   │
│   │   ├── presentation/
│   │   │   ├── login/                      # MVVM Example
│   │   │   │   ├── LoginViewModel.kt
│   │   │   │   ├── LoginScreen.kt
│   │   │   │   ├── LoginUiState.kt
│   │   │   │   └── LoginUiAction.kt
│   │   │   │
│   │   │   └── signup/                     # MVVM Example
│   │   │       ├── SignupViewModel.kt
│   │   │       ├── SignupScreen.kt
│   │   │       ├── SignupUiState.kt
│   │   │       └── SignupUiAction.kt
│   │   │
│   │   └── di/
│   │       └── AuthModule.kt
│   │
│   ├── dashboard/                          # Dashboard feature
│   │   ├── data/
│   │   │   ├── repository/
│   │   │   │   └── DashboardRepositoryImpl.kt
│   │   │   ├── remote/
│   │   │   │   ├── dto/
│   │   │   │   │   └── ItemDto.kt
│   │   │   │   └── DashboardApi.kt
│   │   │   └── local/
│   │   │       ├── entity/
│   │   │       │   └── ItemEntity.kt
│   │   │       └── ItemDao.kt
│   │   │
│   │   ├── domain/
│   │   │   ├── model/
│   │   │   │   └── Item.kt
│   │   │   ├── repository/
│   │   │   │   └── DashboardRepository.kt
│   │   │   └── usecase/
│   │   │       ├── GetItemsUseCase.kt
│   │   │       ├── DeleteItemUseCase.kt
│   │   │       └── StarItemUseCase.kt
│   │   │
│   │   ├── presentation/
│   │   │   ├── dashboard/                  # MVI Example
│   │   │   │   ├── DashboardViewModel.kt
│   │   │   │   ├── DashboardScreen.kt
│   │   │   │   ├── DashboardState.kt
│   │   │   │   ├── DashboardEvent.kt
│   │   │   │   └── DashboardEffect.kt
│   │   │   │
│   │   │   └── components/
│   │   │       ├── ItemCard.kt
│   │   │       └── FilterSheet.kt
│   │   │
│   │   └── di/
│   │       └── DashboardModule.kt
│   │
│   └── profile/                            # Profile feature
│       ├── data/
│       │   └── ... (similar structure)
│       ├── domain/
│       │   └── ... (similar structure)
│       └── presentation/
│           ├── profile/                    # MVVM Example
│           │   ├── ProfileViewModel.kt
│           │   ├── ProfileScreen.kt
│           │   ├── ProfileUiState.kt
│           │   └── ProfileUiAction.kt
│           └── components/
│               └── ProfileCard.kt
│
├── ui/                                     # App-wide UI
│   ├── theme/
│   │   ├── Color.kt                        # Color palette
│   │   ├── Theme.kt                        # Material3 theme
│   │   └── Type.kt                         # Typography
│   │
│   ├── components/                         # Shared composables
│   │   ├── AppButton.kt
│   │   ├── AppTextField.kt
│   │   ├── LoadingIndicator.kt
│   │   └── ErrorView.kt
│   │
│   └── navigation/
│       ├── NavDestination.kt               # Navigation destinations
│       └── AppNavGraph.kt                  # Navigation graph
│
└── App.kt                                  # Application class
```

### File Purpose Summary

| File                            | Purpose                          | Layer        |
|---------------------------------|----------------------------------|--------------|
| **{Feature}ViewModel.kt**       | State management, event handling | Presentation |
| **{Feature}Screen.kt**          | Composable UI                    | Presentation |
| **{Feature}State.kt** (MVI)     | Single immutable state           | Presentation |
| **{Feature}Event.kt** (MVI)     | User action intents              | Presentation |
| **{Feature}Effect.kt** (MVI)    | One-time side effects            | Presentation |
| **{Feature}UiState.kt** (MVVM)  | UI state data class              | Presentation |
| **{Feature}UiAction.kt** (MVVM) | One-time UI actions              | Presentation |
| **{Model}.kt**                  | Domain model (pure Kotlin)       | Domain       |
| **{Feature}Repository.kt**      | Repository interface             | Domain       |
| **{Action}UseCase.kt**          | Business logic use case          | Domain       |
| **{Feature}RepositoryImpl.kt**  | Repository implementation        | Data         |
| **{Model}Dto.kt**               | Network data transfer object     | Data         |
| **{Model}Entity.kt**            | Database entity                  | Data         |
| **{Feature}Api.kt**             | Retrofit API interface           | Data         |
| **{Feature}Dao.kt**             | Room DAO interface               | Data         |
| **{Feature}Module.kt**          | Hilt DI module                   | DI           |

---

## Migration Guide

### Converting MVVM to MVI

#### Step 1: Create Event Interface

**Before (MVVM)**:

```kotlin
class ProfileViewModel {
    fun updateName(name: String) {}
    fun saveProfile() {}
}
```

**After (MVI)**:

```kotlin
sealed interface ProfileEvent {
    data class UpdateName(val name: String) : ProfileEvent
    data object SaveProfile : ProfileEvent
}
```

#### Step 2: Create Single State

**Before (MVVM)**:

```kotlin
private val _profile = MutableStateFlow<Profile?>(null)
private val _isLoading = MutableStateFlow(false)
private val _error = MutableStateFlow<String?>(null)
```

**After (MVI)**:

```kotlin
data class ProfileState(
    val profile: Profile? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

private val _state = MutableStateFlow(ProfileState())
```

#### Step 3: Add Event Handler

**Before (MVVM)**:

```kotlin
fun updateName(name: String) {
    _profile.update { it?.copy(name = name) }
}
```

**After (MVI)**:

```kotlin
fun onEvent(event: ProfileEvent) {
    when (event) {
        is ProfileEvent.UpdateName -> updateName(event.name)
        ProfileEvent.SaveProfile -> saveProfile()
    }
}

private fun updateName(name: String) {
    _state.update { it.copy(profile = it.profile?.copy(name = name)) }
}
```

#### Step 4: Update UI

**Before (MVVM)**:

```kotlin
@Composable
fun ProfileScreen(viewModel: ProfileViewModel) {
    val profile by viewModel.profile.collectAsStateWithLifecycle()

    TextField(
        value = profile?.name ?: "",
        onValueChange = viewModel::updateName
    )
}
```

**After (MVI)**:

```kotlin
@Composable
fun ProfileScreen(viewModel: ProfileViewModel) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    TextField(
        value = state.profile?.name ?: "",
        onValueChange = { name ->
            viewModel.onEvent(ProfileEvent.UpdateName(name))
        }
    )
}
```

---

## Summary

### Quick Reference

| Question                  | Answer   |
|---------------------------|----------|
| **Simple screen?**        | Use MVVM |
| **Complex interactions?** | Use MVI  |
| **Need undo/redo?**       | Use MVI  |
| **Multi-step form?**      | Use MVI  |
| **Just display data?**    | Use MVVM |
| **Real-time updates?**    | Use MVI  |

### Key Principles

1. **Both patterns share Domain & Data layers**
2. **MVVM: Multiple StateFlows, direct method calls**
3. **MVI: Single State, Event-based interactions**
4. **Always use Clean Architecture**
5. **Choose pattern based on screen complexity**
6. **Mixing patterns is OK within different features**

### Final Recommendations

- Start with **MVVM** for most screens
- Migrate to **MVI** when complexity increases
- Use **MVI** from the start for dashboards and complex UIs
- Keep Domain and Data layers pattern-agnostic
- Test both patterns to find what works for your team

---

**Need help deciding?** Ask yourself:

- Can I describe the screen state in one sentence? → **MVVM**
- Do I need to track multiple state changes? → **MVI**
