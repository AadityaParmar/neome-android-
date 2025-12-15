# Android Project Rules - Clean Architecture + MVI

## Project Overview

This is a data-heavy Android application built with Jetpack Compose and Material3, following Clean Architecture principles with MVI (Model-View-Intent) pattern for state management.

## Tech Stack

- **UI**: Jetpack Compose + Material3
- **Async**: Coroutines + Flow
- **Lifecycle**: ViewModel + Lifecycle
- **Navigation**: Navigation Compose
- **Database**: Room
- **Networking**: Retrofit + OkHttp + WebSocket
- **Storage**: DataStore + Security Crypto
- **Background**: WorkManager
- **Notification**: Firebase BOM
- **DI**: Hilt
- **Auth**: Google Credentials, MSAL
- **Image Loading**: Coil
- **Testing**: JUnit, MockK, Turbine

---

## Architecture Rules

### Layer Separation (Clean Architecture)

```
presentation → domain ← data
```

- **Presentation** depends on **Domain** only
- **Data** depends on **Domain** only
- **Domain** has NO dependencies on other layers
- Never import `data` classes in `presentation` layer
- Never import Android framework classes in `domain` layer (except coroutines)

### Package Structure

```
app/src/main/java/com/{package}/
├── core/                    # Shared across features
│   ├── common/              # Resource, UiEvent, Extensions
│   ├── database/            # AppDatabase, TypeConverters
│   ├── network/             # ApiClient, Interceptors, WebSocket
│   ├── datastore/           # PreferencesManager
│   └── di/                  # Hilt modules (AppModule, DatabaseModule, NetworkModule)
│
├── feature/{feature_name}/  # Feature modules
│   ├── data/
│   │   ├── repository/      # RepositoryImpl classes
│   │   ├── remote/          # API interfaces, DTOs
│   │   └── local/           # DAOs, Entities
│   ├── domain/
│   │   ├── model/           # Domain models (pure Kotlin)
│   │   ├── repository/      # Repository interfaces
│   │   └── usecase/         # Business logic use cases
│   └── presentation/
│       ├── {screen}/        # Screen-specific (Screen, ViewModel, State, Event)
│       └── components/      # Feature-specific composables
│
├── ui/                      # App-wide UI
│   ├── theme/               # Theme, Color, Type
│   ├── components/          # Shared composables
│   └── navigation/          # NavGraph, Destinations
│
└── App.kt                   # Application class
```

---

## MVI Pattern Rules

### State Management

Every screen MUST have these files in its package:

1. **{Screen}State.kt** - Immutable data class representing UI state
2. **{Screen}Event.kt** - Sealed interface for user actions
3. **{Screen}Effect.kt** (optional) - Sealed interface for one-time events
4. **{Screen}ViewModel.kt** - Manages state and handles events
5. **{Screen}Screen.kt** - Composable UI

### State Class Rules

```kotlin
// ✅ CORRECT - Immutable, default values, single source of truth
data class DashboardState(
    val items: List<Item> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val searchQuery: String = "",
    val pagination: PaginationState = PaginationState()
)

// ❌ WRONG - Mutable, no defaults
data class DashboardState(
    var items: MutableList<Item>,
    var isLoading: Boolean
)
```

### Event Class Rules

```kotlin
// ✅ CORRECT - Sealed interface, descriptive names
sealed interface DashboardEvent {
    data class Search(val query: String) : DashboardEvent
    data class ItemClicked(val id: String) : DashboardEvent
    data object Refresh : DashboardEvent
    data object LoadMore : DashboardEvent
}

// ❌ WRONG - Generic names, not sealed
interface DashboardEvent
class Click(val id: String) : DashboardEvent
```

### Effect Class Rules (One-time events)

```kotlin
// ✅ CORRECT - For navigation, snackbars, toasts
sealed interface DashboardEffect {
    data class NavigateToDetail(val id: String) : DashboardEffect
    data class ShowSnackbar(val message: String) : DashboardEffect
    data object NavigateBack : DashboardEffect
}
```

### ViewModel Rules

