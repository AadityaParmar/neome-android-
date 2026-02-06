package com.neome.feature.form.domain.util

import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.domain.FormTestFactory
import kotlinx.serialization.json.JsonPrimitive
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class FieldPropertyResolverTest {

    // ==================== Required ====================

    @Test
    fun `required - returns false when not set`() {
        val field = FormTestFactory.defnText(id = "f1")
        val form = FormTestFactory.defnForm(compMap = mapOf(FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { null }
        assertFalse(props.required)
    }

    @Test
    fun `required - returns true when set`() {
        val field = FormTestFactory.defnText(id = "f1", required = true)
        val form = FormTestFactory.defnForm(compMap = mapOf(FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { null }
        assertTrue(props.required)
    }

    @Test
    fun `required - resolves from requiredFieldId when truthy`() {
        val toggle = FormTestFactory.defnSwitch(id = "toggle")
        val field = FormTestFactory.defnText(id = "f1", requiredFieldId = "toggle")
        val toggleId = FormTestFactory.fieldId("toggle")
        val form = FormTestFactory.defnForm(
            compMap = mapOf(toggleId to toggle, FormTestFactory.fieldId("f1") to field)
        )
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { id ->
            if (id == toggleId) JsonPrimitive(true) else null
        }
        assertTrue(props.required)
    }

    @Test
    fun `required - resolves from requiredFieldId when falsy`() {
        val toggle = FormTestFactory.defnSwitch(id = "toggle")
        val field = FormTestFactory.defnText(id = "f1", requiredFieldId = "toggle")
        val toggleId = FormTestFactory.fieldId("toggle")
        val form = FormTestFactory.defnForm(
            compMap = mapOf(toggleId to toggle, FormTestFactory.fieldId("f1") to field)
        )
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { id ->
            if (id == toggleId) JsonPrimitive(false) else null
        }
        assertFalse(props.required)
    }

    // ==================== Disabled ====================

    @Test
    fun `disabled - returns false when not set`() {
        val field = FormTestFactory.defnText(id = "f1")
        val form = FormTestFactory.defnForm(compMap = mapOf(FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { null }
        assertFalse(props.disabled)
    }

    @Test
    fun `disabled - returns true when disabled flag set`() {
        val field = FormTestFactory.defnText(id = "f1", disabled = true)
        val form = FormTestFactory.defnForm(compMap = mapOf(FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { null }
        assertTrue(props.disabled)
    }

    @Test
    fun `disabled - resolves from disabledFieldId when truthy`() {
        val boolField = FormTestFactory.defnSwitch(id = "toggle")
        val textField = FormTestFactory.defnText(id = "f1", disabledFieldId = "toggle")
        val toggleId = FormTestFactory.fieldId("toggle")
        val form =
            FormTestFactory.defnForm(compMap = mapOf(toggleId to boolField, FormTestFactory.fieldId("f1") to textField))
        val props = FieldPropertyResolver.resolveFieldProperties(textField, form) { id ->
            if (id == toggleId) JsonPrimitive(true) else null
        }
        assertTrue(props.disabled)
    }

    @Test
    fun `disabled - resolves from disabledFieldId when falsy`() {
        val boolField = FormTestFactory.defnSwitch(id = "toggle")
        val textField = FormTestFactory.defnText(id = "f1", disabledFieldId = "toggle")
        val toggleId = FormTestFactory.fieldId("toggle")
        val form =
            FormTestFactory.defnForm(compMap = mapOf(toggleId to boolField, FormTestFactory.fieldId("f1") to textField))
        val props = FieldPropertyResolver.resolveFieldProperties(textField, form) { id ->
            if (id == toggleId) JsonPrimitive(false) else null
        }
        assertFalse(props.disabled)
    }

    @Test
    fun `disabled - disabledFieldId with non-empty string is truthy`() {
        val sourceField = FormTestFactory.defnText(id = "source")
        val depField = FormTestFactory.defnText(id = "dep", disabledFieldId = "source")
        val sourceId = FormTestFactory.fieldId("source")
        val form = FormTestFactory.defnForm(
            compMap = mapOf(
                sourceId to sourceField,
                FormTestFactory.fieldId("dep") to depField
            )
        )
        val props = FieldPropertyResolver.resolveFieldProperties(depField, form) { id ->
            if (id == sourceId) JsonPrimitive("someValue") else null
        }
        assertTrue(props.disabled)
    }

    @Test
    fun `disabled - disabledFieldId with empty string is falsy`() {
        val sourceField = FormTestFactory.defnText(id = "source")
        val depField = FormTestFactory.defnText(id = "dep", disabledFieldId = "source")
        val sourceId = FormTestFactory.fieldId("source")
        val form = FormTestFactory.defnForm(
            compMap = mapOf(
                sourceId to sourceField,
                FormTestFactory.fieldId("dep") to depField
            )
        )
        val props = FieldPropertyResolver.resolveFieldProperties(depField, form) { id ->
            if (id == sourceId) JsonPrimitive("") else null
        }
        assertFalse(props.disabled)
    }

    // ==================== Hidden ====================

    @Test
    fun `hidden - returns false when not set`() {
        val field = FormTestFactory.defnText(id = "f1")
        val form = FormTestFactory.defnForm(compMap = mapOf(FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { null }
        assertFalse(props.hidden)
    }

    @Test
    fun `hidden - returns true when hidden set`() {
        val field = FormTestFactory.defnText(id = "f1", hidden = true)
        val form = FormTestFactory.defnForm(compMap = mapOf(FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { null }
        assertTrue(props.hidden)
    }

    @Test
    fun `hidden - returns true when invisible set`() {
        val field = FormTestFactory.defnText(id = "f1", invisible = true)
        val form = FormTestFactory.defnForm(compMap = mapOf(FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { null }
        assertTrue(props.hidden)
    }

    // ==================== ReadOnly ====================

    @Test
    fun `readOnly - returns true when set`() {
        val field = FormTestFactory.defnText(id = "f1", readOnly = true)
        val form = FormTestFactory.defnForm(compMap = mapOf(FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { null }
        assertTrue(props.readOnly)
    }

    // ==================== Label ====================

    @Test
    fun `label - uses label when set`() {
        val field = FormTestFactory.defnText(id = "f1", label = "First Name")
        val form = FormTestFactory.defnForm(compMap = mapOf(FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { null }
        assertEquals("First Name", props.label)
    }

    @Test
    fun `label - appends asterisk when required`() {
        val field = FormTestFactory.defnText(id = "f1", label = "Email", required = true)
        val form = FormTestFactory.defnForm(compMap = mapOf(FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { null }
        assertEquals("Email *", props.label)
    }

    @Test
    fun `label - resolves from labelFieldId`() {
        val source = FormTestFactory.defnText(id = "labelSource")
        val field = FormTestFactory.defnText(id = "f1", labelFieldId = "labelSource")
        val sourceId = FormTestFactory.fieldId("labelSource")
        val form = FormTestFactory.defnForm(
            compMap = mapOf(sourceId to source, FormTestFactory.fieldId("f1") to field)
        )
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { id ->
            if (id == sourceId) FormTestFactory.textValue("Dynamic Label") else null
        }
        assertEquals("Dynamic Label", props.label)
    }

    @Test
    fun `label - direct label takes priority over labelFieldId`() {
        val source = FormTestFactory.defnText(id = "labelSource")
        val field = FormTestFactory.defnText(id = "f1", label = "Direct Label", labelFieldId = "labelSource")
        val sourceId = FormTestFactory.fieldId("labelSource")
        val form = FormTestFactory.defnForm(
            compMap = mapOf(sourceId to source, FormTestFactory.fieldId("f1") to field)
        )
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { id ->
            if (id == sourceId) FormTestFactory.textValue("Dynamic Label") else null
        }
        assertEquals("Direct Label", props.label)
    }

    // ==================== HelperText ====================

    @Test
    fun `helperText - returns direct value`() {
        val field = FormTestFactory.defnText(id = "f1", helperText = "Enter your name")
        val form = FormTestFactory.defnForm(compMap = mapOf(FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { null }
        assertEquals("Enter your name", props.helperText)
    }

    @Test
    fun `helperText - resolves from helperTextFieldId`() {
        val helperSource = FormTestFactory.defnText(id = "helper")
        val field = FormTestFactory.defnText(id = "f1", helperTextFieldId = "helper")
        val helperId = FormTestFactory.fieldId("helper")
        val form =
            FormTestFactory.defnForm(compMap = mapOf(helperId to helperSource, FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { id ->
            if (id == helperId) FormTestFactory.textValue("Dynamic help") else null
        }
        assertEquals("Dynamic help", props.helperText)
    }

    // ==================== Placeholder ====================

    @Test
    fun `placeholder - returns direct value`() {
        val field = FormTestFactory.defnText(id = "f1", placeHolder = "Type here...")
        val form = FormTestFactory.defnForm(compMap = mapOf(FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { null }
        assertEquals("Type here...", props.placeholder)
    }

    @Test
    fun `placeholder - resolves from placeHolderFieldId`() {
        val source = FormTestFactory.defnText(id = "phSource")
        val field = FormTestFactory.defnText(id = "f1", placeHolderFieldId = "phSource")
        val sourceId = FormTestFactory.fieldId("phSource")
        val form = FormTestFactory.defnForm(compMap = mapOf(sourceId to source, FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { id ->
            if (id == sourceId) FormTestFactory.textValue("Dynamic placeholder") else null
        }
        assertEquals("Dynamic placeholder", props.placeholder)
    }

    // ==================== Dependency Map ====================

    @Test
    fun `buildDependencyMap - tracks disabledFieldId dependencies`() {
        val toggle = FormTestFactory.defnSwitch(id = "toggle")
        val depField = FormTestFactory.defnText(id = "dep", disabledFieldId = "toggle")
        val toggleId = FormTestFactory.fieldId("toggle")
        val depId = FormTestFactory.fieldId("dep")
        val compMap = mapOf<Types.MetaIdComp, DefnCompSeal>(
            toggleId to toggle, depId to depField
        )
        val depMap = FieldPropertyResolver.buildDependencyMap(compMap)
        assertTrue(depMap.getDependents(toggleId).contains(depId))
    }

    @Test
    fun `buildDependencyMap - tracks helperTextFieldId dependencies`() {
        val source = FormTestFactory.defnText(id = "source")
        val dep = FormTestFactory.defnText(id = "dep", helperTextFieldId = "source")
        val sourceId = FormTestFactory.fieldId("source")
        val depId = FormTestFactory.fieldId("dep")
        val compMap = mapOf<Types.MetaIdComp, DefnCompSeal>(
            sourceId to source, depId to dep
        )
        val depMap = FieldPropertyResolver.buildDependencyMap(compMap)
        assertTrue(depMap.getDependents(sourceId).contains(depId))
    }

    @Test
    fun `buildDependencyMap - empty for fields with no references`() {
        val f1 = FormTestFactory.defnText(id = "f1")
        val f2 = FormTestFactory.defnText(id = "f2")
        val compMap = mapOf<Types.MetaIdComp, DefnCompSeal>(
            FormTestFactory.fieldId("f1") to f1, FormTestFactory.fieldId("f2") to f2
        )
        val depMap = FieldPropertyResolver.buildDependencyMap(compMap)
        assertTrue(depMap.getDependents(FormTestFactory.fieldId("f1")).isEmpty())
    }

    @Test
    fun `buildDependencyMap - multiple dependents on same source`() {
        val source = FormTestFactory.defnText(id = "source")
        val dep1 = FormTestFactory.defnText(id = "dep1", disabledFieldId = "source")
        val dep2 = FormTestFactory.defnText(id = "dep2", helperTextFieldId = "source")
        val sourceId = FormTestFactory.fieldId("source")
        val compMap = mapOf<Types.MetaIdComp, DefnCompSeal>(
            sourceId to source, FormTestFactory.fieldId("dep1") to dep1, FormTestFactory.fieldId("dep2") to dep2
        )
        val depMap = FieldPropertyResolver.buildDependencyMap(compMap)
        val dependents = depMap.getDependents(sourceId)
        assertEquals(2, dependents.size)
    }

    @Test
    fun `buildDependencyMap - tracks decimal minFieldId dependencies`() {
        val source = FormTestFactory.defnNumber(id = "source")
        val dep = FormTestFactory.defnDecimal(id = "dep", minFieldId = "source")
        val sourceId = FormTestFactory.fieldId("source")
        val depId = FormTestFactory.fieldId("dep")
        val compMap = mapOf<Types.MetaIdComp, DefnCompSeal>(
            sourceId to source, depId to dep
        )
        val depMap = FieldPropertyResolver.buildDependencyMap(compMap)
        assertTrue(depMap.getDependents(sourceId).contains(depId))
    }

    @Test
    fun `buildDependencyMap - tracks requiredFieldId dependencies`() {
        val toggle = FormTestFactory.defnSwitch(id = "toggle")
        val dep = FormTestFactory.defnText(id = "dep", requiredFieldId = "toggle")
        val toggleId = FormTestFactory.fieldId("toggle")
        val depId = FormTestFactory.fieldId("dep")
        val compMap = mapOf<Types.MetaIdComp, DefnCompSeal>(
            toggleId to toggle, depId to dep
        )
        val depMap = FieldPropertyResolver.buildDependencyMap(compMap)
        assertTrue(depMap.getDependents(toggleId).contains(depId))
    }

    @Test
    fun `buildDependencyMap - tracks labelFieldId dependencies`() {
        val source = FormTestFactory.defnText(id = "source")
        val dep = FormTestFactory.defnText(id = "dep", labelFieldId = "source")
        val sourceId = FormTestFactory.fieldId("source")
        val depId = FormTestFactory.fieldId("dep")
        val compMap = mapOf<Types.MetaIdComp, DefnCompSeal>(
            sourceId to source, depId to dep
        )
        val depMap = FieldPropertyResolver.buildDependencyMap(compMap)
        assertTrue(depMap.getDependents(sourceId).contains(depId))
    }

    // ==================== MinDecimal / MaxDecimal ====================

    @Test
    fun `minDecimal - returns null for non-decimal field`() {
        val field = FormTestFactory.defnText(id = "f1")
        val form = FormTestFactory.defnForm(compMap = mapOf(FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { null }
        assertNull(props.minDecimal)
    }

    @Test
    fun `minDecimal - returns direct value`() {
        val field = FormTestFactory.defnDecimal(id = "f1", min = 1.5)
        val form = FormTestFactory.defnForm(compMap = mapOf(FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { null }
        assertEquals(1.5, props.minDecimal)
    }

    @Test
    fun `maxDecimal - returns direct value`() {
        val field = FormTestFactory.defnDecimal(id = "f1", max = 99.9)
        val form = FormTestFactory.defnForm(compMap = mapOf(FormTestFactory.fieldId("f1") to field))
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { null }
        assertEquals(99.9, props.maxDecimal)
    }

    @Test
    fun `minDecimal - resolves from minFieldId`() {
        val source = FormTestFactory.defnDecimal(id = "source")
        val field = FormTestFactory.defnDecimal(id = "f1", minFieldId = "source")
        val sourceId = FormTestFactory.fieldId("source")
        val form = FormTestFactory.defnForm(
            compMap = mapOf(sourceId to source, FormTestFactory.fieldId("f1") to field)
        )
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { id ->
            if (id == sourceId) FormTestFactory.decimalValue(5.5) else null
        }
        assertEquals(5.5, props.minDecimal)
    }

    @Test
    fun `maxDecimal - resolves from maxFieldId`() {
        val source = FormTestFactory.defnDecimal(id = "source")
        val field = FormTestFactory.defnDecimal(id = "f1", maxFieldId = "source")
        val sourceId = FormTestFactory.fieldId("source")
        val form = FormTestFactory.defnForm(
            compMap = mapOf(sourceId to source, FormTestFactory.fieldId("f1") to field)
        )
        val props = FieldPropertyResolver.resolveFieldProperties(field, form) { id ->
            if (id == sourceId) FormTestFactory.decimalValue(100.0) else null
        }
        assertEquals(100.0, props.maxDecimal)
    }
}
