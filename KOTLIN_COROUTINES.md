# Kotlin Coroutines — From Zero to Expert

Since you're coming from React Native, I'll map concepts to things you already know.

---

## Level 1: The Mental Model

In React Native, you deal with async using `async/await` and Promises. Coroutines are Kotlin's
equivalent, but more powerful.

```javascript
// JavaScript
async function fetchUser() {
  const response = await fetch(url);
  return response.json();
}
```

```kotlin
// Kotlin
suspend fun fetchUser(): User {
    val response = apiService.getUser()  // suspends, doesn't block
    return response
}
```

The keyword `suspend` is like marking a function `async`. It tells Kotlin "this function can pause
and resume." But unlike JS, coroutines aren't tied to a single thread — they can switch threads
mid-execution.

> **Key insight:** In JS, everything runs on one thread and the event loop handles async. In Kotlin,
> coroutines can actually run on multiple threads, suspend on one, and resume on another.

---

## Level 2: Core Building Blocks

### 2.1 — suspend functions

A `suspend` function can only be called from another `suspend` function or from a coroutine builder.

```kotlin
// This just marks the function as "can suspend"
suspend fun getUser(): User {
    delay(1000) // like setTimeout but non-blocking
    return User("Aditya")
}
```

Think of `suspend` as a contract: "I might take a while, but I won't block your thread."

### 2.2 — Coroutine Builders (How you start coroutines)

There are 3 main builders:

```kotlin
// 1. launch — fire and forget (like calling an async function without awaiting)
// Returns a Job (a handle to the coroutine)
launch {
    val user = getUser()
    println(user)
}

// 2. async — when you need a result back (like Promise)
// Returns a Deferred<T> (like a Promise<T>)
val deferred: Deferred<User> = async {
    getUser()
}
val user = deferred.await()  // like await in JS

// 3. runBlocking — blocks the current thread (ONLY for main() or tests, NEVER in production/UI)
runBlocking {
    val user = getUser()
}
```

**RN analogy:**

- `launch` ≈ calling `fetchData()` without `await` (fire-and-forget)
- `async/await` ≈ `const result = await fetchData()`
- `runBlocking` ≈ no real equivalent, it's like making synchronous HTTP calls (bad)

### 2.3 — CoroutineScope

Every coroutine needs a scope. The scope defines the lifecycle of the coroutine.

```javascript
// In RN, you cancel async work in useEffect cleanup:
useEffect(() => {
    const controller = new AbortController();
    fetch(url, { signal: controller.signal });
    return () => controller.abort();
}, []);
```

```kotlin
// In Kotlin, the scope handles this automatically
class MyViewModel : ViewModel() {
    // viewModelScope auto-cancels when ViewModel is cleared
    fun loadUser() {
        viewModelScope.launch {
            val user = getUser()
        }
    }
}
```

**Scopes you'll encounter:**

| Scope                      | Lifecycle                            | Use for                |
|----------------------------|--------------------------------------|------------------------|
| `viewModelScope`           | ViewModel death                      | Most business logic    |
| `lifecycleScope`           | Activity/Fragment death              | UI-layer work          |
| `rememberCoroutineScope()` | Composable leaving composition       | Compose events         |
| `GlobalScope`              | App process death                    | Almost never use this  |
| `CoroutineScope(context)`  | Manual control                       | Custom managers        |

---

## Level 3: Dispatchers (Thread Pools)

This is where Kotlin is fundamentally different from JS. You choose **where** your code runs.

```kotlin
// Dispatchers.Main — UI thread (like the JS thread in RN)
// Dispatchers.IO — optimized for network/disk (64+ threads)
// Dispatchers.Default — CPU-heavy work (thread count = CPU cores)
// Dispatchers.Unconfined — starts in caller thread, resumes anywhere (rarely used)

viewModelScope.launch(Dispatchers.IO) {
    val user = repository.fetchUser()         // runs on IO thread

    withContext(Dispatchers.Main) {            // switch to main thread
        updateUI(user)                         // safe to touch UI
    }
}
```

**RN analogy:** In RN, the bridge handles threading for you. In native Android, you must think about
it. But `withContext` makes it easy — it's like `requestAnimationFrame` but for switching threads.

**Pro tip:** If your suspend function does IO work internally, make it "main-safe" by switching
context inside:

```kotlin
// Good pattern — caller doesn't need to worry about threads
suspend fun fetchUser(): User = withContext(Dispatchers.IO) {
    api.getUser()
}

// Now this is safe from ANY dispatcher
viewModelScope.launch {  // runs on Main by default
    val user = fetchUser()  // internally switches to IO
    // back on Main, safe to update UI
}
```

---

## Level 4: Structured Concurrency

This is the killer feature over JS Promises. In JS, if you fire off 3 promises and one fails, the
others keep running (unless you use `Promise.all`). In coroutines, parent-child relationships are
enforced.

```kotlin
viewModelScope.launch {
    // These are CHILDREN of the outer coroutine
    val user = async { getUser() }
    val posts = async { getPosts() }
    val friends = async { getFriends() }

    // If any one fails, ALL siblings are cancelled
    // If the parent scope is cancelled, ALL children are cancelled

    val result = Triple(user.await(), posts.await(), friends.await())
}
```

**RN analogy:** It's like `Promise.all()` but built into the language, with automatic cleanup.

### Cancellation

```kotlin
val job = viewModelScope.launch {
    repeat(1000) { i ->
        println("Working $i")
        delay(500)  // <-- this is a cancellation point
    }
}

// Later...
job.cancel()  // coroutine stops at the next suspension point
```

**Important:** Cancellation is cooperative. If you're doing CPU work without suspending, you need to
check manually:

```kotlin
launch {
    repeat(1000) { i ->
        ensureActive()  // throws CancellationException if cancelled
        // or: if (!isActive) return@launch
        heavyCpuWork(i)
    }
}
```

---

## Level 5: Flow (The Reactive Stream — like RxJS/Observables)

This is where it gets really powerful. `Flow` is Kotlin's answer to observables/streams.

**RN analogy:** Think of it like an `EventEmitter` or an `Observable` that emits values over time.

```kotlin
// Creating a Flow (like creating an Observable)
fun getLocationUpdates(): Flow<Location> = flow {
    while (true) {
        val location = locationProvider.getLocation()
        emit(location)  // send value downstream
        delay(5000)
    }
}

// Collecting a Flow (like subscribing)
viewModelScope.launch {
    getLocationUpdates().collect { location ->
        println("Got location: $location")
    }
}
```

### Flow Operators (like RxJS pipe operators)

```kotlin
repository.getUsers()
    .map { user -> user.name }                    // transform
    .filter { name -> name.startsWith("A") }      // filter
    .distinctUntilChanged()                        // skip duplicates
    .debounce(300)                                 // debounce (like lodash)
    .catch { e -> emit("Error: ${e.message}") }   // error handling
    .flowOn(Dispatchers.IO)                        // upstream runs on IO
    .collect { name -> updateUI(name) }            // terminal operator
```

### StateFlow & SharedFlow

These are the ones you'll use most in Android:

```kotlin
// StateFlow — like React's useState, always has a current value
// This is THE primary way to expose UI state from ViewModel
class UserViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())  // private mutable
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()  // public read-only

    fun loadUser() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val user = repository.getUser()
            _uiState.update { it.copy(user = user, isLoading = false) }
        }
    }
}

// SharedFlow — like an event bus, no initial value
// Good for one-time events (navigation, snackbars, toasts)
class UserViewModel : ViewModel() {
    private val _events = MutableSharedFlow<UiEvent>()
    val events = _events.asSharedFlow()

    fun onDeleteClick() {
        viewModelScope.launch {
            repository.deleteUser()
            _events.emit(UiEvent.ShowSnackbar("User deleted"))
        }
    }
}
```

**RN mental model:**

- `StateFlow` ≈ `useState` + context — always has a value, re-renders on change
- `SharedFlow` ≈ `EventEmitter` — fires events, no "current value"
- `Flow` ≈ `AsyncGenerator` or `Observable` — cold stream, starts when collected

---

## Level 6: Coroutines in Jetpack Compose

This is where everything connects to your UI.

### 6.1 — Collecting State

