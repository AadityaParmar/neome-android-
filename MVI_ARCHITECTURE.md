# MVI Architecture for Jetpack Compose

## Overview

A production-ready, type-safe MVI (Model-View-Intent) architecture implementation for Android with
Jetpack Compose. This guide provides a complete, scalable foundation with middleware support, proper
effect handling, and testing utilities.

## Architecture Diagram

```
┌─────────────────────────────────────────────────────────────────┐
│                         COMPOSE UI                               │
│  ┌─────────────┐    ┌─────────────┐    ┌─────────────────────┐  │
│  │   Screen    │───▶│   Content   │───▶│  Stateless Components│  │
│  │ (Lifecycle) │    │  (State)    │    │     (Preview-able)   │  │
│  └─────────────┘    └─────────────┘    └─────────────────────┘  │
│         │                  ▲                                     │
│         │ collect          │ state                               │
│         ▼                  │                                     │
│  ┌─────────────────────────┴───────────────────────────────────┐│
│  │                      ViewModel                               ││
│  │  ┌──────────┐   ┌──────────┐   ┌──────────┐   ┌──────────┐ ││
│  │  │  Event   │──▶│Middleware│──▶│ Reducer  │──▶│  State   │ ││
│  │  │ Channel  │   │  Chain   │   │  (Pure)  │   │  Flow    │ ││
│  │  └──────────┘   └──────────┘   └──────────┘   └──────────┘ ││
│  │        │                             │                       ││
│  │        │                             ▼                       ││
│  │        │                      ┌──────────┐                   ││
│  │        └─────────────────────▶│  Effect  │                   ││
│  │           side effects        │ Channel  │                   ││
│  │                               └──────────┘                   ││
│  └──────────────────────────────────────────────────────────────┘│
└─────────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────────┐
│                       DOMAIN LAYER                               │
│  ┌─────────────┐    ┌─────────────┐    ┌─────────────────────┐  │
│  │  UseCases   │    │  Repository │    │      Entities       │  │
│  │             │───▶│  Interfaces │───▶│                     │  │
│  └─────────────┘    └─────────────┘    └─────────────────────┘  │
└─────────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────────┐
│                        DATA LAYER                                │
│  ┌─────────────┐    ┌─────────────┐    ┌─────────────────────┐  │
│  │ Repository  │    │ DataSources │    │   API / Database    │  │
│  │    Impl     │───▶│ Local/Remote│───▶│                     │  │
│  └─────────────┘    └─────────────┘    └─────────────────────┘  │
└─────────────────────────────────────────────────────────────────┘
```

## File Structure

```
app/src/main/java/com/example/app/
├── core/
│   └── mvi/
│       ├── MviViewModel.kt          # Base ViewModel
│       ├── UiState.kt               # State marker interface
│       ├── UiEvent.kt               # Event marker interface
│       ├── UiEffect.kt              # Effect marker interface
│       ├── Reducer.kt               # Reducer interface
│       ├── Middleware.kt            # Middleware interface
│       ├── middleware/
│       │   ├── LoggingMiddleware.kt
│       │   ├── AnalyticsMiddleware.kt
│       │   └── ErrorMiddleware.kt
│       └── extensions/
│           └── ComposeExtensions.kt # Compose helpers
├── feature/
│   └── home/
│       ├── HomeScreen.kt            # Composable screen
│       ├── HomeContent.kt           # Stateless content
│       ├── HomeViewModel.kt         # Feature ViewModel
│       ├── HomeContract.kt          # State/Event/Effect definitions
│       └── components/              # Feature-specific components
└── di/
    └── MviModule.kt                 # Hilt module for middlewares
```

---

## Core Contracts

### File: `core/mvi/UiState.kt`

```kotlin
package com.example.app.core.mvi

import androidx.compose.runtime.Immutable

/**
 * Marker interface for UI state.
 * All state classes must be immutable and implement this interface.
 */
@Immutable
interface UiState

/**
 * Common loading states that can be composed into any UiState
 */
enum class LoadingState {
    Idle,
    Loading,
    Refreshing,
    LoadingMore
}

/**
 * Wrapper for async data with loading/error states
 */
@Immutable
sealed interface AsyncData<out T> {
    data object Uninitialized : AsyncData<Nothing>
    data object Loading : AsyncData<Nothing>
    data class Success<T>(val data: T) : AsyncData<T>
    data class Error(val message: String, val throwable: Throwable? = null) : AsyncData<Nothing>

    val dataOrNull: T? get() = (this as? Success)?.data
    val isLoading: Boolean get() = this is Loading
    val isSuccess: Boolean get() = this is Success
    val isError: Boolean get() = this is Error
}

/**
 * Extension to map AsyncData
 */
inline fun <T, R> AsyncData<T>.map(transform: (T) -> R): AsyncData<R> = when (this) {
    is AsyncData.Uninitialized -> AsyncData.Uninitialized
    is AsyncData.Loading -> AsyncData.Loading
    is AsyncData.Success -> AsyncData.Success(transform(data))
    is AsyncData.Error -> this
}
```

### File: `core/mvi/UiEvent.kt`

