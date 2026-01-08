# Location Feature - Current Location with Address

## Overview

A modular location feature providing GPS coordinates with reverse geocoding to get full address information. Designed with Clean Architecture and MVI pattern for complex state management.

**Pattern:** MVI (complex state management with multiple location states and permissions)

---

## Design Principles

1. **Separation of Concerns** - Location capture, permission handling, and geocoding are independent
2. **Offline-First** - Geocoding API returns formatted addresses with proper error handling
3. **Reusable Utilities** - Location capture and permission logic extracted to utilities
4. **Clean Architecture** - Domain, Data, and Presentation layers clearly separated
5. **Comprehensive Error Handling** - All API errors, permission issues, and network failures handled

---

## Folder Structure

```
feature/location/
├── domain/
│   ├── model/
│   │   ├── Location.kt                 # Domain model with geoPoint
│   │   └── GeoPoint.kt                # Lat/Lng coordinates
│   │
│   ├── repository/
│   │   └── LocationRepository.kt      # Repository interface
│   │
│   └── usecase/
│       └── GetCurrentLocationUseCase.kt  # Business logic
│
├── data/
│   ├── remote/
│   │   ├── GeocodingDto.kt           # API response DTOs
│   │   └── GeocodingApiService.kt    # Retrofit API interface
│   │
│   └── repository/
│       └── LocationRepositoryImpl.kt  # Implementation with FusedLocationProvider
│
├── presentation/
│   └── location/                     # MVI - Location State Management
│       ├── LocationState.kt
│       ├── LocationEvent.kt
│       └── LocationViewModel.kt
│
└── di/
    └── LocationModule.kt              # Hilt DI module

utils/
└── LocationUtils.kt                   # Reusable location utilities

componentshowcase/presentation/
├── components/
│   └── LocationShowcase.kt            # UI Component
│
└── searchlocation/
    └── SearchLocationScreen.kt        # Search Location Screen
```

---

## Domain Layer

### Models (Pure Kotlin - No Android Dependencies)

#### Location.kt
```kotlin
package com.neome.feature.location.domain.model

/**
 * Domain model for location data
 * Matches FieldDtoLocation format
 */
data class Location(
    val address: String? = null,
    val city: String? = null,
    val country: String? = null,
    val dateTime: String? = null,      // ISO 8601 format
    val geoPoint: GeoPoint              // {lat, lng} format
)
```

#### GeoPoint.kt
```kotlin
package com.neome.feature.location.domain.model

/**
 * GeoPoint model matching API format
 * Contains latitude and longitude coordinates
 */
data class GeoPoint(
    val lat: Double,
    val lng: Double
)
```

### Repository Interface

#### LocationRepository.kt
```kotlin
package com.neome.feature.location.domain.repository

import com.neome.core.common.Resource
import com.neome.feature.location.domain.model.Location
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for location operations
 * Pure Kotlin interface with no Android dependencies
 */
interface LocationRepository {
    /**
     * Get current location with address
     * Returns Flow<Resource<Location>> for reactive updates
     */
    fun getCurrentLocationWithAddress(): Flow<Resource<Location>>
}
```

### Use Case

#### GetCurrentLocationUseCase.kt
```kotlin
package com.neome.feature.location.domain.usecase

import com.neome.core.common.Resource
import com.neome.feature.location.domain.model.Location
import com.neome.feature.location.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case for getting current location with address
 * Single responsibility: Coordinate location fetching logic
 */
class GetCurrentLocationUseCase @Inject constructor(
    private val repository: LocationRepository
) {
    operator fun invoke(): Flow<Resource<Location>> {
        return repository.getCurrentLocationWithAddress()
    }
}
```

---

## Data Layer

### Remote DTOs

#### GeocodingDto.kt
```kotlin
package com.neome.feature.location.data.remote

import com.google.gson.annotations.SerializedName

/**
 * DTOs for Google Geocoding API response
 */
data class GeocodingResponse(
    @SerializedName("results")
    val results: List<GeocodingResult>,
    @SerializedName("status")
    val status: String,
    @SerializedName("error_message")
    val errorMessage: String? = null
)

data class GeocodingResult(
    @SerializedName("formatted_address")
    val formattedAddress: String,
    @SerializedName("address_components")
    val addressComponents: List<AddressComponent>
)

data class AddressComponent(
    @SerializedName("long_name")
    val longName: String,
    @SerializedName("types")
    val types: List<String>
)

fun List<AddressComponent>.findByType(type: String): String? {
    return firstOrNull { it.types.contains(type) }?.longName
}
```

