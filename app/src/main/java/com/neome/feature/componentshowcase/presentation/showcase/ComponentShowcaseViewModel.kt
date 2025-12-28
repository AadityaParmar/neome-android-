package com.neome.feature.componentshowcase.presentation.showcase

import androidx.lifecycle.ViewModel
import com.neome.feature.componentshowcase.domain.model.ComponentCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ComponentShowcaseViewModel : ViewModel() {

    private val _state = MutableStateFlow(ComponentShowcaseState())
    val state = _state.asStateFlow()

    init {
        loadCategories()
    }

    fun onEvent(event: ComponentShowcaseEvent) {
        when (event) {
            is ComponentShowcaseEvent.SelectCategory -> {
                _state.update { it.copy(selectedCategoryIndex = event.index) }
            }
            is ComponentShowcaseEvent.Search -> {
                _state.update { it.copy(searchQuery = event.query) }
            }
            ComponentShowcaseEvent.ClearSearch -> {
                _state.update { it.copy(searchQuery = "") }
            }
        }
    }

    private fun loadCategories() {
        val categories = listOf(
            ComponentCategory(
                name = "Buttons",
                description = "Material3 button components",
                components = listOf(
                    "Button", "FilledTonalButton", "OutlinedButton", "ElevatedButton",
                    "TextButton", "IconButton", "FloatingActionButton"
                )
            ),
            ComponentCategory(
                name = "Cards",
                description = "Material3 card components",
                components = listOf("Card", "ElevatedCard", "OutlinedCard")
            ),
            ComponentCategory(
                name = "Text Fields",
                description = "Material3 input components",
                components = listOf("TextField", "OutlinedTextField")
            ),
            ComponentCategory(
                name = "Selection",
                description = "Material3 selection controls",
                components = listOf("Checkbox", "RadioButton", "Switch", "Slider")
            ),
            ComponentCategory(
                name = "Dialogs",
                description = "Material3 dialog components",
                components = listOf("AlertDialog", "BasicAlertDialog", "ModalBottomSheet")
            ),
            ComponentCategory(
                name = "Progress",
                description = "Material3 progress indicators",
                components = listOf("CircularProgressIndicator", "LinearProgressIndicator")
            ),
            ComponentCategory(
                name = "Other",
                description = "Other Material3 components",
                components = listOf("Badge", "Chip", "Divider", "ListItem", "Snackbar", "Tooltip")
            ),
            ComponentCategory(
                name = "Media",
                description = "Camera and media capture features",
                components = listOf("Simple Camera", "Camera with Preview", "Camera with Cropper")
            ),
            ComponentCategory(
                name = "File Picker",
                description = "System file picker for selecting files",
                components = listOf("Pick Image", "Pick Video", "Pick Image + Video", "Pick PDF", "Pick All Files")
            ),
            ComponentCategory(
                name = "Image Compression",
                description = "Native image compression using Android SDK",
                components = listOf("Pick Image", "Compression Settings", "Preview Original vs Compressed")
            ),
            ComponentCategory(
                name = "Thumbnail Picker",
                description = "Native video thumbnail extraction using Android SDK",
                components = listOf("Pick Video", "Extract First Frame", "Preview Thumbnail")
            ),
            ComponentCategory(
                name = "Image Primary Color",
                description = "Native image primary color extraction using Android SDK",
                components = listOf("Pick Image", "Extract Dominant Color", "Color Swatch Preview")
            )
        )
        _state.update { it.copy(categories = categories) }
    }
}