```kotlin
package com.example.app.core.mvi

/**
 * Marker interface for UI events (intents).
 * Events represent user actions or system events that trigger state changes.
 *
 * Best Practices:
 * - Use sealed interface for exhaustive when expressions
 * - Use data class for events with parameters
 * - Use data object for events without parameters
 */
interface UiEvent
```

### File: `core/mvi/UiEffect.kt`

```kotlin
package com.example.app.core.mvi

/**
 * Marker interface for one-time side effects.
 * Effects are consumed once and not persisted in state.
 *
 * Examples:
 * - Navigation
 * - Showing snackbar/toast
 * - Triggering haptic feedback
 * - Opening external app/URL
 */
interface UiEffect
```

---

## Reducer Interface

### File: `core/mvi/Reducer.kt`

```kotlin
package com.example.app.core.mvi

/**
 * Pure function that takes current state and event, returns new state.
 * Reducers must be pure functions with no side effects.
 *
 * @param State The UI state type
 * @param Event The UI event type
 */
fun interface Reducer<State : UiState, Event : UiEvent> {
    /**
     * Reduces the current state based on the event.
     *
     * @param state Current state
     * @param event Event to process
     * @return New state (can be same instance if no change needed)
     */
    fun reduce(state: State, event: Event): State
}

/**
 * Composable reducer that combines multiple reducers.
 * Useful for modular state management in complex screens.
 */
class CompositeReducer<State : UiState, Event : UiEvent>(
    private val reducers: List<Reducer<State, Event>>
) : Reducer<State, Event> {

    override fun reduce(state: State, event: Event): State {
        return reducers.fold(state) { currentState, reducer ->
            reducer.reduce(currentState, event)
        }
    }

    companion object {
        fun <S : UiState, E : UiEvent> of(vararg reducers: Reducer<S, E>): CompositeReducer<S, E> {
            return CompositeReducer(reducers.toList())
        }
    }
}
```

---

## Middleware System

### File: `core/mvi/Middleware.kt`

```kotlin
package com.example.app.core.mvi

/**
 * Middleware intercepts events before they reach the reducer.
 * Use for cross-cutting concerns like logging, analytics, error handling.
 *
 * Middleware chain executes in order: first added = first executed.
 */
fun interface Middleware<State : UiState, Event : UiEvent> {

    /**
     * Process an event with access to current state.
     *
     * @param event The event being processed
     * @param currentState The current state when event was dispatched
     * @param next Call this to pass event to next middleware (or reducer if last)
     */
    suspend fun process(
        event: Event,
        currentState: State,
        next: suspend (Event) -> Unit
    )
}

/**
 * Middleware that can transform events before passing them on.
 */
abstract class TransformingMiddleware<State : UiState, Event : UiEvent> : Middleware<State, Event> {

    override suspend fun process(
        event: Event,
        currentState: State,
        next: suspend (Event) -> Unit
    ) {
        val transformedEvent = transform(event, currentState)
        if (transformedEvent != null) {
            next(transformedEvent)
        }
        // If null returned, event is consumed/blocked
    }

    /**
     * Transform or filter the event.
     * @return Transformed event, or null to consume/block the event
     */
    abstract suspend fun transform(event: Event, currentState: State): Event?
}

/**
 * Middleware that only observes events without modifying them.
 */
abstract class ObservingMiddleware<State : UiState, Event : UiEvent> : Middleware<State, Event> {

    override suspend fun process(
        event: Event,
        currentState: State,
        next: suspend (Event) -> Unit
    ) {
        observe(event, currentState)
        next(event)
    }

    abstract suspend fun observe(event: Event, currentState: State)
}
```

### File: `core/mvi/middleware/LoggingMiddleware.kt`

```kotlin
package com.example.app.core.mvi.middleware

import android.util.Log
import com.example.app.core.mvi.Middleware
import com.example.app.core.mvi.ObservingMiddleware
import com.example.app.core.mvi.UiEvent
import com.example.app.core.mvi.UiState
import javax.inject.Inject

/**
 * Logs all events and state transitions for debugging.
 * Only active in debug builds.
 */
class LoggingMiddleware<State : UiState, Event : UiEvent> @Inject constructor(
    private val tag: String = "MVI",
    private val isEnabled: Boolean = true // Set to BuildConfig.DEBUG in production
) : ObservingMiddleware<State, Event>() {
    
    override suspend fun observe(event: Event, currentState: State) {
        if (isEnabled) {
            Log.d(tag, """
                |┌─────────────────────────────────────
                |│ Event: ${event::class.simpleName}
                |│ Data: $event
                |│ Current State: ${currentState::class.simpleName}
                |└─────────────────────────────────────
            """.trimMargin())
        }
    }
}
```

### File: `core/mvi/middleware/AnalyticsMiddleware.kt`