```kotlin
@HiltViewModel
class FeatureViewModel @Inject constructor(
    private val useCase: SomeUseCase
) : ViewModel() {

    // ✅ CORRECT - Private MutableStateFlow, public StateFlow
    private val _state = MutableStateFlow(FeatureState())
    val state = _state.asStateFlow()

    // ✅ CORRECT - Channel for one-time effects
    private val _effect = Channel<FeatureEffect>()
    val effect = _effect.receiveAsFlow()

    // ✅ CORRECT - Single entry point for events
    fun onEvent(event: FeatureEvent) {
        when (event) {
            is FeatureEvent.Load -> loadData()
            is FeatureEvent.Refresh -> refresh()
        }
    }

    // ✅ CORRECT - Update state immutably
    private fun loadData() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            // ...
        }
    }
}
```

### Screen Composable Rules

```kotlin
@Composable
fun FeatureScreen(
    viewModel: FeatureViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit
) {
    // ✅ CORRECT - collectAsStateWithLifecycle for lifecycle awareness
    val state by viewModel.state.collectAsStateWithLifecycle()

    // ✅ CORRECT - LaunchedEffect for one-time effects
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is FeatureEffect.Navigate -> onNavigate(effect.route)
            }
        }
    }

    // ✅ CORRECT - Separate stateless content composable
    FeatureContent(
        state = state,
        onEvent = viewModel::onEvent
    )
}

// ✅ CORRECT - Stateless, testable, previewable
@Composable
private fun FeatureContent(
    state: FeatureState,
    onEvent: (FeatureEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // UI implementation
}
```

---

## Data Layer Rules

### Repository Pattern

```kotlin
// domain/repository/ItemRepository.kt (Interface)
interface ItemRepository {
    fun getItems(filter: String, page: Int): Flow<Resource<List<Item>>>
    suspend fun saveItem(item: Item): Result<Unit>
}

// data/repository/ItemRepositoryImpl.kt (Implementation)
class ItemRepositoryImpl @Inject constructor(
    private val api: ItemApi,
    private val dao: ItemDao
) : ItemRepository {
    // Implementation with offline-first strategy
}
```

### Offline-First Strategy

```kotlin
// ✅ CORRECT - Emit cache first, then fetch fresh
override fun getItems(): Flow<Resource<List<Item>>> = flow {
    emit(Resource.Loading)
    
    // 1. Emit cached data immediately
    val cached = dao.getAll()
    if (cached.isNotEmpty()) {
        emit(Resource.Success(cached.map { it.toDomain() }))
    }
    
    // 2. Fetch fresh data
    try {
        val remote = api.getItems()
        dao.upsertAll(remote.map { it.toEntity() })
        emit(Resource.Success(remote.map { it.toDomain() }))
    } catch (e: Exception) {
        if (cached.isEmpty()) {
            emit(Resource.Error(e.message ?: "Unknown error"))
        }
    }
}.flowOn(Dispatchers.IO)
```

### DTO/Entity/Domain Model Mapping

```kotlin
// data/remote/dto/ItemDto.kt - Network response
data class ItemDto(
    @SerializedName("item_id") val id: String,
    @SerializedName("item_name") val name: String
) {
    fun toEntity() = ItemEntity(id = id, name = name)
    fun toDomain() = Item(id = id, name = name)
}

// data/local/entity/ItemEntity.kt - Database entity
@Entity(tableName = "items")
data class ItemEntity(
    @PrimaryKey val id: String,
    val name: String
) {
    fun toDomain() = Item(id = id, name = name)
}

// domain/model/Item.kt - Domain model (pure Kotlin)
data class Item(
    val id: String,
    val name: String
)
```

---

## Use Case Rules

```kotlin
// ✅ CORRECT - Single responsibility, invoke operator
class GetItemsUseCase @Inject constructor(
    private val repository: ItemRepository
) {
    operator fun invoke(filter: String, page: Int): Flow<Resource<List<Item>>> {
        return repository.getItems(filter, page)
    }
}

// ✅ CORRECT - Business logic in use case
class ValidateEmailUseCase @Inject constructor() {
    operator fun invoke(email: String): ValidationResult {
        if (email.isBlank()) return ValidationResult.Error("Email required")
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult.Error("Invalid email format")
        }
        return ValidationResult.Success
    }
}
```

