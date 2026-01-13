package com.neome.feature.form.presentation.component.composite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.dto.DefnSection
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.presentation.component.FieldFactory
import com.neome.feature.form.presentation.ctx.FormCtx
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Section component for form.
 *
 * A composite component that renders a container with child fields.
 * Sections can be used to group related fields together.
 *
 * Supports:
 * - Label/header
 * - Different layout directions (vertical/horizontal)
 * - Different visual variants
 * - Child field rendering
 *
 * @param defnComp Section definition containing section configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param formCtx Form context for accessing form state and other fields
 * @param modifier Modifier for customization
 */
@Composable
fun FieldSection(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    formCtx: FormCtx,
    modifier: Modifier = Modifier
) {
    val defnSection = defnComp as? DefnSection ?: return

    // Get field state to access computed properties
    val fieldId = defnSection.metaId
    val fieldState = formCtx.getFieldState(fieldId)
    val sectionLabel = fieldState?.fieldProperties?.label ?: defnSection.label
    val sectionDirection = defnSection.sectionDirection ?: EnumDefnThemeDirection.vertical
    val fieldIdSet = defnSection.fieldIdSet ?: emptyList()

    // Get form state from context
    val formState by formCtx.watchFormState().collectAsState()
    val defnForm = formCtx.getDefnForm() ?: return

    val content: @Composable () -> Unit = {
        // Render section label if present
        if (sectionLabel != null) {
            Text(
                text = sectionLabel,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        // Render child fields based on direction
        when (sectionDirection) {
            EnumDefnThemeDirection.horizontal -> {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    fieldIdSet.forEach { fieldId ->
                        renderChildField(
                            fieldId = fieldId,
                            formState = formState,
                            defnForm = defnForm,
                            formCtx = formCtx,
                            onFieldEvent = onFieldEvent,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            EnumDefnThemeDirection.vertical -> {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    fieldIdSet.forEach { fieldId ->
                        renderChildField(
                            fieldId = fieldId,
                            formState = formState,
                            defnForm = defnForm,
                            formCtx = formCtx,
                            onFieldEvent = onFieldEvent
                        )
                    }
                }
            }
        }
    }

    Column(
        modifier = modifier
    ) {
        content()
    }
}

/**
 * Render a child field within the section.
 */
@Composable
private fun renderChildField(
    fieldId: com.neome.api.meta.base.Types.MetaIdField,
    formState: com.neome.feature.form.presentation.state.FormState,
    defnForm: com.neome.core.common.serializer.api.meta.base.dto.DefnFormData,
    formCtx: FormCtx,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val childDefnComp = defnForm.compMap[fieldId] ?: return

    FieldFactory(
        defnComp = childDefnComp,
        formCtx = formCtx,
        onFieldEvent = onFieldEvent,
        modifier = modifier
    )
}
