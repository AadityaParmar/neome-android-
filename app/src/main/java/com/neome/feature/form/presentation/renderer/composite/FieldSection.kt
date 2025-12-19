package com.neome.feature.form.presentation.renderer.composite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnSection
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.renderer.ComponentRenderer
import com.neome.feature.form.presentation.renderer.ComponentRendererFactory

/**
 * Renderer for SECTION composite type
 * Renders fields vertically in a card
 */
object FieldSection : ComponentRenderer {
    @Composable
    override fun Render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier
    ) {
        val section = defnComp as? DefnSection

        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Section label
                if (defnComp.label != null) {
                    Text(
                        text = defnComp.label!!,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }

                // Render child fields
                section?.fieldIdSet?.forEach { fieldId ->
                    val childComp = defnForm.compMap[fieldId]
                    if (childComp != null) {
                        ComponentRendererFactory.Render(
                            defnComp = childComp,
                            defnForm = defnForm,
                            formRef = formRef
                        )
                    }
                } ?: run {
                    Text(
                        text = "No fields defined",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
