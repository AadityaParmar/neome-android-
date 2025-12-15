# Android Development Basics Guide

Welcome to Android development! This guide will teach you everything you need to know to build your first Android app.

---

## Table of Contents

1. [What is Android?](#what-is-android)
2. [Kotlin Language Basics](#kotlin-language-basics)
3. [Setting Up Your Environment](#setting-up-your-environment)
4. [Understanding the Project Structure](#understanding-the-project-structure)
5. [Key Android Components](#key-android-components)
6. [Building UI with Jetpack Compose](#building-ui-with-jetpack-compose)
7. [Understanding Your Current App](#understanding-your-current-app)
8. [Running Your App](#running-your-app)
9. [Next Steps](#next-steps)

---

## What is Android?

Android is a mobile operating system developed by Google, running on billions of devices worldwide.

### Key Facts
- Based on Linux kernel
- Apps are written in **Kotlin** (modern, recommended) or Java (legacy)
- Uses **Jetpack Compose** for modern UI or XML for traditional layouts
- Apps run in isolated sandboxes for security

### Programming Language: Kotlin
Kotlin is the official language for Android development. It's:
- Concise and expressive
- Type-safe (catches errors at compile time)
- Interoperable with Java
- Modern with features like coroutines, null safety, and lambdas

---

## Kotlin Language Basics

Before diving into Android, let's learn Kotlin fundamentals. Kotlin is a modern, expressive language that makes Android development easier and more enjoyable.

### 1. Variables

```kotlin
// val - Immutable (read-only, recommended)
val name = "John"              // Type inferred as String
val age: Int = 25              // Explicit type
// name = "Jane"               // ERROR: Cannot reassign

// var - Mutable (can be changed)
var score = 0
score = 100                    // OK

// Const - Compile-time constant
const val API_KEY = "abc123"
```

**Best Practice:** Use `val` by default, only use `var` when you need to change the value.

### 2. Data Types

```kotlin
// Numbers
val int: Int = 42              // 32-bit integer
val long: Long = 42L           // 64-bit integer
val float: Float = 3.14f       // 32-bit floating point
val double: Double = 3.14      // 64-bit floating point

// Text
val char: Char = 'A'
val text: String = "Hello"

// Boolean
val isActive: Boolean = true

// Type conversion
val num = "123".toInt()
val str = 123.toString()
```

### 3. Null Safety

Kotlin prevents null pointer exceptions at compile time.

```kotlin
// Non-nullable (default)
var name: String = "John"
// name = null                 // ERROR: Cannot be null

// Nullable (add ?)
var nullableName: String? = "John"
nullableName = null            // OK

// Safe call operator (?.)
val length = nullableName?.length    // Returns null if nullableName is null

// Elvis operator (?:)
val nameLength = nullableName?.length ?: 0   // Use 0 if null

// Not-null assertion (!!)
val length2 = nullableName!!.length  // Throws exception if null (use carefully!)

// Safe casting
val text = obj as? String      // Returns null if cast fails
```

### 4. String Templates

```kotlin
val name = "Alice"
val age = 25

// String interpolation
val greeting = "Hello, $name!"
val info = "Name: $name, Age: $age"

// Expressions in strings
val message = "Next year you'll be ${age + 1}"

// Multiline strings
val poem = """
    Roses are red,
    Violets are blue,
    Kotlin is awesome,
    And so are you!
""".trimIndent()
```

### 5. Functions

```kotlin
// Basic function
fun greet(name: String): String {
    return "Hello, $name!"
}

// Single-expression function
fun add(a: Int, b: Int): Int = a + b

// Unit return type (like void in Java)
fun printMessage(message: String): Unit {
    println(message)
}
// or simply
fun printMessage(message: String) {
    println(message)
}

// Default parameters
fun greet(name: String = "Guest", greeting: String = "Hello") {
    println("$greeting, $name!")
}
greet()                        // Hello, Guest!
greet("Alice")                 // Hello, Alice!
greet("Bob", "Hi")             // Hi, Bob!

// Named arguments
greet(greeting = "Hey", name = "Charlie")

// Vararg (variable number of arguments)
fun sum(vararg numbers: Int): Int {
    return numbers.sum()
}
sum(1, 2, 3, 4, 5)             // 15
```

### 6. Classes and Objects

```kotlin
// Simple class
class Person(val name: String, var age: Int)

val person = Person("Alice", 25)
println(person.name)           // Alice
person.age = 26                // OK (var)
// person.name = "Bob"         // ERROR: val cannot be changed

// Class with body
class User(val name: String) {
    var isActive = true

    // Member function
    fun activate() {
        isActive = true
    }

    // Init block (runs when object is created)
    init {
        println("User $name created")
    }
}

// Data class (automatic equals, hashCode, toString, copy)
data class Point(val x: Int, val y: Int)

val p1 = Point(1, 2)
val p2 = Point(1, 2)
println(p1 == p2)              // true (compares values)
println(p1)                    // Point(x=1, y=2)

// Object (singleton)
object DatabaseConfig {
    const val URL = "jdbc:postgresql://localhost"
    fun connect() { /* ... */ }
}
DatabaseConfig.connect()

// Companion object (like static in Java)
class MathUtils {
    companion object {
        const val PI = 3.14159
        fun square(n: Int) = n * n
    }
}
println(MathUtils.PI)          // 3.14159
println(MathUtils.square(5))   // 25
```

### 7. Control Flow

```kotlin
// If expression (returns value)
val max = if (a > b) a else b

val result = if (score >= 90) {
    "A"
} else if (score >= 80) {
    "B"
} else {
    "C"
}

// When expression (like switch, but better)
when (x) {
    1 -> println("One")
    2 -> println("Two")
    3, 4 -> println("Three or Four")
    in 5..10 -> println("Between 5 and 10")
    else -> println("Unknown")
}

val message = when {
    age < 18 -> "Minor"
    age < 65 -> "Adult"
    else -> "Senior"
}

// For loop
for (i in 1..5) {
    println(i)                 // 1, 2, 3, 4, 5
}

for (i in 1 until 5) {
    println(i)                 // 1, 2, 3, 4
}

for (i in 5 downTo 1) {
    println(i)                 // 5, 4, 3, 2, 1
}

for (i in 0..10 step 2) {
    println(i)                 // 0, 2, 4, 6, 8, 10
}

val fruits = listOf("Apple", "Banana", "Orange")
for (fruit in fruits) {
    println(fruit)
}

for ((index, fruit) in fruits.withIndex()) {
    println("$index: $fruit")
}

// While loop
while (x < 10) {
    x++
}

do {
    x++
} while (x < 10)
```

### 8. Collections

```kotlin
// List (immutable)
val fruits = listOf("Apple", "Banana", "Orange")
println(fruits[0])             // Apple
println(fruits.size)           // 3
// fruits.add("Grape")         // ERROR: Cannot modify

// Mutable list
val numbers = mutableListOf(1, 2, 3)
numbers.add(4)
numbers.remove(1)

// Set (unique elements)
val uniqueNumbers = setOf(1, 2, 2, 3)  // [1, 2, 3]

// Map (key-value pairs)
val ages = mapOf(
    "Alice" to 25,
    "Bob" to 30,
    "Charlie" to 35
)
println(ages["Alice"])         // 25

val mutableAges = mutableMapOf("Alice" to 25)
mutableAges["Bob"] = 30

// Collection operations
val numbers = listOf(1, 2, 3, 4, 5)

val doubled = numbers.map { it * 2 }           // [2, 4, 6, 8, 10]
val evens = numbers.filter { it % 2 == 0 }     // [2, 4]
val sum = numbers.sum()                        // 15
val first = numbers.first()                    // 1
val last = numbers.last()                      // 5
val any = numbers.any { it > 3 }               // true
val all = numbers.all { it > 0 }               // true
```

### 9. Lambda Expressions

```kotlin
// Lambda syntax: { parameters -> body }
val sum: (Int, Int) -> Int = { a, b -> a + b }
println(sum(3, 5))             // 8

// Lambda with single parameter (use 'it')
val doubled = listOf(1, 2, 3).map { it * 2 }

// Lambda as function parameter
fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

val result = calculate(5, 3) { x, y -> x + y }  // 8
val result2 = calculate(5, 3) { x, y -> x * y } // 15

// Trailing lambda (if last parameter is lambda, move outside parentheses)
numbers.filter { it > 2 }

// Lambda with receiver (used in Compose)
buildString {
    append("Hello")
    append(" ")
    append("World")
}
```

### 10. Extension Functions

Add functions to existing classes without modifying them.

```kotlin
// Add function to String class
fun String.isPalindrome(): Boolean {
    return this == this.reversed()
}

println("racecar".isPalindrome())      // true
println("hello".isPalindrome())        // false

// Extension with parameters
fun Int.times(action: () -> Unit) {
    for (i in 1..this) {
        action()
    }
}

5.times { println("Hello") }           // Prints "Hello" 5 times
```

### 11. Sealed Classes & Interfaces

Perfect for representing restricted class hierarchies.

```kotlin
// Sealed class (all subclasses must be in same file)
sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
    object Loading : Result()
}

fun handleResult(result: Result) {
    when (result) {
        is Result.Success -> println("Data: ${result.data}")
        is Result.Error -> println("Error: ${result.message}")
        is Result.Loading -> println("Loading...")
        // No 'else' needed - compiler knows all cases
    }
}

// Sealed interface (used for events in Android)
sealed interface UiEvent {
    data class ShowSnackbar(val message: String) : UiEvent
    data class Navigate(val route: String) : UiEvent
    object NavigateBack : UiEvent
}
```

### 12. Scope Functions

Useful for object configuration and transformations.

```kotlin
// let - Execute lambda and return result
val length = "Hello".let {
    println(it)
    it.length
}

// also - Execute lambda and return object
val list = mutableListOf(1, 2, 3).also {
    it.add(4)
    it.add(5)
}

// apply - Configure object and return it
val person = Person("Alice", 25).apply {
    age = 26
    // isActive = true
}

// run - Execute lambda and return result
val result = "Hello".run {
    println(this)
    length
}

// with - Group function calls on object
with(person) {
    println(name)
    println(age)
}
```

### 13. Coroutines Basics

For asynchronous programming (essential for Android).

```kotlin
import kotlinx.coroutines.*

// Launch a coroutine
fun main() = runBlocking {
    launch {
        delay(1000)
        println("World!")
    }
    println("Hello")
}
// Output: Hello, (1 second delay), World!

// Suspend function (can be paused and resumed)
suspend fun fetchData(): String {
    delay(1000)                    // Simulate network call
    return "Data loaded"
}

// Async (returns Deferred<T>, like Future)
suspend fun loadData() {
    val deferred1 = async { fetchData() }
    val deferred2 = async { fetchData() }

    val result1 = deferred1.await()
    val result2 = deferred2.await()
}

// Common dispatchers
launch(Dispatchers.Main) {         // UI thread (Android)
    // Update UI
}

launch(Dispatchers.IO) {           // I/O operations
    // Network, database
}

launch(Dispatchers.Default) {      // CPU-intensive work
    // Heavy computation
}
```

### 14. Common Kotlin Patterns for Android

```kotlin
// Lazy initialization
val database by lazy {
    Room.databaseBuilder(context, AppDatabase::class.java, "app_db").build()
}
// database is created only when first accessed

// Delegation
class User {
    var name: String by Delegates.observable("Initial") { _, old, new ->
        println("Changed from $old to $new")
    }
}

// Type aliases
typealias ClickListener = (View) -> Unit
typealias UserMap = Map<String, User>

// Inline functions (reduce overhead)
inline fun measureTime(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    val end = System.currentTimeMillis()
    println("Time: ${end - start}ms")
}
```

### Quick Kotlin Reference

```kotlin
// Variables
val immutable = "Cannot change"
var mutable = "Can change"

// Functions
fun greet(name: String) = "Hello, $name"

// Classes
data class User(val name: String, var age: Int)

// Collections
val list = listOf(1, 2, 3)
val map = mapOf("key" to "value")

// Null safety
val text: String? = null
val length = text?.length ?: 0

// Control flow
when (x) {
    1 -> println("One")
    else -> println("Other")
}

// Lambdas
list.filter { it > 2 }.map { it * 2 }

// Coroutines
suspend fun load() {
    delay(1000)
}
```

---

## Setting Up Your Environment

### Required Tools

1. **Android Studio** (Official IDE)
   - Download from: https://developer.android.com/studio
   - Includes: Code editor, emulator, debugger, and build tools

2. **JDK (Java Development Kit)**
   - Usually bundled with Android Studio
   - Required for building Android apps

3. **Android SDK**
   - Automatically installed with Android Studio
   - Contains libraries and tools for different Android versions

4. **Device for Testing**
   - Android Emulator (built into Android Studio)
   - OR Physical Android device (enable Developer Options)

---

## Understanding the Project Structure

Your Android project has this structure:

```
android/
├── app/                                    # Main application module
│   ├── build.gradle.kts                   # App dependencies & configuration
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml        # App configuration (IMPORTANT!)
│   │   │   ├── java/com/neomenta/neome/   # Your Kotlin code
│   │   │   │   ├── MainActivity.kt        # Main entry point
│   │   │   │   └── ui/theme/              # App styling & colors
│   │   │   └── res/                       # Resources
│   │   │       ├── drawable/              # Images & icons
│   │   │       ├── mipmap/                # App launcher icons
│   │   │       ├── values/                # Strings, colors, themes
│   │   │       └── xml/                   # XML configs
│   │   ├── test/                          # Unit tests
│   │   └── androidTest/                   # UI/Integration tests
│   └── proguard-rules.pro                 # Code obfuscation rules
├── gradle/                                 # Gradle wrapper files
├── build.gradle.kts                       # Project-level build config
├── settings.gradle.kts                    # Project settings
├── gradle.properties                      # Build properties
├── gradlew                                # Gradle wrapper (Unix)
└── gradlew.bat                            # Gradle wrapper (Windows)
```

### Important Files Explained

#### 1. AndroidManifest.xml
The "blueprint" of your app - declares all components and permissions.

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

  <application
    android:icon="@mipmap/ic_launcher"           <!-- App icon -->
    android:label="@string/app_name"             <!-- App name -->
    android:theme="@style/Theme.Neome">          <!-- App theme -->

    <!-- Main Activity - Entry point of your app -->
    <activity
      android:name=".MainActivity"
      android:exported="true">                   <!-- Visible to other apps -->
      <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
      </intent-filter>
    </activity>
  </application>

</manifest>
```

**Key Points:**
- `android:exported="true"` - Makes activity launchable
- `MAIN` action + `LAUNCHER` category = App shows in launcher
- Add permissions here (e.g., `<uses-permission android:name="android.permission.INTERNET"/>`)

#### 2. build.gradle.kts (App Level)
Configures how your app is built.

```kotlin
android {
    namespace = "com.neomenta.neome"           // Unique package name
    compileSdk = 36                             // SDK version to compile with

    defaultConfig {
        applicationId = "com.neomenta.neome"   // Unique app ID (never change after publish)
        minSdk = 24                             // Minimum Android version (Android 7.0)
        targetSdk = 36                          // Target Android version
        versionCode = 1                         // Increment for each release
        versionName = "1.0"                     // User-visible version
    }
}

dependencies {
    // Add libraries your app needs here
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.material3)
}
```

**Key Concepts:**
- `minSdk`: Oldest Android version you support (higher = fewer devices, newer APIs)
- `targetSdk`: Android version you're targeting (should be latest)
- `versionCode`: Integer version (auto-increment for updates)
- `versionName`: Human-readable version (e.g., "1.0", "2.1")

---

## Key Android Components

### 1. Activity
A **screen** in your app. Each activity represents one focused task.

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This runs when the activity is created
        setContent {
            // Your UI goes here
        }
    }
}
```

**Activity Lifecycle:**
```
onCreate() → onStart() → onResume() → [Running]
    ↓                                      ↓
onDestroy() ← onStop() ← onPause() ← [User leaves]
```

- `onCreate()`: Activity created (initialize UI)
- `onStart()`: Activity visible
- `onResume()`: Activity in foreground (user can interact)
- `onPause()`: Activity partially obscured
- `onStop()`: Activity no longer visible
- `onDestroy()`: Activity destroyed

### 2. Composable Functions
Modern way to build UI with Jetpack Compose.

```kotlin
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
```

**Key Features:**
- Annotated with `@Composable`
- Describe what UI should look like
- Automatically update when data changes (reactive)
- Can be previewed in Android Studio

### 3. State
Data that can change over time and trigger UI updates.

```kotlin
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }

    Button(onClick = { count++ }) {
        Text("Clicked $count times")
    }
}
```

**State Management:**
- `remember` - Preserves state across recompositions
- `mutableStateOf` - Observable state (UI updates when it changes)
- `rememberSaveable` - Survives configuration changes (like rotation)

### 4. ViewModel
Holds UI-related data and survives configuration changes.

```kotlin
class MyViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MyUiState())
    val uiState: StateFlow<MyUiState> = _uiState.asStateFlow()

    fun updateData() {
        _uiState.value = MyUiState(newData = "Updated!")
    }
}
```

**Why Use ViewModel?**
- Survives screen rotation
- Separates UI logic from UI rendering
- Manages data lifecycle properly

---

## Building UI with Jetpack Compose

Jetpack Compose is Android's modern UI toolkit. Write UI in Kotlin code instead of XML.

### Basic Components

#### 1. Text
```kotlin
@Composable
fun TextExamples() {
    Text("Simple text")

    Text(
        text = "Styled text",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue
    )
}
```

#### 2. Button
```kotlin
@Composable
fun ButtonExample() {
    Button(onClick = { /* Do something */ }) {
        Text("Click me!")
    }
}
```

#### 3. Image
```kotlin
@Composable
fun ImageExample() {
    Image(
        painter = painterResource(R.drawable.my_image),
        contentDescription = "Description for accessibility"
    )
}
```

#### 4. TextField (Input)
```kotlin
@Composable
fun TextInputExample() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter your name") }
    )
}
```

### Layouts

#### Column (Vertical)
```kotlin
@Composable
fun VerticalLayout() {
    Column {
        Text("First")
        Text("Second")
        Text("Third")
    }
}
```

#### Row (Horizontal)
```kotlin
@Composable
fun HorizontalLayout() {
    Row {
        Text("Left")
        Text("Middle")
        Text("Right")
    }
}
```

#### Box (Stack)
```kotlin
@Composable
fun StackedLayout() {
    Box {
        Image(...)           // Background
        Text("On top")       // Foreground
    }
}
```

#### LazyColumn (Scrollable List)
```kotlin
@Composable
fun ScrollableList() {
    LazyColumn {
        items(100) { index ->
            Text("Item $index")
        }
    }
}
```

### Modifiers
Modifiers style and position composables.

```kotlin
@Composable
fun ModifierExamples() {
    Text(
        "Styled text",
        modifier = Modifier
            .fillMaxWidth()                    // Take full width
            .padding(16.dp)                    // Add padding
            .background(Color.LightGray)       // Background color
            .clickable { /* Handle click */ }  // Make clickable
    )
}
```

**Common Modifiers:**
- `fillMaxSize()` - Fill available space
- `size(width, height)` - Fixed size
- `padding(dp)` - Add spacing
- `background(color)` - Background color
- `clickable {}` - Handle clicks
- `border()` - Add border
- `clip()` - Clip shape

---

## Understanding Your Current App

Let's break down the code in your `MainActivity.kt`:

```kotlin
// 1. Package declaration - unique identifier for your app
package com.neomenta.neome

// 2. Imports - libraries you're using
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material3.*
// ... more imports

// 3. Main Activity - Entry point of your app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()              // Use full screen (edge-to-edge)
        setContent {                     // Set the UI content
            NeomeTheme {                 // Apply your app theme
                NeomeApp()               // Your main composable
            }
        }
    }
}

// 4. Main App Composable
@Composable
fun NeomeApp() {
    // State: Current selected tab
    var currentDestination by rememberSaveable {
        mutableStateOf(AppDestinations.HOME)
    }

    // Navigation scaffold with bottom navigation
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach { destination ->
                item(
                    icon = { Icon(destination.icon, contentDescription = destination.label) },
                    label = { Text(destination.label) },
                    selected = destination == currentDestination,
                    onClick = { currentDestination = destination }
                )
            }
        }
    ) {
        // Main content area
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Greeting(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

// 5. Navigation destinations (enum)
enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    HOME("Home", Icons.Default.Home),
    FAVORITES("Favorites", Icons.Default.Favorite),
    PROFILE("Profile", Icons.Default.AccountBox),
}

// 6. Simple greeting composable
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

// 7. Preview (shows in Android Studio)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NeomeTheme {
        Greeting("Android")
    }
}
```

### What This App Does

1. Shows a bottom navigation bar with 3 tabs: Home, Favorites, Profile
2. Displays "Hello Android!" in the main content area
3. Uses Material 3 design (modern Material Design)
4. Adapts to different screen sizes (phone, tablet, foldable)

---

## Running Your App

### Method 1: Using Android Emulator

1. Open Android Studio
2. Click "Device Manager" in the toolbar
3. Click "Create Device"
4. Select a device (e.g., Pixel 6)
5. Select a system image (Android version)
6. Click "Finish"
7. Click the green "Run" button (or press Shift+F10)

### Method 2: Using Physical Device

1. On your Android device:
   - Go to Settings → About Phone
   - Tap "Build Number" 7 times (enables Developer Options)
   - Go to Settings → Developer Options
   - Enable "USB Debugging"

2. Connect device via USB

3. In Android Studio:
   - Device appears in device dropdown
   - Click "Run" button

### Common Run Commands

```bash
# Build the app
./gradlew assembleDebug

# Install on connected device
./gradlew installDebug

# Run tests
./gradlew test

# Clean build
./gradlew clean
```

---

## Common Android Concepts

### 1. Intents
A message to start another component (activity, service, etc.)

```kotlin
// Start another activity
val intent = Intent(this, SecondActivity::class.java)
startActivity(intent)

// Start activity with data
val intent = Intent(this, DetailActivity::class.java)
intent.putExtra("USER_ID", 123)
startActivity(intent)
```

### 2. Resources
Assets stored in `res/` folder.

```kotlin
// Access string resource
val text = getString(R.string.app_name)

// Access color resource
val color = getColor(R.color.primary)

// Access drawable resource
val icon = getDrawable(R.drawable.ic_launcher)
```

**Define in XML:**
```xml
<!-- res/values/strings.xml -->
<resources>
    <string name="app_name">Neome</string>
    <string name="welcome">Welcome to my app!</string>
</resources>
```

### 3. Permissions
Declare what your app needs access to.

```xml
<!-- AndroidManifest.xml -->
<manifest>
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.CAMERA" />

    <application>
        ...
    </application>
</manifest>
```

**Request at runtime (for dangerous permissions):**
```kotlin
// Check permission
if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
    != PackageManager.PERMISSION_GRANTED) {
    // Request permission
    ActivityCompat.requestPermissions(this,
        arrayOf(Manifest.permission.CAMERA),
        REQUEST_CODE)
}
```

### 4. Coroutines (Async Operations)
Handle background tasks without blocking the UI.

```kotlin
// In ViewModel
viewModelScope.launch {
    val data = repository.fetchData()  // Background work
    _uiState.value = data               // Update UI
}

// In Composable
LaunchedEffect(Unit) {
    delay(1000)
    println("This runs after 1 second")
}
```

---

## Debugging Tips

### 1. Logcat
Android's logging system - see app logs in Android Studio.

```kotlin
import android.util.Log

Log.d("TAG", "Debug message")
Log.i("TAG", "Info message")
Log.w("TAG", "Warning message")
Log.e("TAG", "Error message")
```

### 2. Breakpoints
Click left margin in code editor to set breakpoints. Run in Debug mode (Shift+F9).

### 3. Preview
Use `@Preview` to see composables without running the app.

```kotlin
@Preview(showBackground = true)
@Composable
fun MyPreview() {
    NeomeTheme {
        Greeting("Preview")
    }
}
```

### 4. Common Errors

**"Unresolved reference"**
- Import missing (Alt+Enter to auto-import)
- Sync Gradle (File → Sync Project with Gradle Files)

**"App keeps crashing"**
- Check Logcat for stack trace
- Look for red errors in console

**"Build failed"**
- Check `build.gradle.kts` for syntax errors
- Invalidate caches (File → Invalidate Caches / Restart)

---

## Next Steps

### 1. Learn More Compose
- Build a counter app
- Create a login form
- Make a simple calculator
- Build a todo list

### 2. Learn Navigation
- Navigate between screens
- Pass data between screens
- Handle back button

### 3. Learn Data Storage
- **SharedPreferences** - Simple key-value storage
- **Room Database** - Local SQL database
- **DataStore** - Modern key-value storage

### 4. Learn Networking
- Use Retrofit to call APIs
- Display data from internet
- Handle loading and error states

### 5. Follow Best Practices
- Use Clean Architecture (see CLAUDE.md)
- Implement MVI pattern for state management
- Write unit tests
- Use dependency injection (Hilt)

---

## Useful Resources

### Official Documentation
- Android Developers: https://developer.android.com
- Jetpack Compose: https://developer.android.com/jetpack/compose
- Kotlin: https://kotlinlang.org/docs/home.html

### Tutorials
- Android Basics in Compose: https://developer.android.com/courses/android-basics-compose/course
- Codelabs: https://developer.android.com/codelabs

### Community
- Stack Overflow: https://stackoverflow.com/questions/tagged/android
- Reddit: r/androiddev
- Discord: Android Dev Discord

---

## Quick Reference

### Gradle Commands
```bash
./gradlew assembleDebug      # Build debug APK
./gradlew assembleRelease    # Build release APK
./gradlew clean              # Clean build
./gradlew test               # Run unit tests
./gradlew connectedAndroidTest  # Run instrumented tests
```

### Common Compose Patterns
```kotlin
// State
var text by remember { mutableStateOf("") }

// Effect
LaunchedEffect(key) { /* Side effect */ }

// Lifecycle-aware state
val state by viewModel.state.collectAsStateWithLifecycle()

// List
LazyColumn {
    items(list) { item -> /* Item UI */ }
}
```

### File Shortcuts
- `MainActivity.kt` - Main screen entry point
- `AndroidManifest.xml` - App configuration
- `build.gradle.kts` - Dependencies & build config
- `strings.xml` - Text resources
- `themes.xml` - App styling

---

Happy coding! Start small, build incrementally, and don't hesitate to experiment. Android development is a journey - enjoy the process!