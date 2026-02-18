package com.neome.feature.form.presentation.components.composite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
 * A composite component that renders a container with child fields arranged either
 * vertically or horizontally.
 *
 * Supports:
 * - Vertical / horizontal layout direction via [DefnSection.sectionDirection]
 * - Container padding via [DefnSection.pl], [DefnSection.pr], [DefnSection.pt], [DefnSection.pb]
 * - Inter-field spacing driven by the form theme ([DefnSection] colSpacing / rowSpacing)
 * - Visibility: hidden sections are not rendered (consistent with leaf fields)
 * - flexGrow: handled by the caller — pass [Modifier.weight] before calling FieldSection
 *
 * Not handled (deferred):
 * - sectionVariant
 * - fieldSpanMap / fieldSpan
 *
 * FormCtx is accessed via [LocalFormCtx], so this composable must be called
 * inside a Form composable tree.
 *
 * @param defnComp  Section definition containing section configuration
 * @param defnForm  The full form definition (used to look up child field definitions)
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier  Modifier applied to the outer container (caller sets weight / size here)
 */
@Composable
fun FieldSection(
    defnComp: DefnCompSeal,
    defnForm: DefnFormUi,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val defnSection = defnComp as? DefnSection ?: return
    val formCtx = LocalFormCtx.current

    // --- Visibility -----------------------------------------------------------
    val fieldState = formCtx.getFieldState(defnSection.metaId)
    if (fieldState?.fieldProperties?.hidden == true) return

    // --- Theme spacing --------------------------------------------------------
    // colSpacing: gap between fields laid out horizontally
    // rowSpacing: gap between fields laid out vertically
    // Defaults match previous hardcoded values so existing forms look unchanged
    // when no theme is set.
    val theme = formCtx.getDefnForm()?.theme
    val colSpacing = (theme?.colSpacing ?: 4L).toInt().dp
    val rowSpacing = (theme?.rowSpacing ?: 2L).toInt().dp

    // --- Container padding from defn ------------------------------------------
    // pl/pr/pt/pb are Long? values representing dp. Null → 0 (no padding).
    val containerPaddingModifier = Modifier.padding(
        start = (defnSection.pl ?: 0L).toInt().dp,
        top = (defnSection.pt ?: 0L).toInt().dp,
        end = (defnSection.pr ?: 0L).toInt().dp,
        bottom = (defnSection.pb ?: 0L).toInt().dp
    )

    val sectionDirection = defnSection.sectionDirection ?: EnumDefnThemeDirection.vertical
    val fieldIdSet = defnSection.fieldIdSet ?: emptyList()

    // --- Outer container ------------------------------------------------------
    // modifier comes from the caller (may carry weight/size for flexGrow scenarios).
    // fillMaxWidth() ensures the section always occupies the full horizontal slot.
    // containerPaddingModifier applies the defn-level padding inside that slot.
    Column(
        modifier = modifier
            .fillMaxWidth()
            .then(containerPaddingModifier)
    ) {
        when (sectionDirection) {
            EnumDefnThemeDirection.horizontal -> {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(colSpacing)
                ) {
                    fieldIdSet.forEach { childFieldId ->
                        RenderChildField(
                            fieldId = childFieldId,
                            defnForm = defnForm,
                            onFieldEvent = onFieldEvent,
                            // Equal distribution: every child gets the same share of
                            // the row width. The caller is responsible for passing
                            // weight to *this* section when flexGrow is true.
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            EnumDefnThemeDirection.vertical -> {
                Column(
                    verticalArrangement = Arrangement.spacedBy(rowSpacing)
                ) {
                    fieldIdSet.forEach { childFieldId ->
                        RenderChildField(
                            fieldId = childFieldId,
                            defnForm = defnForm,
                            onFieldEvent = onFieldEvent
                        )
                    }
                }
            }
        }
    }
}

/**
 * Renders a single child field within a section by delegating to [FieldFactory].
 *
 * Returns without rendering if the child definition cannot be found in [defnForm].
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