```kotlin
@Composable
fun UserScreen(viewModel: UserViewModel = viewModel()) {
    // collectAsState() — bridges Flow/StateFlow to Compose State
    // This is like "subscribing" to the Flow and triggering recomposition
    val uiState by viewModel.uiState.collectAsState()

    // Equivalent RN:
    // const [uiState] = useContext(ViewModelContext)

    when {
        uiState.isLoading -> CircularProgressIndicator()
        uiState.error != null -> ErrorView(uiState.error)
        else -> UserContent(uiState.user)
    }
}
```

### 6.2 — collectAsStateWithLifecycle() (ALWAYS prefer this)

```kotlin
// This is lifecycle-aware — stops collecting when the UI is in background
// Saves battery, prevents crashes
val uiState by viewModel.uiState.collectAsStateWithLifecycle()

// Needs: implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
```

This is like having `useEffect` that automatically unsubscribes when the component unmounts AND when
the app goes to background.

### 6.3 — LaunchedEffect (the useEffect of Compose)

```kotlin
@Composable
fun UserScreen(userId: String) {
    // Runs when userId changes (like useEffect with deps)
    LaunchedEffect(userId) {
        // This block is a coroutine scope!
        // Auto-cancelled when:
        //   1. UserScreen leaves composition (unmount)
        //   2. userId changes (re-launches with new value)
        viewModel.loadUser(userId)
    }

    // LaunchedEffect(Unit) = useEffect(() => {}, []) — runs once
    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> snackbarHostState.showSnackbar(event.message)
                is UiEvent.Navigate -> navController.navigate(event.route)
            }
        }
    }
}
```

### 6.4 — rememberCoroutineScope (for event handlers)

```kotlin
@Composable
fun MyScreen() {
    val scope = rememberCoroutineScope()
    // Like: const scope = useRef(new CoroutineScope())

    val snackbarHostState = remember { SnackbarHostState() }

    Button(onClick = {
        // onClick is NOT a composable/suspend context
        // So you need a scope to launch coroutines
        scope.launch {
            snackbarHostState.showSnackbar("Clicked!")
        }
    }) {
        Text("Click me")
    }
}
```

**When to use which:**

| Compose API                  | RN Equivalent                               | Use When                                           |
|------------------------------|---------------------------------------------|----------------------------------------------------|
| `LaunchedEffect(key)`        | `useEffect(() => {}, [key])`                | Side effects that depend on state                  |
| `LaunchedEffect(Unit)`       | `useEffect(() => {}, [])`                   | One-time setup, collecting events                  |
| `rememberCoroutineScope()`   | Manual ref-based scope                      | User-triggered actions (onClick, etc.)             |
| `DisposableEffect(key)`      | `useEffect(() => { return cleanup }, [key])`| When you need explicit cleanup                     |
| `SideEffect`                 | No equivalent (runs every recomposition)    | Syncing compose state to non-compose code          |
| `produceState`               | `useMemo` + `useEffect` combo               | Convert Flow/suspend to Compose State directly     |

### 6.5 — produceState (neat shortcut)

```kotlin
@Composable
fun UserScreen(userId: String) {
    // Combines "launch coroutine + collect into state" in one API
    val user by produceState<User?>(initialValue = null, userId) {
        value = repository.getUser(userId)  // sets the state
    }

    user?.let { UserContent(it) } ?: LoadingSpinner()
}
```

### 6.6 — snapshotFlow (Compose State → Flow)

```kotlin
@Composable
fun SearchScreen() {
    var query by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        // Convert Compose State changes into a Flow
        // Like turning useState changes into an Observable
        snapshotFlow { query }
            .debounce(300)
            .distinctUntilChanged()
            .collectLatest { searchQuery ->
                viewModel.search(searchQuery)
            }
    }

    TextField(value = query, onValueChange = { query = it })
}
```

---

## Level 7: Expert Patterns

### 7.1 — supervisorScope (Isolate child failures)

```kotlin
// Normal: one child fails → all siblings cancelled
// Supervisor: one child fails → others keep running

viewModelScope.launch {
    supervisorScope {
        val user = async { getUser() }       // if this fails...
        val posts = async { getPosts() }     // this keeps running
        val friends = async { getFriends() } // this keeps running
    }
}
```

### 7.2 — coroutineScope (Wait for all children)

```kotlin
suspend fun loadDashboard(): Dashboard = coroutineScope {
    // Creates a new scope, waits for ALL children
    val user = async { getUser() }
    val stats = async { getStats() }
    Dashboard(user.await(), stats.await())
    // Returns only when both are done
}
```

