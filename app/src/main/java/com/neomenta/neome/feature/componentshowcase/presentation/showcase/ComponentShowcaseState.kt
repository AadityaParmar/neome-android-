package com.neomenta.neome.feature.componentshowcase.presentation.showcase

import com.neomenta.neome.feature.componentshowcase.domain.model.ComponentCategory

data class ComponentShowcaseState(
    val categories: List<ComponentCategory> = emptyList(),
    val selectedCategoryIndex: Int = 0,
    val searchQuery: String = "",
    val isLoading: Boolean = false
)