```kotlin
package com.example.app.core.mvi.middleware

import com.example.app.core.mvi.ObservingMiddleware
import com.example.app.core.mvi.UiEvent
import com.example.app.core.mvi.UiState
import javax.inject.Inject

/**
 * Tracks events marked with @Trackable annotation.
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Trackable(val eventName: String = "")

interface AnalyticsTracker {
    fun track(eventName: String, params: Map<String, Any?>)
}

class AnalyticsMiddleware<State : UiState, Event : UiEvent> @Inject constructor(
    private val tracker: AnalyticsTracker
) : ObservingMiddleware<State, Event>() {

    override suspend fun observe(event: Event, currentState: State) {
        val trackable = event::class.annotations
            .filterIsInstance<Trackable>()
            .firstOrNull()

        if (trackable != null) {
            val eventName = trackable.eventName.ifEmpty { event::class.simpleName ?: "Unknown" }
            tracker.track(eventName, extractParams(event))
        }
    }

    private fun extractParams(event: Event): Map<String, Any?> {
        // Use reflection or sealed class pattern to extract params
        return event::class.java.declaredFields
            .filter { !it.isSynthetic }
            .associate { field ->
                field.isAccessible = true
                field.name to field.get(event)
            }
    }
}
```

### File: `core/mvi/middleware/ErrorMiddleware.kt`

```kotlin
package com.example.app.core.mvi.middleware

import com.example.app.core.mvi.Middleware
import com.example.app.core.mvi.UiEvent
import com.example.app.core.mvi.UiState
import javax.inject.Inject
import kotlinx.coroutines.CancellationException

/**
 * Catches exceptions during event processing and converts them to error events.
 */
class ErrorMiddleware<State : UiState, Event : UiEvent> @Inject constructor(
    private val errorEventFactory: (Throwable) -> Event
) : Middleware<State, Event> {
    
    override suspend fun process(
        event: Event,
        currentState: State,
        next: suspend (Event) -> Unit
    ) {
        try {
            next(event)
        } catch (e: CancellationException) {
            throw e // Don't catch cancellation
        } catch (e: Throwable) {
            next(errorEventFactory(e))
        }
    }
}
```

---

## Base ViewModel

### File: `core/mvi/MviViewModel.kt`

```kotlin
package com.example.app.core.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 * Base ViewModel implementing MVI pattern with:
 * - Type-safe state management
 * - One-time effects via Channel
 * - Middleware support for cross-cutting concerns
 * - Thread-safe state updates
 * 
 * @param State Immutable UI state type
 * @param Event User action/intent type  
 * @param Effect One-time side effect type
 * @param initialState Starting state
 */
abstract class MviViewModel<State : UiState, Event : UiEvent, Effect : UiEffect>(
    initialState: State
) : ViewModel() {

    // region State Management
    
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state.asStateFlow()
    
    /**
     * Current state value. Use for reading state in ViewModel.
     * For UI, always collect `state` flow.
     */
    protected val currentState: State get() = _state.value
    
    private val stateMutex = Mutex()
    
    // endregion

    // region Effects
    
    private val _effect = Channel<Effect>(Channel.BUFFERED)
    val effect: Flow<Effect> = _effect.receiveAsFlow()
    
    // endregion

    // region Events
    
    private val _event = MutableSharedFlow<Event>(extraBufferCapacity = 64)
    
    // endregion

    // region Middleware
    
    private val middlewares = mutableListOf<Middleware<State, Event>>()
    
    /**
     * Add middleware to the processing chain.
     * Order matters: first added = first executed.
     */
    protected fun addMiddleware(middleware: Middleware<State, Event>) {
        middlewares.add(middleware)
    }
    
    /**
     * Add multiple middlewares at once.
     */
    protected fun addMiddlewares(vararg middleware: Middleware<State, Event>) {
        middlewares.addAll(middleware)
    }
    
    // endregion

    init {
        viewModelScope.launch {
            _event.collect { event ->
                processEventWithMiddleware(event)
            }
        }
    }

    // region Public API
    
    /**
     * Dispatch an event to be processed.
     * Safe to call from any thread.
     */
    fun onEvent(event: Event) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }
    
    /**
     * Dispatch multiple events in sequence.
     */
    fun onEvents(vararg events: Event) {
        viewModelScope.launch {
            events.forEach { _event.emit(it) }
        }
    }
    
    // endregion

    // region Event Processing
    
    private suspend fun processEventWithMiddleware(event: Event) {
        if (middlewares.isEmpty()) {
            processEvent(event)
            return
        }
        
        var index = 0
        
        suspend fun executeNext(e: Event) {
            if (index < middlewares.size) {
                val middleware = middlewares[index++]
                middleware.process(e, currentState, ::executeNext)
            } else {
                processEvent(e)
            }
        }
        
        executeNext(event)
    }
    
    private suspend fun processEvent(event: Event) {
        // 1. Pure state reduction (thread-safe)
        stateMutex.withLock {
            val newState = reduce(event)
            _state.value = newState
        }
        
        // 2. Handle side effects after state update
        handleSideEffect(event)
    }
    
    // endregion

    // region Abstract Methods
    
    /**
     * Pure function to reduce state based on event.
     * Must not have side effects.
     * 
     * @param event The event to process
     * @return New state
     */
    protected abstract fun reduce(event: Event): State
    
    /**
     * Handle side effects for events that need async operations.
     * Called after state is updated.
     * 
     * Override to handle events that trigger:
     * - API calls
     * - Database operations
     * - Navigation
     * - Effects emission
     */
    protected open suspend fun handleSideEffect(event: Event) {}
    
    // endregion

    // region Protected Helpers
    
    /**
     * Update state with a transform function.
     * Thread-safe.
     */
    protected suspend fun updateState(transform: (State) -> State) {
        stateMutex.withLock {
            _state.value = transform(_state.value)
        }
    }
    
    /**
     * Update state without suspension (fire-and-forget).
     * Use when you don't need to wait for update.
     */
    protected fun setState(transform: (State) -> State) {
        viewModelScope.launch {
            updateState(transform)
        }
    }
    
    /**
     * Emit a one-time effect to the UI.
     */
    protected fun emitEffect(effect: Effect) {
        viewModelScope.launch {
            _effect.send(effect)
        }
    }
    
    /**
     * Helper to run suspending work with loading state.
     * 
     * @param setLoading Transform to set loading state
     * @param setSuccess Transform to set success state
     * @param setError Transform to set error state
     * @param block The suspending work to execute
     */
    protected suspend fun <T> executeWithState(
        setLoading: (State) -> State,
        setSuccess: (State, T) -> State,
        setError: (State, Throwable) -> State,
        block: suspend () -> T
    ) {
        updateState(setLoading)
        try {
            val result = block()
            updateState { setSuccess(it, result) }
        } catch (e: Exception) {
            updateState { setError(it, e) }
        }
    }
    
    // endregion
}
```

