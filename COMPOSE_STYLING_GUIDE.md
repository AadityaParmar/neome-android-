# Jetpack Compose Styling Guide for CSS Developers

A comprehensive guide to styling in Jetpack Compose for developers familiar with CSS.

## Table of Contents

1. [CSS to Modifier Mapping](#css-to-modifier-mapping)
2. [Layout Systems](#layout-systems)
3. [Flexbox to Column/Row](#flexbox-to-columnrow)
4. [Sizing](#sizing)
5. [Spacing](#spacing)
6. [Positioning](#positioning)
7. [Alignment and Arrangement](#alignment-and-arrangement)
8. [Constraints and Measurements](#constraints-and-measurements)
9. [Visual Styling](#visual-styling)
10. [Responsive Design](#responsive-design)
11. [Advanced Patterns](#advanced-patterns)
12. [Best Practices](#best-practices)

---

## CSS to Modifier Mapping

### Quick Reference Table

| CSS Property               | Compose Modifier                                 | Example                         |
|----------------------------|--------------------------------------------------|---------------------------------|
| `width: 100px`             | `.width(100.dp)`                                 | Fixed width                     |
| `width: 100%`              | `.fillMaxWidth()`                                | Fill parent width               |
| `width: auto`              | No modifier (wrap content)                       | Default behavior                |
| `min-width: 100px`         | `.widthIn(min = 100.dp)`                         | Minimum width                   |
| `max-width: 300px`         | `.widthIn(max = 300.dp)`                         | Maximum width                   |
| `height: 100px`            | `.height(100.dp)`                                | Fixed height                    |
| `height: 100%`             | `.fillMaxHeight()`                               | Fill parent height              |
| `height: auto`             | No modifier (wrap content)                       | Default behavior                |
| `padding: 16px`            | `.padding(16.dp)`                                | All sides                       |
| `padding: 8px 16px`        | `.padding(horizontal = 16.dp, vertical = 8.dp)`  | Horizontal/Vertical             |
| `margin: 16px`             | Parent uses `Spacer` or `Arrangement.spacedBy()` | No direct margin                |
| `background-color: red`    | `.background(Color.Red)`                         | Background color                |
| `border: 1px solid black`  | `.border(1.dp, Color.Black)`                     | Border                          |
| `border-radius: 8px`       | `.clip(RoundedCornerShape(8.dp))`                | Rounded corners                 |
| `display: flex`            | `Row` or `Column`                                | Flexbox container               |
| `flex-direction: row`      | `Row`                                            | Horizontal flex                 |
| `flex-direction: column`   | `Column`                                         | Vertical flex                   |
| `justify-content: center`  | `horizontalArrangement = Arrangement.Center`     | Main axis                       |
| `align-items: center`      | `verticalAlignment = Alignment.CenterVertically` | Cross axis                      |
| `position: absolute`       | `Box` with `Alignment` or `.offset()`            | Absolute positioning            |
| `position: relative`       | `Box`                                            | Container for absolute children |
| `position: fixed`          | N/A (use scaffold/overlay patterns)              | Fixed positioning               |
| `z-index: 10`              | `.zIndex(10f)`                                   | Layering order                  |
| `opacity: 0.5`             | `.alpha(0.5f)`                                   | Transparency                    |
| `overflow: hidden`         | `.clip(shape)`                                   | Clip overflow                   |
| `box-shadow`               | `.shadow(8.dp)`                                  | Elevation shadow                |
| `transform: scale(1.5)`    | `.scale(1.5f)`                                   | Scale transform                 |
| `transform: rotate(45deg)` | `.rotate(45f)`                                   | Rotation                        |
| `cursor: pointer`          | `.clickable { }`                                 | Click interaction               |
| `flex: 1`                  | `.weight(1f)`                                    | Flex grow                       |
| `aspect-ratio: 16/9`       | `.aspectRatio(16f/9f)`                           | Aspect ratio                    |

---

## Layout Systems

### CSS Display Types

#### CSS

```css
/* Block - Takes full width, stacks vertically */
div {
  display: block;
}

/* Inline - Takes only content width */
span {
  display: inline;
}

/* Flex - Flexible box layout */
.container {
  display: flex;
}

/* Grid - Grid layout */
.container {
  display: grid;
}

/* None - Hidden */
.hidden {
  display: none;
}
```

#### Compose

```kotlin
// Block equivalent - Column (vertical stacking)
Column {
    Text("Item 1")  // Takes full width by default in Column
    Text("Item 2")
}

// Inline equivalent - Row (horizontal)
Row {
    Text("Item 1")  // Takes only content width
    Text("Item 2")
}

// Flex equivalent - Row/Column with modifiers
Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween
) {
    Text("Left")
    Text("Right")
}

// Grid equivalent - LazyVerticalGrid
LazyVerticalGrid(
    columns = GridCells.Fixed(3)
) {
    items(9) { index ->
        Text("Item $index")
    }
}

// None equivalent - Conditional rendering
if (isVisible) {
    Text("Visible")
}
// Or use .alpha(0f) for layout space preservation
Text("Hidden", modifier = Modifier.alpha(0f))
```

### Layout Hierarchy

```kotlin
// Root layout containers
Box {
    // Stack items on top of each other (z-axis)
    // Like position: relative container
}

Column {
    // Stack items vertically (y-axis)
    // Like flex-direction: column
}

Row {
    // Stack items horizontally (x-axis)
    // Like flex-direction: row
}

// Can be nested
Column {
    Row {
        Box {
            // Deeply nested layouts
        }
    }
}
```

---

## Flexbox to Column/Row

### Flex Container Properties

#### 1. flex-direction

##### CSS

```css
.container {
  display: flex;
  flex-direction: row; /* or column, row-reverse, column-reverse */
}
```

##### Compose

```kotlin
// flex-direction: row
Row {
    Text("1")
    Text("2")
    Text("3")
}
// Output: 1 2 3

// flex-direction: row-reverse
Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.End
) {
    // Items in reverse order
    Text("3")
    Text("2")
    Text("1")
}
// Or use reverseLayout in LazyRow
LazyRow(reverseLayout = true) { }

// flex-direction: column
Column {
    Text("1")
    Text("2")
    Text("3")
}
// Output:
// 1
// 2
// 3

// flex-direction: column-reverse
Column(
    modifier = Modifier.fillMaxHeight(),
    verticalArrangement = Arrangement.Bottom
) {
    Text("3")
    Text("2")
    Text("1")
}
```

#### 2. justify-content (Main Axis)

##### CSS

```css
.container {
  display: flex;
  justify-content: flex-start; /* flex-end, center, space-between, space-around, space-evenly */
}
```

##### Compose

```kotlin
// For Row (horizontal main axis)
Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Start  // justify-content: flex-start
) { }

Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.End  // justify-content: flex-end
) { }

Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center  // justify-content: center
) { }

Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween  // justify-content: space-between
) { }

Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceAround  // justify-content: space-around
) { }

Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceEvenly  // justify-content: space-evenly
) { }

// For Column (vertical main axis)
Column(
    modifier = Modifier.fillMaxHeight(),
    verticalArrangement = Arrangement.Top  // justify-content: flex-start
) { }

Column(
    modifier = Modifier.fillMaxHeight(),
    verticalArrangement = Arrangement.Bottom  // justify-content: flex-end
) { }

Column(
    modifier = Modifier.fillMaxHeight(),
    verticalArrangement = Arrangement.Center  // justify-content: center
) { }

Column(
    modifier = Modifier.fillMaxHeight(),
    verticalArrangement = Arrangement.SpaceBetween  // justify-content: space-between
) { }

// With specific spacing
Row(
    horizontalArrangement = Arrangement.spacedBy(16.dp)
) { }
```

#### 3. align-items (Cross Axis)

##### CSS

```css
.container {
  display: flex;
  align-items: stretch; /* flex-start, flex-end, center, baseline */
}
```

##### Compose

```kotlin
// For Row (vertical cross axis)
Row(
    verticalAlignment = Alignment.Top  // align-items: flex-start
) { }

Row(
    verticalAlignment = Alignment.Bottom  // align-items: flex-end
) { }

Row(
    verticalAlignment = Alignment.CenterVertically  // align-items: center
) { }

// No direct baseline support, but can use:
Row {
    Text(
        "Text",
        modifier = Modifier.alignByBaseline()
    )
}

// For Column (horizontal cross axis)
Column(
    horizontalAlignment = Alignment.Start  // align-items: flex-start
) { }

Column(
    horizontalAlignment = Alignment.End  // align-items: flex-end
) { }

Column(
    horizontalAlignment = Alignment.CenterHorizontally  // align-items: center
) { }

// Stretch (default for fillMaxWidth/Height)
Column(
    modifier = Modifier.fillMaxWidth()
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()  // Stretches to parent width
            .height(100.dp)
            .background(Color.Red)
    )
}
```

#### 4. align-self (Individual Item Alignment)

##### CSS

```css
.item {
  align-self: center; /* flex-start, flex-end, stretch, baseline */
}
```

##### Compose

```kotlin
Row(
    modifier = Modifier.fillMaxWidth().height(100.dp)
) {
    // Different alignments for each item
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.Red)
            .align(Alignment.Top)  // align-self: flex-start
    )

    Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.Blue)
            .align(Alignment.CenterVertically)  // align-self: center
    )

    Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.Green)
            .align(Alignment.Bottom)  // align-self: flex-end
    )
}

// In Column
Column(
    modifier = Modifier.fillMaxSize()
) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.Red)
            .align(Alignment.Start)  // align-self: flex-start
    )

    Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.Blue)
            .align(Alignment.CenterHorizontally)  // align-self: center
    )

    Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.Green)
            .align(Alignment.End)  // align-self: flex-end
    )
}
```

#### 5. flex-wrap

##### CSS

```css
.container {
  display: flex;
  flex-wrap: wrap; /* nowrap, wrap-reverse */
}
```

##### Compose

```kotlin
// Use FlowRow/FlowColumn for wrapping
FlowRow(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    repeat(20) { index ->
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Blue)
        ) {
            Text("$index", color = Color.White)
        }
    }
    // Automatically wraps to next line
}

// FlowColumn for vertical wrapping
FlowColumn(
    modifier = Modifier.height(400.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp)
) {
    repeat(20) { index ->
        Text("Item $index")
    }
    // Wraps to next column
}
```

#### 6. flex (flex-grow, flex-shrink, flex-basis)

##### CSS

```css
.item {
  flex: 1; /* flex-grow: 1, flex-shrink: 1, flex-basis: 0% */
  flex-grow: 2;
  flex-shrink: 0;
  flex-basis: 100px;
}
```

##### Compose

```kotlin
// flex: 1 equivalent - weight modifier
Row(modifier = Modifier.fillMaxWidth()) {
    Box(
        modifier = Modifier
            .weight(1f)  // flex: 1
            .height(50.dp)
            .background(Color.Red)
    )

    Box(
        modifier = Modifier
            .weight(2f)  // flex: 2 (grows twice as much)
            .height(50.dp)
            .background(Color.Blue)
    )

    Box(
        modifier = Modifier
            .width(100.dp)  // flex-basis: 100px (fixed width)
            .height(50.dp)
            .background(Color.Green)
    )
}

// weight with fill parameter
Row(modifier = Modifier.fillMaxWidth()) {
    Box(
        modifier = Modifier
            .weight(1f, fill = true)  // Fills available space
            .height(50.dp)
            .background(Color.Red)
    )

    Box(
        modifier = Modifier
            .weight(1f, fill = false)  // Takes minimum needed
            .height(50.dp)
            .background(Color.Blue)
    )
}

// Practical example: Form layout
Column(modifier = Modifier.fillMaxSize()) {
    // Header - fixed size
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Blue)
    )

    // Content - grows to fill
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f)  // Takes remaining space
            .background(Color.LightGray)
    )

    // Footer - fixed size
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Blue)
    )
}
```

### Complete Flexbox Example

#### CSS

```css
.container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  padding: 16px;
  gap: 8px;
}

.item {
  flex: 1;
  padding: 8px;
}

.item:first-child {
  flex: 2;
}
```

#### Compose

```kotlin
Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp),  // gap: 8px
    verticalAlignment = Alignment.CenterVertically
) {
    Box(
        modifier = Modifier
            .weight(2f)  // flex: 2
            .padding(8.dp)
            .background(Color.Red)
    ) {
        Text("Item 1")
    }

    Box(
        modifier = Modifier
            .weight(1f)  // flex: 1
            .padding(8.dp)
            .background(Color.Blue)
    ) {
        Text("Item 2")
    }

    Box(
        modifier = Modifier
            .weight(1f)  // flex: 1
            .padding(8.dp)
            .background(Color.Green)
    ) {
        Text("Item 3")
    }
}
```

---

## Sizing

### Width

#### CSS

```css
.element {
  width: auto;      /* Default - fits content */
  width: 100px;     /* Fixed width */
  width: 100%;      /* Fill parent */
  width: 50vw;      /* Viewport width */
  min-width: 100px;
  max-width: 500px;
}
```

#### Compose

```kotlin
// width: auto (default - wrap content)
Box {
    Text("Content")  // Width = content width
}

// width: 100px
Box(
    modifier = Modifier
        .width(100.dp)
        .background(Color.Red)
) {
    Text("Fixed")
}

// width: 100%
Box(
    modifier = Modifier
        .fillMaxWidth()
        .background(Color.Blue)
) {
    Text("Full Width")
}

// width: 50%
Row(modifier = Modifier.fillMaxWidth()) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.5f)  // 50% of parent
            .background(Color.Green)
    ) {
        Text("Half Width")
    }
}

// width: 50vw (screen width)
val configuration = LocalConfiguration.current
val screenWidth = configuration.screenWidthDp.dp

Box(
    modifier = Modifier
        .width(screenWidth * 0.5f)
        .background(Color.Yellow)
)

// min-width, max-width
Box(
    modifier = Modifier
        .widthIn(min = 100.dp, max = 500.dp)
        .background(Color.Cyan)
) {
    Text("Constrained Width")
}

// Specific min or max only
Box(modifier = Modifier.widthIn(min = 100.dp))
Box(modifier = Modifier.widthIn(max = 500.dp))

// Default min constraints
Box(
    modifier = Modifier
        .defaultMinSize(minWidth = 48.dp)  // Minimum touch target
        .background(Color.Red)
)
```

### Height

#### CSS

```css
.element {
  height: auto;
  height: 100px;
  height: 100%;
  height: 50vh;
  min-height: 100px;
  max-height: 500px;
}
```

#### Compose

```kotlin
// height: auto (default)
Box {
    Text("Content")
}

// height: 100px
Box(
    modifier = Modifier
        .height(100.dp)
        .background(Color.Red)
)

// height: 100%
Box(
    modifier = Modifier
        .fillMaxHeight()
        .background(Color.Blue)
)

// height: 50%
Column(modifier = Modifier.fillMaxHeight()) {
    Box(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .background(Color.Green)
    )
}

// height: 50vh (screen height)
val configuration = LocalConfiguration.current
val screenHeight = configuration.screenHeightDp.dp

Box(
    modifier = Modifier
        .height(screenHeight * 0.5f)
        .background(Color.Yellow)
)

// min-height, max-height
Box(
    modifier = Modifier
        .heightIn(min = 100.dp, max = 500.dp)
        .background(Color.Cyan)
) {
    Text("Constrained Height")
}
```

### Size (Width + Height)

```kotlin
// width: 100px; height: 100px;
Box(
    modifier = Modifier
        .size(100.dp)
        .background(Color.Red)
)

// Different width and height
Box(
    modifier = Modifier
        .size(width = 150.dp, height = 100.dp)
        .background(Color.Blue)
)

// Fill entire parent
Box(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.Green)
)

// Fill 50% of parent width and height
Box(
    modifier = Modifier
        .fillMaxSize(0.5f)
        .background(Color.Yellow)
)

// Required size (won't shrink below this)
Box(
    modifier = Modifier
        .requiredSize(100.dp)
        .background(Color.Red)
)
```

### Aspect Ratio

#### CSS

```css
.element {
  aspect-ratio: 16 / 9;
  aspect-ratio: 1; /* Square */
}
```

#### Compose

```kotlin
// 16:9 aspect ratio
Box(
    modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(16f / 9f)
        .background(Color.Red)
)

// Square (1:1)
Box(
    modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(1f)
        .background(Color.Blue)
)

// Portrait (9:16)
Box(
    modifier = Modifier
        .width(200.dp)
        .aspectRatio(9f / 16f)
        .background(Color.Green)
)

// Practical: Image with aspect ratio
AsyncImage(
    model = "https://example.com/image.jpg",
    contentDescription = null,
    modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(16f / 9f)
        .clip(RoundedCornerShape(8.dp)),
    contentScale = ContentScale.Crop
)
```

### Intrinsic Size

```kotlin
// Let children determine size
Row(
    modifier = Modifier
        .width(IntrinsicSize.Min)  // Width = narrowest child
        .background(Color.LightGray)
) {
    Text("Short")
    Text("Very Long Text")
}

// Max intrinsic width
Row(
    modifier = Modifier
        .width(IntrinsicSize.Max)  // Width = widest child
        .background(Color.LightGray)
) {
    Text("Short")
    Text("Very Long Text")
}

// Practical: Align text fields
Column(
    modifier = Modifier.width(IntrinsicSize.Max)
) {
    Row {
        Text("Name:", modifier = Modifier.width(IntrinsicSize.Max))
        TextField(value = name, onValueChange = { name = it })
    }
    Row {
        Text("Email:", modifier = Modifier.width(IntrinsicSize.Max))
        TextField(value = email, onValueChange = { email = it })
    }
}
```

---

## Spacing

### Padding

#### CSS

```css
.element {
  padding: 16px;                    /* All sides */
  padding: 8px 16px;                /* Vertical Horizontal */
  padding: 8px 16px 12px 20px;      /* Top Right Bottom Left */
  padding-top: 8px;
  padding-right: 16px;
  padding-bottom: 12px;
  padding-left: 20px;
}
```

#### Compose

```kotlin
// padding: 16px (all sides)
Box(
    modifier = Modifier
        .padding(16.dp)
        .background(Color.Red)
) {
    Text("Padded")
}

// padding: 8px 16px (vertical, horizontal)
Box(
    modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .background(Color.Blue)
) {
    Text("Padded")
}

// padding: 8px 16px 12px 20px (top, right, bottom, left)
Box(
    modifier = Modifier
        .padding(
            top = 8.dp,
            end = 16.dp,  // Use 'end' instead of 'right' for RTL support
            bottom = 12.dp,
            start = 20.dp  // Use 'start' instead of 'left'
        )
        .background(Color.Green)
) {
    Text("Padded")
}

// Individual sides
Box(
    modifier = Modifier
        .padding(top = 8.dp)
        .background(Color.Yellow)
)

// IMPORTANT: Order matters!
Box(
    modifier = Modifier
        .background(Color.Red)      // Background color
        .padding(16.dp)             // Padding INSIDE the background
        .background(Color.Blue)     // Another background (inner)
) {
    Text("Layered")
}
// vs
Box(
    modifier = Modifier
        .padding(16.dp)             // Padding OUTSIDE the background
        .background(Color.Red)
) {
    Text("Padded")
}
```

### Margin (Spacing Between Elements)

#### CSS

```css
.element {
  margin: 16px;
  margin-bottom: 8px;
}
```

#### Compose

```kotlin
// ❌ NO direct margin modifier in Compose!

// ✅ Solution 1: Use Spacer
Column {
    Text("Item 1")
    Spacer(modifier = Modifier.height(16.dp))  // margin-bottom: 16px
    Text("Item 2")
    Spacer(modifier = Modifier.height(8.dp))
    Text("Item 3")
}

Row {
    Text("Item 1")
    Spacer(modifier = Modifier.width(16.dp))  // margin-right: 16px
    Text("Item 2")
    Spacer(modifier = Modifier.width(8.dp))
    Text("Item 3")
}

// ✅ Solution 2: Use Arrangement.spacedBy (RECOMMENDED)
Column(
    verticalArrangement = Arrangement.spacedBy(16.dp)  // gap: 16px
) {
    Text("Item 1")
    Text("Item 2")
    Text("Item 3")
    // Automatic spacing between all items
}

Row(
    horizontalArrangement = Arrangement.spacedBy(8.dp)
) {
    Text("Item 1")
    Text("Item 2")
    Text("Item 3")
}

// ✅ Solution 3: Use padding on parent
Column {
    Box(modifier = Modifier.padding(bottom = 16.dp)) {
        Text("Item 1")
    }
    Box(modifier = Modifier.padding(bottom = 8.dp)) {
        Text("Item 2")
    }
    Text("Item 3")
}

// ✅ Solution 4: Use padding as "margin"
Column {
    Text("Item 1", modifier = Modifier.padding(bottom = 16.dp))
    Text("Item 2", modifier = Modifier.padding(bottom = 8.dp))
    Text("Item 3")
}
```

### Gap (spacing between flex items)

#### CSS

```css
.container {
  display: flex;
  gap: 16px;
  row-gap: 8px;
  column-gap: 12px;
}
```

#### Compose

```kotlin
// gap: 16px
Row(
    horizontalArrangement = Arrangement.spacedBy(16.dp)
) {
    Text("Item 1")
    Text("Item 2")
    Text("Item 3")
}

Column(
    verticalArrangement = Arrangement.spacedBy(16.dp)
) {
    Text("Item 1")
    Text("Item 2")
    Text("Item 3")
}

// Different horizontal and vertical gaps in FlowRow
FlowRow(
    horizontalArrangement = Arrangement.spacedBy(12.dp),  // column-gap
    verticalArrangement = Arrangement.spacedBy(8.dp)       // row-gap
) {
    repeat(10) {
        Text("Item $it")
    }
}
```

### Negative Spacing

```kotlin
// Negative padding (overlap)
Box {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
    )

    Box(
        modifier = Modifier
            .offset(x = (-20).dp, y = (-20).dp)  // Negative "margin"
            .size(100.dp)
            .background(Color.Blue)
    )
}

// Overlap effect
Row {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
            .zIndex(1f)
    )

    Box(
        modifier = Modifier
            .offset(x = (-30).dp)  // Overlap by 30dp
            .size(100.dp)
            .background(Color.Blue)
            .zIndex(2f)
    )
}
```

---

## Positioning

### CSS Position Types

#### CSS

```css
.element {
  position: static;    /* Default */
  position: relative;  /* Offset from normal position */
  position: absolute;  /* Offset from parent */
  position: fixed;     /* Offset from viewport */
  position: sticky;    /* Hybrid */
}
```

### Static (Default)

#### CSS

```css
.element {
  position: static;  /* Default, follows normal flow */
}
```

#### Compose

```kotlin
// Default behavior - just place in parent
Column {
    Text("Item 1")  // Normal flow
    Text("Item 2")
    Text("Item 3")
}
```

### Relative Positioning

#### CSS

```css
.element {
  position: relative;
  top: 10px;
  left: 20px;
}
```

#### Compose

```kotlin
// Use offset modifier
Column {
    Text("Item 1")

    Text(
        "Item 2",
        modifier = Modifier
            .offset(x = 20.dp, y = 10.dp)  // top: 10px, left: 20px
            .background(Color.Yellow)
    )

    Text("Item 3")  // Still in flow, pushed down by Item 2's original space
}

// Animated offset
var offsetX by remember { mutableStateOf(0.dp) }

Text(
    "Animated",
    modifier = Modifier
        .offset(x = offsetX)
        .clickable { offsetX += 10.dp }
)
```

### Absolute Positioning

#### CSS

```css
.parent {
  position: relative;
}

.child {
  position: absolute;
  top: 10px;
  right: 20px;
  bottom: 10px;
  left: 20px;
}
```

#### Compose

```kotlin
// Box is the "position: relative" container
Box(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray)
) {
    // Child 1 - Top Left
    Text(
        "Top Left",
        modifier = Modifier
            .align(Alignment.TopStart)
            .padding(16.dp)
    )

    // Child 2 - Top Right
    Text(
        "Top Right",
        modifier = Modifier
            .align(Alignment.TopEnd)
            .padding(16.dp)
    )

    // Child 3 - Center
    Text(
        "Center",
        modifier = Modifier.align(Alignment.Center)
    )

    // Child 4 - Bottom Right
    Text(
        "Bottom Right",
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(16.dp)
    )

    // Child 5 - Custom position
    Text(
        "Custom",
        modifier = Modifier
            .align(Alignment.TopStart)
            .offset(x = 100.dp, y = 200.dp)
    )
}

// All alignment options
Alignment.TopStart        // top: 0, left: 0
Alignment.TopCenter       // top: 0, left: 50%
Alignment.TopEnd          // top: 0, right: 0
Alignment.CenterStart     // top: 50%, left: 0
Alignment.Center          // top: 50%, left: 50%
Alignment.CenterEnd       // top: 50%, right: 0
Alignment.BottomStart     // bottom: 0, left: 0
Alignment.BottomCenter    // bottom: 0, left: 50%
Alignment.BottomEnd       // bottom: 0, right: 0

// Precise positioning with offset
Box(modifier = Modifier.fillMaxSize()) {
    Box(
        modifier = Modifier
            .align(Alignment.TopStart)
            .offset(x = 20.dp, y = 10.dp)  // top: 10px, left: 20px
            .size(50.dp)
            .background(Color.Red)
    )
}

// From bottom/right
Box(modifier = Modifier.fillMaxSize()) {
    Box(
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .offset(x = (-20).dp, y = (-10).dp)  // bottom: 10px, right: 20px
            .size(50.dp)
            .background(Color.Blue)
    )
}

// Multiple absolute positioned children
Box(modifier = Modifier.fillMaxSize()) {
    // Background
    Image(
        painter = painterResource(R.drawable.background),
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )

    // Overlay badge
    Box(
        modifier = Modifier
            .align(Alignment.TopEnd)
            .padding(16.dp)
            .size(24.dp)
            .background(Color.Red, CircleShape)
    )

    // Floating action button
    FloatingActionButton(
        onClick = { },
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(16.dp)
    ) {
        Icon(Icons.Default.Add, contentDescription = null)
    }
}
```

### Fixed Positioning (Viewport)

#### CSS

```css
.element {
  position: fixed;
  top: 0;
  right: 0;
}
```

#### Compose

```kotlin
// Use Scaffold with floating components
@Composable
fun FixedPositionExample() {
    Scaffold(
        floatingActionButton = {
            // Fixed bottom-right FAB
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        },
        topBar = {
            // Fixed top bar
            TopAppBar(title = { Text("Title") })
        },
        bottomBar = {
            // Fixed bottom bar
            BottomAppBar {
                Text("Bottom")
            }
        }
    ) { padding ->
        // Content with padding to avoid overlap
        Content(modifier = Modifier.padding(padding))
    }
}

// Custom fixed overlay
@Composable
fun CustomFixedOverlay() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Main content (scrollable)
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(50) {
                Text("Item $it", modifier = Modifier.padding(16.dp))
            }
        }

        // Fixed header (stays on top while scrolling)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.Blue)
                .align(Alignment.TopCenter)
        ) {
            Text("Fixed Header", color = Color.White)
        }
    }
}
```

### Sticky Positioning

#### CSS

```css
.element {
  position: sticky;
  top: 0;
}
```

#### Compose

```kotlin
// Use stickyHeader in LazyColumn
LazyColumn {
    // Section 1
    stickyHeader {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .padding(16.dp)
        ) {
            Text("Section 1", color = Color.White)
        }
    }
    items(20) {
        Text("Item $it", modifier = Modifier.padding(16.dp))
    }

    // Section 2
    stickyHeader {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
                .padding(16.dp)
        ) {
            Text("Section 2", color = Color.White)
        }
    }
    items(20) {
        Text("Item $it", modifier = Modifier.padding(16.dp))
    }
}
```

### Z-Index (Layering)

#### CSS

```css
.element {
  z-index: 10;
}
```

#### Compose

```kotlin
Box(modifier = Modifier.fillMaxSize()) {
    // Layer 1 (bottom)
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Red)
            .align(Alignment.Center)
    )

    // Layer 2
    Box(
        modifier = Modifier
            .size(150.dp)
            .background(Color.Blue)
            .align(Alignment.Center)
            .offset(x = 20.dp, y = 20.dp)
    )

    // Layer 3 (top)
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Green)
            .align(Alignment.Center)
            .offset(x = 40.dp, y = 40.dp)
    )
}

// Explicit z-index control
Box(modifier = Modifier.fillMaxSize()) {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Red)
            .zIndex(2f)  // Brings to front
    )

    Box(
        modifier = Modifier
            .size(150.dp)
            .background(Color.Blue)
            .offset(x = 20.dp, y = 20.dp)
            .zIndex(1f)
    )

    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Green)
            .offset(x = 40.dp, y = 40.dp)
            .zIndex(0f)  // Default
    )
}
```

---

## Alignment and Arrangement

### Box Alignment (Absolute)

```kotlin
Box(modifier = Modifier.fillMaxSize()) {
    Text("Center", modifier = Modifier.align(Alignment.Center))

    // All 9 positions
    Text("TL", modifier = Modifier.align(Alignment.TopStart))
    Text("TC", modifier = Modifier.align(Alignment.TopCenter))
    Text("TR", modifier = Modifier.align(Alignment.TopEnd))
    Text("CL", modifier = Modifier.align(Alignment.CenterStart))
    Text("C", modifier = Modifier.align(Alignment.Center))
    Text("CR", modifier = Modifier.align(Alignment.CenterEnd))
    Text("BL", modifier = Modifier.align(Alignment.BottomStart))
    Text("BC", modifier = Modifier.align(Alignment.BottomCenter))
    Text("BR", modifier = Modifier.align(Alignment.BottomEnd))
}

// BiasAlignment for precise control
Box(modifier = Modifier.fillMaxSize()) {
    Text(
        "Custom",
        modifier = Modifier.align(
            // -1f = left/top, 0f = center, 1f = right/bottom
            BiasAlignment(
                horizontalBias = 0.5f,  // 50% from left (center)
                verticalBias = -0.5f    // 25% from top
            )
        )
    )
}
```

### Row Alignment

```kotlin
// Horizontal arrangement (main axis)
Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Start  // Left
) { }

Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center  // Center
) { }

Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.End  // Right
) { }

Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween
) { }

Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceAround
) { }

Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceEvenly
) { }

// Vertical alignment (cross axis)
Row(
    modifier = Modifier.height(100.dp),
    verticalAlignment = Alignment.Top
) { }

Row(
    modifier = Modifier.height(100.dp),
    verticalAlignment = Alignment.CenterVertically
) { }

Row(
    modifier = Modifier.height(100.dp),
    verticalAlignment = Alignment.Bottom
) { }

// Both
Row(
    modifier = Modifier
        .fillMaxWidth()
        .height(100.dp),
    horizontalArrangement = Arrangement.SpaceEvenly,
    verticalAlignment = Alignment.CenterVertically
) {
    Text("1")
    Text("2")
    Text("3")
}
```

### Column Alignment

```kotlin
// Vertical arrangement (main axis)
Column(
    modifier = Modifier.fillMaxHeight(),
    verticalArrangement = Arrangement.Top
) { }

Column(
    modifier = Modifier.fillMaxHeight(),
    verticalArrangement = Arrangement.Center
) { }

Column(
    modifier = Modifier.fillMaxHeight(),
    verticalArrangement = Arrangement.Bottom
) { }

Column(
    modifier = Modifier.fillMaxHeight(),
    verticalArrangement = Arrangement.SpaceBetween
) { }

// Horizontal alignment (cross axis)
Column(
    modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.Start  // Left
) { }

Column(
    modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally
) { }

Column(
    modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.End  // Right
) { }

// Both
Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text("1")
    Text("2")
    Text("3")
}
```

### Centering Techniques

```kotlin
// Center in Box
Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
) {
    Text("Centered")
}

// Center in Column
Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text("Centered")
}

// Center in Row
Row(
    modifier = Modifier.fillMaxSize(),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically
) {
    Text("Centered")
}

// Center with weight
Column(modifier = Modifier.fillMaxSize()) {
    Spacer(modifier = Modifier.weight(1f))  // Push down
    Text("Centered")
    Spacer(modifier = Modifier.weight(1f))  // Push up
}
```

---

## Constraints and Measurements

### Box Constraints

```kotlin
// constrainAs for complex layouts
BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
    // Access parent constraints
    val maxWidth = maxWidth
    val maxHeight = maxHeight
    val minWidth = minWidth
    val minHeight = minHeight

    when {
        maxWidth < 600.dp -> {
            // Compact layout
            Column {
                Text("Compact")
            }
        }
        maxWidth < 840.dp -> {
            // Medium layout
            Row {
                Text("Medium")
            }
        }
        else -> {
            // Expanded layout
            Row {
                Sidebar()
                MainContent()
            }
        }
    }
}

// Responsive image sizing
BoxWithConstraints {
    val imageSize = if (maxWidth < 600.dp) {
        maxWidth * 0.9f
    } else {
        400.dp
    }

    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = Modifier.size(imageSize)
    )
}
```

### Measuring Children

```kotlin
// Layout modifier for custom measurements
Box(
    modifier = Modifier
        .fillMaxSize()
        .layout { measurable, constraints ->
            // Measure child
            val placeable = measurable.measure(constraints)

            // Custom layout logic
            layout(placeable.width, placeable.height) {
                // Place child
                placeable.placeRelative(0, 0)
            }
        }
)

// OnGloballyPositioned for reading layout info
Box(
    modifier = Modifier
        .fillMaxSize()
        .onGloballyPositioned { coordinates ->
            val size = coordinates.size
            val position = coordinates.positionInRoot()

            println("Width: ${size.width}, Height: ${size.height}")
            println("X: ${position.x}, Y: ${position.y}")
        }
)
```

---

## Visual Styling

### Background

#### CSS

```css
.element {
  background-color: red;
  background: linear-gradient(red, blue);
  background-image: url('image.png');
}
```

#### Compose

```kotlin
// Solid color
Box(
    modifier = Modifier
        .size(100.dp)
        .background(Color.Red)
)

// With shape
Box(
    modifier = Modifier
        .size(100.dp)
        .background(Color.Blue, RoundedCornerShape(8.dp))
)

// Gradient
Box(
    modifier = Modifier
        .size(100.dp)
        .background(
            Brush.verticalGradient(
                colors = listOf(Color.Red, Color.Blue)
            )
        )
)

// Horizontal gradient
Box(
    modifier = Modifier
        .size(100.dp)
        .background(
            Brush.horizontalGradient(
                colors = listOf(Color.Red, Color.Blue)
            )
        )
)

// Radial gradient
Box(
    modifier = Modifier
        .size(100.dp)
        .background(
            Brush.radialGradient(
                colors = listOf(Color.Red, Color.Blue)
            )
        )
)

// Gradient with stops
Box(
    modifier = Modifier
        .size(100.dp)
        .background(
            Brush.verticalGradient(
                0.0f to Color.Red,
                0.3f to Color.Yellow,
                1.0f to Color.Blue
            )
        )
)

// Image background
Box(modifier = Modifier.size(200.dp)) {
    Image(
        painter = painterResource(R.drawable.background),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    // Content on top
    Text("Overlay", modifier = Modifier.align(Alignment.Center))
}
```

### Borders

#### CSS

```css
.element {
  border: 1px solid black;
  border-radius: 8px;
  border-top: 2px solid red;
}
```

#### Compose

```kotlin
// All sides
Box(
    modifier = Modifier
        .size(100.dp)
        .border(1.dp, Color.Black)
)

// With rounded corners
Box(
    modifier = Modifier
        .size(100.dp)
        .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
)

// Different corner radius
Box(
    modifier = Modifier
        .size(100.dp)
        .border(
            width = 2.dp,
            color = Color.Blue,
            shape = RoundedCornerShape(
                topStart = 8.dp,
                topEnd = 16.dp,
                bottomStart = 0.dp,
                bottomEnd = 8.dp
            )
        )
)

// Gradient border
Box(
    modifier = Modifier
        .size(100.dp)
        .border(
            width = 2.dp,
            brush = Brush.horizontalGradient(
                colors = listOf(Color.Red, Color.Blue)
            ),
            shape = RoundedCornerShape(8.dp)
        )
)

// Single side border (custom drawing)
Box(
    modifier = Modifier
        .size(100.dp)
        .drawBehind {
            drawLine(
                color = Color.Red,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                strokeWidth = 2.dp.toPx()
            )
        }
)
```

### Shadows and Elevation

#### CSS

```css
.element {
  box-shadow: 0 2px 4px rgba(0,0,0,0.2);
  box-shadow: 0 4px 8px rgba(0,0,0,0.3);
}
```

#### Compose

```kotlin
// Material elevation shadow
Surface(
    modifier = Modifier.size(100.dp),
    shadowElevation = 8.dp,
    shape = RoundedCornerShape(8.dp)
) {
    Box(modifier = Modifier.background(Color.White)) {
        Text("Elevated")
    }
}

// Custom shadow (deprecated but still works)
Box(
    modifier = Modifier
        .size(100.dp)
        .shadow(
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp)
        )
        .background(Color.White)
)

// Colored shadow (custom drawing)
Box(
    modifier = Modifier
        .size(100.dp)
        .graphicsLayer {
            shadowElevation = 8.dp.toPx()
            shape = RoundedCornerShape(8.dp)
            clip = true
        }
        .background(Color.White)
)
```

### Opacity

#### CSS

```css
.element {
  opacity: 0.5;
}
```

#### Compose

```kotlin
Box(
    modifier = Modifier
        .size(100.dp)
        .alpha(0.5f)  // 0f = transparent, 1f = opaque
        .background(Color.Red)
)

// Animated opacity
var isVisible by remember { mutableStateOf(true) }
val alpha by animateFloatAsState(if (isVisible) 1f else 0f)

Box(
    modifier = Modifier
        .size(100.dp)
        .alpha(alpha)
        .background(Color.Blue)
)
```

### Clipping and Overflow

#### CSS

```css
.element {
  overflow: hidden;
  overflow: scroll;
  clip-path: circle(50%);
}
```

#### Compose

```kotlin
// overflow: hidden
Box(
    modifier = Modifier
        .size(100.dp)
        .clip(RectangleShape)  // Clips children
) {
    // Large content gets clipped
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Red)
    )
}

// Rounded corners clipping
Box(
    modifier = Modifier
        .size(100.dp)
        .clip(RoundedCornerShape(16.dp))
) {
    Image(
        painter = painterResource(R.drawable.image),
        contentDescription = null
    )
}

// Circle clip
Box(
    modifier = Modifier
        .size(100.dp)
        .clip(CircleShape)
) {
    Image(
        painter = painterResource(R.drawable.avatar),
        contentDescription = null
    )
}

// Custom clip shape
Box(
    modifier = Modifier
        .size(100.dp)
        .clip(CutCornerShape(16.dp))  // Cut corners
)

// overflow: scroll equivalent
Box(
    modifier = Modifier
        .size(200.dp)
        .verticalScroll(rememberScrollState())  // Scrollable
) {
    // Large content
    Column {
        repeat(20) {
            Text("Item $it", modifier = Modifier.padding(16.dp))
        }
    }
}
```

### Transformations

#### CSS

```css
.element {
  transform: rotate(45deg);
  transform: scale(1.5);
  transform: translate(10px, 20px);
  transform: skew(10deg);
}
```

#### Compose

```kotlin
// Rotate
Box(
    modifier = Modifier
        .size(100.dp)
        .rotate(45f)  // Degrees
        .background(Color.Red)
)

// Scale
Box(
    modifier = Modifier
        .size(100.dp)
        .scale(1.5f)  // 1.5x size
        .background(Color.Blue)
)

// Different X and Y scale
Box(
    modifier = Modifier
        .size(100.dp)
        .scale(scaleX = 1.5f, scaleY = 0.8f)
        .background(Color.Green)
)

// Translate (offset)
Box(
    modifier = Modifier
        .size(100.dp)
        .offset(x = 10.dp, y = 20.dp)
        .background(Color.Yellow)
)

// Multiple transformations
Box(
    modifier = Modifier
        .size(100.dp)
        .rotate(45f)
        .scale(1.5f)
        .offset(x = 10.dp, y = 10.dp)
        .background(Color.Cyan)
)

// Graphics layer for better performance
Box(
    modifier = Modifier
        .size(100.dp)
        .graphicsLayer {
            rotationZ = 45f
            scaleX = 1.5f
            scaleY = 1.5f
            translationX = 10.dp.toPx()
            translationY = 20.dp.toPx()
            alpha = 0.8f
        }
        .background(Color.Magenta)
)

// Rotation with pivot point
Box(
    modifier = Modifier
        .size(100.dp)
        .graphicsLayer {
            rotationZ = 45f
            transformOrigin = TransformOrigin(0f, 0f)  // Top-left pivot
        }
        .background(Color.Red)
)
```

---

## Responsive Design

### Breakpoints

#### CSS

```css
@media (max-width: 600px) {
  /* Mobile */
}

@media (min-width: 601px) and (max-width: 840px) {
  /* Tablet */
}

@media (min-width: 841px) {
  /* Desktop */
}
```

#### Compose

```kotlin
@Composable
fun ResponsiveLayout() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    when {
        screenWidth < 600.dp -> {
            // Compact (Mobile)
            CompactLayout()
        }
        screenWidth < 840.dp -> {
            // Medium (Tablet)
            MediumLayout()
        }
        else -> {
            // Expanded (Desktop)
            ExpandedLayout()
        }
    }
}

// BoxWithConstraints for responsive sizing
@Composable
fun ResponsiveGrid() {
    BoxWithConstraints {
        val columns = when {
            maxWidth < 600.dp -> 2
            maxWidth < 840.dp -> 3
            else -> 4
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(columns)
        ) {
            items(20) {
                GridItem()
            }
        }
    }
}

// Window size class (Material3)
@Composable
fun AdaptiveLayout(windowSizeClass: WindowSizeClass) {
    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            // Phone in portrait
            NavigationBar { }
        }
        WindowWidthSizeClass.Medium -> {
            // Tablet or phone in landscape
            NavigationRail { }
        }
        WindowWidthSizeClass.Expanded -> {
            // Desktop or large tablet
            PermanentNavigationDrawer { }
        }
    }
}
```

### Screen Dimensions

```kotlin
@Composable
fun ScreenDimensions() {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current

    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidthPx = with(density) { screenWidth.toPx() }

    // Use dimensions
    Box(
        modifier = Modifier
            .width(screenWidth * 0.8f)
            .height(screenHeight * 0.5f)
    )
}
```

### Orientation

```kotlin
@Composable
fun OrientationLayout() {
    val configuration = LocalConfiguration.current

    when (configuration.orientation) {
        Configuration.ORIENTATION_PORTRAIT -> {
            Column {
                // Portrait layout
            }
        }
        Configuration.ORIENTATION_LANDSCAPE -> {
            Row {
                // Landscape layout
            }
        }
    }
}
```

---

## Advanced Patterns

### Constrained Layout (CSS Grid equivalent)

```kotlin
// ConstraintLayout
ConstraintLayout(
    modifier = Modifier.fillMaxSize()
) {
    val (header, content, footer) = createRefs()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Blue)
            .constrainAs(header) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .constrainAs(content) {
                top.linkTo(header.bottom)
                bottom.linkTo(footer.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                height = Dimension.fillToConstraints
            }
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Blue)
            .constrainAs(footer) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
    )
}

// Guidelines
ConstraintLayout(modifier = Modifier.fillMaxSize()) {
    val (box1, box2) = createRefs()
    val guideline = createGuidelineFromStart(0.3f)  // 30% from left

    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
            .constrainAs(box1) {
                start.linkTo(parent.start)
                end.linkTo(guideline)
                top.linkTo(parent.top)
            }
    )

    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Blue)
            .constrainAs(box2) {
                start.linkTo(guideline)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }
    )
}

// Chains
ConstraintLayout(modifier = Modifier.fillMaxSize()) {
    val (box1, box2, box3) = createRefs()

    createHorizontalChain(box1, box2, box3, chainStyle = ChainStyle.Spread)

    Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.Red)
            .constrainAs(box1) { }
    )
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.Blue)
            .constrainAs(box2) { }
    )
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.Green)
            .constrainAs(box3) { }
    )
}
```

### Custom Shapes

```kotlin
// Custom shape
class TriangleShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            moveTo(size.width / 2f, 0f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }
        return Outline.Generic(path)
    }
}

Box(
    modifier = Modifier
        .size(100.dp)
        .clip(TriangleShape())
        .background(Color.Red)
)

// Hexagon
class HexagonShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            val width = size.width
            val height = size.height

            moveTo(width * 0.25f, 0f)
            lineTo(width * 0.75f, 0f)
            lineTo(width, height * 0.5f)
            lineTo(width * 0.75f, height)
            lineTo(width * 0.25f, height)
            lineTo(0f, height * 0.5f)
            close()
        }
        return Outline.Generic(path)
    }
}
```

### Conditional Modifiers

```kotlin
// Conditional modifier
@Composable
fun ConditionalModifier(isHighlighted: Boolean) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .then(
                if (isHighlighted) {
                    Modifier.border(2.dp, Color.Red)
                } else {
                    Modifier
                }
            )
            .background(Color.LightGray)
    )
}

// Extension function for cleaner code
fun Modifier.conditional(
    condition: Boolean,
    modifier: Modifier.() -> Modifier
): Modifier {
    return if (condition) {
        then(modifier(Modifier))
    } else {
        this
    }
}

// Usage
Box(
    modifier = Modifier
        .size(100.dp)
        .conditional(isHighlighted) {
            border(2.dp, Color.Red)
        }
        .background(Color.LightGray)
)
```

### Modifier Chains

```kotlin
// Reusable modifier chains
val cardModifier = Modifier
    .fillMaxWidth()
    .padding(16.dp)
    .shadow(4.dp, RoundedCornerShape(8.dp))
    .background(Color.White, RoundedCornerShape(8.dp))
    .padding(16.dp)

// Use it
@Composable
fun MyCard() {
    Box(modifier = cardModifier) {
        Text("Card content")
    }
}

// Parameterized modifier
fun cardModifier(
    elevation: Dp = 4.dp,
    cornerRadius: Dp = 8.dp
) = Modifier
    .fillMaxWidth()
    .padding(16.dp)
    .shadow(elevation, RoundedCornerShape(cornerRadius))
    .background(Color.White, RoundedCornerShape(cornerRadius))
    .padding(16.dp)
```

---

## Best Practices

### 1. Modifier Order Matters

```kotlin
// ❌ WRONG: Border inside padding
Box(
    modifier = Modifier
        .padding(16.dp)
        .border(1.dp, Color.Black)
        .size(100.dp)
) { }

// ✅ CORRECT: Border outside padding
Box(
    modifier = Modifier
        .size(100.dp)
        .border(1.dp, Color.Black)
        .padding(16.dp)
) { }

// Order of operations:
// 1. Size/layout modifiers (size, fillMaxWidth, weight)
// 2. Border/background
// 3. Padding (inside border)
// 4. Content

// Standard order:
Modifier
    .size(100.dp)           // 1. Size first
    .background(Color.Red)  // 2. Background
    .border(1.dp, Color.Black) // 3. Border
    .padding(8.dp)          // 4. Inner padding
    .clickable { }          // 5. Interactions
```

### 2. Use dp for Sizing, sp for Text

```kotlin
// ✅ CORRECT
Box(modifier = Modifier.size(100.dp))  // Use dp for UI elements

Text(
    text = "Hello",
    fontSize = 16.sp  // Use sp for text (scales with user preferences)
)

// ❌ WRONG
Box(modifier = Modifier.size(100.sp))  // Don't use sp for UI
Text(text = "Hello", fontSize = 16.dp)  // Don't use dp for text
```

### 3. Always Accept Modifier Parameter

```kotlin
// ✅ CORRECT
@Composable
fun MyComposable(
    modifier: Modifier = Modifier  // Always add this
) {
    Box(modifier = modifier) {  // Apply to root element
        // Content
    }
}

// ❌ WRONG
@Composable
fun MyComposable() {
    Box {  // No way for parent to customize
        // Content
    }
}
```

### 4. Use Material Theme Values

```kotlin
// ✅ CORRECT: Use theme values
Text(
    text = "Hello",
    color = MaterialTheme.colorScheme.primary,
    style = MaterialTheme.typography.bodyLarge
)

Box(
    modifier = Modifier
        .padding(MaterialTheme.spacing.medium)  // Custom spacing system
)

// ❌ WRONG: Hardcoded values
Text(
    text = "Hello",
    color = Color.Blue,  // Doesn't adapt to theme
    fontSize = 16.sp
)
```

### 5. Use Semantic Modifiers

```kotlin
// ✅ CORRECT: Use semantics for accessibility
Button(
    onClick = { },
    modifier = Modifier.semantics {
        contentDescription = "Submit button"
        role = Role.Button
    }
) {
    Text("Submit")
}

// Image with content description
Image(
    painter = painterResource(R.drawable.icon),
    contentDescription = "Settings icon",  // Important for accessibility
    modifier = Modifier.size(24.dp)
)
```

### 6. Performance: Use remember for Heavy Calculations

```kotlin
// ❌ WRONG: Recalculates every recomposition
@Composable
fun ExpensiveLayout() {
    val expensiveValue = expensiveComputation()  // Runs every time!

    Text("Value: $expensiveValue")
}

// ✅ CORRECT: Remember the value
@Composable
fun ExpensiveLayout() {
    val expensiveValue = remember { expensiveComputation() }

    Text("Value: $expensiveValue")
}

// With dependencies
@Composable
fun ExpensiveLayout(input: Int) {
    val expensiveValue = remember(input) {
        expensiveComputation(input)
    }

    Text("Value: $expensiveValue")
}
```

### 7. Use Layout Modifiers Wisely

```kotlin
// ✅ CORRECT: fillMaxSize on parent
Column(modifier = Modifier.fillMaxSize()) {
    Box(modifier = Modifier.weight(1f)) {
        // Content
    }
}

// ❌ WRONG: Conflicting size modifiers
Box(
    modifier = Modifier
        .fillMaxSize()
        .size(100.dp)  // Conflict! Which size?
)

// ❌ WRONG: weight without fill parent
Column {  // Not fillMaxHeight!
    Box(modifier = Modifier.weight(1f)) {
        // weight doesn't work without parent being measured
    }
}
```

### 8. RTL Support

```kotlin
// ✅ CORRECT: Use start/end instead of left/right
Box(
    modifier = Modifier.padding(start = 16.dp, end = 8.dp)
)

// Use Arrangement.Start/End
Row(
    horizontalArrangement = Arrangement.Start  // Auto RTL
)

// ❌ WRONG: Hardcoded left/right
Box(
    modifier = Modifier.padding(left = 16.dp, right = 8.dp)  // Doesn't flip in RTL
)
```

---

## Quick Reference: CSS to Compose

### Layout

| CSS                       | Compose                                   |
|---------------------------|-------------------------------------------|
| `display: flex`           | `Row { }` or `Column { }`                 |
| `flex-direction: row`     | `Row { }`                                 |
| `flex-direction: column`  | `Column { }`                              |
| `justify-content: center` | `Arrangement.Center`                      |
| `align-items: center`     | `Alignment.CenterVertically/Horizontally` |
| `gap: 16px`               | `Arrangement.spacedBy(16.dp)`             |
| `flex: 1`                 | `.weight(1f)`                             |

### Sizing

| CSS                           | Compose                  |
|-------------------------------|--------------------------|
| `width: 100px`                | `.width(100.dp)`         |
| `width: 100%`                 | `.fillMaxWidth()`        |
| `width: 50%`                  | `.fillMaxWidth(0.5f)`    |
| `height: 100px`               | `.height(100.dp)`        |
| `height: 100%`                | `.fillMaxHeight()`       |
| `width: 100px; height: 100px` | `.size(100.dp)`          |
| `min-width: 100px`            | `.widthIn(min = 100.dp)` |
| `aspect-ratio: 16/9`          | `.aspectRatio(16f/9f)`   |

### Spacing

| CSS                 | Compose                                         |
|---------------------|-------------------------------------------------|
| `padding: 16px`     | `.padding(16.dp)`                               |
| `padding: 8px 16px` | `.padding(horizontal = 16.dp, vertical = 8.dp)` |
| `margin: 16px`      | `Arrangement.spacedBy(16.dp)` or `Spacer`       |
| `gap: 16px`         | `Arrangement.spacedBy(16.dp)`                   |

### Visual

| CSS                       | Compose                           |
|---------------------------|-----------------------------------|
| `background-color: red`   | `.background(Color.Red)`          |
| `border: 1px solid black` | `.border(1.dp, Color.Black)`      |
| `border-radius: 8px`      | `.clip(RoundedCornerShape(8.dp))` |
| `opacity: 0.5`            | `.alpha(0.5f)`                    |
| `box-shadow: ...`         | `.shadow(8.dp)`                   |
| `overflow: hidden`        | `.clip(shape)`                    |

### Position

| CSS                     | Compose                                 |
|-------------------------|-----------------------------------------|
| `position: absolute`    | `Box { ... .align(Alignment) }`         |
| `top: 10px; left: 20px` | `.align(TopStart).offset(20.dp, 10.dp)` |
| `z-index: 10`           | `.zIndex(10f)`                          |

### Transform

| CSS                          | Compose              |
|------------------------------|----------------------|
| `transform: rotate(45deg)`   | `.rotate(45f)`       |
| `transform: scale(1.5)`      | `.scale(1.5f)`       |
| `transform: translate(10px)` | `.offset(x = 10.dp)` |

---

Happy Styling! 🎨
