# Form feature — Modules and classes list

All modules and classes under `com.neome.feature.form`, with package path and file. Submodules that work together are grouped. See [form.md](form.md) for full architecture and how-to guides.

---

## Domain — Types & Context

| Package | File | Class / role |
|---------|------|----------------|
| `com.neome.feature.form.domain` | TypesForm.kt | DefnFormUi, TypeUiPermissionRole, TypeUiFormPermission, etc. |

| Package | File | Class / role |
|---------|------|----------------|
| `com.neome.feature.form.domain.ctx` | FormCtx.kt | FormCtx (internal API) |
| `com.neome.feature.form.domain.ctx` | FormCtxImpl.kt | FormCtxImpl (state owner + dispatch) |
| `com.neome.feature.form.domain.ctx` | FormApiContext.kt | Form API context types |

| Package | File | Class / role |
|---------|------|----------------|
| `com.neome.feature.form.domain.ref` | FormRef.kt | FormRef (external API) |
| `com.neome.feature.form.domain.ref` | FormRefImpl.kt | FormRefImpl |

---

## Domain — Helpers (ctx/helper)

| Package | File | Class / role |
|---------|------|----------------|
| `com.neome.feature.form.domain.ctx.helper` | FormReducerResult.kt | FormReducerResult |
| `com.neome.feature.form.domain.ctx.helper` | FormCtxInitHelper.kt | FormCtxInitHelper |
| `com.neome.feature.form.domain.ctx.helper` | FormCtxEventHelper.kt | FormCtxEventHelper |
| `com.neome.feature.form.domain.ctx.helper` | FormCtxValidationHelper.kt | FormCtxValidationHelper |

---

## Domain — Event execution submodule (work together)

| Package | File | Class / role |
|---------|------|----------------|
| `com.neome.feature.form.domain.ctx.helper.events` | FormCtxInitEvents.kt | initEvents, onInitForm execution |
| `com.neome.feature.form.domain.ctx.helper.events` | FormCtxFormEvents.kt | executeEvents, executeEvent, CategorizedEvents, mergeEventPropsIntoFieldStates |
| `com.neome.feature.form.domain.ctx.helper.events` | FormCtxActionExecutor.kt | executeAction, resolveSourceValue, resolveAffectedFieldIds |
| `com.neome.feature.form.domain.ctx.helper.events` | FormCtxEventPropsHelper.kt | updateFormEventProps, mergeEventPropsIntoFieldStates |

---

## Domain — Schema submodule (work together)

| Package | File | Class / role |
|---------|------|----------------|
| `com.neome.feature.form.domain.ctx.helper.schema` | CompSchema.kt | CompSchema (base) |
| `com.neome.feature.form.domain.ctx.helper.schema` | CompSchemaFactory.kt | CompSchemaFactory |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldTextSchema.kt | FieldTextSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldNumberSchema.kt | FieldNumberSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldDecimalSchema.kt | FieldDecimalSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldEmailSchema.kt | FieldEmailSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldParagraphSchema.kt | FieldParagraphSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldHandleSchema.kt | FieldHandleSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldHyperlinkSchema.kt | FieldHyperlinkSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldMobileNumberSchema.kt | FieldMobileNumberSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldOtpSchema.kt | FieldOtpSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldBoolSchema.kt | FieldBoolSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldDateSchema.kt | FieldDateSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldTimeSchema.kt | FieldTimeSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldDateTimeSchema.kt | FieldDateTimeSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldDateRangeSchema.kt | FieldDateRangeSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldDurationSchema.kt | FieldDurationSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldLocationSchema.kt | FieldLocationSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldColorSchema.kt | FieldColorSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldSliderSchema.kt | FieldSliderSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldScanCodeSchema.kt | FieldScanCodeSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldSymbolSchema.kt | FieldSymbolSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldGridSchema.kt | FieldGridSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldChipSetSchema.kt | FieldChipSetSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldPickTextSchema.kt | FieldPickTextSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldPickTreeSchema.kt | FieldPickTreeSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldPickUserSchema.kt | FieldPickUserSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldPickRoleSchema.kt | FieldPickRoleSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldPickGridRowSchema.kt | FieldPickGridRowSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldSetOfTextSchema.kt | FieldSetOfTextSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldSetOfUserSchema.kt | FieldSetOfUserSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldSetOfRoleSchema.kt | FieldSetOfRoleSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldSetOfDocumentSchema.kt | FieldSetOfDocumentSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldImageSchema.kt | FieldImageSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldVideoSchema.kt | FieldVideoSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldAudioSchema.kt | FieldAudioSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldDocumentSchema.kt | FieldDocumentSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldCameraSchema.kt | FieldCameraSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldVoiceSchema.kt | FieldVoiceSchema |
| `com.neome.feature.form.domain.ctx.helper.schema` | FieldSignatureSchema.kt | FieldSignatureSchema |

