package com.neome.feature.form.presentation.components.base

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.form.domain.ctx.FormCtx
import com.neome.feature.form.presentation.components.composite.FieldSection
import com.neome.feature.form.presentation.components.composite.FieldTab
import com.neome.feature.form.presentation.components.field.FieldDecimal
import com.neome.feature.form.presentation.components.field.FieldEmail
import com.neome.feature.form.presentation.components.field.FieldNumber
import com.neome.feature.form.presentation.components.field.FieldParagraph
import com.neome.feature.form.presentation.components.field.FieldText
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Factory responsible for selecting the correct field renderer
 * implementation depending on the field definition.
 */
@Composable
fun FieldFactory(
    defnComp: DefnCompSeal,
    defnForm: DefnFormData,
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

        EnumDefnCompType.email -> FieldEmail(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            formCtx = formCtx,
            modifier = modifier
        )

        EnumDefnCompType.paragraph -> FieldParagraph(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            formCtx = formCtx,
            modifier = modifier
        )

        EnumDefnCompType.number -> FieldNumber(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            formCtx = formCtx,
            modifier = modifier
        )

        EnumDefnCompType.decimal -> FieldDecimal(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            formCtx = formCtx,
            modifier = modifier
        )

        EnumDefnCompType.section -> FieldSection(
            defnComp = defnComp,
            defnForm = defnForm,
            onFieldEvent = onFieldEvent,
            formCtx = formCtx,
            modifier = modifier
        )

        EnumDefnCompType.tab -> FieldTab(
            defnComp = defnComp,
            defnForm = defnForm,
            onFieldEvent = onFieldEvent,
            formCtx = formCtx,
            modifier = modifier
        )

        EnumDefnCompType.grid -> {
            // TODO: Implement FieldGrid component
            Column(
                modifier = modifier
            ) {
                Text(
                    text = "Grid component not implemented yet",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        else -> {
            Column(
                modifier = modifier
            ) {
                Text(
                    text = "Field: ${defnComp.type.value} not implemented yet",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