---

## Compose Extensions

### File: `core/mvi/extensions/ComposeExtensions.kt`

```kotlin
package com.example.app.core.mvi.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.example.app.core.mvi.MviViewModel
import com.example.app.core.mvi.UiEffect
import com.example.app.core.mvi.UiEvent
import com.example.app.core.mvi.UiState
import kotlinx.coroutines.flow.Flow

/**
 * Collect effects with proper lifecycle handling.
 * Effects are only collected when lifecycle is at least STARTED.
 */
@Composable
fun <Effect : UiEffect> CollectEffects(
    effects: Flow<Effect>,
    onEffect: suspend (Effect) -> Unit
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    
    LaunchedEffect(effects, lifecycleOwner) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            effects.collect { effect ->
                onEffect(effect)
            }
        }
    }
}

/**
 * Convenience composable for setting up MVI screen.
 * Handles state collection and effect processing.
 * 
 * @param viewModel The MVI ViewModel
 * @param onEffect Effect handler
 * @param content Screen content receiving state and event dispatcher
 */
@Composable
fun <State : UiState, Event : UiEvent, Effect : UiEffect> MviScreen(
    viewModel: MviViewModel<State, Event, Effect>,
    onEffect: suspend (Effect) -> Unit = {},
    content: @Composable (state: State, onEvent: (Event) -> Unit) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    
    CollectEffects(
        effects = viewModel.effect,
        onEffect = onEffect
    )
    
    content(state, viewModel::onEvent)
}

/**
 * Type alias for event dispatcher function.
 */
typealias EventDispatcher<Event> = (Event) -> Unit

/**
 * Remember an event dispatcher to prevent unnecessary recomposition.
 */
@Composable
fun <Event : UiEvent> rememberEventDispatcher(
    onEvent: (Event) -> Unit
): EventDispatcher<Event> = onEvent
```

---

## Feature Implementation Example

### File: `feature/home/HomeContract.kt`