---

## Domain — Utils

| Package | File | Class / role |
|---------|------|----------------|
| `com.neome.feature.form.domain.util` | FieldPropertyResolver.kt | FieldPropertyResolver |
| `com.neome.feature.form.domain.util` | FilterForm.kt | prepareUiForm (permissions) |
| `com.neome.feature.form.domain.util` | FormPlus.kt | FormPlus (tree traversal) |
| `com.neome.feature.form.domain.util` | ConditionResolver.kt | ConditionResolver (event conditions) |
| `com.neome.feature.form.domain.util` | CalcFormula.kt | Formula calculation (TODO) |
| `com.neome.feature.form.domain.util` | ArgValueResolver.kt | Variable resolution (TODO) |
| `com.neome.feature.form.domain.util` | TypeArgValueResolver.kt | Typed arg resolution |
| `com.neome.feature.form.domain.util` | DatePlus.kt | Date utilities (TODO) |

---

## Domain — FieldVal submodule (work together)

| Package | File | Class / role |
|---------|------|----------------|
| `com.neome.feature.form.domain.util.FieldVal` | FieldValueResolver.kt | FieldValueResolver (combines Converter + DefaultValue) |
| `com.neome.feature.form.domain.util.FieldVal` | Converter.kt | Raw ↔ Typed ↔ JsonElement conversions |
| `com.neome.feature.form.domain.util.FieldVal` | DefaultValue.kt | Default value init, MutableFormValue |

---

## Presentation — State

| Package | File | Class / role |
|---------|------|----------------|
| `com.neome.feature.form.presentation.state` | FormState.kt | FormState, FieldDependencyMap, SendBtnDisableFlag |
| `com.neome.feature.form.presentation.state` | FieldState.kt | FieldState, FieldProperties |
| `com.neome.feature.form.presentation.state` | FormEvent.kt | FormEvent (16 events) |
| `com.neome.feature.form.presentation.state` | FormIntent.kt | FormIntent (4 intents) |
| `com.neome.feature.form.presentation.state` | FieldEvent.kt | FieldEvent (3 events) |
| `com.neome.feature.form.presentation.state` | FieldError.kt | FieldError, ErrorType |

---

## Presentation — Components (root & base)

| Package | File | Class / role |
|---------|------|----------------|
| `com.neome.feature.form.presentation.components` | Form.kt | Form (root composable) |
| `com.neome.feature.form.presentation.components` | Utils.kt | Theme color resolver |
| `com.neome.feature.form.presentation.components.base` | FieldFactory.kt | FieldFactory (type router) |
| `com.neome.feature.form.presentation.components.base` | FieldController.kt | rememberFieldController, FieldController, FieldUiState |
| `com.neome.feature.form.presentation.components.base` | FieldBase.kt | FieldBase (layout wrapper) |

---

## Presentation — Composite components

| Package | File | Class / role |
|---------|------|----------------|
| `com.neome.feature.form.presentation.components.composite` | FieldSection.kt | FieldSection |
| `com.neome.feature.form.presentation.components.composite` | FieldTab.kt | FieldTab |

