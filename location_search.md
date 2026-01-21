# SearchLocationScreen – UI & Interaction Specification

> Jetpack Compose • Android

---

## 1. Overview

This document describes the UI structure, state handling, and interaction behavior for **SearchLocationScreen** and its child components.

The screen is displayed as a **Full-screen ModalBottomSheet** (Jetpack Compose Material3).

The screen supports:

* A right-side **Search / Cancel (Close)** icon toggle
* Showing / hiding a **SearchBarComponent**
* Rendering a **Google Map** with current location
* Showing a **Nearby Places** list
* A static **Send your current location** component above the list

---

## 1.1 Full-Screen Bottom Sheet (90% height)

### Description

* Uses **Material3 ModalBottomSheet** composable
* Displayed as **90% screen height** bottom sheet
* No drag handle (dragHandle = null)
* Can be dismissed by swiping down or tapping outside

### Implementation

```kotlin
ModalBottomSheet(
    onDismissRequest = onDismiss,
    sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    dragHandle = null
) {
    RealSearchLocationComponent(
        onCancel = onDismiss,
        onRetryLocation = onRetryLocation,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.90f)
    )
}
```

---

## 2. Top Header Bar

### UI Layout

```
[ Cancel ]     Send location     [ ↻ ]
```

### Components

| Position | Element | Type | Action |
| -------- | ------- | ---- | ------ |
| Left | "Cancel" | TextButton | Close bottom sheet |
| Center | "Send location" | Text (titleMedium) | Title only |
| Right | Refresh icon | IconButton | Fetch current location |

### Implementation

```kotlin
@Composable
private fun TopHeaderBar(
    onCancel: () -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextButton(onClick = onCancel) {
            Text(text = "Cancel")
        }
        Text(text = "Send location", style = MaterialTheme.typography.titleMedium)
        IconButton(onClick = onRetry) {
            Icon(imageVector = Icons.Default.Refresh, contentDescription = "Retry location")
        }
    }
}
```

### Behavior

* **Cancel button:** Closes the bottom sheet (calls `onDismiss`)
* **Retry button:** Fetches current location (calls `onRetryLocation`)

---

## 4. Component Hierarchy

```
SearchLocationScreen (ModalBottomSheet)
│
├── RealSearchLocationComponent
│   ├── TopHeaderBar (Cancel, Title, Retry)
│   ├── SearchBarComponent (always visible)
│   ├── GoogleMapComponent
│   └── NearByPlacesComponent
│       ├── SendCurrentLocationComponent (static - always visible)
│       └── NearbyPlacesList (search results)
```

---

## 5. RealSearchLocationComponent

### Responsibility

* Controls layout of header bar, search bar, map, and nearby places
* Receives `onCancel` and `onRetryLocation` callbacks

---

## 6. SearchBarComponent

### Description

* Uses **Jetpack Compose TextField** with custom styling
* Always visible below TopHeaderBar

### Behavior

* Accepts text input
* Emits search query events
* Placeholder: "Search or enter an address"

### UI

* Full width
* Placed below TopHeaderBar
* **Padding:** 12dp horizontal, 4dp vertical around the TextField
* **Background color:** Light grey (`Color(0xFFF1F3F4)`)
* **Border radius:** 8dp

### Styling

```kotlin
TextField(
    value = searchQuery,
    onValueChange = onSearchQueryChanged,
    modifier = Modifier.fillMaxWidth(),
    placeholder = {
        Text(
            text = "Search or enter an address",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    },
    colors = TextFieldDefaults.colors(
        focusedContainerColor = Color(0xFFF1F3F4),
        unfocusedContainerColor = Color(0xFFF1F3F4),
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
    )
)
```


## 7. GoogleMapComponent

### Description

* Renders Google Map
* Centers on **current user location**

### Features

* Location marker
* Default zoom

## 8. NearByPlacesComponent

### Structure

1. **SendCurrentLocationComponent** (static – always on top)
2. **Nearby places list** (scrollable)

---

## 9. SendCurrentLocationComponent (Static Item)

### UI Layout

```
[ ● ]  Send your current location
       Accurate to 25 meter
```

### UI Details

* Left icon:

    * Circular container
    * Dot icon inside
    * Icon center aligned to primary and secondary line
* Spacing:

    * **8dp gap** between icon and text

### Text

* **Primary text:** `Send your current location`
* **Secondary text:** `Accurate to 25 meter`

> 📷 **Send Location Component Image**

```
![Send Location](images/send_current_location.png)
```

---

## 10. Nearby Places List

### Description

* Renders list of nearby places
* Scrollable
* Reduced vertical spacing between list items
* Each item contains place name and distance (future scope)
* Right now nearby search places not fetch from Google API

### Item Layout

