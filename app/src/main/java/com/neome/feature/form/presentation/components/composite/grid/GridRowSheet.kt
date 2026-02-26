package com.neome.feature.form.presentation.components.composite.grid

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.core.common.serializer.api.meta.base.dto.DefnGridData
import com.neome.feature.form.domain.model.DefnFormUi
import com.neome.feature.form.domain.ctx.FormCtx
import com.neome.feature.form.domain.ctx.LocalFormCtx
import com.neome.feature.form.presentation.components.base.FieldFactory
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Bottom sheet for adding or editing a single grid row.
 *
 * Renders child fields inside a [CompositionLocalProvider] that provides
 * [gridFormCtx] as [LocalFormCtx]. This means child fields rendered by
 * [FieldFactory] read/write from the isolated grid form state,
 * not the parent form state.
 *
 * Field events from child fields are forwarded directly to the parent via [onFieldEvent].
 *
 * @param gridFormCtx Isolated FormCtx for this row
 * @param defnGrid Grid definition containing [fieldIdSet]
 * @param defnForm Parent form definition (contains child field defs in compMap)
 * @param onFieldEvent Callback for field events from this row
 * @param onSubmit Called when user submits the row (validation passed)
 * @param onDismiss Called when user cancels or dismisses the sheet
 * @param isEditing true for edit mode, false for add mode (affects labels)
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GridRowSheet(
    gridFormCtx: FormCtx,
    defnGrid: DefnGridData,
    defnForm: DefnFormUi,
    onFieldEvent: (FieldEvent) -> Unit,
    onSubmit: () -> Unit,
    onDismiss: () -> Unit,
    isEditing: Boolean
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState
    ) {
        CompositionLocalProvider(LocalFormCtx provides gridFormCtx) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.75f)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                // Header
                Text(
                    text = if (isEditing) "Edit Row" else "Add Row",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Render child fields
                val fieldIdSet = defnGrid.fieldIdSet ?: emptyList()
                fieldIdSet.forEach { fieldId ->
                    val childDefnComp = defnForm.compMap[fieldId] ?: return@forEach
                    FieldFactory(
                        defnComp = childDefnComp,
                        defnForm = defnForm,
                        onFieldEvent = onFieldEvent,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Footer buttons
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    ) {
                        Text("Cancel")
                    }

                    Button(
                        onClick = onSubmit,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)
                    ) {
                        Text(if (isEditing) "Save" else "Add")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