---

## Dependency Injection Rules

### Module Organization

```kotlin
// core/di/AppModule.kt - Application-scoped dependencies
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context = context
}

// core/di/NetworkModule.kt - Network dependencies
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor())
        .build()
}

// core/di/DatabaseModule.kt - Database dependencies
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_db").build()
}

// feature/{feature}/di/{Feature}Module.kt - Feature-specific dependencies
@Module
@InstallIn(ViewModelComponent::class)
abstract class DashboardModule {
    @Binds
    abstract fun bindRepository(impl: DashboardRepositoryImpl): DashboardRepository
}
```

---

## Compose UI Rules

### Component Guidelines

```kotlin
// ✅ CORRECT - Stateless, modifier parameter, default values
@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled && !isLoading
    ) {
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.size(16.dp))
        } else {
            Text(text)
        }
    }
}

// ❌ WRONG - Stateful, no modifier, hardcoded values
@Composable
fun CustomButton(text: String) {
    var clicked by remember { mutableStateOf(false) }
    Button(onClick = { clicked = true }) {
        Text(text)
    }
}
```

### Preview Rules

```kotlin
// ✅ CORRECT - Multiple previews for different states
@Preview(showBackground = true)
@Composable
private fun FeatureContentPreview() {
    AppTheme {
        FeatureContent(
            state = FeatureState(items = listOf(sampleItem)),
            onEvent = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FeatureContentLoadingPreview() {
    AppTheme {
        FeatureContent(
            state = FeatureState(isLoading = true),
            onEvent = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FeatureContentErrorPreview() {
    AppTheme {
        FeatureContent(
            state = FeatureState(error = "Network error"),
            onEvent = {}
        )
    }
}
```

---

## Resource Wrapper

```kotlin
// core/common/Resource.kt
sealed class Resource<out T> {
    data object Loading : Resource<Nothing>()
    data class Success<T>(val data: T) : Resource<T>()
    data class Error(val message: String, val throwable: Throwable? = null) : Resource<Nothing>()

    val isLoading get() = this is Loading
    val isSuccess get() = this is Success
    val isError get() = this is Error
    
    fun getOrNull(): T? = (this as? Success)?.data
}

// Extension function
fun <T> Flow<T>.asResource(): Flow<Resource<T>> = flow {
    emit(Resource.Loading)
    try {
        collect { emit(Resource.Success(it)) }
    } catch (e: Exception) {
        emit(Resource.Error(e.message ?: "Unknown error", e))
    }
}
```

---

## Navigation Rules

```kotlin
// ui/navigation/NavDestination.kt
sealed class NavDestination(val route: String) {
    data object Dashboard : NavDestination("dashboard")
    data object Detail : NavDestination("detail/{id}") {
        fun createRoute(id: String) = "detail/$id"
    }
}

// ui/navigation/AppNavGraph.kt
@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NavDestination.Dashboard.route,
        modifier = modifier
    ) {
        composable(NavDestination.Dashboard.route) {
            DashboardScreen(
                onNavigateToDetail = { id ->
                    navController.navigate(NavDestination.Detail.createRoute(id))
                }
            )
        }
        composable(
            route = NavDestination.Detail.route,
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: return@composable
            DetailScreen(itemId = id)
        }
    }
}
```

---

## Testing Rules

### ViewModel Testing

```kotlin
@OptIn(ExperimentalCoroutinesApi::class)
class DashboardViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: DashboardViewModel
    private lateinit var getItemsUseCase: GetItemsUseCase

    @Before
    fun setup() {
        getItemsUseCase = mockk()
        viewModel = DashboardViewModel(getItemsUseCase)
    }

    @Test
    fun `when refresh event, should update state with new items`() = runTest {
        // Given
        val items = listOf(Item("1", "Test"))
        coEvery { getItemsUseCase() } returns flowOf(Resource.Success(items))

        // When
        viewModel.onEvent(DashboardEvent.Refresh)

        // Then
        viewModel.state.test {
            val state = awaitItem()
            assertEquals(items, state.items)
            assertEquals(false, state.isLoading)
        }
    }
}
```

