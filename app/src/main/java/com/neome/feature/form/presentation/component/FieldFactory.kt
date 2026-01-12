package com.neome.feature.form.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.presentation.component.composite.FieldSection
import com.neome.feature.form.presentation.component.composite.FieldTab
import com.neome.feature.form.presentation.component.field.FieldText
import com.neome.feature.form.presentation.ctx.FormCtx
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Factory responsible for selecting the correct field renderer
 * implementation depending on the field definition.
 */
@Composable
fun FieldFactory(
    defnComp: DefnCompSeal,
    formCtx: FormCtx,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    when (defnComp.type) {
        EnumDefnCompType.text -> FieldText(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            formCtx = formCtx,
            modifier = modifier
        )

        EnumDefnCompType.section -> FieldSection(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            formCtx = formCtx,
            modifier = modifier
        )

        EnumDefnCompType.tab -> FieldTab(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            formCtx = formCtx,
            modifier = modifier
        )

        else -> {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Unsupported field type: ${defnComp.type.value}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
