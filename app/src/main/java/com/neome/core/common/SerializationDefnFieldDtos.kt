package com.neome.core.common

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCalculateFormulaMode
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.core.common.serializer.DefnDtoTextSer
import com.neome.core.common.serializer.MetaIdCompSer
import com.neome.core.common.serializer.MetaIdCompositeSer
import com.neome.core.common.serializer.MetaIdFieldSer
import com.neome.core.common.serializer.MetaIdFormSer
import com.neome.core.common.serializer.MetaIdGridSer
import com.neome.core.common.serializer.MetaIdLayoutGridSer
import com.neome.core.common.serializer.MetaIdRoleSer
import com.neome.core.common.serializer.SymbolSer
import kotlinx.serialization.Contextual
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable
sealed interface DefnComp {
    var disabled: Boolean?
    var disabledFieldId: Types.MetaIdField?
    var disabledRoleIdSet: Array<Types.MetaIdRole>?
    var disabledVar: Boolean?
    var hidden: Boolean?
    var hideDirtyIndicator: Boolean?
    var invisible: Boolean?
    var label: String?
    var maxWidth: Int?
    var name: Symbol
    var pb: Int?
    var pl: Int?
    var pr: Int?
    var pt: Int?
    var readOnly: Boolean?
    var type: Types.EnumDefnCompType
}

@Serializable
sealed interface DefnField : DefnComp {
    var metaId: MetaIdField
}

@Serializable
sealed interface DefnDtoText {
    var value: Array<String>?
}


@Serializable
sealed interface DefnFieldEditable : DefnField {
    var autoFill: Boolean?
    var autoFocus: Boolean?
    var helperText: String?
    var helperTextFieldId: MetaIdField?
    var helperTextVar: DefnDtoText?
    var hideLabel: Boolean?
    var icon: String?
    var iconVar: String?
    var labelFieldId: MetaIdField?
    var placeHolder: String?
    var placeHolderFieldId: MetaIdField?
    var placeHolderVar: DefnDtoText?
    var prefix: String?
    var prefixVar: DefnDtoText?
    var required: Boolean?
    var requiredFieldId: MetaIdField?
    var requiredRoleIdSet: Array<MetaIdRole>?
    var requiredVar: Boolean?
    var suffix: String?
    var suffixVar: DefnDtoText?
}

@Serializable
sealed interface DefnFieldEditableText : DefnFieldEditable {
    var defaultFieldId: MetaIdField?
    var defaultValue: String?
    var defaultVar: DefnDtoText?
}

@Serializable
sealed interface DefnFieldText : DefnFieldEditableText {
    var maxCharCount: Int?
    var maxCharCountFieldId: MetaIdField?
    var maxCharCountVar: Int?
    var minCharCount: Int?
    var minCharCountFieldId: MetaIdField?
    var minCharCountVar: Int?
}


@Serializable
sealed interface DefnFieldNumber : DefnFieldEditable {
    var defaultFieldId: MetaIdField?
    var defaultValue: Int?
    var defaultVar: Int?
    var max: Int?
    var maxFieldId: MetaIdField?
    var maxVar: Int?
    var min: Int?
    var minDisplayValue: Int?
    var minFieldId: MetaIdField?
    var minVar: Int?
    var numberFormat: String?
}


@Serializable
sealed interface DefnForm {
    var allowToPrintForm: Boolean?
    var calculateFormulaMode: EnumDefnCalculateFormulaMode?
    var chatBubbleFieldIdSet: Array<MetaIdField>?
    var chatLabelFieldId: MetaIdField?
    var chatLabelPatternVar: DefnDtoText?
    var commentReadOnlyRoleSet: Array<MetaIdRole>?
    var commentRoleSet: Array<MetaIdRole>?
    var compMap: Map<MetaIdComp, DefnComp>
    var configForm: Boolean?
    var displayCompositeId: Types.MetaIdComposite
    var formulaFieldIdSet: Array<MetaIdField>?
    var gridLookupMap: Map<Types.MetaIdLayoutGrid, Types.MetaIdGrid>?
    var label: String?
    var metaId: Types.MetaIdForm
    var name: Symbol
}