#### GeocodingApiService.kt
```kotlin
package com.neome.feature.location.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit API interface for Google Geocoding API
 */
interface GeocodingApiService {
    @GET("geocode/json")
    suspend fun reverseGeocode(
        @Query("latlng") latlng: String,
        @Query("key") key: String
    ): GeocodingResponse
}
```

### Repository Implementation

#### LocationRepositoryImpl.kt
```kotlin
package com.neome.feature.location.data.repository

import android.annotation.SuppressLint
import android.content.Context
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.neome.BuildConfig
import com.neome.core.common.Resource
import com.neome.feature.location.data.remote.GeocodingApiService
import com.neome.feature.location.domain.model.GeoPoint
import com.neome.feature.location.domain.model.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

/**
 * Implementation using:
 * - FusedLocationProviderClient for GPS
 * - Google Geocoding API for address
 */
class LocationRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val geocodingApi: GeocodingApiService
) : LocationRepository {

    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    override fun getCurrentLocationWithAddress(): Flow<Resource<Location>> = flow {
        emit(Resource.Loading)

        try {
            // Get GPS coordinates
            val locationResult = fusedLocationClient.getCurrentLocation(
                Priority.PRIORITY_HIGH_ACCURACY,
                null
            ).await()

            // Create GeoPoint and timestamp
            val geoPoint = GeoPoint(
                lat = locationResult.latitude,
                lng = locationResult.longitude
            )
            val dateTime = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
                .format(Date())

            // Reverse geocode
            val geocodingResponse = geocodingApi.reverseGeocode(
                latlng = "${geoPoint.lat},${geoPoint.lng}",
                key = BuildConfig.GOOGLE_API_KEY
            )

            // Handle response
            when (geocodingResponse.status) {
                "OK" -> {
                    val result = geocodingResponse.results.firstOrNull()
                    emit(Resource.Success(Location(
                        address = result?.formattedAddress,
                        city = result?.addressComponents?.findByType("locality"),
                        country = result?.addressComponents?.findByType("country"),
                        dateTime = dateTime,
                        geoPoint = geoPoint
                    )))
                }
                else -> {
                    emit(Resource.Error("Geocoding error: ${geocodingResponse.status}"))
                }
            }
        } catch (e: Exception) {
            emit(Resource.Error("Location error: ${e.message}"))
        }
    }
}
```

---

## Presentation Layer - Location MVI

### LocationState.kt
```kotlin
package com.neome.feature.componentshowcase.presentation.location

import com.neome.feature.location.domain.model.Location

/**
 * UI State for Location showcase
 * Separate states for manual and auto-load
 */
data class LocationState(
    val location: Location? = null,              // Manual "Get Location"
    val autoLoadedLocation: Location? = null,    // Auto-load (5s timer)
    val isLoading: Boolean = false,
    val isAutoLoading: Boolean = false,
    val error: String? = null,
    val autoLoadError: String? = null,
    val permissionGranted: Boolean = false
)
```

### LocationEvent.kt
```kotlin
package com.neome.feature.componentshowcase.presentation.location

/**
 * User events for Location showcase
 */
sealed interface LocationEvent {
    data object GetLocation : LocationEvent
    data object GetAutoLoadLocation : LocationEvent
    data object ClearLocation : LocationEvent
    data class PermissionResult(val granted: Boolean) : LocationEvent
}
```

