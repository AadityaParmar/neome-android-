package com.neome.core.mvi

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