```kotlin
package com.example.app.feature.home

import androidx.compose.runtime.Immutable
import com.example.app.core.mvi.AsyncData
import com.example.app.core.mvi.UiEffect
import com.example.app.core.mvi.UiEvent
import com.example.app.core.mvi.UiState
import com.example.app.core.mvi.middleware.Trackable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

/**
 * Contract defines all State, Events, and Effects for Home feature.
 * Single source of truth for the feature's MVI components.
 */
object HomeContract {

    // region State
    
    @Immutable
    data class State(
        val items: AsyncData<ImmutableList<Item>> = AsyncData.Uninitialized,
        val selectedItem: Item? = null,
        val isRefreshing: Boolean = false,
        val searchQuery: String = "",
        val filterState: FilterState = FilterState()
    ) : UiState {
        
        val isLoading: Boolean get() = items.isLoading
        val hasError: Boolean get() = items.isError
        val errorMessage: String? get() = (items as? AsyncData.Error)?.message
        
        val filteredItems: ImmutableList<Item>
            get() = items.dataOrNull
                ?.filter { it.matchesFilter(filterState) }
                ?.filter { searchQuery.isBlank() || it.title.contains(searchQuery, ignoreCase = true) }
                ?.let { kotlinx.collections.immutable.toImmutableList(it) }
                ?: persistentListOf()
    }
    
    @Immutable
    data class FilterState(
        val category: String? = null,
        val sortBy: SortOption = SortOption.DATE_DESC,
        val showFavoritesOnly: Boolean = false
    )
    
    @Immutable
    data class Item(
        val id: String,
        val title: String,
        val description: String,
        val category: String,
        val isFavorite: Boolean = false,
        val createdAt: Long = 0
    ) {
        fun matchesFilter(filter: FilterState): Boolean {
            if (filter.showFavoritesOnly && !isFavorite) return false
            if (filter.category != null && category != filter.category) return false
            return true
        }
    }
    
    enum class SortOption { DATE_DESC, DATE_ASC, TITLE_ASC, TITLE_DESC }
    
    // endregion

    // region Events
    
    sealed interface Event : UiEvent {
        
        // Lifecycle events
        data object OnScreenLaunch : Event
        data object OnRefresh : Event
        data object OnRetry : Event
        
        // User interactions
        @Trackable("item_clicked")
        data class OnItemClick(val item: Item) : Event
        
        @Trackable("item_favorite_toggled")
        data class OnToggleFavorite(val item: Item) : Event
        
        data class OnSearchQueryChange(val query: String) : Event
        data class OnFilterChange(val filterState: FilterState) : Event
        data object OnClearFilters : Event
        
        // Dialog events
        data object OnDismissItemDetail : Event
        data class OnDeleteItem(val item: Item) : Event
        
        // Internal events (triggered by ViewModel)
        data class OnItemsLoaded(val items: List<Item>) : Event
        data class OnError(val message: String) : Event
        data object OnLoadingStarted : Event
    }
    
    // endregion

    // region Effects
    
    sealed interface Effect : UiEffect {
        data class ShowSnackbar(val message: String, val actionLabel: String? = null) : Effect
        data class NavigateToDetail(val itemId: String) : Effect
        data object NavigateBack : Effect
        data class ShowError(val message: String) : Effect
        data class ShareItem(val item: Item) : Effect
    }
    
    // endregion
}
```

### File: `feature/home/HomeViewModel.kt`

```kotlin
package com.example.app.feature.home

import androidx.lifecycle.viewModelScope
import com.example.app.core.mvi.AsyncData
import com.example.app.core.mvi.MviViewModel
import com.example.app.core.mvi.middleware.LoggingMiddleware
import com.example.app.domain.repository.ItemRepository
import com.example.app.feature.home.HomeContract.Effect
import com.example.app.feature.home.HomeContract.Event
import com.example.app.feature.home.HomeContract.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ItemRepository,
    loggingMiddleware: LoggingMiddleware<State, Event>
) : MviViewModel<State, Event, Effect>(State()) {

    init {
        // Add middlewares in order
        addMiddleware(loggingMiddleware)
        
        // Load initial data
        onEvent(Event.OnScreenLaunch)
    }

    override fun reduce(event: Event): State = when (event) {
        // Loading states
        is Event.OnLoadingStarted -> currentState.copy(
            items = AsyncData.Loading
        )
        
        is Event.OnItemsLoaded -> currentState.copy(
            items = AsyncData.Success(event.items.toImmutableList()),
            isRefreshing = false
        )
        
        is Event.OnError -> currentState.copy(
            items = AsyncData.Error(event.message),
            isRefreshing = false
        )
        
        // Refresh
        is Event.OnRefresh -> currentState.copy(
            isRefreshing = true
        )
        
        // Search & Filter
        is Event.OnSearchQueryChange -> currentState.copy(
            searchQuery = event.query
        )
        
        is Event.OnFilterChange -> currentState.copy(
            filterState = event.filterState
        )
        
        is Event.OnClearFilters -> currentState.copy(
            filterState = HomeContract.FilterState(),
            searchQuery = ""
        )
        
        // Item selection
        is Event.OnItemClick -> currentState.copy(
            selectedItem = event.item
        )
        
        is Event.OnDismissItemDetail -> currentState.copy(
            selectedItem = null
        )
        
        // Favorite toggle - optimistic update
        is Event.OnToggleFavorite -> {
            val updatedItems = currentState.items.dataOrNull?.map { item ->
                if (item.id == event.item.id) {
                    item.copy(isFavorite = !item.isFavorite)
                } else item
            }?.toImmutableList()
            
            currentState.copy(
                items = updatedItems?.let { AsyncData.Success(it) } ?: currentState.items
            )
        }
        
        // Events that don't modify state directly
        is Event.OnScreenLaunch,
        is Event.OnRetry,
        is Event.OnDeleteItem -> currentState
    }

    override suspend fun handleSideEffect(event: Event) {
        when (event) {
            is Event.OnScreenLaunch,
            is Event.OnRetry -> loadItems()
            
            is Event.OnRefresh -> refreshItems()
            
            is Event.OnItemClick -> {
                emitEffect(Effect.NavigateToDetail(event.item.id))
            }
            
            is Event.OnToggleFavorite -> {
                toggleFavorite(event.item)
            }
            
            is Event.OnDeleteItem -> {
                deleteItem(event.item)
            }
            
            else -> { /* No side effect needed */ }
        }
    }

    private fun loadItems() {
        viewModelScope.launch {
            onEvent(Event.OnLoadingStarted)
            
            repository.getItems()
                .onSuccess { items ->
                    onEvent(Event.OnItemsLoaded(items))
                }
                .onFailure { error ->
                    onEvent(Event.OnError(error.message ?: "Unknown error"))
                }
        }
    }
    
    private fun refreshItems() {
        viewModelScope.launch {
            repository.refreshItems()
                .onSuccess { items ->
                    onEvent(Event.OnItemsLoaded(items))
                    emitEffect(Effect.ShowSnackbar("Refreshed successfully"))
                }
                .onFailure { error ->
                    onEvent(Event.OnError(error.message ?: "Refresh failed"))
                }
        }
    }
    
    private suspend fun toggleFavorite(item: HomeContract.Item) {
        repository.toggleFavorite(item.id)
            .onFailure { error ->
                // Revert optimistic update
                onEvent(Event.OnToggleFavorite(item))
                emitEffect(Effect.ShowError("Failed to update favorite"))
            }
    }
    
    private suspend fun deleteItem(item: HomeContract.Item) {
        repository.deleteItem(item.id)
            .onSuccess {
                emitEffect(Effect.ShowSnackbar("Item deleted", actionLabel = "Undo"))
                loadItems() // Refresh list
            }
            .onFailure { error ->
                emitEffect(Effect.ShowError("Failed to delete item"))
            }
    }
}
```