### LocationViewModel.kt
```kotlin
package com.neome.feature.componentshowcase.presentation.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neome.core.common.Resource
import com.neome.feature.location.domain.usecase.GetCurrentLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LocationState())
    val state = _state.asStateFlow()

    fun onEvent(event: LocationEvent) {
        when (event) {
            is LocationEvent.GetLocation -> getCurrentLocation()
            is LocationEvent.GetAutoLoadLocation -> getAutoLoadLocation()
            is LocationEvent.ClearLocation -> clearLocation()
            is LocationEvent.PermissionResult -> updatePermission(event.granted)
        }
    }

    private fun getCurrentLocation() {
        viewModelScope.launch {
            getCurrentLocationUseCase().collect { resource ->
                when (resource) {
                    is Resource.Loading -> _state.update { it.copy(isLoading = true) }
                    is Resource.Success -> _state.update {
                        it.copy(location = resource.data, isLoading = false, error = null)
                    }
                    is Resource.Error -> _state.update {
                        it.copy(isLoading = false, error = resource.message)
                    }
                }
            }
        }
    }

    private fun getAutoLoadLocation() {
        viewModelScope.launch {
            getCurrentLocationUseCase().collect { resource ->
                when (resource) {
                    is Resource.Loading -> _state.update { it.copy(isAutoLoading = true) }
                    is Resource.Success -> _state.update {
                        it.copy(autoLoadedLocation = resource.data, isAutoLoading = false)
                    }
                    is Resource.Error -> _state.update {
                        it.copy(isAutoLoading = false, autoLoadError = resource.message)
                    }
                }
            }
        }
    }
}
```

---

## Utils Layer

### LocationUtils.kt
```kotlin
package com.neome.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.neome.feature.location.domain.model.GeoPoint
import kotlinx.coroutines.tasks.await

/**
 * Reusable location utilities
 * Provides permission checking and location capture
 */
object LocationUtils {

    /**
     * Check if location permissions are granted
     */
    fun hasLocationPermission(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED ||
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Capture current GPS coordinates
     * @return GeoPoint with lat/lng or null if failed
     */
    suspend fun captureLocation(context: Context): GeoPoint? {
        if (!hasLocationPermission(context)) return null

        return try {
            val fusedLocationClient: FusedLocationProviderClient =
                LocationServices.getFusedLocationProviderClient(context)

            val location = fusedLocationClient.getCurrentLocation(
                Priority.PRIORITY_HIGH_ACCURACY,
                null
            ).await()

            location?.let {
                GeoPoint(lat = it.latitude, lng = it.longitude)
            }
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Get required location permissions
     */
    fun getRequiredPermissions(): Array<String> {
        return arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }
}
```

---

## UI Components

### LocationShowcase.kt
```kotlin
/**
 * Main location showcase component
 * Features:
 * - Manual location capture with "Get Location" button
 * - Auto-load location with 5-second countdown timer
 * - Permission handling with Accompanist Permissions
 * - Navigation to search location screen
 */
@Composable
fun LocationShowcase(
    onNavigateToSearch: () -> Unit = {},
    viewModel: LocationViewModel = hiltViewModel()
) {
    // Handles permissions and navigation
    // Shows current location card
    // Shows auto-load location card
    // Search location button
}
```

### SearchLocationScreen.kt
```kotlin
/**
 * Search location screen (placeholder)
 * Future implementation for location search
 */
@Composable
fun SearchLocationScreen(
    onNavigateBack: () -> Unit
) {
    // Back navigation
    // Search UI (to be implemented)
}
```

---

## DI Module

### LocationModule.kt
```kotlin
package com.neome.feature.location.di

import com.neome.feature.location.data.remote.GeocodingApiService
import com.neome.feature.location.data.repository.LocationRepositoryImpl
import com.neome.feature.location.domain.repository.LocationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocationModule {

    @Provides
    @Singleton
    fun provideGeocodingApiService(okHttpClient: OkHttpClient): GeocodingApiService {
        return Retrofit.Builder()
            .baseUrl("https://maps.googleapis.com/maps/api/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GeocodingApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideLocationRepository(
        @ApplicationContext context: Context,
        geocodingApiService: GeocodingApiService
    ): LocationRepository {
        return LocationRepositoryImpl(context, geocodingApiService)
    }
}
```

---

## API Configuration

### local.properties
```properties
# Google API Key for Geocoding (Never commit to git!)
GOOGLE_API_KEY=YOUR_API_KEY_HERE
```

