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
import com.neome.feature.utils.JsonParser
import kotlinx.serialization.json.JsonElement
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class FormCtxEventHelperTest {

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
            metaId = SysId.create("mfd-field1")!!
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

        baseState = FormState(
            defnForm = defnForm,
            fieldStates = mapOf(
                fieldId1 to FieldState(fieldProperties = FieldProperties()),
                fieldId2 to FieldState(fieldProperties = FieldProperties())
            ),
            valueMap = emptyMap(),
            errors = emptyMap(),
            fieldDependencies = FieldDependencyMap(),
            compSchemaMap = emptyMap(),
            isInitialized = true
        )
    }

    // ==================== handleFieldValueChanged ====================

    @Test
    fun `handleFieldValueChanged updates valueMap with new value`() {
        val value = encodeTextValue("hello")
        val event = FormEvent.FieldValueChanged(fieldId1, value)

        val result = FormCtxEventHelper.handleFieldValueChanged(baseState, event, defnForm)

        assertEquals(value, result.state.valueMap[fieldId1])
    }

    @Test
    fun `handleFieldValueChanged removes null value from valueMap`() {
        val stateWithValue = baseState.copy(
            valueMap = mapOf(fieldId1 to encodeTextValue("hello"))
        )
        val event = FormEvent.FieldValueChanged(fieldId1, null)

        val result = FormCtxEventHelper.handleFieldValueChanged(stateWithValue, event, defnForm)

        assertFalse(result.state.valueMap.containsKey(fieldId1))
    }

    @Test
    fun `handleFieldValueChanged marks field as dirty when value differs from default`() {
        val event = FormEvent.FieldValueChanged(fieldId1, encodeTextValue("changed"))

        val result = FormCtxEventHelper.handleFieldValueChanged(baseState, event, defnForm)

        assertTrue(result.state.fieldStates[fieldId1]!!.isDirty)
    }

    @Test
    fun `handleFieldValueChanged emits Watch intent`() {
        val value = encodeTextValue("hello")
        val event = FormEvent.FieldValueChanged(fieldId1, value)

        val result = FormCtxEventHelper.handleFieldValueChanged(baseState, event, defnForm)

        assertNotNull(result.intent)
        assertTrue(result.intent is FormIntent.Watch)
        val watch = result.intent as FormIntent.Watch
        assertEquals(fieldId1, watch.fieldId)
        assertEquals(value, watch.fieldValue)
    }

    @Test
    fun `handleFieldValueChanged returns unchanged state for unknown field`() {
        val unknownFieldId: Types.MetaIdComp = SysId.create("mfd-unknown")!!
        val event = FormEvent.FieldValueChanged(unknownFieldId, encodeTextValue("test"))

        val result = FormCtxEventHelper.handleFieldValueChanged(baseState, event, defnForm)

        assertEquals(baseState, result.state)
    }

    // ==================== handleFieldFocused / handleFieldBlurred ====================

    @Test
    fun `handleFieldFocused sets isFocused to true`() {
        val event = FormEvent.FieldFocused(fieldId1)

        val result = FormCtxEventHelper.handleFieldFocused(baseState, event)

        assertTrue(result.state.fieldStates[fieldId1]!!.isFocused)
    }

    @Test
    fun `handleFieldBlurred sets isFocused to false and isTouched to true`() {
        val focusedState = baseState.copy(
            fieldStates = baseState.fieldStates + (fieldId1 to FieldState(isFocused = true))
        )
        val event = FormEvent.FieldBlurred(fieldId1)

        val result = FormCtxEventHelper.handleFieldBlurred(focusedState, event)

        assertFalse(result.state.fieldStates[fieldId1]!!.isFocused)
        assertTrue(result.state.fieldStates[fieldId1]!!.isTouched)
    }

    // ==================== handleSubmit ====================

    @Test
    fun `handleSubmit emits Submit intent when form is valid`() {
        val result = FormCtxEventHelper.handleSubmit(baseState)

        assertNotNull(result.intent)
        assertTrue(result.intent is FormIntent.Submit)
        assertTrue(result.state.isSubmitting)
    }

    @Test
    fun `handleSubmit does not emit Submit when form has errors`() {
        val stateWithRequiredSchema = baseState.copy(
            fieldStates = mapOf(
                fieldId1 to FieldState(
                    fieldProperties = FieldProperties(required = true)
                ),
                fieldId2 to FieldState(fieldProperties = FieldProperties())
            ),
            compSchemaMap = mapOf(
                fieldId1 to FieldTextSchema(defnForm, defnForm.compMap[fieldId1]!!)
            )
        )

        val result = FormCtxEventHelper.handleSubmit(stateWithRequiredSchema)

        assertNull(result.intent)
        assertFalse(result.state.isSubmitting)
    }

    // ==================== handleReset ====================

    @Test
    fun `handleReset clears all interaction state and errors`() {
        val dirtyState = baseState.copy(
            fieldStates = mapOf(
                fieldId1 to FieldState(isTouched = true, isDirty = true, isFocused = true),
                fieldId2 to FieldState(isTouched = true, isDirty = true)
            ),
            valueMap = mapOf(fieldId1 to encodeTextValue("changed")),
            errors = mapOf(fieldId1 to FieldError("error")),
            isSubmitting = true
        )
        val event = FormEvent.Reset(null)

        val result = FormCtxEventHelper.handleReset(dirtyState, event)

        result.state.fieldStates.values.forEach { fieldState ->
            assertFalse(fieldState.isTouched)
            assertFalse(fieldState.isDirty)
            assertFalse(fieldState.isFocused)
        }
        assertTrue(result.state.errors.isEmpty())
        assertFalse(result.state.isSubmitting)
    }

    @Test
    fun `handleReset with explicit valueMap uses those values`() {
        val resetValues = mapOf(fieldId1 to encodeTextValue("reset-value"))
        val event = FormEvent.Reset(resetValues)

        val result = FormCtxEventHelper.handleReset(baseState, event)

        assertEquals(encodeTextValue("reset-value"), result.state.valueMap[fieldId1])
    }

    // ==================== handleSetValues with triggers ====================

    @Test
    fun `handleSetValues updates valueMap for known fields`() {
        val newValues = mapOf(
            fieldId1 to encodeTextValue("new1"),
            fieldId2 to encodeTextValue("new2")
        )
        val event = FormEvent.SetValues(newValues)

        val result = FormCtxEventHelper.handleSetValues(baseState, event, defnForm)

        assertEquals(encodeTextValue("new1"), result.state.valueMap[fieldId1])
        assertEquals(encodeTextValue("new2"), result.state.valueMap[fieldId2])
    }

    @Test
    fun `handleSetValues marks changed fields as dirty`() {
        val newValues = mapOf(fieldId1 to encodeTextValue("new1"))
        val event = FormEvent.SetValues(newValues)

        val result = FormCtxEventHelper.handleSetValues(baseState, event, defnForm)

        assertTrue(result.state.fieldStates[fieldId1]!!.isDirty)
        assertFalse(result.state.fieldStates[fieldId2]!!.isDirty)
    }

    @Test
    fun `handleSetValues ignores unknown field IDs`() {
        val unknownFieldId: Types.MetaIdComp = SysId.create("mfd-unknown")!!
        val newValues = mapOf(unknownFieldId to encodeTextValue("ignored"))
        val event = FormEvent.SetValues(newValues)

        val result = FormCtxEventHelper.handleSetValues(baseState, event, defnForm)

        assertFalse(result.state.valueMap.containsKey(unknownFieldId))
    }

    // ==================== triggerDependentFields ====================

    @Test
    fun `triggerDependentFields with empty dependents returns unchanged state`() {
        val result = FormCtxEventHelper.triggerDependentFields(
            fieldStates = baseState.fieldStates,
            valueMap = baseState.valueMap,
            dependentIds = emptySet(),
            defnForm = defnForm,
            errors = baseState.errors,
            compSchemaMap = baseState.compSchemaMap
        )

        assertEquals(baseState.fieldStates, result.fieldStates)
        assertEquals(baseState.errors, result.errors)
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