### Repository Testing

```kotlin
class ItemRepositoryImplTest {

    private lateinit var repository: ItemRepositoryImpl
    private lateinit var api: ItemApi
    private lateinit var dao: ItemDao

    @Before
    fun setup() {
        api = mockk()
        dao = mockk()
        repository = ItemRepositoryImpl(api, dao)
    }

    @Test
    fun `should emit cached data first then fresh data`() = runTest {
        // Given
        val cached = listOf(ItemEntity("1", "Cached"))
        val remote = listOf(ItemDto("1", "Fresh"))
        
        coEvery { dao.getAll() } returns cached
        coEvery { api.getItems() } returns remote
        coEvery { dao.upsertAll(any()) } just Runs

        // When & Then
        repository.getItems().test {
            assertEquals(Resource.Loading, awaitItem())
            assertEquals(Resource.Success(cached.map { it.toDomain() }), awaitItem())
            assertEquals(Resource.Success(remote.map { it.toDomain() }), awaitItem())
            awaitComplete()
        }
    }
}
```

---

## Naming Conventions

| Type | Convention | Example |
|------|------------|---------|
| Feature Package | lowercase, singular | `feature/dashboard` |
| Screen | PascalCase + Screen | `DashboardScreen` |
| ViewModel | PascalCase + ViewModel | `DashboardViewModel` |
| State | PascalCase + State | `DashboardState` |
| Event | PascalCase + Event | `DashboardEvent` |
| Effect | PascalCase + Effect | `DashboardEffect` |
| UseCase | Verb + UseCase | `GetItemsUseCase` |
| Repository | Noun + Repository | `ItemRepository` |
| DAO | Noun + Dao | `ItemDao` |
| Entity | Noun + Entity | `ItemEntity` |
| DTO | Noun + Dto | `ItemDto` |
| API | Noun + Api | `ItemApi` |
| Module | Noun + Module | `NetworkModule` |

---

## Code Generation Checklist

When creating a new feature, generate files in this order:

1. **Domain Layer**
   - [ ] `domain/model/{Model}.kt`
   - [ ] `domain/repository/{Feature}Repository.kt`
   - [ ] `domain/usecase/{Action}UseCase.kt`

2. **Data Layer**
   - [ ] `data/remote/dto/{Model}Dto.kt`
   - [ ] `data/remote/{Feature}Api.kt`
   - [ ] `data/local/entity/{Model}Entity.kt`
   - [ ] `data/local/{Feature}Dao.kt`
   - [ ] `data/repository/{Feature}RepositoryImpl.kt`

3. **Presentation Layer**
   - [ ] `presentation/{screen}/{Screen}State.kt`
   - [ ] `presentation/{screen}/{Screen}Event.kt`
   - [ ] `presentation/{screen}/{Screen}Effect.kt` (if needed)
   - [ ] `presentation/{screen}/{Screen}ViewModel.kt`
   - [ ] `presentation/{screen}/{Screen}Screen.kt`
   - [ ] `presentation/components/{Component}.kt` (if needed)

4. **DI**
   - [ ] `di/{Feature}Module.kt`

5. **Navigation**
   - [ ] Add destination to `NavDestination.kt`
   - [ ] Add composable to `AppNavGraph.kt`

---

## Deprecation Rules

### ALWAYS Use Non-Deprecated APIs

**CRITICAL**: Always use the latest non-deprecated classes, methods, and APIs. Check for deprecation warnings and use recommended replacements.

### Common Deprecated → Replacement

