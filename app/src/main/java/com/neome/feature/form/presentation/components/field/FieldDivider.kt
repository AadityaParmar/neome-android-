package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.dto.DefnFieldDivider
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Divider field component for form.
 *
 * Renders a horizontal divider line at full width. The height varies
 * based on [EnumDefnThemeDividerKind]:
 * - [EnumDefnThemeDividerKind.thin] — 1dp height (default)
 * - [EnumDefnThemeDividerKind.thick] — 4dp height
 *
 * Color is hardcoded to Grey 300 (`#E0E0E0`).
 *
 * The divider carries no stored value. [rememberFieldController] is used solely
 * for consistent access to resolved field properties (hidden, disabled, etc.).
 *
 * FormCtx is accessed via LocalFormCtx.current inside [rememberFieldController],
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp     Field definition containing divider configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier     Modifier for customization
 */
@Composable
fun FieldDivider(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Dividers carry no stored value — Unit? as a no-op type
    val fieldController = rememberFieldController<Unit?>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    if (fieldController.fieldId == null) return

    val (properties, _) = fieldController.field.value

    if (properties.hidden) return

    // Cast to DefnFieldDivider to access divider-specific properties
    val defnDivider = defnComp as? DefnFieldDivider

    // Resolve divider kind: direct value -> variable -> default thin
    val dividerKind = defnDivider?.dividerKind
        ?: defnDivider?.dividerKindVar
        ?: EnumDefnThemeDividerKind.thin

    FieldDividerContent(
        dividerKind = dividerKind,
        modifier = modifier
    )
}

/**
 * Stateless divider content for optimal recomposition control.
 *
 * Renders a full-width horizontal line whose height depends on [dividerKind]:
 * - thin → 1dp
 * - thick → 4dp
 *
 * @param dividerKind The kind of divider (thin or thick)
 * @param modifier    Modifier for customization
 */
@Composable
private fun FieldDividerContent(
    dividerKind: EnumDefnThemeDividerKind,
    modifier: Modifier = Modifier
) {
    val height: Dp = when (dividerKind) {
        EnumDefnThemeDividerKind.thin -> 1.dp
        EnumDefnThemeDividerKind.thick -> 4.dp
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .background(Color(0xFFE0E0E0)) // Grey 300
    )
}