---

## Presentation — Field components (leaf fields)

| Package | File | Class / role |
|---------|------|----------------|
| `com.neome.feature.form.presentation.components.field` | FieldText.kt | FieldText |
| `com.neome.feature.form.presentation.components.field` | FIeldParagraph.kt | FieldParagraph |
| `com.neome.feature.form.presentation.components.field` | FieldEmail.kt | FieldEmail |
| `com.neome.feature.form.presentation.components.field` | FieldHandle.kt | FieldHandle |
| `com.neome.feature.form.presentation.components.field` | FieldHyperlink.kt | FieldHyperlink |
| `com.neome.feature.form.presentation.components.field` | FieldMobileNumber.kt | FieldMobileNumber |
| `com.neome.feature.form.presentation.components.field` | FieldNumber.kt | FieldNumber |
| `com.neome.feature.form.presentation.components.field` | FieldDecimal.kt | FieldDecimal |
| `com.neome.feature.form.presentation.components.field` | FieldCounter.kt | FieldCounter |
| `com.neome.feature.form.presentation.components.field` | FieldLogCounter.kt | FieldLogCounter |
| `com.neome.feature.form.presentation.components.field` | FieldDate.kt | FieldDate |
| `com.neome.feature.form.presentation.components.field` | FieldDateTime.kt | FieldDateTime |
| `com.neome.feature.form.presentation.components.field` | FieldTime.kt | FieldTime |
| `com.neome.feature.form.presentation.components.field` | FieldDateRange.kt | FieldDateRange |
| `com.neome.feature.form.presentation.components.field` | FieldDateTimeRange.kt | FieldDateTimeRange |
| `com.neome.feature.form.presentation.components.field` | FieldSwitch.kt | FieldSwitch |
| `com.neome.feature.form.presentation.components.field` | FieldPickText.kt | FieldPickText |
| `com.neome.feature.form.presentation.components.field` | FieldSetOfText.kt | FieldSetOfText |
| `com.neome.feature.form.presentation.components.field` | FieldButton.kt | FieldButton |
| `com.neome.feature.form.presentation.components.field` | FieldImage.kt | FieldImage |
| `com.neome.feature.form.presentation.components.field` | FieldDocument.kt | FieldDocument |
| `com.neome.feature.form.presentation.components.field` | FieldSignature.kt | FieldSignature |
| `com.neome.feature.form.presentation.components.field` | FieldCamera.kt | FieldCamera |
| `com.neome.feature.form.presentation.components.field` | FieldIdentifier.kt | FieldIdentifier |
| `com.neome.feature.form.presentation.components.field` | MuiIconMapper.kt | MuiIconMapper |
| `com.neome.feature.form.presentation.components.field` | RawCounter.kt | RawCounter |
| `com.neome.feature.form.presentation.components.field` | RawCaptureExtraProperties.kt | RawCaptureExtraProperties |
| `com.neome.feature.form.presentation.components.field` | ImagePreviewDialog.kt | ImagePreviewDialog |
| `com.neome.feature.form.presentation.components.field` | SignatureDrawDialog.kt | SignatureDrawDialog |

---

## Presentation — Raw pickers (work together)

| Package | File | Class / role |
|---------|------|----------------|
| `com.neome.feature.form.presentation.components.raw.picker` | RawPickerSingleSelect.kt | RawPickerSingleSelect |
| `com.neome.feature.form.presentation.components.raw.picker` | RawPickerMultiSelect.kt | RawPickerMultiSelect |

---

## Presentation — Screen & sample

| Package | File | Class / role |
|---------|------|----------------|
| `com.neome.feature.form.presentation.screen` | FormScreen.kt | FormScreen |
| `com.neome.feature.form.presentation.screen` | FormScreenViewModel.kt | FormScreenViewModel |
| `com.neome.feature.form.presentation.sample` | FormSampleDataFactory.kt | FormSampleDataFactory |