| Deprecated | Use Instead |
|------------|-------------|
| `LiveData` in new code | `StateFlow` / `SharedFlow` |
| `viewModelScope.launch` with `liveData` | `viewModelScope.launch` with `Flow` |
| `onActivityResult` | `ActivityResultContracts` |
| `startActivityForResult` | `registerForActivityResult` |
| `AsyncTask` | `Coroutines` |
| `Loader` | `ViewModel` + `Flow` |
| `LocalBroadcastManager` | `Flow` / `SharedFlow` / `EventBus` |
| `Handler(Looper)` constructor | `Handler(Looper.getMainLooper())` or coroutines |
| `PackageManager.GET_*` flags | `PackageManager.PackageInfoFlags.of()` (API 33+) |
| `Environment.getExternalStorageDirectory()` | `Context.getExternalFilesDir()` |
| `Notification.Builder(context)` | `NotificationCompat.Builder(context, channelId)` |
| `Html.fromHtml(string)` | `Html.fromHtml(string, Html.FROM_HTML_MODE_LEGACY)` |
| `getColor(int)` | `ContextCompat.getColor(context, int)` |
| `getDrawable(int)` | `ContextCompat.getDrawable(context, int)` |
| `requestPermissions` in Activity | `ActivityResultContracts.RequestPermission` |
| `onBackPressed()` | `OnBackPressedCallback` / `OnBackPressedDispatcher` |
| `supportFragmentManager.beginTransaction()` for navigation | `Navigation Component` |
| `kotlin-android-extensions` | `ViewBinding` / `Compose` |
| `kapt` (where possible) | `ksp` |

### Jetpack Compose Specific

| Deprecated | Use Instead |
|------------|-------------|
| `accompanist-systemuicontroller` | `enableEdgeToEdge()` + `WindowInsets` |
| `accompanist-pager` | `androidx.compose.foundation.pager` |
| `accompanist-navigation-animation` | Built-in `navigation-compose` animation |
| `accompanist-swiperefresh` | `material3.pulltorefresh` |
| `accompanist-permissions` | Still valid, but check latest version |
| `collectAsState()` | `collectAsStateWithLifecycle()` |
| `rememberCoroutineScope` for ViewModel calls | Direct `viewModel.onEvent()` |
| `@ExperimentalMaterial3Api` (check if still needed) | Remove if API is stable |

### Material/UI Components

| Deprecated | Use Instead |
|------------|-------------|
| Material2 `TopAppBar` | Material3 `TopAppBar` / `CenterAlignedTopAppBar` |
| Material2 `BottomNavigation` | Material3 `NavigationBar` |
| Material2 `BottomDrawer` | Material3 `ModalBottomSheet` |
| `Scaffold` with `scaffoldState` | `Scaffold` with `SnackbarHostState` |
| `rememberScaffoldState()` | `remember { SnackbarHostState() }` |

### Coroutines/Flow

| Deprecated | Use Instead |
|------------|-------------|
| `flowOn` after `collect` | `flowOn` before `collect` |
| `BroadcastChannel` | `SharedFlow` |
| `ConflatedBroadcastChannel` | `StateFlow` |
| `Channel.sendBlocking` | `Channel.trySend` |
| `callbackFlow { sendBlocking }` | `callbackFlow { trySend }` |

### Room Database

| Deprecated | Use Instead |
|------------|-------------|
| `@Query` returning `LiveData` | `@Query` returning `Flow` |
| `allowMainThreadQueries()` | Coroutines with `Dispatchers.IO` |
| `Room.databaseBuilder().fallbackToDestructiveMigration()` | Proper migrations |

### Hilt/DI

| Deprecated | Use Instead |
|------------|-------------|
| `@ViewModelInject` | `@HiltViewModel` + `@Inject constructor` |
| `@Assisted` in ViewModel | `@AssistedInject` with `@AssistedFactory` |

### Network/Retrofit

| Deprecated | Use Instead |
|------------|-------------|
| `Call<T>` with callbacks | `suspend fun` returning `T` or `Response<T>` |
| `@Headers` with dynamic values | `@Header` parameter |
| RxJava adapters | Coroutines adapter (built-in) |

### Build Configuration

```kotlin
// ❌ Deprecated - build.gradle
android {
    buildToolsVersion "33.0.0"  // Often unnecessary now
}

// ✅ Current - build.gradle.kts
android {
    compileSdk = 35
    defaultConfig {
        minSdk = 26
        targetSdk = 35
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

// ❌ Deprecated plugin
plugins {
    id("kotlin-android-extensions")  // Removed
    id("kotlin-kapt")  // Use KSP when possible
}

// ✅ Current
plugins {
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}
```