// ===== Serializable classes for polymorphic serialization =====

@Serializable
data class DefnDtoTextData(
    override var value: Array<String>?
) : DefnDtoText


// Sealed class hierarchy for DefnComp
@Serializable
sealed class DefnCompSeal : DefnComp

// DefnFieldText serializable
@Serializable
@SerialName("text")
data class DefnFieldTextSer(
    // DefnComp properties
    override var disabled: Boolean? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var disabledFieldId: Types.MetaIdField? = null,

    override var disabledRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,

    override var disabledVar: Boolean? = null,

    override var hidden: Boolean? = null,

    override var hideDirtyIndicator: Boolean? = null,

    override var invisible: Boolean? = null,

    override var label: String? = null,

    override var maxWidth: Int? = null,

    @Serializable(with = SymbolSer::class)
    override var name: Symbol,

    override var pb: Int? = null,

    override var pl: Int? = null,

    override var pr: Int? = null,

    override var pt: Int? = null,

    override var readOnly: Boolean? = null,

    override var type: Types.EnumDefnCompType = Types.EnumDefnCompType.text,


    // DefnField properties
    @Serializable(with = MetaIdFieldSer::class)
    override var metaId: MetaIdField,


    // DefnFieldEditable properties
    override var autoFill: Boolean? = null,

    override var autoFocus: Boolean? = null,

    override var helperText: String? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var helperTextFieldId: MetaIdField? = null,

    @Serializable(with = DefnDtoTextSer::class)
    override var helperTextVar: DefnDtoText? = null,

    override var hideLabel: Boolean? = null,

    override var icon: String? = null,

    override var iconVar: String? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var labelFieldId: MetaIdField? = null,

    override var placeHolder: String? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var placeHolderFieldId: MetaIdField? = null,

    @Serializable(with = DefnDtoTextSer::class) override var placeHolderVar: DefnDtoText? = null,

    override var prefix: String? = null,

    @Serializable(with = DefnDtoTextSer::class) override var prefixVar: DefnDtoText? = null,

    override var required: Boolean? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var requiredFieldId: MetaIdField? = null,

    override var requiredRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) MetaIdRole>? = null,

    override var requiredVar: Boolean? = null,

    override var suffix: String? = null,

    @Serializable(with = DefnDtoTextSer::class)
    override var suffixVar: DefnDtoText? = null,


    // DefnFieldEditableText properties
    @Serializable(with = MetaIdFieldSer::class)
    override var defaultFieldId: MetaIdField? = null,

    override var defaultValue: String? = null,

    @Serializable(with = DefnDtoTextSer::class) override var defaultVar: DefnDtoText? = null,


    // DefnFieldText properties
    override var maxCharCount: Int? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var maxCharCountFieldId: MetaIdField? = null,

    override var maxCharCountVar: Int? = null,

    override var minCharCount: Int? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var minCharCountFieldId: MetaIdField? = null,

    override var minCharCountVar: Int? = null,

    ) : DefnCompSeal(),
    DefnFieldText

