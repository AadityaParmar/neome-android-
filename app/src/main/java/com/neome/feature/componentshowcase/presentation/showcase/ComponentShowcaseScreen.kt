package com.neome.feature.componentshowcase.presentation.showcase

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.neome.feature.componentshowcase.presentation.components.ButtonShowcase
import com.neome.feature.componentshowcase.presentation.components.CardShowcase
import com.neome.feature.componentshowcase.presentation.components.DialogShowcase
import com.neome.feature.componentshowcase.presentation.components.FilePickerShowcase
import com.neome.feature.componentshowcase.presentation.components.ImageCompressionShowcase
import com.neome.feature.componentshowcase.presentation.components.MediaShowcase
import com.neome.feature.componentshowcase.presentation.components.OtherComponentsShowcase
import com.neome.feature.componentshowcase.presentation.components.ProgressShowcase
import com.neome.feature.componentshowcase.presentation.components.SelectionShowcase
import com.neome.feature.componentshowcase.presentation.components.TextFieldShowcase
import com.neome.feature.componentshowcase.presentation.components.ThumbnailPickerShowcase
import com.neome.feature.componentshowcase.presentation.components.ImagePrimaryColorShowcase
import com.neome.feature.componentshowcase.domain.model.ComponentCategory

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
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
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
                PrimaryScrollableTabRow(
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
                        7 -> MediaShowcase()
                        8 -> FilePickerShowcase()
                        9 -> ImageCompressionShowcase()
                        10 -> ThumbnailPickerShowcase()
                        11 -> ImagePrimaryColorShowcase()
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
                    ComponentCategory(
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