### Code Examples

```kotlin
// ❌ DEPRECATED - Using LiveData
class MyViewModel : ViewModel() {
    private val _data = MutableLiveData<List<Item>>()
    val data: LiveData<List<Item>> = _data
}

// ✅ CURRENT - Using StateFlow
class MyViewModel : ViewModel() {
    private val _data = MutableStateFlow<List<Item>>(emptyList())
    val data = _data.asStateFlow()
}

// ❌ DEPRECATED - onBackPressed
override fun onBackPressed() {
    if (shouldHandleBack) handleBack()
    else super.onBackPressed()
}

// ✅ CURRENT - OnBackPressedCallback
val callback = object : OnBackPressedCallback(true) {
    override fun handleOnBackPressed() {
        if (shouldHandleBack) handleBack()
        else isEnabled = false
    }
}
onBackPressedDispatcher.addCallback(this, callback)

// ❌ DEPRECATED - Activity Result
override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
}

// ✅ CURRENT - ActivityResultContracts
val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
    if (result.resultCode == RESULT_OK) {
        // Handle result
    }
}

// ❌ DEPRECATED - collectAsState
@Composable
fun Screen(viewModel: MyViewModel) {
    val state by viewModel.state.collectAsState()
}

// ✅ CURRENT - collectAsStateWithLifecycle
@Composable
fun Screen(viewModel: MyViewModel) {
    val state by viewModel.state.collectAsStateWithLifecycle()
}

// ❌ DEPRECATED - Old Scaffold
@Composable
fun MyScreen() {
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState) { }
}

// ✅ CURRENT - New Scaffold
@Composable
fun MyScreen() {
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { }
}
```

### Proactive Deprecation Check

When generating code:
1. **Check Android API level** - Use `@RequiresApi` or compat libraries
2. **Check library versions** - Use latest stable versions
3. **Check Compose BOM** - Use latest Compose BOM for coordinated versions
4. **Suppress only when necessary** - `@Suppress("DEPRECATION")` only if no alternative exists

```kotlin
// build.gradle.kts - Always use latest stable versions
dependencies {
    // Compose BOM for coordinated versions
    implementation(platform("androidx.compose:compose-bom:2024.12.01"))
    
    // Use lifecycle-runtime-compose for collectAsStateWithLifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")
}
```

---

## Anti-Patterns to Avoid

### ❌ Never Do This

```kotlin
// ❌ Mutable state in ViewModel
var items = mutableListOf<Item>()

// ❌ Business logic in Composable
@Composable
fun Screen() {
    val filteredItems = items.filter { it.isActive }  // Move to ViewModel
}

// ❌ Direct API call in ViewModel
viewModelScope.launch {
    val response = retrofit.create(Api::class.java).getItems()  // Use Repository
}

// ❌ Android imports in Domain layer
import android.content.Context  // Not allowed in domain

// ❌ Exposing MutableStateFlow
val state = MutableStateFlow(State())  // Should be private

// ❌ Multiple sources of truth
val items = dao.getAll()  // Should flow through Repository
val remoteItems = api.getItems()

// ❌ Hardcoded strings in UI
Text("Loading...")  // Use string resources

// ❌ Nested callbacks
api.getItems { items ->
    items.forEach { item ->
        api.getDetail(item.id) { detail ->  // Use coroutines/Flow
        }
    }
}
```

---

## Performance Guidelines

1. **Use `LazyColumn`/`LazyRow`** for lists, never `Column` with `forEach`
2. **Use `key`** parameter in lazy lists for stable recomposition
3. **Use `remember`** for expensive calculations
4. **Use `derivedStateOf`** for computed values that trigger recomposition
5. **Use `Dispatchers.IO`** for database/network operations
6. **Use `flowOn(Dispatchers.IO)`** in repository flows
7. **Debounce** search queries (300-500ms)
8. **Paginate** large datasets (50-100 items per page)
9. **Use `collectAsStateWithLifecycle`** instead of `collectAsState`
