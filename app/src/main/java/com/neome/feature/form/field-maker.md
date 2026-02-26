# skill:defnFieldMaker

## Metadata

| Property         | Value                                                     |
|------------------|-----------------------------------------------------------|
| **Version**      | 1.0.0                                                     |
| **Last Updated** | 2026-02-17                                                |
| **Scope**        | Creating new field types for the Form FieldFactory system |
| **Path**         | `app/src/main/java/com/neome/feature/form/field-maker.md` |
| **Depends On**   | `skill:defnForm` (form architecture knowledge)            |

---

## Table of Contents

1. [Quick Reference](#quick-reference)
2. [Prerequisites & Assumptions](#prerequisites--assumptions)
3. [Decision Tree](#decision-tree)
4. [Step-by-Step Checklist](#step-by-step-checklist)
5. [Code Templates](#code-templates)
6. [Validation Schema Patterns](#validation-schema-patterns)
7. [Property Resolution Patterns](#property-resolution-patterns)
8. [Reference Examples](#reference-examples)
9. [Anti-Patterns & Common Mistakes](#anti-patterns--common-mistakes)
10. [Post-Creation Verification](#post-creation-verification)

---

## Quick Reference

### Usage Pattern

```
using skill : defnFieldMaker do [instruction]
```

### Example Instructions

| Task                       | Example                                              |
|----------------------------|------------------------------------------------------|
| Add simple text-like field | `Add new field type FieldColor`                      |
| Add numeric field          | `Add new field type FieldRating with min/max`        |
| Add complex field          | `Add new field type FieldLocation with capture`      |
| Add picker field           | `Add new field type FieldPickText with dropdown`     |
| Add media field            | `Add new field type FieldAudio with size validation` |

### Files to Touch (Ordered)

| # | File (relative to `feature/form/`)              | Action | When                                   |
|---|-------------------------------------------------|--------|----------------------------------------|
| 1 | `domain/util/FieldVal/Converter.kt`             | EDIT   | Always                                 |
| 2 | `domain/util/FieldVal/DefaultValue.kt`          | EDIT   | If has default                         |
| 3 | `domain/util/FieldPropertyResolver.kt`          | EDIT   | If has unique props or `*FieldId` refs |
| 4 | `presentation/state/FieldState.kt`              | EDIT   | If new `FieldProperties` fields needed |
| 5 | `domain/ctx/helper/schema/Field{Name}Schema.kt` | CREATE | Always                                 |
| 6 | `domain/ctx/helper/schema/CompSchemaFactory.kt` | EDIT   | Always                                 |
| 7 | `presentation/components/field/Field{Name}.kt`  | CREATE | Always                                 |
| 8 | `presentation/components/base/FieldFactory.kt`  | EDIT   | Always                                 |

> **Order matters.** Domain layer first (steps 1-6), then presentation (steps 7-8). This prevents compile errors from missing value conversions or schemas.

---

## Prerequisites & Assumptions

Before using this skill, these artifacts MUST already exist (they are auto-generated from the server schema):

### Already Exists (DO NOT CREATE)

| Artifact                             | Location                                                           | Example                                               |
|--------------------------------------|--------------------------------------------------------------------|-------------------------------------------------------|
| `DefnField{Name}` interface          | `api/meta/base/dto/DefnField{Name}.kt`                             | `DefnFieldSlider`                                     |
| `DefnField{Name}Data` data class     | `core/common/serializer/api/meta/base/dto/DefnField{Name}Data.kt`  | `DefnFieldSliderData`                                 |
| `FieldValue{Name}Data` data class    | `core/common/serializer/api/meta/base/dto/FieldValue{Name}Data.kt` | `FieldValueSliderData`                                |
| `EnumDefnCompType.{name}` enum entry | `api/meta/base/Types.kt`                                           | `EnumDefnCompType.slider`                             |
| `DefnCompSerializer` routing         | `core/common/serializer/api/meta/base/dto/DefnCompData.kt`         | Maps `"slider"` to `DefnFieldSliderData.serializer()` |

### Must Verify Before Starting

1. **Confirm the `EnumDefnCompType` value** - Check `api/meta/base/Types.kt` for the exact enum name
2. **Confirm the Defn interface** - Check `api/meta/base/dto/DefnField{Name}.kt` for available properties
3. **Confirm the FieldValue type** - Check `core/common/serializer/api/meta/base/dto/FieldValue{Name}Data.kt` for value structure
4. **Identify the Defn interface hierarchy** - Is it `DefnFieldEditable`? `DefnFieldEditableText`? Direct `DefnField`?

### Key Interface Hierarchy (for reference)

```
DefnComp                          -- Base: name, type, label, disabled, hidden
  +-- DefnField                   -- Adds: metaId
       +-- DefnFieldEditable      -- Adds: required, placeholder, helperText, icon, prefix, suffix
            +-- DefnFieldEditableText  -- Adds: defaultValue (String), defaultFieldId
            |    +-- DefnFieldText     -- Adds: minCharCount, maxCharCount, validationPattern
            |    +-- DefnFieldParagraph -- Adds: lineCount, flexHeight
            +-- DefnFieldNumber    -- Adds: min, max, defaultValue (Long)
            +-- DefnFieldDecimal   -- Adds: min, max, defaultValue (Double)
            +-- DefnFieldSwitch    -- Adds: captureTime/User/Location, showAsCheckbox
            +-- DefnFieldCounter   -- Adds: step, minDisplayValue
            +-- ... (other field types)
```

---

## Decision Tree

Use this to determine which optional steps apply to your new field.

```
START
  |
  +-- Does the field have a value the user edits?
  |     YES --> Step 1 (Converter) is REQUIRED
  |     NO  --> Field is display-only. Consider if it even needs a FieldState.
  |
  +-- Does the field have a `defaultValue` property?
  |     YES --> Step 2 (DefaultValue) is REQUIRED
  |     NO  --> Skip Step 2
  |
  +-- Does the Defn interface have any `*FieldId` properties?
  |   (e.g., minFieldId, maxFieldId, showLabelFieldId)
  |     YES --> Step 3 (FieldPropertyResolver.extractFieldIdReferences) is REQUIRED
  |     NO  --> Skip the extractFieldIdReferences part of Step 3
  |
  +-- Does the field need unique computed properties NOT already in FieldProperties?
  |   (e.g., a new `showStars: Boolean?` for a rating field)
  |     YES --> Step 3 (resolveFieldProperties) + Step 4 (FieldState.kt) are REQUIRED
  |     NO  --> Skip Step 4. Existing properties (required, disabled, label, etc.) suffice.
  |
  +-- Does the field need validation?
  |     YES --> Steps 5-6 (Schema + Factory) are REQUIRED
  |     NO  --> Register as `null` in CompSchemaFactory (Step 6 still needed)
  |
  +-- Does the field render UI?
        YES --> Steps 7-8 (Field component + FieldFactory) are REQUIRED
        NO  --> Field is domain-only (rare). Skip Steps 7-8.
```

---

## Step-by-Step Checklist

### Step 1: Add Value Conversion (ALWAYS)

> **File:** `domain/util/FieldVal/Converter.kt`

Add the new field type to two functions: `fnRawValueToFieldValue` and `fnFieldValueToRawValue`.

#### 1a. `fnRawValueToFieldValue` - Raw value to typed FieldValue wrapper

Find the `when (compType)` block and add a branch:

```kotlin
// In fnRawValueToFieldValue():
EnumDefnCompType.{fieldType} -> {
    val stringValue = value?.toString() ?: return null
    FieldValue{Name}Data(stringValue)  // or appropriate constructor
}
```

**Pattern by value kind:**

| Value Kind        | Raw Type      | Constructor Pattern                                                               |
|-------------------|---------------|-----------------------------------------------------------------------------------|
| String-based      | `String`      | `FieldValue{Name}Data(value?.toString() ?: return null)`                          |
| Long-based        | `Long`        | `FieldValue{Name}Data(value?.toString()?.toLongOrNull() ?: return null)`          |
| Double-based      | `Double`      | `FieldValue{Name}Data(value?.toString()?.toDoubleOrNull() ?: return null)`        |
| Boolean-based     | `Boolean`     | `FieldValue{Name}Data(value?.toString()?.toBooleanStrictOrNull() ?: return null)` |
| Complex/Composite | `JsonElement` | Return `null` (handled via direct JSON serialization)                             |

#### 1b. `fnFieldValueToRawValue` - Typed FieldValue to raw value

Find the `when (compType)` block and add a branch:

```kotlin
// In fnFieldValueToRawValue():
EnumDefnCompType.{fieldType} -> {
    when (value) {
        is FieldValue{Name}Data -> value.value  // extract raw value
        is JsonElement -> {
            val typed = fnRawValueToFieldValue(compType, fnFieldValueToRawValue(compType, value))
            (typed as? FieldValue{Name}Data)?.value
        }
        else -> null
    }
}
```

> **Note:** For complex types where `fnRawValueToFieldValue` returns `null`, you may only need to handle JsonElement round-tripping via `fnFieldValueToJsonElement`.

---

### Step 2: Add Default Value Resolver (IF HAS DEFAULTS)

> **File:** `domain/util/FieldVal/DefaultValue.kt`

Only needed if the `DefnField{Name}` interface has `defaultValue`, `defaultVar`, or `defaultFieldId` properties.

#### 2a. Add dispatch branch in `resolveCompDefaultValue`

Find the `when (defnComp.type)` block and add:

```kotlin
EnumDefnCompType.{fieldType} -> resolver{Name}(defnForm, defnComp, mutableFormValue, formValue, resolvedSet)
```

#### 2b. Create resolver function

Follow the existing pattern (e.g., `resolverEditableText`):

```kotlin
private fun resolver{Name}(
    defnForm: DefnFormUi,
    defnComp: DefnCompSeal,
    mutableFormValue: MutableFormValue,
    formValue: FormValueData?,
    resolvedSet: MutableSet<Types.MetaIdComp>
): Any? {
    val field = defnComp as? DefnField{Name} ?: return null

    // Priority 1: Direct default value
    field.defaultValue?.let { return it }

    // Priority 2: Default from another field (recursive)
    field.defaultFieldId?.let { defaultFieldId ->
        return resolveDefaultFieldIdVal(defnForm, defaultFieldId, defnComp.type, mutableFormValue, formValue, resolvedSet)
    }

    // Priority 3: Variable (TODO - when ArgValueResolver is implemented)
    // field.defaultVar?.let { ... }

    return null
}
```

---

### Step 3: Add Property Resolution (IF NEEDED)

> **File:** `domain/util/FieldPropertyResolver.kt`

Two sub-tasks: (a) dependency extraction for `*FieldId` refs, (b) property resolver functions.

#### 3a. Add to `extractFieldIdReferences` (if field has `*FieldId` properties)

Find the end of the `if (defnComp is DefnField...)` chain and add:

```kotlin
if (defnComp is DefnField{Name}) {
    defnComp.{prop1}FieldId?.let { refs.add(it) }
    defnComp.{prop2}FieldId?.let { refs.add(it) }
}
```

#### 3b. Add resolver calls in `resolveFieldProperties` (if field has unique properties)

Find the `return FieldProperties(...)` constructor call and add your new property:

```kotlin
return FieldProperties(
    // ... existing properties ...
    myNewProp = resolveMyNewProp(defnComp, defnForm, getFieldValue),
)
```

#### 3c. Create resolver function (if new property)

Follow the 3-level priority pattern:

```kotlin
private fun resolveMyNewProp(
    defnComp: DefnCompSeal,
    defnForm: DefnFormUi,
    getFieldValue: ((Types.MetaIdComp) -> JsonElement?)?
): SomeType? {
    if (defnComp !is DefnField{Name}) return null

    // Priority 1: Direct value
    defnComp.myNewProp?.let { return it }

    // Priority 2: Variable
    defnComp.myNewPropVar?.let { return it }

    // Priority 3: Field reference
    defnComp.myNewPropFieldId?.let { fieldId ->
        // Resolve from referenced field's value
        val fieldValue = getFieldValue?.invoke(fieldId)
        // Convert and return
    }

    return null
}
```

---

### Step 4: Add FieldProperties Fields (IF NEEDED)

> **File:** `presentation/state/FieldState.kt`

Only if Step 3b introduced new properties. Add nullable fields with `null` defaults:

```kotlin
@Immutable
@Serializable
data class FieldProperties(
    // ... existing properties ...
    val myNewProp: SomeType? = null,  // {Name}: description
)
```

> **Rules:**
> - Always nullable with `null` default (most fields won't use this property)
> - Add a comment indicating which field type uses it
> - Keep alphabetical ordering within the property group

---

### Step 5: Create Validation Schema (ALWAYS)

> **File:** `domain/ctx/helper/schema/Field{Name}Schema.kt` (NEW FILE)

```kotlin
package com.neome.feature.form.domain.ctx.helper.schema

import com.neome.api.meta.base.dto.DefnField{Name}
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.model.DefnFormUi
import com.neome.core.common.serializer.api.meta.base.dto.FieldValue{Name}Data
import com.neome.feature.form.domain.util.FieldVal.FieldValueResolver
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import io.konform.validation.Invalid
import io.konform.validation.Validation
import kotlinx.serialization.json.JsonElement


/**
 * CompSchema implementation for Field{Name}.
 *
 * Uses Konform library for type-safe, declarative validation.
 * Validations are applied dynamically based on FieldProperties:
 * - required: value must not be null/empty
 * - (add other validations here)
 */
class Field{Name}Schema(
    override val defnForm: DefnFormUi,
    override val defnComp: DefnCompSeal
) : CompSchema(defnForm, defnComp) {

    private val defnField = defnComp as DefnField{Name}

    /**
     * Pure validation that returns an error message without side effects.
     */
    override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
        val typedValue =
            FieldValueResolver.fnJsonElementFieldValue(defnField.type, fieldValue) as FieldValue{Name}Data?
        val properties = fieldState?.fieldProperties ?: FieldProperties()

        // Extract the raw value from the typed wrapper
        val rawValue = typedValue?.value  // adjust based on FieldValue{Name}Data structure

        // Build and execute Konform validation
        val validation = buildValidation(properties)
        val result = validation(rawValue)

        // Return first error message or null if valid
        return if (result is Invalid) {
            result.errors.firstOrNull()?.message
        } else {
            null
        }
    }

    /**
     * Build Konform validation dynamically based on FieldProperties.
     * Only applies validations for non-null constraint values.
     */
    private fun buildValidation(properties: FieldProperties): Validation<{RawType}?> {
        return Validation {
            // Required check
            if (properties.required) {
                constrain("Required") { it != null }
            }

            // Add field-specific validations here
            // Example: min/max for numbers, regex for strings, etc.
        }
    }
}
```

**Schema patterns by value type** -- see [Validation Schema Patterns](#validation-schema-patterns) section.

---

### Step 6: Register Schema in Factory (ALWAYS)

> **File:** `domain/ctx/helper/schema/CompSchemaFactory.kt`

Find the appropriate category section in the `when (defnComp.type)` block and add:

```kotlin
// In create():
EnumDefnCompType.{fieldType} -> Field{Name}Schema(defnForm, defnComp)
```

If the field is display-only and needs no validation:

```kotlin
EnumDefnCompType.{fieldType} -> null
```

> **Placement:** Add the branch under the correct category comment (`// TEXT-BASED FIELDS`, `// NUMBER FIELDS`, etc.) to maintain organization.

---

### Step 7: Create Field UI Component (ALWAYS)

> **File:** `presentation/components/field/Field{Name}.kt` (NEW FILE)

```kotlin
package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValue{Name}Data
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent


/**
 * {Name} field component for form.
 *
 * Stateful wrapper that uses rememberFieldController for state management.
 * Delegates rendering to stateless Field{Name}Content for optimal recomposition.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController,
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun Field{Name}(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Stable field controller remembered across recompositions
    val fieldController = rememberFieldController<FieldValue{Name}Data>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    // Early return if field setup is invalid
    if (fieldController.fieldId == null) return

    // Read reactive field value (derivedStateOf provides fine-grained recomposition)
    val fieldValue = fieldController.value.value

    // Read reactive field properties and error
    val (properties, error) = fieldController.field.value

    // Early return if field is hidden
    if (properties.hidden) return

    // Extract current value from FieldValue{Name}Data
    val currentValue = fieldValue?.value ?: ""  // adjust default based on value type

    // Delegate to stateless content for optimal recomposition
    FieldBase(modifier = modifier) {
        Field{Name}Content(
            value = currentValue,
            label = properties.label,
            placeholder = properties.placeholder,
            helperText = properties.helperText,
            error = error,
            enabled = !properties.disabled,
            readOnly = properties.readOnly,
            onValueChange = { newValue ->
                // Convert UI value to FieldValue wrapper
                val fv = if (newValue.isEmpty()) null else FieldValue{Name}Data(newValue)
                fieldController.onChange(fv)
            }
        )
    }
}


/**
 * Stateless {name} field content for optimal recomposition control.
 *
 * Only recomposes when its parameters change. Uses fixed placeholder space
 * for supporting text to prevent layout jumps when error/helper text changes.
 */
@Composable
private fun Field{Name}Content(
    value: String,
    label: String?,
    placeholder: String?,
    helperText: String?,
    error: FieldError?,
    enabled: Boolean,
    readOnly: Boolean,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        label = label?.let { { Text(it) } },
        placeholder = placeholder?.let { { Text(it) } },
        isError = error != null,
        supportingText = {
            // Always render with placeholder space to prevent layout jumps
            Text(text = error?.message ?: helperText ?: " ")
        },
        enabled = enabled,
        readOnly = readOnly,
        maxLines = 1,
        modifier = modifier.fillMaxWidth(),
        onValueChange = onValueChange
    )
}
```

#### Variant: Casting to specific DefnData type

If the field needs properties from its specific `DefnField{Name}Data` class (not just `DefnComp`), cast early:

```kotlin
@Composable
fun Field{Name}(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val defn = defnComp as? DefnField{Name}Data ?: return  // Cast FIRST
    // ... rest of component ...
    // Now you can access: defn.someSpecificProperty
}
```

#### Variant: Non-text fields (picker, toggle, date, media)

For fields that don't use `OutlinedTextField`, build a custom content composable:

```kotlin
@Composable
private fun Field{Name}Content(
    value: {ValueType},
    label: String?,
    // ... other params ...
    onValueChange: ({ValueType}) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        // Custom UI (Switch, DatePicker, BottomSheet, etc.)
        // ...

        // Supporting text (error or helper)
        if (error != null || !helperText.isNullOrBlank()) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = error?.message ?: helperText ?: "",
                style = MaterialTheme.typography.bodySmall,
                color = if (error != null) MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}
```

---

### Step 8: Register in FieldFactory (ALWAYS)

> **File:** `presentation/components/base/FieldFactory.kt`

#### 8a. Add import

```kotlin
import com.neome.feature.form.presentation.components.field.Field{Name}
```

#### 8b. Add `when` branch

Find the `when (defnComp.type)` block and add before the `else`:

```kotlin
EnumDefnCompType.{fieldType} -> Field{Name}(
    defnComp = defnComp,
    onFieldEvent = onFieldEvent,
    modifier = modifier
)
```

> **Note:** Leaf fields take `(defnComp, onFieldEvent, modifier)`. Composite fields additionally take `defnForm`.

---

## Code Templates

### Template A: Simple String-Based Field (like FieldText, FieldEmail)

**Value type:** `FieldValue{Name}Data(value: String)`

Use Step 7 template as-is. Key points:

- `currentValue = fieldValue?.value ?: ""`
- `onChange = { if (it.isEmpty()) null else FieldValue{Name}Data(it) }`
- Schema validates `String` with Konform

### Template B: Numeric Field (like FieldNumber)

**Value type:** `FieldValue{Name}Data(value: Long)` or `(value: Double)`

Key differences from Template A:

```kotlin
// In the composable:
val currentValue = fieldValue?.value?.toString() ?: ""

onValueChange = { newValue ->
    if (newValue.isEmpty() || newValue == "-") {
        fieldController.onChange(null)
        return@Field{Name}Content
    }
    val parsed = newValue.toLongOrNull()  // or toDoubleOrNull()
    if (parsed != null) {
        fieldController.onChange(FieldValue{Name}Data(parsed))
    }
}

// In the content composable:
keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
// or KeyboardType.Decimal
```

Schema validates `Long?` or `Double?`.

### Template C: Boolean/Toggle Field (like FieldSwitch)

**Value type:** `FieldValue{Name}Data(value: Boolean)`

Key differences:

```kotlin
// In the composable:
val currentValue = fieldValue?.value ?: false

// In the content composable:
Switch(
    checked = value,
    onCheckedChange = if (enabled) { newChecked ->
        fieldController.onChange(FieldValue{Name}Data(newChecked))
    } else null,
    enabled = enabled
)
```

### Template D: Picker/Selection Field (like FieldPickText)

**Value type:** complex (e.g., `FieldValuePickTextData`)

Key differences:

- Often uses `RawPickerSingleSelect` or `RawPickerMultiSelect` from `raw/picker/`
- Value is set from picker callback, not from text input
- May need `ModalBottomSheet` or `AlertDialog`

### Template E: Date/Time Field (like FieldDate)

**Value type:** `FieldValueDateData(value: String)` (ISO format)

Key differences:

- `OutlinedTextField` is `readOnly = true` with click handler
- Opens `DatePickerDialog` or `TimePickerDialog`
- Formats display value but stores ISO format

### Template F: Media Field (like FieldImage, FieldDocument)

**Value type:** complex (e.g., `FieldValueImageData`)

Key differences:

- Uses `ActivityResultContracts` for file picking
- Validates file size via `properties.maxSize`
- May display preview, file name, size info
- Manages `SendBtnDisableFlag.Uploading` during upload

---

## Validation Schema Patterns

### Pattern 1: Required-Only (simplest)

For fields that only need a required check:

```kotlin
override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
    return isRequired(fieldValue, fieldState)  // Uses base class helper
}
```

### Pattern 2: Required + Konform for String

```kotlin
override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
    val typedValue = FieldValueResolver.fnJsonElementFieldValue(defnField.type, fieldValue) as FieldValue{Name}Data?
    val properties = fieldState?.fieldProperties ?: FieldProperties()
    val textValue = typedValue?.value ?: ""

    val validation = Validation<String> {
        if (properties.required) {
            constrain("Required") { it.isNotBlank() }
        }
        // Skip other checks if empty and not required
        if (textValue.isEmpty() && !properties.required) return@Validation

        // Add constraints:
        properties.minCharCount?.let { min ->
            constrain("Must be at least $min characters") { it.length >= min }
        }
    }

    val result = validation(textValue)
    return if (result is Invalid) result.errors.firstOrNull()?.message else null
}
```

### Pattern 3: Required + Konform for Nullable Numeric

```kotlin
override fun validate(fieldValue: JsonElement?, fieldState: FieldState?): String? {
    val typedValue = FieldValueResolver.fnJsonElementFieldValue(defnField.type, fieldValue) as FieldValue{Name}Data?
    val properties = fieldState?.fieldProperties ?: FieldProperties()
    val numberValue = typedValue?.value  // Long? or Double?

    val validation = Validation<Long?> {
        if (properties.required) {
            constrain("Required") { it != null }
        }
        properties.minNumber?.let { min ->
            constrain("Must be at least ${min.toLong()}") { value -> value == null || value >= min }
        }
        properties.maxNumber?.let { max ->
            constrain("Must be at most ${max.toLong()}") { value -> value == null || value <= max }
        }
    }

    val result = validation(numberValue)
    return if (result is Invalid) result.errors.firstOrNull()?.message else null
}
```

### Pattern 4: Required + Regex Format

```kotlin
// In validate():
if (textValue.isNotEmpty()) {
    if (!FORMAT_REGEX.matches(textValue)) {
        return "Invalid format"
    }
}

companion object {
    private val FORMAT_REGEX = Regex("^[a-zA-Z0-9]+$")
}
```

### Pattern 5: Required + Domain-Specific (from DefnField, not FieldProperties)

Some validations come from the Defn interface directly, not from resolved `FieldProperties`:

```kotlin
// Access definition-level config (not from FieldProperties):
defnField.validationPattern?.let { pattern ->
    // Validate against pattern
}

defnField.allowedDomains?.let { domains ->
    // Validate domain whitelist
}
```

### Pattern 6: Required + Capture Validations (for fields with captureTime/Location/User)

```kotlin
// Check capture requirements
if (typedValue?.value == true) {  // Only validate captures when toggle is ON
    if (defnField.captureTime == true && typedValue.captureTime == null) {
        return "Capture time is required"
    }
    if (defnField.captureLocation == true && typedValue.captureLocation == null) {
        return "Capture location is required"
    }
}
```

### Pattern 7: Required + Size Validation (for media fields)

```kotlin
properties.maxSize?.let { maxSizeBytes ->
    typedValue?.size?.let { fileSize ->
        if (fileSize > maxSizeBytes) {
            val maxMB = maxSizeBytes / (1024 * 1024)
            return "File size exceeds ${maxMB}MB limit"
        }
    }
}
```

---

## Property Resolution Patterns

### When to Add New FieldProperties

Add a new `FieldProperties` field when:

- The field type has a unique configuration property that affects UI rendering
- The property can change dynamically (via `*Var` or `*FieldId`)
- Multiple composables need to read this property

Do NOT add when:

- The property is static and can be read directly from `DefnField{Name}Data` in the composable
- The property is only used in validation (read from `defnField` in the Schema instead)

### 3-Level Resolution Pattern

Every dynamic property follows:

```
Priority 1: defnComp.{property}           -- Direct value from JSON
Priority 2: defnComp.{property}Var        -- Variable (ArgValueResolver, currently partial)
Priority 3: defnComp.{property}FieldId    -- Value from another field (via getFieldValue)
```

### Example: Adding a `rating` property

```kotlin
// 1. FieldState.kt - Add property
data class FieldProperties(
    // ... existing ...
    val maxStars: Long? = null,  // Rating: max star count
)

// 2. FieldPropertyResolver.kt - Add resolver
private fun resolveMaxStars(
    defnComp: DefnCompSeal,
    defnForm: DefnFormUi,
    getFieldValue: ((Types.MetaIdComp) -> JsonElement?)?
): Long? {
    if (defnComp !is DefnFieldRating) return null

    // Priority 1: Direct
    defnComp.maxStars?.let { return it }

    // Priority 2: Variable
    defnComp.maxStarsVar?.let { return it }

    // Priority 3: FieldId reference
    defnComp.maxStarsFieldId?.let { fieldId ->
        return FieldValueResolver.fnResolveNumericValue(
            EnumDefnCompType.number,
            getFieldValue?.invoke(fieldId)
        )
    }

    return null
}

// 3. FieldPropertyResolver.kt - Wire into resolveFieldProperties
return FieldProperties(
    // ... existing ...
    maxStars = resolveMaxStars(defnComp, defnForm, getFieldValue),
)

// 4. FieldPropertyResolver.kt - Add to extractFieldIdReferences
if (defnComp is DefnFieldRating) {
    defnComp.maxStarsFieldId?.let { refs.add(it) }
}
```

---

## Reference Examples

### Example 1: FieldText (Simple String Field)

The simplest complete field. Study this first.

| Layer            | File                       | Key Points                                                         |
|------------------|----------------------------|--------------------------------------------------------------------|
| Converter        | `Converter.kt`             | `text -> FieldValueTextData(string)`                               |
| DefaultValue     | `DefaultValue.kt`          | `resolverEditableText` handles `defaultValue`, `defaultFieldId`    |
| PropertyResolver | `FieldPropertyResolver.kt` | Resolves `minCharCount`, `maxCharCount` via 3-level cascade        |
| FieldProperties  | `FieldState.kt`            | `minCharCount: Long?`, `maxCharCount: Long?`                       |
| Schema           | `FieldTextSchema.kt`       | Required + min/max char + regex validation patterns                |
| SchemaFactory    | `CompSchemaFactory.kt`     | `text -> FieldTextSchema(defnForm, defnComp)`                      |
| UI Component     | `FieldText.kt`             | `rememberFieldController<FieldValueTextData>`, `OutlinedTextField` |
| FieldFactory     | `FieldFactory.kt`          | `text -> FieldText(defnComp, onFieldEvent, modifier)`              |

### Example 2: FieldNumber (Numeric Field with Min/Max)

Shows numeric value handling and range validation.

| Layer            | File                       | Key Points                                       |
|------------------|----------------------------|--------------------------------------------------|
| Converter        | `Converter.kt`             | `number -> FieldValueNumberData(toLongOrNull())` |
| PropertyResolver | `FieldPropertyResolver.kt` | Resolves `minNumber`, `maxNumber`                |
| Schema           | `FieldNumberSchema.kt`     | Validates `Long?` with required + min/max        |
| UI Component     | `FieldNumber.kt`           | `KeyboardType.Number`, `toLongOrNull()` parsing  |

### Example 3: FieldSwitch (Complex Field with Casting)

Shows DefnData casting, capture metadata, and render mode switching.

| Layer            | File                       | Key Points                                                                           |
|------------------|----------------------------|--------------------------------------------------------------------------------------|
| UI Component     | `FieldSwitch.kt`           | Casts `defnComp as? DefnFieldSwitchData`, reads `showAsCheckbox`, `captureTime` etc. |
| Schema           | `FieldBoolSchema.kt`       | Required + capture validations                                                       |
| PropertyResolver | `FieldPropertyResolver.kt` | `resolveShowAsCheckbox` with `showAsCheckboxFieldId`                                 |

---

## Anti-Patterns & Common Mistakes

### DO NOT

| Anti-Pattern                                                  | Why                                         | Correct Approach                                                      |
|---------------------------------------------------------------|---------------------------------------------|-----------------------------------------------------------------------|
| Create `DefnField*` or `DefnField*Data` classes               | They are auto-generated                     | Verify they exist before starting                                     |
| Create `FieldValue*Data` classes                              | They are auto-generated                     | Use the existing one from serializer package                          |
| Add mutable state in field composables                        | Violates MVI/UDF                            | Use `rememberFieldController` for all state                           |
| Read `FormState` directly in field composables                | Breaks fine-grained recomposition           | Use `fieldController.value` and `fieldController.field`               |
| Skip the `if (fieldController.fieldId == null) return` check  | Crashes on non-field DefnComp               | Always add this guard                                                 |
| Skip the `if (properties.hidden) return` check                | Shows fields that should be hidden          | Always add this guard                                                 |
| Put business logic in the composable                          | Violates Clean Architecture                 | Put it in Schema or PropertyResolver                                  |
| Use `collectAsStateWithLifecycle`                             | Old pattern, FormState uses Compose `State` | Use `fieldController.value.value` (direct read)                       |
| Forget to register in CompSchemaFactory                       | Validation silently skipped                 | Always add entry (even `null` for no validation)                      |
| Forget to add Converter branches                              | Value serialization fails                   | Always add both `fnRawValueToFieldValue` and `fnFieldValueToRawValue` |
| Use `mutableStateOf` inside field composables for value state | Creates second source of truth              | The only source of truth is FormState via FieldController             |
| Skip error/helperText in supporting text                      | Inconsistent UI                             | Always show `error?.message ?: helperText ?: " "`                     |

### MUST DO

| Rule                                                            | Why                                                 |
|-----------------------------------------------------------------|-----------------------------------------------------|
| Wrap content in `FieldBase { ... }`                             | Consistent 16dp horizontal, 8dp vertical padding    |
| Create a stateless `Field{Name}Content` composable              | Enables previews, testing, optimal recomposition    |
| Use `" "` (space) as fallback for supporting text               | Prevents layout jumps when error appears/disappears |
| Pass `Modifier = Modifier` as default parameter                 | Follows Compose conventions                         |
| Accept `modifier: Modifier = Modifier` as last param in content | Compose convention for composables                  |

---

## Post-Creation Verification

After creating a new field, verify:

1. **Compile check:** Build the project -- no unresolved references
2. **Converter round-trip:** `fnRawValueToFieldValue` -> `fnFieldValueToRawValue` produces the same value
3. **Schema registration:** The field type appears in `CompSchemaFactory.create()` (not falling to `else`)
4. **FieldFactory routing:** The field type appears in `FieldFactory` `when` block (not falling to `else`)
5. **Hidden field:** Setting `hidden = true` in DefnComp causes the field to not render
6. **Required validation:** Setting `required = true` and submitting empty shows "Required" error
7. **Value change flow:** Typing a value fires `FieldEvent.ValueChanged` -> value appears in `FormState.valueMap`
8. **Error display:** Validation errors appear in the supporting text area below the field

### Quick Smoke Test (using FormSampleDataFactory)

Add your new field to the sample form in `presentation/sample/FormSampleDataFactory.kt` to verify it renders correctly in the demo screen.

---

## Changelog

### v1.0.0 (2026-02-17)

- Initial skill creation
- Complete step-by-step guide for adding new field types to FieldFactory
- 8-step checklist covering domain + presentation layers
- 6 code templates (A-F) for different field categories
- 7 validation schema patterns
- Property resolution patterns with 3-level cascade
- 3 reference examples (FieldText, FieldNumber, FieldSwitch)
- Decision tree for determining which optional steps apply
- Anti-patterns and post-creation verification checklist
