# FieldGrid Implementation Plan

> **For Claude:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task.

**Goal:** Add a grid field type to the form system that displays rows in a table, supports add/edit/delete via a bottom sheet, and stores values as `FieldValueGridData` in the parent form's `valueMap`.

**Architecture:** FieldGrid is a hybrid composite — it renders child fields (like FieldSection) but also stores its own value (like a leaf field). The grid value (`FieldValueGridData`) lives in `FormState.valueMap[gridMetaId]`. Each row opens a bottom sheet containing a nested `Form` component (with synthetic `DefnFormUi`) for field rendering and validation. On bottom sheet submit, the row's `valueMap` is collected and merged back into the parent grid value via `FormEvent.FieldValueChanged`.

**Tech Stack:** Jetpack Compose, Material3 (ModalBottomSheet, DropdownMenu, FloatingActionButton), existing Form/FieldFactory infrastructure, FieldValueGridData/FieldDtoGridRowData DTOs.

---

## Decisions

| Decision | Choice |
|----------|--------|
| Row display | Table-like rows with columns matching grid fields |
| Bottom sheet content | Nested Form using FieldFactory (reuses full field system) |
| CRUD scope | Add + Edit + Delete |
| Value storage | In parent `FormState.valueMap[gridMetaId]` as `FieldValueGridData` |
| Add new row | FAB (FloatingActionButton) below the table |
| Edit row | Tap row → opens bottom sheet pre-filled |
| Delete row | Long press → context menu with delete option |
| Row commit timing | Immediate — on bottom sheet submit, parent `FormState` is updated |

---

## Data Model Reference

```
// Grid value stored in parent form's valueMap[gridMetaId]
FieldValueGridData(
    keys: List<RowId>,          // ordered row IDs
    map: Map<RowId, FieldDtoGridRowData>  // row data by ID
)

// Each row
FieldDtoGridRowData(
    rowId: RowId,
    rowOrder: String?,
    createdBy: EntUserId?,
    createdOn: String?,
    updatedBy: EntUserId?,
    updatedOn: String?,
    valueMap: Map<MetaIdField, JsonElement>?  // field values for this row
)

// Grid definition
DefnGrid(
    metaId: MetaIdGrid,
    fieldIdSet: List<MetaIdField>?,  // fields in each row (section children)
    minRows: Long?, maxRows: Long?,
    hideAddBtn: Boolean?,
    showExpand: Boolean?,
    ...
)
```

---

## Task 1: Create GridRowBottomSheet — Nested Form for Row Editing

**Files:**
- Create: `app/src/main/java/com/neome/feature/form/presentation/components/composite/GridRowBottomSheet.kt`

**Why first:** The bottom sheet is the core interaction point. Building it first lets us test row creation/editing independently.

**Step 1: Create the `GridRowBottomSheet` composable**

This composable:
- Takes the grid's `DefnGrid` definition and optionally an existing `FieldDtoGridRowData` (for edit mode)
- Builds a synthetic `DefnFormUi` from the grid's `fieldIdSet`
- Renders a `ModalBottomSheet` containing a `Form` component
- On inner form submit, creates a `FieldDtoGridRowData` from the form's `valueMap` and calls `onSubmit`

```kotlin
// GridRowBottomSheet.kt
package com.neome.feature.form.presentation.components.composite

/**
 * Bottom sheet for adding or editing a single grid row.
 *
 * Embeds a nested [Form] component with a synthetic [DefnFormUi] built from
 * the grid's [DefnGrid.fieldIdSet]. On submit, collects the inner form's valueMap
 * and delivers it as a [FieldDtoGridRowData] via [onSubmit].
 *
 * @param defnGrid      Grid definition containing fieldIdSet and constraints
 * @param defnForm      Parent form definition (for compMap lookups and theme)
 * @param existingRow   If non-null, pre-fills the form for editing this row
 * @param onSubmit      Called with the new/updated FieldDtoGridRowData on successful submit
 * @param onDismiss     Called when the sheet is dismissed without submitting
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GridRowBottomSheet(
    defnGrid: DefnGrid,
    defnForm: DefnFormUi,
    existingRow: FieldDtoGridRowData?,
    onSubmit: (FieldDtoGridRowData) -> Unit,
    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    val formRef = remember { mutableStateOf<FormRef?>(null) }

    // Build synthetic DefnFormUi from grid's fields
    val syntheticDefnForm = remember(defnGrid, defnForm) {
        buildSyntheticFormForGrid(defnGrid, defnForm)
    }

    // Build initial values from existing row (edit mode) or empty (add mode)
    val initialValue = remember(existingRow) {
        existingRow?.let { row ->
            FormValueData(
                rowId = row.rowId,
                valueMap = (row.valueMap ?: emptyMap()) as Map<MetaIdComp, JsonElement>
            )
        }
    }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        modifier = Modifier.fillMaxHeight(0.85f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            // Header
            Text(
                text = if (existingRow != null) "Edit Row" else "Add Row",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Nested form for row fields
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                Form(
                    defnForm = syntheticDefnForm,
                    initialValue = initialValue,
                    formRef = formRef,
                    onIntent = { intent ->
                        if (intent is FormIntent.Submit) {
                            val rowData = buildGridRowFromValueMap(
                                valueMap = intent.valueMap,
                                existingRow = existingRow
                            )
                            onSubmit(rowData)
                            scope.launch {
                                sheetState.hide()
                                onDismiss()
                            }
                        }
                    }
                )
            }

            // Submit button
            Button(
                onClick = { formRef.value?.submit() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Text(if (existingRow != null) "Update" else "Add")
            }
        }
    }
}
```

