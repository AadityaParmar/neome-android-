package com.neome.feature.form.presentation.renderer.field

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
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.renderer.ComponentRenderer

/**
 * Renderer for unsupported field types
 * Shows placeholder indicating the field type is not yet implemented
 */
object UnsupportedRenderer : ComponentRenderer {
    @Composable
    override fun Render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.errorContainer
            )
        ) {
            Text(
                text = "Unsupported field type: ${defnComp.type}\nField: ${defnComp.label ?: defnComp.name.name}",
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.onErrorContainer
            )
        }
    }
}
