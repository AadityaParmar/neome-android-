package com.neome.feature.form.presentation.components.base

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.form.presentation.components.composite.FieldSection
import com.neome.feature.form.presentation.components.composite.FieldTab
import com.neome.feature.form.presentation.components.field.FieldDate
import com.neome.feature.form.presentation.components.field.FieldDateRange
import com.neome.feature.form.presentation.components.field.FieldDateTime
import com.neome.feature.form.presentation.components.field.FieldDateTimeRange
import com.neome.feature.form.presentation.components.field.FieldDecimal
import com.neome.feature.form.presentation.components.field.FieldDocument
import com.neome.feature.form.presentation.components.field.FieldEmail
import com.neome.feature.form.presentation.components.field.FieldHandle
import com.neome.feature.form.presentation.components.field.FieldHyperlink
import com.neome.feature.form.presentation.components.field.FieldImage
import com.neome.feature.form.presentation.components.field.FieldMobile
import com.neome.feature.form.presentation.components.field.FieldNumber
import com.neome.feature.form.presentation.components.field.FieldParagraph
import com.neome.feature.form.presentation.components.field.FieldText
import com.neome.feature.form.presentation.components.field.FieldTime
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Factory responsible for selecting the correct field renderer
 * implementation depending on the field definition.
 */
@Composable
fun FieldFactory(
    defnComp: DefnCompSeal,
    defnForm: DefnFormData,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    when (defnComp.type) {
        EnumDefnCompType.text -> FieldText(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            modifier = modifier
        )

        EnumDefnCompType.email -> FieldEmail(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            modifier = modifier
        )

        EnumDefnCompType.handle -> FieldHandle(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            modifier = modifier
        )

        EnumDefnCompType.hyperlink -> FieldHyperlink(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            modifier = modifier
        )

        EnumDefnCompType.mobileNumber -> FieldMobile(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            modifier = modifier
        )

        EnumDefnCompType.date -> FieldDate(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            modifier = modifier
        )

        EnumDefnCompType.image -> FieldImage(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            modifier = modifier
        )

        EnumDefnCompType.document -> FieldDocument(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            modifier = modifier
        )

        EnumDefnCompType.dateTime -> FieldDateTime(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            modifier = modifier
        )

        EnumDefnCompType.dateRange -> FieldDateRange(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            modifier = modifier
        )

        EnumDefnCompType.dateTimeRange -> FieldDateTimeRange(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            modifier = modifier
        )

        EnumDefnCompType.time -> FieldTime(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            modifier = modifier
        )

        EnumDefnCompType.paragraph -> FieldParagraph(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            modifier = modifier
        )

        EnumDefnCompType.number -> FieldNumber(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            modifier = modifier
        )

        EnumDefnCompType.decimal -> FieldDecimal(
            defnComp = defnComp,
            onFieldEvent = onFieldEvent,
            modifier = modifier
        )

        EnumDefnCompType.section -> FieldSection(
            defnComp = defnComp,
            defnForm = defnForm,
            onFieldEvent = onFieldEvent,
            modifier = modifier
        )

        EnumDefnCompType.tab -> FieldTab(
            defnComp = defnComp,
            defnForm = defnForm,
            onFieldEvent = onFieldEvent,
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