* **Primary text:** Place name (single line, truncate with ellipsis)
* **Secondary text:** Address (single line only, truncate from end with ellipsis)
* **Icon-to-text gap:** 8dp

### Text Styling

```kotlin
Text(
    text = place.address,
    style = MaterialTheme.typography.bodySmall,
    maxLines = 1,  // Single line only
    overflow = TextOverflow.Ellipsis  // Truncate from end
)
```

---

## 11. Place Search Functionality (New)

### Overview

When the user types in the **SearchBarComponent**, the app should perform **Place Search** using the **GroCoding Place Search API** and reflect results in the **NearByPlacesComponent**.

---

### Search Flow

1. User enters text in `SearchBarComponent`
2. On text change (with debounce)
3. Call **GroCoding Place Search API**
4. Receive places response
5. Update UI state
6. Render results inside **Nearby Places List**
7. **6 search results** shown from Google Places API response (limit to 6)  

---

### Trigger Conditions

* API call should be triggered when:

    * Search text length ≥ 2 characters
    * User stops typing (debounce recommended: 300–500ms)

---

### API Responsibility
 
* The API is responsible for:

    * Searching places based on text input
    * Returning place name, address, coordinates

> 🔗 **API Source:** GroCoding Place Search API

---

### UI State Mapping

```kotlin
data class SearchLocationState(
    val showSearchBar: Boolean = false,
    val searchQuery: String = "",
    val isLoading: Boolean = false,
    val searchResults: List<PlaceUiModel> = emptyList()
)
```

---

### Event Handling

```kotlin
sealed interface SearchLocationEvent {
    data class OnSearchQueryChange(val query: String) : SearchLocationEvent
    object OnSearchClear : SearchLocationEvent
}
```

---

### Result Rendering Rules

* If `searchQuery` is empty → show **Nearby Places (default)**
* If searching → show loading indicator
* If results available → replace nearby list with **Search Results**
* If no results → show empty state UI

---

### Error Handling

* Network error → show non-blocking error message
* Empty response → show `No places found`

---

### Notes

* API calls must be handled inside ViewModel
* UI layer remains stateless
* This logic is independent of Google Map rendering

---

## 12. Location Handling & File Structure Rules (Updated)

This section documents the **source of truth for user location**, how it is fetched, and how it is shared across components.

---

### 12.1 Send Your Current Location – Data Flow

#### Source Function

* Location data is fetched using:

```kotlin
getCurrentLocationWithAddress()
```

#### Responsibility

* Fetch:

    * Latitude
    * Longitude
    * Address (human readable)

* This function is the **single source of truth** for:

    * "Send your current location" action
    * Location data passed upward via events

---

### 12.2 Event Flow – Send Current Location

1. User taps **Send your current location** component
2. UI triggers `OnSendCurrentLocationClick`
3. ViewModel calls `getCurrentLocationWithAddress()`
4. Response is received
5. Response is emitted via `onEvent` callback
6. Parent screen consumes location data

```kotlin
sealed interface SearchLocationEvent {
    object OnSendCurrentLocationClick : SearchLocationEvent
    data class OnLocationReceived(val location: LocationUiModel) : SearchLocationEvent
}
```

---

### 12.3 Repository Layer

#### Implementation Location

* Function implementation exists in:

```
LocationRepositoryImpl
```

#### Responsibility

* Interact with Android location services
* Resolve coordinates to address
* Return domain-safe location model

---

### 12.4 GoogleMapComponent – Current Location Rendering

#### Existing Function Used

```kotlin
val geoPoint = captureLocation(context)
```

#### Behavior

* This function is already implemented
* Used **only for map rendering**
* Provides latitude & longitude

#### Rules

* `captureLocation(context)`:

    * ❌ Must NOT fetch address
    * ✅ Used only for showing user location on map

* `getCurrentLocationWithAddress()`:

    * ✅ Used for business logic & user actions
    * ✅ Used by "Send your current location"

---

### 12.5 Separation of Concerns

| Use Case                  | Function                          | Layer      |
| ------------------------- | --------------------------------- | ---------- |
| Show user location on map | `captureLocation(context)`        | UI / Map   |
| Send current location     | `getCurrentLocationWithAddress()` | Repository |

---

### 12.6 Summary Rules

* Never duplicate location fetching logic
* Map rendering and business actions use **different functions** intentionally
* `LocationRepositoryImpl` remains the only place with real location logic

---

## 13. Assets & Images

### Can we attach images to this MD file?

✅ **Yes** — images can be attached using relative paths.

### Example Folder Structure

```
/docs
  ├── SearchLocationScreen.md
  └── images/
      ├── search_bar.png
      ├── google_map.png
      └── send_current_location.png
```

---

## 12. Notes

* This document is implementation-agnostic
* Can be shared with design & development teams
* Images can be added once provided

---

**Status:** Draft
