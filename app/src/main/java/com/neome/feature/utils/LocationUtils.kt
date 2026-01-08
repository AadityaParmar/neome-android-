package com.neome.feature.utils

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.neome.feature.location.domain.model.GeoPoint
import kotlinx.coroutines.tasks.await

/**
 * Utility functions for location-related operations
 * Provides reusable functions for location permission checking and location capture
 */

/**
 * Checks if the app has location permissions granted
 * @param context Application context
 * @return true if either FINE or COARSE location permission is granted
 */
fun hasLocationPermission(context: Context): Boolean {
    val fineLocationGranted = ContextCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    val coarseLocationGranted = ContextCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    return fineLocationGranted || coarseLocationGranted
}

/**
 * Captures the current location and returns as GeoPoint
 * @param context Application context
 * @return GeoPoint with latitude and longitude, or null if location cannot be captured
 * @throws SecurityException if location permission is not granted
 */
@SuppressLint("MissingPermission")
suspend fun captureLocation(context: Context): GeoPoint? {
    // Check permission before attempting to capture location
    if (!hasLocationPermission(context)) {
        throw SecurityException("Location permission not granted")
    }

    return try {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

        val locationResult = fusedLocationClient.getCurrentLocation(
            Priority.PRIORITY_HIGH_ACCURACY,
            null
        ).await()

        if (locationResult != null) {
            GeoPoint(
                lat = locationResult.latitude,
                lng = locationResult.longitude
            )
        } else {
            null
        }
    } catch (e: Exception) {
        null
    }
}

/**
 * Returns the array of required location permissions
 * @return Array of permission strings needed for location access
 */
fun getRequiredPermissions(): Array<String> {
    return arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )
}