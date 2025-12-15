package com.neomenta.neome.feature.componentshowcase.presentation.showcase

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.neomenta.neome.feature.componentshowcase.presentation.components.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentShowcaseScreen(
    viewModel: ComponentShowcaseViewModel = viewModel(),
    onNavigateBack: () -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ComponentShowcaseContent(
        state = state,
        onEvent = viewModel::onEvent,
        onNavigateBack = onNavigateBack
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ComponentShowcaseContent(
    state: ComponentShowcaseState,
    onEvent: (ComponentShowcaseEvent) -> Unit,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Material3 Components") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Search Bar
            OutlinedTextField(
                value = state.searchQuery,
                onValueChange = { onEvent(ComponentShowcaseEvent.Search(it)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("Search components...") },
                leadingIcon = {
                    Icon(Icons.Filled.Search, contentDescription = null)
                },
                trailingIcon = {
                    if (state.searchQuery.isNotEmpty()) {
                        IconButton(onClick = { onEvent(ComponentShowcaseEvent.ClearSearch) }) {
                            Icon(Icons.Filled.Clear, contentDescription = "Clear")
                        }
                    }
                },
                singleLine = true
            )

            // Tab Row for categories
            if (state.categories.isNotEmpty()) {
                ScrollableTabRow(
                    selectedTabIndex = state.selectedCategoryIndex,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    state.categories.forEachIndexed { index, category ->
                        Tab(
                            selected = state.selectedCategoryIndex == index,
                            onClick = { onEvent(ComponentShowcaseEvent.SelectCategory(index)) },
                            text = { Text(category.name) }
                        )
                    }
                }
            }

            // Component showcase content
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                item {
                    when (state.selectedCategoryIndex) {
                        0 -> ButtonShowcase()
                        1 -> CardShowcase()
                        2 -> TextFieldShowcase()
                        3 -> SelectionShowcase()
                        4 -> DialogShowcase()
                        5 -> ProgressShowcase()
                        6 -> OtherComponentsShowcase()
                    }
                }

                // Category Info
                if (state.categories.isNotEmpty()) {
                    item {
                        val category = state.categories[state.selectedCategoryIndex]
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    category.name,
                                    style = MaterialTheme.typography.titleLarge
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    category.description,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                Text(
                                    "Components in this category:",
                                    style = MaterialTheme.typography.labelLarge
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                category.components.forEach { component ->
                                    Text(
                                        "• $component",
                                        style = MaterialTheme.typography.bodySmall,
                                        modifier = Modifier.padding(start = 8.dp, top = 2.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ComponentShowcaseScreenPreview() {
    MaterialTheme {
        ComponentShowcaseContent(
            state = ComponentShowcaseState(
                categories = listOf(
                    com.neomenta.neome.feature.componentshowcase.domain.model.ComponentCategory(
                        "Buttons",
                        "Material3 button components",
                        listOf("Button", "IconButton")
                    )
                ),
                selectedCategoryIndex = 0
            ),
            onEvent = {},
            onNavigateBack = {}
        )
    }
}
