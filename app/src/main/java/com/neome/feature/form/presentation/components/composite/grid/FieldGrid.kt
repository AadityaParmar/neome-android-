package com.neome.feature.form.presentation.components.composite.grid

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnGridData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueGridData
import com.neome.feature.form.domain.model.DefnFormUi
import com.neome.feature.form.domain.ctx.LocalFormCtx
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent
import com.neome.feature.form.presentation.state.FieldProperties

/**
 * Grid field component: displays a list of rows with add/edit/remove actions.
 *
 * Pure event emitter — zero local state. All grid row editing state lives
 * in [FormState.gridCtx], managed by the MVI reducer.
 *
 * - Add: emits [FieldEvent.GridAdd] → reducer initializes gridCtx → sheet opens
 * - Edit: emits [FieldEvent.GridEdit] → reducer initializes gridCtx with row data → sheet opens
 * - Remove: emits [FieldEvent.GridRemove] → reducer removes row from grid value
 * - Sheet visibility: derived from `formState.gridCtx?.gridId == fieldId`
 * - Submit: [GridRowSheet] emits [FieldEvent.GridSubmit] → reducer validates + merges + closes
 * - Dismiss: [GridRowSheet] emits [FieldEvent.GridClose] → reducer clears gridCtx
 */
@Composable
fun FieldGrid(
    defnComp: DefnCompSeal,
    defnForm: DefnFormUi,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val fieldController = rememberFieldController<FieldValueGridData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    val fieldId = fieldController.fieldId
    if (fieldId == null) return

    val fieldValue = fieldController.value.value
    val (properties, error) = fieldController.field.value

    if (properties.hidden) return

    val defnGrid = defnComp as? DefnGridData ?: return

    // ==================== Read grid sheet state from FormState ====================
    val formCtx = LocalFormCtx.current
    val formState = formCtx.formState.value
    val gridCtxActive = formState.gridCtx?.gridId == fieldId

    // ==================== Render ====================
    FieldBase(modifier = modifier, properties = properties) {
        FieldGridContent(
            fieldId = fieldId,
            keys = fieldValue?.keys ?: emptyList(),
            error = error,
            properties = properties,
            onAddRow = { onFieldEvent(FieldEvent.GridAdd(fieldId)) },
            onEditRow = { rowId -> onFieldEvent(FieldEvent.GridEdit(fieldId, rowId)) },
            onRemoveRow = { rowId -> onFieldEvent(FieldEvent.GridRemove(fieldId, rowId)) },
            modifier = Modifier.fillMaxWidth()
        )
    }

    // ==================== Bottom sheet (driven by gridCtx) ====================
    if (gridCtxActive) {
        val gridFormCtx = remember(formCtx, defnForm) {
            GridFormCtx(parentFormCtx = formCtx, defnForm = defnForm)
        }
        GridRowSheet(
            gridFormCtx = gridFormCtx,
            defnGrid = defnGrid,
            defnForm = defnForm,
            onFieldEvent = onFieldEvent,
            onSubmit = { onFieldEvent(FieldEvent.GridSubmit(fieldId)) },
            onDismiss = { onFieldEvent(FieldEvent.GridClose(fieldId)) },
            isEditing = formState.gridCtx?.isNewRow == false
        )
    }
}

/**
 * Stateless grid content: list of rows (clickable), Add button, remove icon per row.
 */
@Composable
private fun FieldGridContent(
    fieldId: MetaIdComp,
    keys: List<Types.RowId>,
    error: FieldError?,
    properties: FieldProperties,
    onAddRow: () -> Unit,
    onEditRow: (Types.RowId) -> Unit,
    onRemoveRow: (Types.RowId) -> Unit,
    modifier: Modifier = Modifier
) {
    val interactive = !properties.disabled && !properties.readOnly

    Column(modifier = modifier) {
        keys.forEach { rowId ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(enabled = interactive) {
                        onEditRow(rowId)
                    }
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = rowId.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    onClick = { onRemoveRow(rowId) },
                    enabled = interactive
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Remove row"
                    )
                }
            }
        }

        if (interactive) {
            TextButton(
                onClick = onAddRow,
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text("Add")
            }
        }

        error?.message?.let { msg ->
            Text(
                text = msg,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
