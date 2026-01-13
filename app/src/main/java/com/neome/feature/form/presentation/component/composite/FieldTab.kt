package com.neome.feature.form.presentation.component.composite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.dto.DefnTab
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.form.presentation.component.FieldFactory
import com.neome.feature.form.presentation.ctx.FormCtx
import com.neome.feature.form.presentation.state.FieldEvent
import com.neome.feature.form.presentation.state.FormState

/**
 * Tab component for form.
 *
 * A composite component that renders tabs with child components.
 * Each tab contains child components that are rendered using FieldFactory.
 *
 * Supports:
 * - Multiple tabs with scrollable tab row
 * - Child component rendering in tab content
 *
 * @param defnComp Tab definition containing tab configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param formCtx Form context for accessing form state and other fields
 * @param modifier Modifier for customization
 */
@Composable
fun FieldTab(
    defnComp: DefnCompSeal,
    defnForm: DefnFormData,
    onFieldEvent: (FieldEvent) -> Unit,
    formCtx: FormCtx,
    modifier: Modifier = Modifier
) {
    val defnTab = defnComp as? DefnTab ?: return

    val tabIdSet = defnTab.tabIdSet ?: emptyList()

    // Get form state from context
    val formState by formCtx.watchFormState().collectAsState()

    // Selected tab index state
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    if (tabIdSet.isEmpty()) {
        return
    }

    Column(modifier = modifier.fillMaxSize()) {
        // Tab Row
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.fillMaxWidth(),
            edgePadding = 0.dp
        ) {
            tabIdSet.forEachIndexed { index, tabId ->
                val tabComponent = defnForm.compMap[tabId]
                val tabLabel = tabComponent?.label ?: tabComponent?.name?.value ?: "Tab ${index + 1}"

                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(tabLabel) }
                )
            }
        }

        // Tab Content
        val selectedTabId = tabIdSet.getOrNull(selectedTabIndex)
        if (selectedTabId != null) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                RenderTabContent(
                    tabId = selectedTabId,
                    formState = formState,
                    defnForm = defnForm,
                    formCtx = formCtx,
                    onFieldEvent = onFieldEvent
                )
            }
        }
    }
}

/**
 * Render content for a specific tab.
 * Renders the tab component and its children using FieldFactory.
 */
@Composable
private fun RenderTabContent(
    tabId: MetaIdComposite,
    formState: FormState,
    defnForm: DefnFormData,
    formCtx: FormCtx,
    onFieldEvent: (FieldEvent) -> Unit
) {
    val tabComponent = defnForm.compMap[tabId]

    // Render the tab component using FieldFactory
    // This will recursively render child components (e.g., sections with their fields)
    if (tabComponent != null) {
        FieldFactory(
            defnComp = tabComponent,
            defnForm = defnForm,
            formCtx = formCtx,
            onFieldEvent = onFieldEvent
        )
    }
}
