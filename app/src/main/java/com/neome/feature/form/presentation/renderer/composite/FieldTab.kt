package com.neome.feature.form.presentation.renderer.composite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnTab
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.renderer.ComponentRenderer
import com.neome.feature.form.presentation.renderer.ComponentRendererFactory

/**
 * Renderer for TAB composite type
 * Renders child composites in tabs
 */
object FieldTab : ComponentRenderer {
    @Composable
    override fun Render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier
    ) {
        val tabComp = defnComp as? DefnTab
        val tabIds = tabComp?.tabIdSet?.toList() ?: emptyList()
        print(tabIds)
        println("===tabIds ${tabComp?.tabIdSet} $tabComp ")

        var selectedTabIndex by remember { mutableIntStateOf(0) }

        Column(modifier = modifier.fillMaxWidth()) {
            // Tab Row
            if (tabIds.isNotEmpty()) {
                ScrollableTabRow(
                    selectedTabIndex = selectedTabIndex,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    tabIds.forEachIndexed { index, tabId ->
                        val tabDef = defnForm.compMap[tabId]
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            text = {
                                Text(
                                    text = tabDef?.label ?: tabDef?.name?.name
                                    ?: "Tab ${index + 1}",
                                    style = MaterialTheme.typography.labelLarge
                                )
                            }
                        )
                    }
                }

                // Tab Content
                if (selectedTabIndex in tabIds.indices) {
                    val selectedTabId = tabIds[selectedTabIndex]
                    val selectedTabComp = defnForm.compMap[selectedTabId]

                    if (selectedTabComp != null) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            ComponentRendererFactory.Render(
                                defnComp = selectedTabComp,
                                defnForm = defnForm,
                                formRef = formRef
                            )
                        }
                    }
                }
            } else {
                Text(
                    text = "No tabs defined",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