**Step 2: Implement `buildSyntheticFormForGrid` helper**

This function creates a minimal `DefnFormUi` that:
- Contains only the grid's fields from `fieldIdSet`
- Wraps them in a synthetic section as the root composite
- Copies theme from the parent form

```kotlin
/**
 * Builds a minimal DefnFormUi containing only the grid's row fields
 * wrapped in a synthetic section.
 */
private fun buildSyntheticFormForGrid(
    defnGrid: DefnGrid,
    parentDefnForm: DefnFormUi
): DefnFormUi {
    val fieldIdSet = defnGrid.fieldIdSet ?: emptyList()
    val syntheticSectionId = "__grid_row_section__"

    // Collect only the grid's field definitions from parent compMap
    val compMap = mutableMapOf<MetaIdComp, DefnCompSeal>()
    fieldIdSet.forEach { fieldId ->
        parentDefnForm.compMap[fieldId]?.let { compMap[fieldId] = it }
    }

    // Add a synthetic root section containing all grid fields
    val syntheticSection = DefnSectionData(
        metaId = MetaIdComp(syntheticSectionId),
        type = EnumDefnCompType.section,
        fieldIdSet = fieldIdSet,
        sectionDirection = EnumDefnThemeDirection.vertical
    )
    compMap[MetaIdComp(syntheticSectionId)] = syntheticSection

    // Build DefnFormUi with the synthetic section as root
    return DefnFormUi(
        compMap = compMap,
        displayCompositeId = MetaIdComposite(syntheticSectionId),
        theme = parentDefnForm.theme,
        // Copy other required fields with sensible defaults
    )
}
```

**Note:** The exact construction of `DefnFormUi` depends on how `DefnFormData` is serialized. You may need to use JSON merge construction (same pattern as `FilterForm.prepare`) rather than direct constructor. Inspect `DefnFormUi` and `DefnFormData` serialization to determine the best approach.

**Step 3: Implement `buildGridRowFromValueMap` helper**

```kotlin
/**
 * Converts the inner form's valueMap into a FieldDtoGridRowData.
 * Preserves existing row metadata (rowId, createdBy, etc.) when editing.
 */
private fun buildGridRowFromValueMap(
    valueMap: Map<MetaIdComp, JsonElement>,
    existingRow: FieldDtoGridRowData?
): FieldDtoGridRowData {
    val now = java.time.Instant.now().toString()
    return FieldDtoGridRowData(
        rowId = existingRow?.rowId ?: SysId.nextId(RowId::class.java),
        rowOrder = existingRow?.rowOrder,
        createdBy = existingRow?.createdBy,
        createdOn = existingRow?.createdOn ?: now,
        updatedBy = existingRow?.updatedBy,  // TODO: set to current user
        updatedOn = now,
        valueMap = valueMap as Map<MetaIdField, JsonElement>
    )
}
```