### build.gradle.kts
```kotlin
android {
    defaultConfig {
        // Read API key from local.properties
        val properties = Properties()
        val localPropertiesFile = rootProject.file("local.properties")
        if (localPropertiesFile.exists()) {
            properties.load(localPropertiesFile.inputStream())
        }
        val googleApiKey = properties.getProperty("GOOGLE_API_KEY") ?: "GOOGLE_API_KEY_HERE"
        buildConfigField("String", "GOOGLE_API_KEY", "\"$googleApiKey\"")
    }

    buildFeatures {
        buildConfig = true
    }
}
```

---

## Features

### 1. Manual Location Capture
- Click "Get Location" button
- Fetches GPS coordinates
- Reverse geocodes to get address
- Displays: lat, lng, address, city, country, dateTime

### 2. Auto-Load Location (5-Second Timer)
- Automatically triggers on permission grant
- Countdown: 5s → 4s → 3s → 2s → 1s → Fetch
- Separate state from manual location
- Displays address in dedicated card

### 3. Permission Handling
- Runtime permission request with Accompanist
- Permission status tracked in state
- Error messages for denied permissions
- Retry mechanism

### 4. Search Location Navigation
- Full-width "Search Location" button
- Navigates to search screen
- Back button returns to showcase
- Placeholder for future search implementation

---

## Error Handling

### Geocoding API Errors
| Status | Message |
|--------|---------|
| `OK` | Success ✅ |
| `ZERO_RESULTS` | No address found |
| `OVER_QUERY_LIMIT` | API quota exceeded |
| `REQUEST_DENIED` | Invalid API key |
| `INVALID_REQUEST` | Malformed request |
| `UNKNOWN_ERROR` | Server error |

### Location Errors
- Permission denied
- Location services disabled
- Network unavailable
- GPS timeout

---

## Dependencies

```kotlin
// Location Services
implementation("com.google.android.gms:play-services-location:21.3.0")

// Coroutines for Play Services
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.8.0")

// Networking for Geocoding API
implementation("com.squareup.retrofit2:retrofit:2.11.0")
implementation("com.squareup.retrofit2:converter-gson:2.11.0")
implementation("com.squareup.okhttp3:okhttp:4.12.0")
implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

// Permissions
implementation("com.google.accompanist:accompanist-permissions:0.36.0")
```

---

## Permissions

```xml
<!-- AndroidManifest.xml -->
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.INTERNET" />
```

---

## Usage Flow

```
1. User opens Location tab
2. Permission prompt appears
3. User grants permission
   ↓
4. Auto-load timer starts (5s countdown)
5. Timer ends → Fetch location automatically
6. Display address in auto-load card
   ↓
7. User can also click "Get Location" manually
8. Separate location data in manual card
   ↓
9. User can click "Search Location"
10. Navigate to search screen
11. Back button → Return to location tab
```

---

## File Summary

| File | Layer | Purpose |
|------|-------|---------|
| `Location.kt` | Domain | Location domain model |
| `GeoPoint.kt` | Domain | Lat/Lng coordinates |
| `LocationRepository.kt` | Domain | Repository interface |
| `GetCurrentLocationUseCase.kt` | Domain | Business logic |
| `GeocodingDto.kt` | Data | API response DTOs |
| `GeocodingApiService.kt` | Data | Retrofit API |
| `LocationRepositoryImpl.kt` | Data | Repository implementation |
| `LocationState.kt` | Presentation | UI state |
| `LocationEvent.kt` | Presentation | User events |
| `LocationViewModel.kt` | Presentation | State management |
| `LocationShowcase.kt` | Presentation | UI component |
| `SearchLocationScreen.kt` | Presentation | Search screen |
| `LocationModule.kt` | DI | Hilt module |
| `LocationUtils.kt` | Utils | Reusable utilities |

---

## Next Steps

1. ✅ Domain models created
2. ✅ Repository interface and implementation
3. ✅ Use case implemented
4. ✅ Location state management (MVI)
5. ✅ UI components with auto-load
6. ✅ Permission handling
7. ✅ Navigation to search screen
8. 🔄 Refactor with LocationUtils
9. ⏭️ Implement search location feature
10. ⏭️ Add location caching
11. ⏭️ Add offline mode

---

## Security Notes

⚠️ **IMPORTANT:**
- API key stored in `local.properties` (gitignored)
- Never commit API key to version control
- Use BuildConfig to access key securely
- Validate API responses before use
- Handle all error cases explicitly