### 7.3 — Exception Handling

```kotlin
// Pattern 1: try-catch (simplest)
viewModelScope.launch {
    try {
        val user = getUser()
    } catch (e: Exception) {
        _uiState.update { it.copy(error = e.message) }
    }
}

// Pattern 2: CoroutineExceptionHandler (global catch for launch)
val handler = CoroutineExceptionHandler { _, throwable ->
    Log.e("TAG", "Caught: $throwable")
}
viewModelScope.launch(handler) {
    throw RuntimeException("boom")  // caught by handler
}

// Pattern 3: Result wrapper (recommended for clean architecture)
sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()
    data object Loading : Result<Nothing>()
}

// In repository
suspend fun getUser(): Result<User> = try {
    Result.Success(api.getUser())
} catch (e: Exception) {
    Result.Error(e)
}
```

### 7.4 — callbackFlow (Bridge callbacks to Flow)

This is huge for wrapping Android SDK callbacks (location, sensors, etc.):

```kotlin
// Convert callback-based API to Flow
fun locationUpdates(): Flow<Location> = callbackFlow {
    val callback = object : LocationCallback() {
        override fun onLocationResult(result: LocationResult) {
            trySend(result.lastLocation)  // emit to flow
        }
    }

    locationClient.requestLocationUpdates(request, callback, Looper.getMainLooper())

    awaitClose {  // cleanup when flow is cancelled (like useEffect cleanup)
        locationClient.removeLocationUpdates(callback)
    }
}

// Usage in Compose
@Composable
fun LocationScreen() {
    val location by locationRepository
        .locationUpdates()
        .collectAsStateWithLifecycle(initialValue = null)
}
```

### 7.5 — collectLatest vs collect

```kotlin
// collect: processes every emission sequentially
flow.collect { value ->
    heavyWork(value)  // if new value arrives, waits for this to finish
}

// collectLatest: cancels previous work when new value arrives
// PERFECT for search-as-you-type
flow.collectLatest { query ->
    val results = search(query)  // cancelled if new query arrives
    showResults(results)
}

// mapLatest: same idea but as an operator
flow.mapLatest { query -> search(query) }
    .collect { results -> showResults(results) }
```

### 7.6 — stateIn and shareIn (Cold → Hot conversion)

```kotlin
class UserViewModel : ViewModel() {
    // Convert a cold Flow (from Room/repository) into a hot StateFlow
    val users: StateFlow<List<User>> = repository.getUsersFlow()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000), // keep alive 5s after last collector
            initialValue = emptyList()
        )

    // WhileSubscribed(5000) is the gold standard:
    // - Stops upstream when no collectors (screen in background)
    // - 5s grace period for config changes (rotation)
    // - Restarts when collector returns
}
```

### 7.7 — Combining multiple Flows

```kotlin
class DashboardViewModel : ViewModel() {
    val dashboardState: StateFlow<DashboardState> = combine(
        userRepository.getUserFlow(),
        statsRepository.getStatsFlow(),
        settingsRepository.getSettingsFlow()
    ) { user, stats, settings ->
        // Like useMemo(() => {...}, [user, stats, settings])
        DashboardState(user, stats, settings)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = DashboardState()
    )
}
```

---

## Quick Reference Cheat Sheet

```
JS/RN Concept          →  Kotlin Coroutine Equivalent
─────────────────────────────────────────────────────
async/await            →  suspend / coroutine builders
Promise                →  Deferred<T>
Promise.all()          →  coroutineScope { async {} + async {} }
Promise.race()         →  select {} (advanced)
setTimeout             →  delay()
setInterval            →  while(true) { delay() } in a flow
AbortController        →  Job.cancel() / scope cancellation
Observable/RxJS        →  Flow
BehaviorSubject        →  StateFlow
Subject                →  SharedFlow
useEffect              →  LaunchedEffect
useEffect cleanup      →  DisposableEffect / awaitClose
useState               →  mutableStateOf / StateFlow
useCallback + scope    →  rememberCoroutineScope
EventEmitter           →  SharedFlow / callbackFlow
```

---

Start with **Level 1-4** to build your foundation, then **Levels 5-6** for day-to-day Compose work.
**Level 7** patterns come into play as your app complexity grows.