**Step 4: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/presentation/components/composite/GridRowBottomSheet.kt
git commit -m "feat(form): add GridRowBottomSheet with nested Form for grid row editing"
```

---

## Task 2: Create FieldGrid Composable — Table Display

**Files:**
- Create: `app/src/main/java/com/neome/feature/form/presentation/components/composite/FieldGrid.kt`

**Step 1: Create `FieldGrid` composable with table display**

FieldGrid is a composite component that:
- Reads the `FieldValueGridData` from `FormCtx.getValue(gridMetaId)`
- Displays rows in a table format (header row + data rows)
- Shows column headers from field labels
- Shows each row's field values as text in columns
- Opens `GridRowBottomSheet` on row tap (edit) or FAB click (add)
- Shows long-press context menu for delete

```kotlin
// FieldGrid.kt
package com.neome.feature.form.presentation.components.composite

@Composable
fun FieldGrid(
    defnComp: DefnCompSeal,
    defnForm: DefnFormUi,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val defnGrid = defnComp as? DefnGrid ?: return
    val formCtx = LocalFormCtx.current
    val fieldIdSet = defnGrid.fieldIdSet ?: emptyList()

    // --- Visibility ---
    val fieldState = formCtx.getFieldState(defnGrid.metaId)
    if (fieldState?.fieldProperties?.hidden == true) return

    // --- Read grid value from parent form ---
    val gridMetaId = defnGrid.metaId as MetaIdComp
    val gridJsonValue = formCtx.formState.value.valueMap[gridMetaId]
    val gridValue = remember(gridJsonValue) {
        gridJsonValue?.let {
            try {
                JsonParser.json.decodeFromJsonElement(
                    FieldValueGridData.serializer(), it
                )
            } catch (e: Exception) { null }
        }
    }

    val rows = gridValue?.keys?.mapNotNull { rowId ->
        gridValue.map[rowId]?.let { rowId to it }
    } ?: emptyList()

    // --- Bottom sheet state ---
    var showBottomSheet by remember { mutableStateOf(false) }
    var editingRow by remember { mutableStateOf<FieldDtoGridRowData?>(null) }

    // --- Resolve column headers from field definitions ---
    val columns = remember(fieldIdSet, defnForm) {
        fieldIdSet.mapNotNull { fieldId ->
            val comp = defnForm.compMap[fieldId]
            val label = (comp as? DefnField)?.label
                ?: (comp as? DefnFieldEditable)?.label
                ?: fieldId.toString()
            fieldId to label
        }
    }

    // --- Layout ---
    Box(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Optional grid label
            defnGrid.propertyEditorLabel?.let { label ->
                Text(
                    text = label,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }

            // Table header
            if (columns.isNotEmpty()) {
                GridTableHeader(columns = columns.map { it.second })
            }

            // Data rows
            rows.forEach { (rowId, rowData) ->
                GridTableRow(
                    rowData = rowData,
                    columns = columns,
                    defnForm = defnForm,
                    onTap = {
                        editingRow = rowData
                        showBottomSheet = true
                    },
                    onDelete = {
                        // Remove row from grid value
                        val updatedGrid = removeGridRow(gridValue, rowId)
                        val jsonElement = JsonParser.json.encodeToJsonElement(
                            FieldValueGridData.serializer(), updatedGrid
                        )
                        onFieldEvent(FieldEvent.ValueChanged(gridMetaId, jsonElement))
                    }
                )
            }

            // Row count info
            if (rows.isNotEmpty()) {
                Text(
                    text = "${rows.size} row(s)",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                )
            }
        }

        // FAB for adding new row
        if (defnGrid.hideAddBtn != true) {
            val maxRows = defnGrid.maxRowsVar
            val canAdd = maxRows == null || rows.size < maxRows
            if (canAdd) {
                SmallFloatingActionButton(
                    onClick = {
                        editingRow = null
                        showBottomSheet = true
                    },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add row")
                }
            }
        }
    }

    // --- Bottom Sheet ---
    if (showBottomSheet) {
        GridRowBottomSheet(
            defnGrid = defnGrid,
            defnForm = defnForm,
            existingRow = editingRow,
            onSubmit = { newRow ->
                val updatedGrid = upsertGridRow(gridValue, newRow)
                val jsonElement = JsonParser.json.encodeToJsonElement(
                    FieldValueGridData.serializer(), updatedGrid
                )
                onFieldEvent(FieldEvent.ValueChanged(gridMetaId, jsonElement))
                showBottomSheet = false
                editingRow = null
            },
            onDismiss = {
                showBottomSheet = false
                editingRow = null
            }
        )
    }
}
```

**Step 2: Implement table sub-composables**

```kotlin
@Composable
private fun GridTableHeader(columns: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        columns.forEach { label ->
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun GridTableRow(
    rowData: FieldDtoGridRowData,
    columns: List<Pair<MetaIdField, String>>,
    defnForm: DefnFormUi,
    onTap: () -> Unit,
    onDelete: () -> Unit
) {
    var showMenu by remember { mutableStateOf(false) }

    Box {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .combinedClickable(
                    onClick = onTap,
                    onLongClick = { showMenu = true }
                )
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            columns.forEach { (fieldId, _) ->
                val cellValue = rowData.valueMap?.get(fieldId)
                val defnComp = defnForm.compMap[fieldId]
                val displayText = if (cellValue != null && defnComp != null) {
                    FieldValueResolver.fnResolveFieldValueToSting(
                        defnComp as DefnCompSeal, cellValue
                    ) ?: "-"
                } else {
                    "-"
                }

                Text(
                    text = displayText,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.weight(1f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        // Long-press context menu
        DropdownMenu(
            expanded = showMenu,
            onDismissRequest = { showMenu = false }
        ) {
            DropdownMenuItem(
                text = { Text("Delete") },
                leadingIcon = { Icon(Icons.Default.Delete, null) },
                onClick = {
                    showMenu = false
                    onDelete()
                }
            )
        }
    }
}
```

**Step 3: Implement grid value helper functions**

```kotlin
/**
 * Creates a new FieldValueGridData with the given row added or updated.
 */
private fun upsertGridRow(
    currentGrid: FieldValueGridData?,
    row: FieldDtoGridRowData
): FieldValueGridData {
    val currentKeys = currentGrid?.keys?.toMutableList() ?: mutableListOf()
    val currentMap = currentGrid?.map?.toMutableMap() ?: mutableMapOf()

    if (!currentKeys.contains(row.rowId)) {
        currentKeys.add(row.rowId)
    }
    currentMap[row.rowId] = row

    return FieldValueGridData(keys = currentKeys, map = currentMap)
}

/**
 * Creates a new FieldValueGridData with the given row removed.
 */
private fun removeGridRow(
    currentGrid: FieldValueGridData?,
    rowId: RowId
): FieldValueGridData {
    val currentKeys = currentGrid?.keys?.toMutableList() ?: mutableListOf()
    val currentMap = currentGrid?.map?.toMutableMap() ?: mutableMapOf()

    currentKeys.remove(rowId)
    currentMap.remove(rowId)

    return FieldValueGridData(keys = currentKeys, map = currentMap)
}
```

**Step 4: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/presentation/components/composite/FieldGrid.kt
git commit -m "feat(form): add FieldGrid composable with table display, CRUD, and bottom sheet"
```

---

## Task 3: Wire FieldGrid into FieldFactory

**Files:**
- Modify: `app/src/main/java/com/neome/feature/form/presentation/components/base/FieldFactory.kt`

**Step 1: Replace the grid TODO with FieldGrid**

In `FieldFactory.kt`, replace the existing grid placeholder (lines 209-219):

```kotlin
// BEFORE:
EnumDefnCompType.grid -> {
    // TODO: Implement FieldGrid component
    Column(modifier = modifier) {
        Text(
            text = "Grid component not implemented yet",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

// AFTER:
EnumDefnCompType.grid -> FieldGrid(
    defnComp = defnComp,
    defnForm = defnForm,
    onFieldEvent = onFieldEvent,
    modifier = modifier
)
```

Add the import:
```kotlin
import com.neome.feature.form.presentation.components.composite.FieldGrid
```

**Step 2: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/presentation/components/base/FieldFactory.kt
git commit -m "feat(form): wire FieldGrid into FieldFactory, replacing TODO placeholder"
```

---

## Task 4: Add Grid Value Support to Converter

**Files:**
- Modify: `app/src/main/java/com/neome/feature/form/domain/util/FieldVal/Converter.kt`

Currently, the grid type falls through to `else -> null` in both `fnRawValueToFieldValue` and `fnFieldValueToRawValue`. Since the grid value is a complex type (like `pickText`), it should be handled via KSerializer in the FieldController. However, we need `fnJsonElementFieldValue` to work for grid values (used by `DefaultValue.fnEnsureInitGrid`).

**Step 1: Add grid case to Converter**

In `fnRawValueToFieldValue`, add after the `pickText` null case:
```kotlin
// Complex types — serialized/deserialized via KSerializer
Types.EnumDefnCompType.pickText -> null
Types.EnumDefnCompType.grid -> null  // ADD THIS LINE
```

In `fnFieldValueToRawValue`, add:
```kotlin
Types.EnumDefnCompType.grid -> {
    when (value) {
        is FieldValueGridData -> value  // Return as-is, it's already structured
        else -> null
    }
}
```

**Step 2: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/domain/util/FieldVal/Converter.kt
git commit -m "feat(form): add grid type handling in Converter"
```

---

## Task 5: Handle Grid as Value-Carrying Composite in FormCtxInitHelper

**Files:**
- Modify: `app/src/main/java/com/neome/feature/form/domain/ctx/helper/FormCtxInitHelper.kt`

Currently, `initializeFormState` filters out composite types from `fieldStates` and `valueMap`. But grid is unique: it's composite AND has a value. We need to ensure:
1. Grid fields get a `FieldState` (for properties like hidden, disabled)
2. Grid values are included in the `valueMap`
3. Grid's CHILD fields are NOT in the parent's fieldStates/valueMap (they live in row-level valueMaps)

**Step 1: Modify the composite type filter to include grid in valueMap**

In `FormCtxInitHelper.initializeFormState`, the `valueMap` filter currently excludes composites:

```kotlin
// CURRENT:
val valueMap = initialValueMap.filterKeys { fieldId ->
    compMap[fieldId]?.let { !isCompositeType(it.type) } ?: false
}

// CHANGE TO:
val valueMap = initialValueMap.filterKeys { fieldId ->
    val comp = compMap[fieldId] ?: return@filterKeys false
    !isCompositeType(comp.type) || comp.type == EnumDefnCompType.grid
}
```

Similarly, for `fieldStates`, include grid:

```kotlin
// CURRENT:
val fieldStates = compMap
    .filter { (_, defnComp) -> !isCompositeType(defnComp.type) }
    .mapValues { ... }

// CHANGE TO:
val fieldStates = compMap
    .filter { (_, defnComp) ->
        !isCompositeType(defnComp.type) || defnComp.type == EnumDefnCompType.grid
    }
    .mapValues { ... }
```

And in `leafFields` for dependency map:
```kotlin
val leafFields = compMap.filter { (_, defnComp) ->
    !isCompositeType(defnComp.type) || defnComp.type == EnumDefnCompType.grid
}
```

**Step 2: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/domain/ctx/helper/FormCtxInitHelper.kt
git commit -m "feat(form): include grid in fieldStates and valueMap during init"
```

---

## Task 6: Add Grid to Sample Data for Testing

**Files:**
- Modify: `app/src/main/java/com/neome/feature/form/presentation/sample/FormSampleDataFactory.kt`

**Step 1: Add a grid field to the sample form**

Add a grid with 2-3 simple fields (text, number) to the existing sample form definition so the grid can be visually tested in the demo screen.

Inspect `FormSampleDataFactory.kt` to understand the current sample structure, then add:
- A `DefnGridData` with `fieldIdSet` pointing to 2-3 field definitions
- The field definitions (text + number) added to the sample `compMap`
- Add the grid's metaId to the root section's `fieldIdSet`

**Step 2: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/presentation/sample/FormSampleDataFactory.kt
git commit -m "feat(form): add grid field to sample form data for testing"
```

---

## Task 7: Refine Synthetic DefnFormUi Construction

**Files:**
- Modify: `app/src/main/java/com/neome/feature/form/presentation/components/composite/GridRowBottomSheet.kt`

**Step 1: Investigate DefnFormUi construction**

The `buildSyntheticFormForGrid` function needs to produce a valid `DefnFormUi`. Since `DefnFormUi` extends `DefnFormData` which implements `DefnForm`, check:
- Required fields in `DefnFormData` constructor
- Whether JSON merge construction is needed (as used by `FilterForm.prepare`)
- Whether `DefnFormData` can be instantiated directly with a minimal compMap

Inspect:
- `app/src/main/java/com/neome/core/common/serializer/api/meta/base/dto/DefnFormData.kt`
- `app/src/main/java/com/neome/feature/form/domain/TypesForm.kt` (DefnFormUi)
- `app/src/main/java/com/neome/core/common/serializer/api/meta/base/dto/DefnSectionData.kt`

Adjust the helper function based on findings. The key requirement:
- `compMap` must contain the grid's fields + a synthetic root section
- `displayCompositeId` must point to the root section
- `theme` should be copied from parent for consistent styling

**Step 2: Test the bottom sheet opens and renders fields correctly**

Build and run the app, navigate to the form with the grid sample, tap the FAB. Verify:
- Bottom sheet opens
- Fields from the grid definition render correctly
- Field validation works (required fields, etc.)
- Submit creates a row and displays in the table

**Step 3: Commit any fixes**

```bash
git add -A
git commit -m "fix(form): refine synthetic DefnFormUi construction for grid row bottom sheet"
```

---

## Task 8: Polish and Edge Cases

**Files:**
- Modify: `app/src/main/java/com/neome/feature/form/presentation/components/composite/FieldGrid.kt`
- Modify: `app/src/main/java/com/neome/feature/form/presentation/components/composite/GridRowBottomSheet.kt`

**Step 1: Handle empty state**

When no rows exist, show a placeholder message instead of just the FAB:
```kotlin
if (rows.isEmpty()) {
    Text(
        text = "No rows added yet",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
    )
}
```

**Step 2: Handle maxRows constraint in UI**

- Disable/hide FAB when `rows.size >= defnGrid.maxRowsVar`
- This is already sketched in Task 2 but verify it works with the schema validation

**Step 3: Handle minRows validation feedback**

- `FieldGridSchema` already validates minRows/maxRows
- Ensure the grid field shows validation errors from `FormCtx.getError(gridMetaId)`
- Display error text below the table

**Step 4: Handle disabled/readOnly state**

- When form is disabled or grid is readOnly, hide the FAB, disable row tap, hide long-press menu
- Read `fieldState?.fieldProperties?.disabled` and `fieldState?.fieldProperties?.readOnly`

**Step 5: Commit**

```bash
git add -A
git commit -m "feat(form): add empty state, validation feedback, and disabled/readOnly handling for FieldGrid"
```

---

## Task 9: Update form.md Documentation

**Files:**
- Modify: `app/src/main/java/com/neome/feature/form/form.md`

**Step 1: Update the following sections**

1. **Version** → bump to next minor (e.g., 1.17.0)
2. **Key Files** table → add `FieldGrid.kt`, `GridRowBottomSheet.kt`
3. **Component Hierarchy** → move `grid` from TODO to implemented under COMPOSITE TYPES
4. **FieldFactory supported types** → add `grid` with description
5. **File Structure** → add new files under `presentation/components/composite/`
6. **Changelog** → add entry describing all changes

**Step 2: Update composite README**

Update `presentation/components/composite/README.md` to include FieldGrid and GridRowBottomSheet.

**Step 3: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/form.md
git add app/src/main/java/com/neome/feature/form/presentation/components/composite/README.md
git commit -m "docs(form): update form.md and composite README for FieldGrid feature"
```

---

## Execution Notes

### Key Risk: Synthetic DefnFormUi Construction (Task 7)

The trickiest part is building a valid `DefnFormUi` from just the grid's fields. If `DefnFormUi`/`DefnFormData` have many required fields, you may need to:
- Use JSON merge construction (serialize a minimal JSON, then deserialize)
- Or create a builder/factory function that handles defaults

Investigate the actual constructors before implementing.

### Grid Fields in Parent FormState

Grid's CHILD fields (the ones inside each row) must NOT appear in the parent form's `fieldStates` or `valueMap`. They only exist inside `FieldDtoGridRowData.valueMap`. The `DefaultValue.fnEnsureInit` already handles this correctly — it tracks grid children in `gridSet` and processes them separately via `fnEnsureInitGrid`.

### Value Flow Diagram

```
User taps FAB → Bottom sheet opens with nested Form
  → User fills fields → Nested form validates
  → User taps Submit → FormIntent.Submit(innerValueMap)
  → buildGridRowFromValueMap() → FieldDtoGridRowData
  → upsertGridRow() → updated FieldValueGridData
  → Encode to JsonElement
  → onFieldEvent(FieldEvent.ValueChanged(gridMetaId, json))
  → Parent FormCtx dispatches FieldValueChanged
  → Parent valueMap updated → Compose recomposes FieldGrid table
```

### Testing Checklist

- [ ] Grid renders with sample data
- [ ] FAB opens bottom sheet with correct fields
- [ ] Adding a row shows it in the table
- [ ] Tapping a row opens edit sheet pre-filled
- [ ] Editing a row updates the table
- [ ] Long press shows delete menu
- [ ] Deleting a row removes it from table
- [ ] minRows/maxRows validation works
- [ ] FAB hidden when maxRows reached
- [ ] FAB hidden when hideAddBtn is true
- [ ] Grid respects hidden/disabled/readOnly
- [ ] Parent form submit includes grid data in valueMap
- [ ] Empty state message shows when no rows