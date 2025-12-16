package com.neome.feature.componentshowcase.domain.model

data class ComponentCategory(
    val name: String,
    val description: String,
    val components: List<String>
)
