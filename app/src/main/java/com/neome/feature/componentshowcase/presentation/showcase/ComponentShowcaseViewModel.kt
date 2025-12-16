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
            )
        )
        _state.update { it.copy(categories = categories) }
    }
}
