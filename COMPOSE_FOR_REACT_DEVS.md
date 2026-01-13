# Jetpack Compose for React Developers

A comprehensive guide to Jetpack Compose for developers coming from React.

## Table of Contents

1. [Core Concepts Comparison](#core-concepts-comparison)
2. [Components vs Composables](#components-vs-composables)
3. [State Management](#state-management)
4. [Props and Parameters](#props-and-parameters)
5. [Recomposition vs Re-rendering](#recomposition-vs-re-rendering)
6. [Lifecycle and Effects](#lifecycle-and-effects)
7. [Performance Optimization](#performance-optimization)
8. [Advanced Patterns](#advanced-patterns)
9. [Common Pitfalls](#common-pitfalls)
10. [Best Practices](#best-practices)

---

## Core Concepts Comparison

| React Concept   | Compose Equivalent                                  | Key Difference                            |
|-----------------|-----------------------------------------------------|-------------------------------------------|
| Component       | `@Composable` function                              | Function-based, no class components       |
| Props           | Function parameters                                 | Type-safe, no prop drilling by default    |
| `useState`      | `remember { mutableStateOf() }`                     | More explicit state creation              |
| `useEffect`     | `LaunchedEffect`, `DisposableEffect`                | Effect scope tied to keys                 |
| `useCallback`   | `remember { lambda }`                               | Automatic lambda capturing                |
| `useMemo`       | `remember { computation }` or `derivedStateOf`      | Two different optimizations               |
| `useContext`    | `CompositionLocal`                                  | Compile-time safe                         |
| `children` prop | Trailing lambda / `content: @Composable () -> Unit` | Type-safe composition                     |
| `key` prop      | `key()` function                                    | Explicit identity management              |
| React.memo      | Stable types / `@Stable` annotation                 | Smart recomposition by default            |
| Refs            | `remember { mutableStateOf() }`                     | No direct DOM access                      |
| Portals         | N/A                                                 | Android views handle layering differently |

---

## Components vs Composables

### React Component

```javascript
// Function Component
function Greeting({ name, onButtonClick }) {
  const [count, setCount] = useState(0);

  return (
    <div>
      <h1>Hello, {name}!</h1>
      <p>Count: {count}</p>
      <button onClick={() => {
        setCount(count + 1);
        onButtonClick();
      }}>
        Click me
      </button>
    </div>
  );
}

// Usage
<Greeting name="John" onButtonClick={handleClick} />
```

### Jetpack Compose Composable

```kotlin
// Composable Function
@Composable
fun Greeting(
    name: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier  // Standard in Compose
) {
    var count by remember { mutableStateOf(0) }

    Column(modifier = modifier) {
        Text(
            text = "Hello, $name!",
            style = MaterialTheme.typography.headlineMedium
        )
        Text("Count: $count")
        Button(
            onClick = {
                count++
                onButtonClick()
            }
        ) {
            Text("Click me")
        }
    }
}

// Usage
Greeting(
    name = "John",
    onButtonClick = { handleClick() }
)
```

### Key Differences

1. **No JSX/XML**: Compose uses Kotlin DSL
2. **@Composable annotation**: Required for all composable functions
3. **Modifier parameter**: Standard practice for styling and layout
4. **Type safety**: Compile-time checking for all props/parameters
5. **No class components**: Everything is a function

---

## State Management

### Local State

#### React

```javascript
function Counter() {
  const [count, setCount] = useState(0);
  const [name, setName] = useState('');

  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>+</button>
      <input
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
    </div>
  );
}
```

#### Compose

```kotlin
@Composable
fun Counter() {
    // Method 1: Using 'by' delegation (recommended)
    var count by remember { mutableStateOf(0) }
    var name by remember { mutableStateOf("") }

    Column {
        Text("Count: $count")
        Button(onClick = { count++ }) {
            Text("+")
        }
        TextField(
            value = name,
            onValueChange = { name = it }
        )
    }
}

// Method 2: Using .value explicitly
@Composable
fun CounterExplicit() {
    val count = remember { mutableStateOf(0) }
    val name = remember { mutableStateOf("") }

    Column {
        Text("Count: ${count.value}")
        Button(onClick = { count.value++ }) {
            Text("+")
        }
        TextField(
            value = name.value,
            onValueChange = { name.value = it }
        )
    }
}
```

### Hoisted State (Lifting State Up)

#### React

```javascript
function Parent() {
  const [value, setValue] = useState('');

  return (
    <div>
      <Input value={value} onChange={setValue} />
      <Display value={value} />
    </div>
  );
}

function Input({ value, onChange }) {
  return <input value={value} onChange={(e) => onChange(e.target.value)} />;
}

function Display({ value }) {
  return <p>{value}</p>;
}
```

#### Compose

```kotlin
@Composable
fun Parent() {
    var value by remember { mutableStateOf("") }

    Column {
        InputField(
            value = value,
            onValueChange = { value = it }
        )
        Display(value = value)
    }
}

// Stateless composable (recommended pattern)
@Composable
fun InputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
    )
}

@Composable
fun Display(
    value: String,
    modifier: Modifier = Modifier
) {
    Text(text = value, modifier = modifier)
}
```

### State from ViewModel (Redux/Context equivalent)

#### React with Redux/Context

```javascript
// Redux
function Counter() {
  const count = useSelector(state => state.count);
  const dispatch = useDispatch();

  return (
    <button onClick={() => dispatch({ type: 'INCREMENT' })}>
      Count: {count}
    </button>
  );
}

// Context
function Counter() {
  const { count, increment } = useContext(CounterContext);

  return (
    <button onClick={increment}>Count: {count}</button>
  );
}
```

#### Compose with ViewModel

```kotlin
// ViewModel (MVI pattern)
@HiltViewModel
class CounterViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(CounterState())
    val state = _state.asStateFlow()

    fun onEvent(event: CounterEvent) {
        when (event) {
            CounterEvent.Increment -> {
                _state.update { it.copy(count = it.count + 1) }
            }
        }
    }
}

data class CounterState(val count: Int = 0)
sealed interface CounterEvent {
    data object Increment : CounterEvent
}

// Screen composable
@Composable
fun CounterScreen(
    viewModel: CounterViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    CounterContent(
        state = state,
        onEvent = viewModel::onEvent
    )
}

// Stateless content (easily testable)
@Composable
private fun CounterContent(
    state: CounterState,
    onEvent: (CounterEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Button(onClick = { onEvent(CounterEvent.Increment) }) {
        Text("Count: ${state.count}")
    }
}
```

### State Preservation

#### React

```javascript
// State is lost on unmount by default
function MyComponent() {
  const [value, setValue] = useState('');
  // Lost when component unmounts
}

// Preserve with key
<MyComponent key="persistent-key" />
```

#### Compose

```kotlin
@Composable
fun MyComponent() {
    // Lost when composable leaves composition
    var value by remember { mutableStateOf("") }

    // Preserved across recompositions but lost on config change
    var value2 by remember { mutableStateOf("") }

    // Preserved across config changes (Activity recreation)
    var value3 by rememberSaveable { mutableStateOf("") }
}

// Preserve with key
key("persistent-key") {
    MyComponent()
}
```

---

## Props and Parameters

### Basic Props/Parameters

#### React

```javascript
function Button({
  text,
  onClick,
  disabled = false,  // Default value
  variant = 'primary',
  children
}) {
  return (
    <button
      onClick={onClick}
      disabled={disabled}
      className={`btn-${variant}`}
    >
      {text || children}
    </button>
  );
}

// Usage
<Button text="Click" onClick={handleClick} />
<Button onClick={handleClick}>Click</Button>
```

#### Compose

```kotlin
@Composable
fun CustomButton(
    text: String? = null,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,  // Standard practice
    enabled: Boolean = true,
    variant: ButtonVariant = ButtonVariant.Primary,
    content: @Composable (() -> Unit)? = null  // Like children
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = when (variant) {
                ButtonVariant.Primary -> MaterialTheme.colorScheme.primary
                ButtonVariant.Secondary -> MaterialTheme.colorScheme.secondary
            }
        )
    ) {
        if (content != null) {
            content()
        } else {
            Text(text ?: "")
        }
    }
}

enum class ButtonVariant { Primary, Secondary }

// Usage
CustomButton(text = "Click", onClick = { handleClick() })
CustomButton(onClick = { handleClick() }) {
    Text("Click")
}
```

### Children Pattern

#### React

```javascript
function Card({ children, title }) {
  return (
    <div className="card">
      <h2>{title}</h2>
      <div className="card-content">
        {children}
      </div>
    </div>
  );
}

// Usage
<Card title="My Card">
  <p>Content here</p>
  <Button>Click</Button>
</Card>
```

#### Compose

```kotlin
@Composable
fun Card(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit  // Trailing lambda
) {
    Card(modifier = modifier) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            // ColumnScope allows Column-specific modifiers in content
            content()
        }
    }
}

// Usage (trailing lambda syntax)
Card(title = "My Card") {
    Text("Content here")
    Spacer(modifier = Modifier.height(8.dp))
    Button(onClick = {}) {
        Text("Click")
    }
}
```

### Slot API Pattern (React's render props)

#### React

```javascript
function Layout({ header, sidebar, content, footer }) {
  return (
    <div>
      <header>{header}</header>
      <div className="main">
        <aside>{sidebar}</aside>
        <main>{content}</main>
      </div>
      <footer>{footer}</footer>
    </div>
  );
}

// Usage
<Layout
  header={<Header />}
  sidebar={<Sidebar />}
  content={<MainContent />}
  footer={<Footer />}
/>
```

#### Compose

```kotlin
@Composable
fun Layout(
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    sidebar: @Composable () -> Unit,
    footer: @Composable () -> Unit,
    content: @Composable () -> Unit  // Main content last for trailing lambda
) {
    Column(modifier = modifier.fillMaxSize()) {
        // Header
        header()

        // Main area
        Row(modifier = Modifier.weight(1f)) {
            // Sidebar
            sidebar()
            // Content
            Box(modifier = Modifier.weight(1f)) {
                content()
            }
        }

        // Footer
        footer()
    }
}

// Usage
Layout(
    header = { Header() },
    sidebar = { Sidebar() },
    footer = { Footer() }
) {
    // Trailing lambda for main content
    MainContent()
}
```

---

## Recomposition vs Re-rendering

### How React Re-renders

```javascript
function Parent() {
  const [count, setCount] = useState(0);

  console.log('Parent renders');

  return (
    <div>
      <button onClick={() => setCount(count + 1)}>Count: {count}</button>
      <Child />  {/* Re-renders even though no props changed! */}
      <MemoizedChild />  {/* Won't re-render */}
    </div>
  );
}

function Child() {
  console.log('Child renders');
  return <p>I'm a child</p>;
}

const MemoizedChild = React.memo(Child);
```

**React behavior**: When parent state changes, ALL children re-render by default unless wrapped in `React.memo`.

### How Compose Recomposes

```kotlin
@Composable
fun Parent() {
    var count by remember { mutableStateOf(0) }

    println("Parent recomposes")

    Column {
        Button(onClick = { count++ }) {
            Text("Count: $count")  // Only THIS recomposes!
        }
        Child()  // Does NOT recompose!
        UnstableChild(SomeObject())  // Might recompose
    }
}

@Composable
fun Child() {
    println("Child recomposes")
    Text("I'm a child")
}

data class SomeObject(val value: Int = 0)  // Stable by default

@Composable
fun UnstableChild(data: SomeObject) {
    // Recomposes if data changes
    Text("Data: ${data.value}")
}
```

**Compose behavior**: Smart recomposition! Only composables that read changed state recompose.

### Stability Analysis

```kotlin
// ✅ STABLE - Won't cause recomposition if unchanged
data class StableData(val id: Int, val name: String)

@Composable
fun StableComponent(data: StableData) {
    // Only recomposes if 'data' changes
    Text("${data.name}")
}

// ❌ UNSTABLE - Always causes recomposition
class UnstableData(var id: Int, var name: String)  // Mutable properties

@Composable
fun UnstableComponent(data: UnstableData) {
    // Recomposes whenever parent recomposes!
    Text("${data.name}")
}

// ✅ MAKE IT STABLE - Use @Stable annotation
@Stable
class StabilizedData(var id: Int, var name: String)

// ✅ STABLE - Primitives and immutable types
@Composable
fun AlwaysStable(
    count: Int,  // Stable
    name: String,  // Stable
    onClick: () -> Unit,  // Stable (lambda captured properly)
    list: List<String>  // Stable if immutable
) {
}

// ❌ UNSTABLE - Mutable collections
@Composable
fun UnstableList(
    list: MutableList<String>  // Unstable!
) {
}

// ✅ FIX - Convert to immutable
@Composable
fun StableList(
    list: List<String>  // Stable
) {
}
```

### Skipping Recomposition

#### React

```javascript
// Must explicitly memoize
const MemoizedChild = React.memo(({ name, onClick }) => {
  return <button onClick={onClick}>{name}</button>;
});

function Parent() {
  const [count, setCount] = useState(0);

  // Must memoize callback too!
  const handleClick = useCallback(() => {
    console.log('Clicked');
  }, []);

  return (
    <div>
      <button onClick={() => setCount(count + 1)}>Count: {count}</button>
      <MemoizedChild name="Button" onClick={handleClick} />
    </div>
  );
}
```

#### Compose

```kotlin
// Automatic skipping with stable parameters!
@Composable
fun OptimizedChild(
    name: String,
    onClick: () -> Unit
) {
    Button(onClick = onClick) {
        Text(name)
    }
}

@Composable
fun Parent() {
    var count by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { count++ }) {
            Text("Count: $count")
        }

        // Automatically skips recomposition!
        OptimizedChild(
            name = "Button",
            onClick = { println("Clicked") }
        )
    }
}

// For unstable parameters, wrap in remember
@Composable
fun ParentWithUnstable() {
    var count by remember { mutableStateOf(0) }
    val data = UnstableData(...)

    // Force stability with remember
    val stableData = remember(data.id) { data }

    OptimizedChild(
        name = stableData.name,
        onClick = { }
    )
}
```

---

## Lifecycle and Effects

### Component Lifecycle Comparison

#### React Lifecycle

```javascript
function MyComponent() {
  // componentDidMount + componentDidUpdate
  useEffect(() => {
    console.log('Component mounted or updated');

    // componentWillUnmount
    return () => {
      console.log('Cleanup');
    };
  });

  // componentDidMount only
  useEffect(() => {
    console.log('Component mounted');
  }, []);

  // Run when specific deps change
  useEffect(() => {
    console.log('Count changed:', count);
  }, [count]);

  return <div>Content</div>;
}
```

#### Compose Lifecycle

```kotlin
@Composable
fun MyComponent() {
    // Enters composition (like componentDidMount)
    LaunchedEffect(Unit) {
        println("Component entered composition")

        // Cleanup (like componentWillUnmount)
        awaitCancellation()
    }

    // On every recomposition
    // (Usually NOT what you want - avoid this!)
    SideEffect {
        println("After every successful recomposition")
    }

    // On specific key change
    var count by remember { mutableStateOf(0) }
    LaunchedEffect(count) {
        println("Count changed: $count")
    }

    // Cleanup when key changes or composable leaves
    DisposableEffect(count) {
        println("Subscribe with count: $count")

        onDispose {
            println("Cleanup for count: $count")
        }
    }

    Text("Content")
}
```

### Effect Types Deep Dive

#### 1. LaunchedEffect (useEffect equivalent)

```kotlin
@Composable
fun LaunchedEffectExamples() {
    var count by remember { mutableStateOf(0) }

    // Run once on first composition
    LaunchedEffect(Unit) {
        // Fetch initial data
        val data = fetchData()
        println("Initial data: $data")
    }

    // Run when count changes
    LaunchedEffect(count) {
        // Track analytics
        logEvent("count_changed", count)
    }

    // Multiple keys
    var searchQuery by remember { mutableStateOf("") }
    LaunchedEffect(count, searchQuery) {
        // Runs when either changes
        search(searchQuery, page = count)
    }

    // Cancellation when key changes
    LaunchedEffect(searchQuery) {
        // Debounce search
        delay(300)
        search(searchQuery)
        // If searchQuery changes again before 300ms,
        // this coroutine is cancelled and restarted
    }
}
```

#### 2. DisposableEffect (useEffect with cleanup)

```kotlin
@Composable
fun DisposableEffectExamples() {
    // Lifecycle observer
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> println("Resumed")
                Lifecycle.Event.ON_PAUSE -> println("Paused")
                else -> Unit
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    // WebSocket connection
    var isConnected by remember { mutableStateOf(false) }

    DisposableEffect(Unit) {
        val connection = WebSocketConnection()
        connection.connect()
        isConnected = true

        onDispose {
            connection.disconnect()
            isConnected = false
        }
    }
}
```

#### 3. SideEffect (immediate effects)

```kotlin
@Composable
fun SideEffectExamples() {
    var count by remember { mutableStateOf(0) }

    // Run AFTER successful recomposition
    SideEffect {
        // Update non-Compose state
        // Example: Analytics, logging
        println("Recomposed with count: $count")
    }

    // ⚠️ WARNING: Runs on EVERY recomposition!
    // Use sparingly
}
```

#### 4. rememberCoroutineScope (event handlers)

```kotlin
@Composable
fun CoroutineScopeExamples() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Button(
        onClick = {
            // Launch coroutine from event handler
            scope.launch {
                val result = doAsyncWork()
                snackbarHostState.showSnackbar("Result: $result")
            }
        }
    ) {
        Text("Do Work")
    }
}
```

#### 5. rememberUpdatedState (always get latest value)

```kotlin
@Composable
fun rememberUpdatedStateExample(
    onTimeout: () -> Unit
) {
    // Capture latest onTimeout without restarting effect
    val currentOnTimeout by rememberUpdatedState(onTimeout)

    LaunchedEffect(Unit) {
        delay(5000)
        // Always calls the LATEST onTimeout
        currentOnTimeout()
    }
}

// React equivalent
function TimeoutComponent ({ onTimeout }) {
    const timeoutRef = useRef (onTimeout);

    useEffect(() => {
        timeoutRef.current = onTimeout;
    }, [onTimeout]);

    useEffect(() => {
        const id = setTimeout (() => {
        timeoutRef.current();
    }, 5000);
        return () => clearTimeout(id);
    }, []);
}
```

#### 6. derivedStateOf (computed values)

```kotlin
@Composable
fun DerivedStateExamples() {
    var items by remember { mutableStateOf(listOf<Item>()) }
    var searchQuery by remember { mutableStateOf("") }

    // ❌ BAD: Recomposes entire composable on every keystroke
    val filteredItems = items.filter { it.name.contains(searchQuery) }

    // ✅ GOOD: Only filtered list consumers recompose
    val filteredItems by remember {
        derivedStateOf {
            items.filter { it.name.contains(searchQuery) }
        }
    }

    LazyColumn {
        items(filteredItems) { item ->
            Text(item.name)
        }
    }
}

// React equivalent
function FilteredList () {
    const[items, setItems] = useState([]);
    const[searchQuery, setSearchQuery] = useState('');

    const filteredItems = useMemo (() => {
    return items.filter(item => item . name . includes (searchQuery));
}, [items, searchQuery]);

    return<div> {/* render filteredItems */ } < / div >;
}
```

### Practical Effect Examples

#### Data Fetching

```kotlin
@Composable
fun UserProfile(userId: String) {
    var user by remember { mutableStateOf<User?>(null) }
    var isLoading by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(userId) {
        isLoading = true
        error = null

        try {
            user = fetchUser(userId)
        } catch (e: Exception) {
            error = e.message
        } finally {
            isLoading = false
        }
    }

    when {
        isLoading -> CircularProgressIndicator()
        error != null -> Text("Error: $error")
        user != null -> UserCard(user!!)
    }
}
```

#### Debounced Search

```kotlin
@Composable
fun SearchBar() {
    var query by remember { mutableStateOf("") }
    var results by remember { mutableStateOf<List<String>>(emptyList()) }

    LaunchedEffect(query) {
        if (query.isBlank()) {
            results = emptyList()
            return@LaunchedEffect
        }

        // Debounce
        delay(300)

        // If query changed during delay, this is cancelled
        results = search(query)
    }

    Column {
        TextField(
            value = query,
            onValueChange = { query = it }
        )

        LazyColumn {
            items(results) { result ->
                Text(result)
            }
        }
    }
}
```

#### Polling

```kotlin
@Composable
fun RealtimeData() {
    var data by remember { mutableStateOf<Data?>(null) }
    var isActive by remember { mutableStateOf(true) }

    LaunchedEffect(isActive) {
        while (isActive) {
            data = fetchLatestData()
            delay(5000)  // Poll every 5 seconds
        }
    }

    Column {
        data?.let { DataDisplay(it) }
        Button(onClick = { isActive = !isActive }) {
            Text(if (isActive) "Stop" else "Start")
        }
    }
}
```

---

## Performance Optimization

### List Rendering

#### React

```javascript
function ItemList({ items }) {
  return (
    <div>
      {items.map(item => (
        <ItemCard key={item.id} item={item} />
      ))}
    </div>
  );
}

// For large lists, use react-window or react-virtualized
import { FixedSizeList } from 'react-window';

function VirtualizedList({ items }) {
  return (
    <FixedSizeList
      height={600}
      itemCount={items.length}
      itemSize={80}
    >
      {({ index, style }) => (
        <div style={style}>
          <ItemCard item={items[index]} />
        </div>
      )}
    </FixedSizeList>
  );
}
```

#### Compose

```kotlin
@Composable
fun ItemList(items: List<Item>) {
    // ❌ BAD: Don't use Column for long lists!
    Column {
        items.forEach { item ->
            ItemCard(item = item)
        }
    }

    // ✅ GOOD: Use LazyColumn (virtualized by default!)
    LazyColumn {
        items(
            items = items,
            key = { it.id }  // Important for performance!
        ) { item ->
            ItemCard(item = item)
        }
    }
}

// Different item types
@Composable
fun MixedList(items: List<ListItem>) {
    LazyColumn {
        items(
            items = items,
            key = { it.id },
            contentType = { item ->
                // Help Compose reuse compositions of same type
                when (item) {
                    is HeaderItem -> "header"
                    is TextItem -> "text"
                    is ImageItem -> "image"
                }
            }
        ) { item ->
            when (item) {
                is HeaderItem -> HeaderCard(item)
                is TextItem -> TextCard(item)
                is ImageItem -> ImageCard(item)
            }
        }
    }
}

// Sticky headers
@Composable
fun StickyHeaderList(sections: List<Section>) {
    LazyColumn {
        sections.forEach { section ->
            stickyHeader {
                SectionHeader(section.title)
            }
            items(
                items = section.items,
                key = { it.id }
            ) { item ->
                ItemCard(item)
            }
        }
    }
}

// Grid
@Composable
fun ImageGrid(images: List<Image>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(
            items = images,
            key = { it.id }
        ) { image ->
            AsyncImage(
                model = image.url,
                contentDescription = null
            )
        }
    }
}
```

### Keys and Identity

#### React

```javascript
// ❌ BAD: Using index as key
{items.map((item, index) => (
  <ItemCard key={index} item={item} />
))}

// ✅ GOOD: Using stable ID
{items.map(item => (
  <ItemCard key={item.id} item={item} />
))}

// Preserve state across reorders
const [items, setItems] = useState([
  { id: 1, name: 'A' },
  { id: 2, name: 'B' }
]);

// If you reorder items, React uses key to preserve component state
```

#### Compose

```kotlin
@Composable
fun KeyExamples(items: List<Item>) {
    // ❌ BAD: No key
    LazyColumn {
        items(items) { item ->
            ItemCard(item)
        }
    }

    // ✅ GOOD: With key
    LazyColumn {
        items(
            items = items,
            key = { it.id }
        ) { item ->
            ItemCard(item)
        }
    }

    // Using key() for arbitrary composables
    Column {
        items.forEach { item ->
            key(item.id) {
                // State inside is preserved across reordering
                var expanded by remember { mutableStateOf(false) }
                ItemCard(
                    item = item,
                    expanded = expanded,
                    onToggle = { expanded = !expanded }
                )
            }
        }
    }
}

// Multiple keys for complex scenarios
@Composable
fun ComplexKeyScenario(userId: String, postId: String) {
    key(userId, postId) {
        // This composable's state is tied to BOTH userId and postId
        var comments by remember { mutableStateOf<List<Comment>>(emptyList()) }

        LaunchedEffect(Unit) {
            // Refetch when either userId or postId changes
            comments = fetchComments(userId, postId)
        }

        CommentsList(comments)
    }
}
```

### Avoiding Unnecessary Recomposition

#### React

```javascript
// Problem: Parent re-renders, child re-renders unnecessarily
function Parent() {
  const [count, setCount] = useState(0);

  const data = { value: 'hello' };  // ❌ New object every render

  const handleClick = () => {  // ❌ New function every render
    console.log('clicked');
  };

  return (
    <div>
      <button onClick={() => setCount(count + 1)}>Count: {count}</button>
      <ExpensiveChild data={data} onClick={handleClick} />
    </div>
  );
}

// Solution: useMemo and useCallback
function ParentOptimized() {
  const [count, setCount] = useState(0);

  const data = useMemo(() => ({ value: 'hello' }), []);  // ✅ Stable reference

  const handleClick = useCallback(() => {  // ✅ Stable function
    console.log('clicked');
  }, []);

  return (
    <div>
      <button onClick={() => setCount(count + 1)}>Count: {count}</button>
      <ExpensiveChild data={data} onClick={handleClick} />
    </div>
  );
}

const ExpensiveChild = React.memo(({ data, onClick }) => {
  console.log('ExpensiveChild rendered');
  return <button onClick={onClick}>{data.value}</button>;
});
```

#### Compose

```kotlin
@Composable
fun Parent() {
    var count by remember { mutableStateOf(0) }

    // ❌ BAD: New object every recomposition
    val data = Data(value = "hello")

    Column {
        Button(onClick = { count++ }) {
            Text("Count: $count")
        }
        ExpensiveChild(
            data = data,
            onClick = { println("clicked") }
        )
    }
}

// ✅ SOLUTION 1: Use immutable data classes (automatically stable)
data class Data(val value: String)  // Immutable = Stable

@Composable
fun ParentOptimized() {
    var count by remember { mutableStateOf(0) }
    val data = remember { Data(value = "hello") }  // Stable reference

    Column {
        Button(onClick = { count++ }) {
            Text("Count: $count")
        }
        ExpensiveChild(
            data = data,
            onClick = { println("clicked") }  // Lambdas are stable by default!
        )
    }
}

// ✅ SOLUTION 2: Use remember for expensive computations
@Composable
fun ParentWithExpensiveCalc() {
    var count by remember { mutableStateOf(0) }

    // Only recalculates when count changes
    val expensiveResult = remember(count) {
        expensiveComputation(count)
    }

    Column {
        Button(onClick = { count++ }) {
            Text("Count: $count")
        }
        ResultDisplay(result = expensiveResult)
    }
}

@Composable
fun ExpensiveChild(
    data: Data,
    onClick: () -> Unit
) {
    println("ExpensiveChild recomposed")
    Button(onClick = onClick) {
        Text(data.value)
    }
}

// ✅ SOLUTION 3: Use @Stable annotation for mutable classes
@Stable
class MutableData(var value: String)

// Now Compose treats it as stable if the value doesn't change
```

### Reading State in Lambdas

#### React

```javascript
function Counter() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => {
      // ❌ Stale closure: always logs 0
      console.log(count);

      // ❌ Stale closure: doesn't increment properly
      setCount(count + 1);
    }, 1000);

    return () => clearInterval(interval);
  }, []);  // Empty deps = stale closure

  // ✅ Solution: Use functional update
  useEffect(() => {
    const interval = setInterval(() => {
      setCount(prev => prev + 1);
    }, 1000);

    return () => clearInterval(interval);
  }, []);
}
```

#### Compose

```kotlin
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }

    // ✅ Compose handles this automatically!
    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            println(count)  // Always reads latest value!
            count++  // Always increments correctly!
        }
    }

    // But if you need to avoid effect restart on state change:
    val currentCount by rememberUpdatedState(count)

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            println(currentCount)  // Latest value without restarting effect
        }
    }

    Text("Count: $count")
}
```

---

## Advanced Patterns

### Custom Hooks vs Custom Composables

#### React Custom Hook

```javascript
function useCounter(initialValue = 0) {
  const [count, setCount] = useState(initialValue);

  const increment = useCallback(() => setCount(c => c + 1), []);
  const decrement = useCallback(() => setCount(c => c - 1), []);
  const reset = useCallback(() => setCount(initialValue), [initialValue]);

  return { count, increment, decrement, reset };
}

// Usage
function MyComponent() {
  const { count, increment, decrement, reset } = useCounter(10);

  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={increment}>+</button>
      <button onClick={decrement}>-</button>
      <button onClick={reset}>Reset</button>
    </div>
  );
}
```

#### Compose Custom Composable

```kotlin
// Custom composable for state management
@Composable
fun rememberCounterState(initialValue: Int = 0): CounterState {
    return remember {
        CounterState(initialValue)
    }
}

// State class (can be @Stable)
@Stable
class CounterState(initialValue: Int) {
    var count by mutableStateOf(initialValue)
        private set

    private val initialCount = initialValue

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }

    fun reset() {
        count = initialCount
    }
}

// Usage
@Composable
fun MyComponent() {
    val counterState = rememberCounterState(initialValue = 10)

    Column {
        Text("Count: ${counterState.count}")
        Row {
            Button(onClick = counterState::increment) { Text("+") }
            Button(onClick = counterState::decrement) { Text("-") }
            Button(onClick = counterState::reset) { Text("Reset") }
        }
    }
}
```

### Higher-Order Components vs Higher-Order Composables

#### React HOC

```javascript
// HOC for loading state
function withLoading(Component) {
  return function WithLoadingComponent({ isLoading, ...props }) {
    if (isLoading) {
      return <Spinner />;
    }
    return <Component {...props} />;
  };
}

// Usage
const UserProfile = ({ user }) => <div>{user.name}</div>;
const UserProfileWithLoading = withLoading(UserProfile);

// In parent
<UserProfileWithLoading isLoading={loading} user={user} />
```

#### Compose Higher-Order Composable

```kotlin
// Higher-order composable for loading state
@Composable
fun WithLoading(
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    if (isLoading) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        content()
    }
}

// Usage
@Composable
fun UserProfile(user: User) {
    Text(user.name)
}

@Composable
fun Screen() {
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val user by viewModel.user.collectAsStateWithLifecycle()

    WithLoading(isLoading = isLoading) {
        user?.let { UserProfile(it) }
    }
}

// Alternative: Inline pattern (more common in Compose)
@Composable
fun Screen() {
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val user by viewModel.user.collectAsStateWithLifecycle()

    when {
        isLoading -> CircularProgressIndicator()
        user != null -> UserProfile(user!!)
        else -> Text("No data")
    }
}
```

### Render Props vs Slot API

Already covered in [Slot API Pattern](#slot-api-pattern-reacts-render-props)

### Context API vs CompositionLocal

#### React Context

```javascript
const ThemeContext = React.createContext('light');

function ThemeProvider({ children }) {
  const [theme, setTheme] = useState('light');

  return (
    <ThemeContext.Provider value={{ theme, setTheme }}>
      {children}
    </ThemeContext.Provider>
  );
}

function ThemedButton() {
  const { theme, setTheme } = useContext(ThemeContext);

  return (
    <button
      className={theme}
      onClick={() => setTheme(theme === 'light' ? 'dark' : 'light')}
    >
      Toggle Theme
    </button>
  );
}

// Usage
<ThemeProvider>
  <App />
</ThemeProvider>
```

#### Compose CompositionLocal

```kotlin
// Define CompositionLocal
data class AppTheme(val isDark: Boolean)

val LocalAppTheme = compositionLocalOf { AppTheme(isDark = false) }

// Provider
@Composable
fun AppThemeProvider(
    content: @Composable () -> Unit
) {
    var isDark by remember { mutableStateOf(false) }
    val theme = remember(isDark) { AppTheme(isDark) }

    CompositionLocalProvider(LocalAppTheme provides theme) {
        content()
    }
}

// Consumer
@Composable
fun ThemedButton(onToggle: () -> Unit) {
    val theme = LocalAppTheme.current

    Button(
        onClick = onToggle,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (theme.isDark) Color.DarkGray else Color.LightGray
        )
    ) {
        Text("Toggle Theme")
    }
}

// Usage
@Composable
fun App() {
    var isDark by remember { mutableStateOf(false) }

    CompositionLocalProvider(LocalAppTheme provides AppTheme(isDark)) {
        Scaffold {
            ThemedButton(onToggle = { isDark = !isDark })
        }
    }
}

// Built-in CompositionLocals
@Composable
fun ExampleBuiltIns() {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    val lifecycleOwner = LocalLifecycleOwner.current
}
```

### Controlled vs Uncontrolled Components

#### React

```javascript
// Controlled
function ControlledInput() {
  const [value, setValue] = useState('');

  return (
    <input
      value={value}
      onChange={(e) => setValue(e.target.value)}
    />
  );
}

// Uncontrolled
function UncontrolledInput() {
  const inputRef = useRef();

  const handleSubmit = () => {
    console.log(inputRef.current.value);
  };

  return (
    <>
      <input ref={inputRef} defaultValue="initial" />
      <button onClick={handleSubmit}>Submit</button>
    </>
  );
}
```

#### Compose

```kotlin
// Controlled (recommended in Compose)
@Composable
fun ControlledTextField() {
    var value by remember { mutableStateOf("") }

    TextField(
        value = value,
        onValueChange = { value = it }
    )
}

// "Uncontrolled" pattern (not common, but possible)
@Composable
fun UncontrolledTextField() {
    val textFieldState = remember { mutableStateOf("initial") }

    Column {
        BasicTextField(
            value = textFieldState.value,
            onValueChange = { textFieldState.value = it }
        )
        Button(onClick = {
            // Access value without prop drilling
            println(textFieldState.value)
        }) {
            Text("Submit")
        }
    }
}

// More idiomatic: Hoisted state
@Composable
fun TextFieldScreen() {
    var value by remember { mutableStateOf("") }

    Column {
        TextField(
            value = value,
            onValueChange = { value = it }
        )
        Button(onClick = { submitValue(value) }) {
            Text("Submit")
        }
    }
}
```

---

## Common Pitfalls

### 1. Not Using remember for State

```kotlin
// ❌ WRONG: State resets on every recomposition!
@Composable
fun Counter() {
    var count = 0  // Resets to 0 every time!

    Button(onClick = { count++ }) {
        Text("Count: $count")
    }
}

// ✅ CORRECT: State persists across recompositions
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }

    Button(onClick = { count++ }) {
        Text("Count: $count")
    }
}
```

### 2. Reading State in LaunchedEffect Without Key

```kotlin
// ❌ WRONG: Reads stale count value
@Composable
fun StaleClosureExample() {
    var count by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        delay(5000)
        println(count)  // Always prints 0 (initial value)!
    }

    Button(onClick = { count++ }) {
        Text("Count: $count")
    }
}

// ✅ CORRECT: Include count as key to restart effect
@Composable
fun CorrectExample1() {
    var count by remember { mutableStateOf(0) }

    LaunchedEffect(count) {
        delay(5000)
        println(count)  // Prints latest count
    }

    Button(onClick = { count++ }) {
        Text("Count: $count")
    }
}

// ✅ CORRECT: Use rememberUpdatedState for long-running effects
@Composable
fun CorrectExample2() {
    var count by remember { mutableStateOf(0) }
    val currentCount by rememberUpdatedState(count)

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            println(currentCount)  // Always prints latest count!
        }
    }

    Button(onClick = { count++ }) {
        Text("Count: $count")
    }
}
```

### 3. Using Mutable Collections

```kotlin
// ❌ WRONG: Changes to mutableList don't trigger recomposition!
@Composable
fun MutableListProblem() {
    val items = remember { mutableStateListOf<String>() }
    // This works ^^^, but...

    // This doesn't work:
    val itemsList = remember { mutableListOf<String>() }

    Button(onClick = {
        itemsList.add("Item")  // No recomposition!
    }) {
        Text("Add Item")
    }

    Text("Count: ${itemsList.size}")  // Never updates UI!
}

// ✅ CORRECT: Use Compose's snapshot-aware collections
@Composable
fun CorrectMutableList() {
    val items = remember { mutableStateListOf<String>() }

    Button(onClick = {
        items.add("Item")  // Triggers recomposition!
    }) {
        Text("Add Item")
    }

    Text("Count: ${items.size}")
}

// ✅ CORRECT: Use immutable state
@Composable
fun ImmutableList() {
    var items by remember { mutableStateOf(listOf<String>()) }

    Button(onClick = {
        items = items + "Item"  // Creates new list
    }) {
        Text("Add Item")
    }

    Text("Count: ${items.size}")
}
```

### 4. Not Using Modifier Parameter

```kotlin
// ❌ WRONG: No way for parent to customize layout
@Composable
fun MyButton(text: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text)
    }
}

// ✅ CORRECT: Always accept modifier parameter
@Composable
fun MyButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier  // Always add this!
) {
    Button(
        onClick = onClick,
        modifier = modifier  // Apply it to root element
    ) {
        Text(text)
    }
}

// Now parent can customize:
MyButton(
    text = "Click",
    onClick = {},
    modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
)
```

### 5. Calling Composables in Non-Composable Functions

```kotlin
// ❌ WRONG: Can't call composables outside @Composable context
fun createButton(): Button {  // Not @Composable
    return Button(onClick = {}) {  // Error!
        Text("Click")
    }
}

// ✅ CORRECT: Make function @Composable
@Composable
fun CreateButton(): Unit {  // Returns Unit, not Button
    Button(onClick = {}) {
        Text("Click")
    }
}
```

### 6. Using Column/Row for Long Lists

```kotlin
// ❌ WRONG: Renders all items at once (performance issue!)
@Composable
fun BadList(items: List<String>) {
    Column {
        items.forEach { item ->
            Text(item)
        }
    }
}

// ✅ CORRECT: Use LazyColumn for virtualization
@Composable
fun GoodList(items: List<String>) {
    LazyColumn {
        items(items) { item ->
            Text(item)
        }
    }
}
```

### 7. Not Using Lifecycle-Aware State Collection

```kotlin
// ❌ WRONG: Continues collecting when app is backgrounded
@Composable
fun BadStateCollection(viewModel: MyViewModel) {
    val state = viewModel.state.collectAsState()
    // Keeps collecting even when app is paused!
}

// ✅ CORRECT: Stops collecting when lifecycle is paused
@Composable
fun GoodStateCollection(viewModel: MyViewModel) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    // Automatically pauses/resumes with lifecycle
}
```

---

## Best Practices

### 1. Composable Naming

```kotlin
// ✅ CORRECT: PascalCase for composables (like React components)
@Composable
fun UserProfile() {
}

@Composable
fun CustomButton() {
}

// ✅ CORRECT: remember* for functions that return remembered values
@Composable
fun rememberScrollState(): ScrollState {
}

// ❌ WRONG: camelCase for composables
@Composable
fun userProfile() {
}  // Should be PascalCase
```

### 2. State Hoisting

```kotlin
// ✅ CORRECT: Stateless composable (easy to test and reuse)
@Composable
fun Counter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(onClick = onIncrement, modifier = modifier) {
        Text("Count: $count")
    }
}

// Stateful wrapper
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }

    Counter(
        count = count,
        onIncrement = { count++ },
        modifier = modifier
    )
}
```

### 3. Single Responsibility

```kotlin
// ❌ WRONG: Screen composable doing too much
@Composable
fun UserScreen(viewModel: UserViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column {
        TopAppBar { Text("Users") }

        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            LazyColumn {
                items(state.users) { user ->
                    // Complex user card inline...
                }
            }
        }

        // More complex UI...
    }
}

// ✅ CORRECT: Separate concerns
@Composable
fun UserScreen(viewModel: UserViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    UserScreenContent(
        state = state,
        onEvent = viewModel::onEvent
    )
}

@Composable
private fun UserScreenContent(
    state: UserState,
    onEvent: (UserEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { UserScreenTopBar() },
        modifier = modifier
    ) { padding ->
        when {
            state.isLoading -> LoadingIndicator()
            state.error != null -> ErrorView(state.error)
            else -> UserList(
                users = state.users,
                onUserClick = { onEvent(UserEvent.UserClicked(it)) }
            )
        }
    }
}

@Composable
private fun UserList(
    users: List<User>,
    onUserClick: (User) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(users, key = { it.id }) { user ->
            UserCard(
                user = user,
                onClick = { onUserClick(user) }
            )
        }
    }
}

@Composable
private fun UserCard(
    user: User,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // User card implementation
}
```

### 4. Preview Everything

```kotlin
@Composable
fun UserCard(user: User) {
    // Implementation
}

// ✅ CORRECT: Multiple preview states
@Preview(showBackground = true)
@Composable
private fun UserCardPreview() {
    AppTheme {
        UserCard(user = User(id = "1", name = "John Doe", email = "john@example.com"))
    }
}

@Preview(showBackground = true)
@Composable
private fun UserCardLongNamePreview() {
    AppTheme {
        UserCard(
            user = User(
                id = "1",
                name = "Very Long Name That Might Break Layout",
                email = "verylongemail@example.com"
            )
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun UserCardDarkPreview() {
    AppTheme {
        UserCard(user = User(id = "1", name = "John Doe", email = "john@example.com"))
    }
}

// Multiple device previews
@Preview(device = Devices.PHONE)
@Preview(device = Devices.TABLET)
@Composable
private fun UserCardDevicePreview() {
    AppTheme {
        UserCard(user = User(id = "1", name = "John Doe", email = "john@example.com"))
    }
}
```

### 5. Use Sealed Interfaces for Events/Effects

```kotlin
// ✅ CORRECT: Type-safe events
sealed interface UserEvent {
    data class LoadUser(val id: String) : UserEvent
    data class UpdateName(val name: String) : UserEvent
    data object Refresh : UserEvent
    data object Logout : UserEvent
}

@Composable
fun UserScreen(viewModel: UserViewModel = hiltViewModel()) {
    // Compiler ensures all events are handled
    viewModel.onEvent(UserEvent.LoadUser("123"))
}
```

### 6. Immutable State

```kotlin
// ✅ CORRECT: Immutable data class
data class UserState(
    val user: User? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

// Update immutably
_state.update { it.copy(isLoading = true) }

// ❌ WRONG: Mutable properties
data class UserState(
    var user: User? = null,
    var isLoading: Boolean = false,
    var error: String? = null
)
```

### 7. Use Material3 Components

```kotlin
// ✅ CORRECT: Use Material3 components
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold

@Composable
fun MyScreen() {
    Scaffold(
        topBar = { TopAppBar { Text("Title") } }
    ) { padding ->
        Button(onClick = {}) {
            Text("Click")
        }
    }
}

// ❌ WRONG: Using Material2
import androidx . compose . material . Button  // Deprecated
```

### 8. Testing

```kotlin
// Composable to test
@Composable
fun Greeting(name: String) {
    Text("Hello, $name!")
}

// Test
class GreetingTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun greeting_displaysCorrectText() {
        // Given
        composeTestRule.setContent {
            Greeting(name = "John")
        }

        // Then
        composeTestRule
            .onNodeWithText("Hello, John!")
            .assertIsDisplayed()
    }

    @Test
    fun button_click_incrementsCounter() {
        // Given
        composeTestRule.setContent {
            var count by remember { mutableStateOf(0) }

            Column {
                Text("Count: $count")
                Button(onClick = { count++ }) {
                    Text("Increment")
                }
            }
        }

        // When
        composeTestRule
            .onNodeWithText("Increment")
            .performClick()

        // Then
        composeTestRule
            .onNodeWithText("Count: 1")
            .assertIsDisplayed()
    }
}
```

---

## Quick Reference: React to Compose

### State

```javascript
// React
const [value, setValue] = useState(0);
setValue(1);
```

```kotlin
// Compose
var value by remember { mutableStateOf(0) }
value = 1
```

### Effects

```javascript
// React
useEffect(() => {
  // Effect
  return () => {
    // Cleanup
  };
}, [dep]);
```

```kotlin
// Compose
LaunchedEffect(dep) {
    // Effect

    awaitCancellation()  // Or use DisposableEffect for cleanup
}
```

### Callbacks

```javascript
// React
const handleClick = useCallback(() => {
  doSomething();
}, [dep]);
```

```kotlin
// Compose
val handleClick = remember(dep) {
    { doSomething() }
}

// Or often not needed:
Button(onClick = { doSomething() })  // Stable by default
```

### Memoization

```javascript
// React
const value = useMemo(() => {
  return expensiveComputation();
}, [dep]);
```

```kotlin
// Compose
val value = remember(dep) {
    expensiveComputation()
}

// For derived state:
val value by remember {
    derivedStateOf {
        expensiveComputation()
    }
}
```

### Context

```javascript
// React
const value = useContext(MyContext);
```

```kotlin
// Compose
val value = LocalMyContext.current
```

### Lists

```javascript
// React
{items.map(item => (
  <Item key={item.id} item={item} />
))}
```

```kotlin
// Compose
LazyColumn {
    items(items, key = { it.id }) { item ->
        Item(item = item)
    }
}
```

### Conditional Rendering

```javascript
// React
{isLoading && <Spinner />}
{isLoading ? <Spinner /> : <Content />}
```

```kotlin
// Compose
if (isLoading) {
    Spinner()
}

if (isLoading) Spinner() else Content()

when {
    isLoading -> Spinner()
    error != null -> ErrorView()
    else -> Content()
}
```

---

## Conclusion

### Key Takeaways

1. **Composables are functions**, not classes or objects
2. **Smart recomposition** - only what changed recomposes
3. **Explicit state** with `remember` and `mutableStateOf`
4. **Type-safe** everything - no runtime prop types
5. **Lifecycle-aware effects** with keys
6. **Immutability** is crucial for performance
7. **Material3** for modern UI
8. **Always add Modifier parameter** to composables
9. **Hoist state** for reusability and testability
10. **LazyColumn/Row** for lists, not Column/Row

### React vs Compose Philosophy

| React                                   | Compose                            |
|-----------------------------------------|------------------------------------|
| Virtual DOM diffing                     | Smart recomposition                |
| Manual optimization (memo, useCallback) | Automatic optimization (stability) |
| Runtime prop validation                 | Compile-time type safety           |
| Imperative refs                         | Declarative state                  |
| Class + Function components             | Function-only components           |
| JSX syntax                              | Kotlin DSL                         |
| Hooks for state                         | `remember` for state               |
| One-way data flow                       | One-way data flow                  |

### Resources

- [Official Compose Documentation](https://developer.android.com/jetpack/compose)
- [Compose Samples](https://github.com/android/compose-samples)
- [Now in Android Sample](https://github.com/android/nowinandroid)
- [Compose Pathway](https://developer.android.com/courses/pathways/compose)

---

**Happy Composing! 🎉**
