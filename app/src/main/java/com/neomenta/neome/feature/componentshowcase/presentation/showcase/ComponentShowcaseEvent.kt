package com.neomenta.neome.feature.componentshowcase.presentation.showcase

sealed interface ComponentShowcaseEvent {
    data class SelectCategory(val index: Int) : ComponentShowcaseEvent
    data class Search(val query: String) : ComponentShowcaseEvent
    data object ClearSearch : ComponentShowcaseEvent
}