### File: `feature/home/HomeScreen.kt`

```kotlin
package com.example.app.feature.home

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.app.core.mvi.extensions.CollectEffects
import com.example.app.feature.home.HomeContract.Effect
import com.example.app.feature.home.HomeContract.Event

/**
 * Screen composable - handles lifecycle and effect processing.
 * Delegates rendering to stateless HomeContent.
 */
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigateToDetail: (String) -> Unit,
    onNavigateBack: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current

    // Collect and handle effects
    CollectEffects(viewModel.effect) { effect ->
        when (effect) {
            is Effect.NavigateToDetail -> onNavigateToDetail(effect.itemId)
            is Effect.NavigateBack -> onNavigateBack()
            is Effect.ShowSnackbar -> {
                // In real app, use SnackbarHostState
                Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
            }
            is Effect.ShowError -> {
                Toast.makeText(context, effect.message, Toast.LENGTH_LONG).show()
            }
            is Effect.ShareItem -> {
                // Handle share intent
            }
        }
    }

    // Render stateless content
    HomeContent(
        state = state,
        onEvent = viewModel::onEvent
    )
}
```

### File: `feature/home/HomeContent.kt`

```kotlin
package com.example.app.feature.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.app.core.mvi.AsyncData
import com.example.app.feature.home.HomeContract.Event
import com.example.app.feature.home.HomeContract.Item
import com.example.app.feature.home.HomeContract.State
import kotlinx.collections.immutable.persistentListOf

/**
 * Stateless content composable - fully previewable.
 * Receives state and emits events.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    state: State,
    onEvent: (Event) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home") },
                actions = {
                    IconButton(onClick = { onEvent(Event.OnRefresh) }) {
                        Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when {
                state.isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                
                state.hasError -> {
                    ErrorContent(
                        message = state.errorMessage ?: "Unknown error",
                        onRetry = { onEvent(Event.OnRetry) },
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                
                state.filteredItems.isEmpty() -> {
                    EmptyContent(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                
                else -> {
                    ItemList(
                        items = state.filteredItems,
                        onItemClick = { onEvent(Event.OnItemClick(it)) },
                        onToggleFavorite = { onEvent(Event.OnToggleFavorite(it)) }
                    )
                }
            }
            
            // Pull to refresh overlay
            if (state.isRefreshing) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                )
            }
        }
    }
}

@Composable
private fun ItemList(
    items: List<Item>,
    onItemClick: (Item) -> Unit,
    onToggleFavorite: (Item) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = items,
            key = { it.id }
        ) { item ->
            ItemCard(
                item = item,
                onClick = { onItemClick(item) },
                onToggleFavorite = { onToggleFavorite(item) }
            )
        }
    }
}

@Composable
private fun ItemCard(
    item: Item,
    onClick: () -> Unit,
    onToggleFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            IconButton(onClick = onToggleFavorite) {
                Icon(
                    imageVector = if (item.isFavorite) {
                        Icons.Default.Favorite
                    } else {
                        Icons.Default.FavoriteBorder
                    },
                    contentDescription = if (item.isFavorite) "Remove from favorites" else "Add to favorites",
                    tint = if (item.isFavorite) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    }
                )
            }
        }
    }
}

@Composable
private fun ErrorContent(
    message: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.error
        )
        Button(onClick = onRetry) {
            Text("Retry")
        }
    }
}

@Composable
private fun EmptyContent(
    modifier: Modifier = Modifier
) {
    Text(
        text = "No items found",
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge
    )
}

// region Previews

private class HomeStatePreviewProvider : PreviewParameterProvider<State> {
    override val values: Sequence<State> = sequenceOf(
        // Loading state
        State(items = AsyncData.Loading),
        
        // Success state with items
        State(
            items = AsyncData.Success(
                persistentListOf(
                    Item("1", "First Item", "Description for first item", "Category A"),
                    Item("2", "Second Item", "Description for second item", "Category B", isFavorite = true),
                    Item("3", "Third Item", "Description for third item", "Category A")
                )
            )
        ),
        
        // Error state
        State(items = AsyncData.Error("Network error. Please try again.")),
        
        // Empty state
        State(items = AsyncData.Success(persistentListOf()))
    )
}

@Preview(showBackground = true, name = "Home States")
@Composable
private fun HomeContentPreview(
    @PreviewParameter(HomeStatePreviewProvider::class) state: State
) {
    MaterialTheme {
        HomeContent(
            state = state,
            onEvent = {}
        )
    }
}

// endregion
```

