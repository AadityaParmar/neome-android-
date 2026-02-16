package com.neome.feature.form.presentation.components.composite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.dto.DefnSection
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.ctx.LocalFormCtx
import com.neome.feature.form.presentation.components.base.FieldFactory
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
 * FormCtx is accessed via LocalFormCtx.current, so this composable must be called
 * inside a Form composable tree.
 *
 * @param defnComp Section definition containing section configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldSection(
    defnComp: DefnCompSeal,
    defnForm: DefnFormUi,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val defnSection = defnComp as? DefnSection ?: return

    // Get form context
    val formCtx = LocalFormCtx.current

    // Get field state to access computed properties
    val fieldId = defnSection.metaId
    val fieldState = formCtx.getFieldState(fieldId)
    val sectionLabel = fieldState?.fieldProperties?.label ?: defnSection.label
    val sectionDirection = defnSection.sectionDirection ?: EnumDefnThemeDirection.vertical
    val fieldIdSet = defnSection.fieldIdSet ?: emptyList()


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
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    fieldIdSet.forEach { fieldId ->
                        RenderChildField(
                            fieldId = fieldId,
                            defnForm = defnForm,
                            onFieldEvent = onFieldEvent,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            EnumDefnThemeDirection.vertical -> {
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    fieldIdSet.forEach { fieldId ->
                        RenderChildField(
                            fieldId = fieldId,
                            defnForm = defnForm,
                            onFieldEvent = onFieldEvent
                        )
                    }
                }
            }
        }
    }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        content()
    }
}

/**
 * Render a child field within the section.
 */
@Composable
private fun RenderChildField(
    fieldId: com.neome.api.meta.base.Types.MetaIdField,
    defnForm: DefnFormUi,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val childDefnComp = defnForm.compMap[fieldId] ?: return

    FieldFactory(
        defnComp = childDefnComp,
        defnForm = defnForm,
        onFieldEvent = onFieldEvent,
        modifier = modifier
    )
}