// DefnFieldNumber serializable
@Serializable
@SerialName("number")
data class DefnFieldNumberSer(
    // DefnComp properties
    override var disabled: Boolean? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var disabledFieldId: Types.MetaIdField? = null,

    override var disabledRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,

    override var disabledVar: Boolean? = null,

    override var hidden: Boolean? = null,

    override var hideDirtyIndicator: Boolean? = null,

    override var invisible: Boolean? = null,

    override var label: String? = null,

    override var maxWidth: Int? = null,

    @Serializable(with = SymbolSer::class)
    override var name: Symbol,

    override var pb: Int? = null,

    override var pl: Int? = null,

    override var pr: Int? = null,

    override var pt: Int? = null,

    override var readOnly: Boolean? = null,

    override var type: Types.EnumDefnCompType = Types.EnumDefnCompType.number,


    // DefnField properties
    @Serializable(with = MetaIdFieldSer::class)
    override var metaId: MetaIdField,


    // DefnFieldEditable properties
    override var autoFill: Boolean? = null,

    override var autoFocus: Boolean? = null,

    override var helperText: String? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var helperTextFieldId: MetaIdField? = null,

    @Serializable(with = DefnDtoTextSer::class)
    override var helperTextVar: DefnDtoText? = null,

    override var hideLabel: Boolean? = null,

    override var icon: String? = null,

    override var iconVar: String? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var labelFieldId: MetaIdField? = null,

    override var placeHolder: String? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var placeHolderFieldId: MetaIdField? = null,

    @Serializable(with = DefnDtoTextSer::class) override var placeHolderVar: DefnDtoText? = null,

    override var prefix: String? = null,

    @Serializable(with = DefnDtoTextSer::class) override var prefixVar: DefnDtoText? = null,

    override var required: Boolean? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var requiredFieldId: MetaIdField? = null,

    override var requiredRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) MetaIdRole>? = null,

    override var requiredVar: Boolean? = null,

    override var suffix: String? = null,

    @Contextual override var suffixVar: DefnDtoText? = null,


    // DefnFieldNumber properties
    @Serializable(with = MetaIdFieldSer::class)
    override var defaultFieldId: MetaIdField? = null,

    override var defaultValue: Int? = null,

    override var defaultVar: Int? = null,

    override var max: Int? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var maxFieldId: MetaIdField? = null,

    override var maxVar: Int? = null,

    override var min: Int? = null,

    override var minDisplayValue: Int? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var minFieldId: MetaIdField? = null,

    override var minVar: Int? = null,

    override var numberFormat: String? = null
) : DefnCompSeal(),
    DefnFieldNumber

// Polymorphic serializer for DefnComp
object DefnCompSerializer : JsonContentPolymorphicSerializer<DefnComp>(DefnComp::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<DefnComp> {
        val type = element.jsonObject["type"]?.jsonPrimitive?.content
        return when (type) {
            "text",
            Types.EnumDefnCompType.text.value -> DefnFieldTextSer.serializer()

            "number",
            Types.EnumDefnCompType.number.value -> DefnFieldNumberSer.serializer()
            // Add more types as needed (bool,
            // date,
            // decimal,
            // etc.)
            else -> DefnFieldTextSer.serializer() // Default fallback
        }
    }
}

// DefnForm serializable
@Serializable
data class DefnFormSer(
    override var allowToPrintForm: Boolean? = null,

    override var calculateFormulaMode: EnumDefnCalculateFormulaMode? = null,

    override var chatBubbleFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) MetaIdField>? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var chatLabelFieldId: MetaIdField? = null,

    @Contextual override var chatLabelPatternVar: DefnDtoText? = null,

    override var commentReadOnlyRoleSet: Array<@Serializable(with = MetaIdRoleSer::class) MetaIdRole>? = null,

    override var commentRoleSet: Array<@Serializable(with = MetaIdRoleSer::class) MetaIdRole>? = null,

    // Polymorphic map - the values will be deserialized based on their "type" field
    override var compMap: Map<@Serializable(with = MetaIdCompSer::class) MetaIdComp,
            @Serializable(
                with = DefnCompSerializer::class
            ) DefnComp>,

    override var configForm: Boolean? = null,

    @Serializable(with = MetaIdCompositeSer::class)
    override var displayCompositeId: Types.MetaIdComposite,

    override var formulaFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) MetaIdField>? = null,

    override var gridLookupMap: Map<@Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid,
            @Serializable(
                with = MetaIdGridSer::class
            ) Types.MetaIdGrid>? = null,

    override var label: String? = null,

    @Serializable(with = MetaIdFormSer::class)
    override var metaId: Types.MetaIdForm,

    @Serializable(with = SymbolSer::class)
    override var name: Symbol
) : DefnForm