---

## Testing Utilities

### File: `core/mvi/testing/MviTestExtensions.kt`

```kotlin
package com.example.app.core.mvi.testing

import app.cash.turbine.test
import com.example.app.core.mvi.MviViewModel
import com.example.app.core.mvi.UiEffect
import com.example.app.core.mvi.UiEvent
import com.example.app.core.mvi.UiState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * Test helper for MVI ViewModels.
 */
class MviTestRobot<State : UiState, Event : UiEvent, Effect : UiEffect>(
    private val viewModel: MviViewModel<State, Event, Effect>,
    private val scope: TestScope
) {
    
    /**
     * Send an event and wait for processing.
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    fun sendEvent(event: Event) {
        viewModel.onEvent(event)
        scope.advanceUntilIdle()
    }
    
    /**
     * Send multiple events in sequence.
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    fun sendEvents(vararg events: Event) {
        events.forEach { event ->
            viewModel.onEvent(event)
        }
        scope.advanceUntilIdle()
    }
    
    /**
     * Assert current state matches expected.
     */
    fun assertState(expected: State) {
        assert(viewModel.state.value == expected) {
            "State mismatch.\nExpected: $expected\nActual: ${viewModel.state.value}"
        }
    }
    
    /**
     * Assert state matches predicate.
     */
    fun assertState(predicate: (State) -> Boolean, message: String = "State predicate failed") {
        assert(predicate(viewModel.state.value)) {
            "$message\nActual state: ${viewModel.state.value}"
        }
    }
    
    /**
     * Get current state.
     */
    val currentState: State get() = viewModel.state.value
    
    /**
     * Test effects with Turbine.
     */
    suspend fun testEffects(
        timeout: Duration = 1.seconds,
        validate: suspend app.cash.turbine.ReceiveTurbine<Effect>.() -> Unit
    ) {
        viewModel.effect.test(timeout = timeout, validate = validate)
    }
}

/**
 * Extension function to create test robot.
 */
fun <State : UiState, Event : UiEvent, Effect : UiEffect> MviViewModel<State, Event, Effect>.testRobot(
    scope: TestScope
): MviTestRobot<State, Event, Effect> = MviTestRobot(this, scope)

/**
 * Run MVI test with proper coroutine handling.
 */
@OptIn(ExperimentalCoroutinesApi::class)
fun <State : UiState, Event : UiEvent, Effect : UiEffect> runMviTest(
    viewModel: MviViewModel<State, Event, Effect>,
    testBody: suspend TestScope.(MviTestRobot<State, Event, Effect>) -> Unit
) = runTest {
    val robot = viewModel.testRobot(this)
    testBody(robot)
}
```

### File: `feature/home/HomeViewModelTest.kt`

```kotlin
package com.example.app.feature.home

import app.cash.turbine.test
import com.example.app.core.mvi.AsyncData
import com.example.app.core.mvi.middleware.LoggingMiddleware
import com.example.app.core.mvi.testing.runMviTest
import com.example.app.domain.repository.ItemRepository
import com.example.app.feature.home.HomeContract.*
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var repository: ItemRepository
    private lateinit var viewModel: HomeViewModel

    private val testItems = listOf(
        Item("1", "Test Item 1", "Description 1", "Category A"),
        Item("2", "Test Item 2", "Description 2", "Category B")
    )

    @Before
    fun setup() {
        repository = mockk()
        
        // Default successful response
        coEvery { repository.getItems() } returns Result.success(testItems)
    }

    private fun createViewModel(): HomeViewModel {
        return HomeViewModel(
            repository = repository,
            loggingMiddleware = LoggingMiddleware(isEnabled = false)
        )
    }

    @Test
    fun `initial state loads items successfully`() = runMviTest(createViewModel()) { robot ->
        advanceUntilIdle()
        
        robot.assertState { state ->
            state.items is AsyncData.Success &&
            state.items.dataOrNull?.size == 2
        }
    }

    @Test
    fun `OnRefresh updates state and reloads items`() = runMviTest(createViewModel()) { robot ->
        advanceUntilIdle() // Wait for initial load
        
        robot.sendEvent(Event.OnRefresh)
        
        robot.assertState { !it.isRefreshing }
        assertEquals(2, robot.currentState.items.dataOrNull?.size)
    }

    @Test
    fun `OnItemClick emits NavigateToDetail effect`() = runMviTest(createViewModel()) { robot ->
        advanceUntilIdle()
        
        val item = testItems.first()
        
        robot.testEffects {
            robot.sendEvent(Event.OnItemClick(Item(item.id, item.title, item.description, item.category)))
            
            val effect = awaitItem()
            assertTrue(effect is Effect.NavigateToDetail)
            assertEquals(item.id, (effect as Effect.NavigateToDetail).itemId)
        }
    }

    @Test
    fun `OnError shows error state`() = runMviTest(createViewModel()) { robot ->
        advanceUntilIdle()
        
        robot.sendEvent(Event.OnError("Network error"))
        
        robot.assertState { state ->
            state.items is AsyncData.Error &&
            state.errorMessage == "Network error"
        }
    }

    @Test
    fun `search query filters items correctly`() = runMviTest(createViewModel()) { robot ->
        advanceUntilIdle()
        
        robot.sendEvent(Event.OnSearchQueryChange("Item 1"))
        
        assertEquals("Item 1", robot.currentState.searchQuery)
        assertEquals(1, robot.currentState.filteredItems.size)
        assertEquals("Test Item 1", robot.currentState.filteredItems.first().title)
    }

    @Test
    fun `toggle favorite updates item optimistically`() = runMviTest(createViewModel()) { robot ->
        advanceUntilIdle()
        
        coEvery { repository.toggleFavorite(any()) } returns Result.success(Unit)
        
        val item = robot.currentState.items.dataOrNull?.first()!!
        robot.sendEvent(Event.OnToggleFavorite(item))
        
        val updatedItem = robot.currentState.items.dataOrNull?.first()
        assertTrue(updatedItem?.isFavorite == true)
    }
}
```

