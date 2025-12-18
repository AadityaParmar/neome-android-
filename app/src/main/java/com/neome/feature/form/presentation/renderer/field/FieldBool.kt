package com.neome.feature.form.presentation.renderer.field

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnForm
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.renderer.ComponentRenderer

/**
 * Renderer for BOOL field type (checkbox/toggle)
 */
object FieldBool : ComponentRenderer {
    @Composable
    override fun Render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier
    ) {
        val fieldId = defnComp.name.name
        val value by formRef.watch<Boolean>(fieldId)
            .collectAsStateWithLifecycle(initialValue = false)

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = defnComp.label ?: defnComp.name.name,
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = value ?: false,
                onCheckedChange = { newValue ->
                    formRef.setValue(fieldId, newValue)
                },
                enabled = defnComp.disabled != true && defnComp.readOnly != true
            )
        }
    }
}
