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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueGridData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent
import com.neome.feature.form.presentation.state.FieldProperties

/**
 * Grid field component: displays a list of rows (rowId as text), Add button, clickable rows, remove per row.
 *
 * Uses DefnGridData / FieldValueGridData. Emits FieldEvent.GridAdd, GridEdit, GridRemove.
 *
 * Uses Column (not LazyColumn) to avoid nested scrolling with form's verticalScroll.
 */
@Composable
fun FieldGrid(
    defnComp: DefnCompSeal,
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

    FieldBase(modifier = modifier, properties = properties) {
        FieldGridContent(
            fieldId = fieldId,
            keys = fieldValue?.keys ?: emptyList(),
            error = error,
            properties = properties,
            onFieldEvent = onFieldEvent,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

/**
 * Stateless grid content: list of rows (clickable), Add button, remove icon per row.
 */
@Composable
private fun FieldGridContent(
    fieldId: Types.MetaIdComp,
    keys: List<Types.RowId>,
    error: FieldError?,
    properties: FieldProperties,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val interactive = !properties.disabled && !properties.readOnly

    Column(modifier = modifier) {
        keys.forEach { rowId ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(enabled = interactive) {
                        onFieldEvent(FieldEvent.GridEdit(fieldId, rowId))
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
                    onClick = { onFieldEvent(FieldEvent.GridRemove(fieldId, rowId)) },
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
                onClick = { onFieldEvent(FieldEvent.GridAdd(fieldId)) },
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