---

## Dependency Injection

### File: `di/MviModule.kt`

```kotlin
package com.example.app.di

import com.example.app.core.mvi.UiEvent
import com.example.app.core.mvi.UiState
import com.example.app.core.mvi.middleware.AnalyticsMiddleware
import com.example.app.core.mvi.middleware.AnalyticsTracker
import com.example.app.core.mvi.middleware.LoggingMiddleware
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MviModule {

    @Provides
    @Singleton
    fun provideAnalyticsTracker(): AnalyticsTracker {
        // Return your analytics implementation (Firebase, Amplitude, etc.)
        return object : AnalyticsTracker {
            override fun track(eventName: String, params: Map<String, Any?>) {
                // Implementation
            }
        }
    }

    @Provides
    fun <S : UiState, E : UiEvent> provideLoggingMiddleware(): LoggingMiddleware<S, E> {
        return LoggingMiddleware(
            tag = "MVI",
            isEnabled = true // Use BuildConfig.DEBUG
        )
    }

    @Provides
    fun <S : UiState, E : UiEvent> provideAnalyticsMiddleware(
        tracker: AnalyticsTracker
    ): AnalyticsMiddleware<S, E> {
        return AnalyticsMiddleware(tracker)
    }
}
```

---

## Quick Reference

### Decision Tree: When to Use What

```
User Action Received
        │
        ▼
┌─────────────────────┐
│  Does it modify     │──── No ───▶ handleSideEffect() only
│  UI state?          │              (navigation, toast, etc.)
└─────────────────────┘
        │ Yes
        ▼
┌─────────────────────┐
│  Is it a simple     │──── Yes ──▶ reduce() only
│  synchronous update?│              (toggle, filter, select)
└─────────────────────┘
        │ No
        ▼
┌─────────────────────┐
│  Does it need       │──── Yes ──▶ reduce() + handleSideEffect()
│  async operation?   │              (API call, DB query)
└─────────────────────┘
        │ No
        ▼
    reduce() only
```

### Common Patterns

| Pattern           | When to Use                               | Example               |
|-------------------|-------------------------------------------|-----------------------|
| Optimistic Update | Fast perceived response                   | Toggle favorite       |
| Loading State     | Async operations                          | API calls             |
| Partial State     | Complex screens with independent sections | Dashboard             |
| Derived State     | Computed from existing state              | Filtered/sorted lists |
| Effect            | One-time actions                          | Navigation, toast     |

### Required Dependencies

```kotlin
// build.gradle.kts (app module)
dependencies {
    // Compose
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0")
    
    // Immutable collections (recommended)
    implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.7")
    
    // Hilt
    implementation("com.google.dagger:hilt-android:2.51")
    kapt("com.google.dagger:hilt-compiler:2.51")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    
    // Testing
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0")
    testImplementation("app.cash.turbine:turbine:1.1.0")
    testImplementation("io.mockk:mockk:1.13.10")
}
```

---

## Best Practices Summary

1. **State is always immutable** - Use `data class` with `copy()`
2. **Reducers are pure functions** - No side effects, no async
3. **Effects are for one-time actions** - Navigation, toasts, analytics
4. **Use `sealed interface`** - Compile-time exhaustiveness for events/effects
5. **Stateless content composables** - Easy to preview and test
6. **Immutable collections** - Better Compose performance with `@Immutable`
7. **Middleware for cross-cutting** - Logging, analytics, error handling
8. **Test with Turbine** - For flow/effect testing
