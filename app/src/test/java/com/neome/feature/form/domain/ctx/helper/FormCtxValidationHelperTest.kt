package com.neome.feature.form.domain.ctx.helper

import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldTextData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueTextData
import com.neome.feature.form.domain.ctx.helper.schema.CompSchema
import com.neome.feature.form.domain.ctx.helper.schema.FieldTextSchema
import com.neome.feature.form.presentation.state.FieldDependencyMap
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.form.presentation.state.SendBtnDisableFlag
import com.neome.feature.utils.JsonParser
import kotlinx.serialization.json.JsonElement
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class FormCtxValidationHelperTest {

    private lateinit var fieldId1: Types.MetaIdComp
    private lateinit var fieldId2: Types.MetaIdComp
    private lateinit var defnForm: DefnFormData
    private lateinit var baseState: FormState

    @Before
    fun setup() {
        fieldId1 = SysId.create("mfd-field1")!!
        fieldId2 = SysId.create("mfd-field2")!!

        val textComp1 = DefnFieldTextData(
            name = createSymbol("field1"),
            type = EnumDefnCompType.text,
            metaId = SysId.create("mfd-field1")!!,
            required = true
        )
        val textComp2 = DefnFieldTextData(
            name = createSymbol("field2"),
            type = EnumDefnCompType.text,
            metaId = SysId.create("mfd-field2")!!
        )

        defnForm = DefnFormData(
            compMap = mapOf(fieldId1 to textComp1, fieldId2 to textComp2),
            displayCompositeId = SysId.create("mtb-tab1")!!,
            name = createSymbol("testForm"),
            metaId = SysId.create("mf-test")!!,
        )

        val compSchemaMap: Map<Types.MetaIdComp, CompSchema> = mapOf(
            fieldId1 to FieldTextSchema(defnForm, textComp1),
            fieldId2 to FieldTextSchema(defnForm, textComp2)
        )

        baseState = FormState(
            defnForm = defnForm,
            fieldStates = mapOf(
                fieldId1 to FieldState(
                    fieldProperties = FieldProperties(required = true)
                ),
                fieldId2 to FieldState(fieldProperties = FieldProperties())
            ),
            valueMap = emptyMap(),
            errors = emptyMap(),
            fieldDependencies = FieldDependencyMap(),
            compSchemaMap = compSchemaMap,
            isInitialized = true
        )
    }

    // ==================== handleValidateField ====================

    @Test
    fun `handleValidateField sets error for required field with no value`() {
        val event = FormEvent.ValidateField(fieldId1)

        val result = FormCtxValidationHelper.handleValidateField(baseState, event)

        assertTrue(result.state.errors.containsKey(fieldId1))
        assertEquals(FieldError.ErrorType.Validation, result.state.errors[fieldId1]!!.type)
    }

    @Test
    fun `handleValidateField clears error for required field with value`() {
        val stateWithValue = baseState.copy(
            valueMap = mapOf(fieldId1 to encodeTextValue("hello")),
            errors = mapOf(
                fieldId1 to FieldError("Required", FieldError.ErrorType.Validation)
            )
        )
        val event = FormEvent.ValidateField(fieldId1)

        val result = FormCtxValidationHelper.handleValidateField(stateWithValue, event)

        assertFalse(result.state.errors.containsKey(fieldId1))
    }

    @Test
    fun `handleValidateField preserves custom errors when clearing validation errors`() {
        val stateWithCustomError = baseState.copy(
            valueMap = mapOf(fieldId1 to encodeTextValue("hello")),
            errors = mapOf(
                fieldId1 to FieldError("Custom error", FieldError.ErrorType.Custom)
            )
        )
        val event = FormEvent.ValidateField(fieldId1)

        val result = FormCtxValidationHelper.handleValidateField(stateWithCustomError, event)

        // Custom error should be preserved (validation passed, but custom error remains)
        assertTrue(result.state.errors.containsKey(fieldId1))
        assertEquals(FieldError.ErrorType.Custom, result.state.errors[fieldId1]!!.type)
    }

    @Test
    fun `handleValidateField preserves server errors when clearing validation errors`() {
        val stateWithServerError = baseState.copy(
            valueMap = mapOf(fieldId1 to encodeTextValue("hello")),
            errors = mapOf(
                fieldId1 to FieldError("Server error", FieldError.ErrorType.Server)
            )
        )
        val event = FormEvent.ValidateField(fieldId1)

        val result = FormCtxValidationHelper.handleValidateField(stateWithServerError, event)

        assertTrue(result.state.errors.containsKey(fieldId1))
        assertEquals(FieldError.ErrorType.Server, result.state.errors[fieldId1]!!.type)
    }

    @Test
    fun `handleValidateField returns unchanged state for unknown field`() {
        val unknownFieldId: Types.MetaIdComp = SysId.create("mfd-unknown")!!
        val event = FormEvent.ValidateField(unknownFieldId)

        val result = FormCtxValidationHelper.handleValidateField(baseState, event)

        assertEquals(baseState.errors, result.state.errors)
    }

    // ==================== handleValidateAll ====================

    @Test
    fun `handleValidateAll validates all fields with schemas`() {
        // fieldId1 is required with no value -> should have error
        // fieldId2 is not required with no value -> should have no error

        val result = FormCtxValidationHelper.handleValidateAll(baseState)

        assertTrue(result.state.errors.containsKey(fieldId1))
        assertFalse(result.state.errors.containsKey(fieldId2))
    }

    @Test
    fun `handleValidateAll clears existing validation errors for valid fields`() {
        val stateWithErrors = baseState.copy(
            valueMap = mapOf(fieldId1 to encodeTextValue("hello")),
            errors = mapOf(
                fieldId1 to FieldError("Required", FieldError.ErrorType.Validation)
            )
        )

        val result = FormCtxValidationHelper.handleValidateAll(stateWithErrors)

        assertFalse(result.state.errors.containsKey(fieldId1))
    }

    // ==================== handleSetFieldError ====================

    @Test
    fun `handleSetFieldError adds custom error`() {
        val event = FormEvent.SetFieldError(fieldId1, "Custom error message")

        val result = FormCtxValidationHelper.handleSetFieldError(baseState, event)

        assertTrue(result.state.errors.containsKey(fieldId1))
        assertEquals("Custom error message", result.state.errors[fieldId1]!!.message)
        assertEquals(FieldError.ErrorType.Custom, result.state.errors[fieldId1]!!.type)
    }

    // ==================== handleClearFieldError ====================

    @Test
    fun `handleClearFieldError removes error for field`() {
        val stateWithError = baseState.copy(
            errors = mapOf(
                fieldId1 to FieldError("some error"),
                fieldId2 to FieldError("another error")
            )
        )
        val event = FormEvent.ClearFieldError(fieldId1)

        val result = FormCtxValidationHelper.handleClearFieldError(stateWithError, event)

        assertFalse(result.state.errors.containsKey(fieldId1))
        assertTrue(result.state.errors.containsKey(fieldId2))
    }

    // ==================== handleClearAllErrors ====================

    @Test
    fun `handleClearAllErrors removes all errors`() {
        val stateWithErrors = baseState.copy(
            errors = mapOf(
                fieldId1 to FieldError("error1"),
                fieldId2 to FieldError("error2")
            )
        )

        val result = FormCtxValidationHelper.handleClearAllErrors(stateWithErrors)

        assertTrue(result.state.errors.isEmpty())
    }

    // ==================== updateFieldError (shared utility) ====================

    @Test
    fun `updateFieldError sets validation error when error message is not null`() {
        val errors = emptyMap<Types.MetaIdComp, FieldError>()

        val result = FormCtxValidationHelper.updateFieldError(fieldId1, "Required", errors)

        assertTrue(result.containsKey(fieldId1))
        assertEquals("Required", result[fieldId1]!!.message)
        assertEquals(FieldError.ErrorType.Validation, result[fieldId1]!!.type)
    }

    @Test
    fun `updateFieldError clears validation error when error is null`() {
        val errors = mapOf(
            fieldId1 to FieldError("Required", FieldError.ErrorType.Validation)
        )

        val result = FormCtxValidationHelper.updateFieldError(fieldId1, null, errors)

        assertFalse(result.containsKey(fieldId1))
    }

    @Test
    fun `updateFieldError preserves custom error when error is null`() {
        val errors = mapOf(
            fieldId1 to FieldError("Custom", FieldError.ErrorType.Custom)
        )

        val result = FormCtxValidationHelper.updateFieldError(fieldId1, null, errors)

        assertTrue(result.containsKey(fieldId1))
        assertEquals(FieldError.ErrorType.Custom, result[fieldId1]!!.type)
    }

    // ==================== Send button flag integration ====================

    @Test
    fun `validation errors add Invalid flag to disableSendBtnSet`() {
        val event = FormEvent.ValidateField(fieldId1) // required, no value

        val result = FormCtxValidationHelper.handleValidateField(baseState, event)

        assertTrue(SendBtnDisableFlag.Invalid in result.state.disableSendBtnSet)
    }

    @Test
    fun `clearing all errors removes Invalid flag from disableSendBtnSet`() {
        val stateWithInvalidFlag = baseState.copy(
            errors = mapOf(fieldId1 to FieldError("error")),
            disableSendBtnSet = setOf(SendBtnDisableFlag.Invalid)
        )

        val result = FormCtxValidationHelper.handleClearAllErrors(stateWithInvalidFlag)

        assertFalse(SendBtnDisableFlag.Invalid in result.state.disableSendBtnSet)
    }

    @Test
    fun `validation emits SendBtnStateChanged intent on transition`() {
        // Start with enabled send button (no flags)
        val event = FormEvent.ValidateField(fieldId1) // required, no value -> will fail

        val result = FormCtxValidationHelper.handleValidateField(baseState, event)

        // Should emit disabled intent since button was enabled and now has errors
        assertNotNull(result.intent)
        assertTrue(result.intent is FormIntent.SendBtnStateChanged)
        assertFalse((result.intent as FormIntent.SendBtnStateChanged).enabled)
    }

    // ==================== Helpers ====================

    private fun createSymbol(name: String): Symbol {
        val sym = Symbol()
        sym.value = name
        return sym
    }

    private fun encodeTextValue(text: String): JsonElement {
        return JsonParser.json.encodeToJsonElement(
            FieldValueTextData.serializer(),
            FieldValueTextData(text)
        )
    }
}
