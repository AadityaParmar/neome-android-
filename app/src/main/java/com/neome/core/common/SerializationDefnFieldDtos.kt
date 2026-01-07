package com.neome.core.common

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCalculateFormulaMode
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.core.common.serializer.SymbolSer
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

interface DefnComp {
    val disabled: Boolean?
    val disabledFieldId: Types.MetaIdField?
    val disabledRoleIdSet: Array<Types.MetaIdRole>?
    val disabledVar: Boolean?
    val hidden: Boolean?
    val hideDirtyIndicator: Boolean?
    val invisible: Boolean?
    val label: String?
    val maxWidth: Int?
    val name: Symbol
    val pb: Int?
    val pl: Int?
    val pr: Int?
    val pt: Int?
    val readOnly: Boolean?
    val type: Types.EnumDefnCompType
}

interface DefnField : DefnComp {
    val metaId: MetaIdField
}


interface DefnFieldEditable : DefnField {
    val autoFill: Boolean?
    val autoFocus: Boolean?
    val helperText: String?
    val helperTextFieldId: MetaIdField?
    val helperTextVar: DefnDtoText?
    val hideLabel: Boolean?
    val icon: String?
    val iconVar: String?
    val labelFieldId: MetaIdField?
    val placeHolder: String?
    val placeHolderFieldId: MetaIdField?
    val placeHolderVar: DefnDtoText?
    val prefix: String?
    val prefixVar: DefnDtoText?
    val required: Boolean?
    val requiredFieldId: MetaIdField?
    val requiredRoleIdSet: Array<MetaIdRole>?
    val requiredVar: Boolean?
    val suffix: String?
    val suffixVar: DefnDtoText?
}

interface DefnFieldEditableText : DefnFieldEditable {
    val defaultFieldId: MetaIdField?
    val defaultValue: String?
    val defaultVar: DefnDtoText?
}

interface DefnFieldText : DefnFieldEditableText {
    val maxCharCount: Int?
    val maxCharCountFieldId: MetaIdField?
    val maxCharCountVar: Int?
    val minCharCount: Int?
    val minCharCountFieldId: MetaIdField?
    val minCharCountVar: Int?
}


interface DefnFieldNumber : DefnFieldEditable {
    val defaultFieldId: MetaIdField?
    val defaultValue: Int?
    val defaultVar: Int?
    val max: Int?
    val maxFieldId: MetaIdField?
    val maxVar: Int?
    val min: Int?
    val minDisplayValue: Int?
    val minFieldId: MetaIdField?
    val minVar: Int?
    val numberFormat: String?
}


interface DefnForm {
    val allowToPrintForm: Boolean?
    val calculateFormulaMode: EnumDefnCalculateFormulaMode?
    val chatBubbleFieldIdSet: Array<MetaIdField>?
    val chatLabelFieldId: MetaIdField?
    val chatLabelPatternVar: DefnDtoText?
    val commentReadOnlyRoleSet: Array<MetaIdRole>?
    val commentRoleSet: Array<MetaIdRole>?
    val compMap: Map<MetaIdComp, DefnComp>
    val configForm: Boolean?
    val displayCompositeId: Types.MetaIdComposite
    val formulaFieldIdSet: Array<MetaIdField>?
    val gridLookupMap: Map<Types.MetaIdLayoutGrid, Types.MetaIdGrid>?
    val label: String?
    val metaId: Types.MetaIdForm
    val name: Symbol
}

// ===== Serializable classes for polymorphic serialization =====


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

    override var helperTextVar: DefnDtoTextData? = null,

    override var hideLabel: Boolean? = null,

    override var icon: String? = null,

    override var iconVar: String? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var labelFieldId: MetaIdField? = null,

    override var placeHolder: String? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var placeHolderFieldId: MetaIdField? = null,

    override var placeHolderVar: DefnDtoTextData? = null,

    override var prefix: String? = null,

    override var prefixVar: DefnDtoTextData? = null,

    override var required: Boolean? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var requiredFieldId: MetaIdField? = null,

    override var requiredRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) MetaIdRole>? = null,

    override var requiredVar: Boolean? = null,

    override var suffix: String? = null,

    override var suffixVar: DefnDtoTextData? = null,


    // DefnFieldEditableText properties
    @Serializable(with = MetaIdFieldSer::class)
    override var defaultFieldId: MetaIdField? = null,

    override var defaultValue: String? = null,

    override var defaultVar: DefnDtoTextData? = null,


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

    override var helperTextVar: DefnDtoTextData? = null,

    override var hideLabel: Boolean? = null,

    override var icon: String? = null,

    override var iconVar: String? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var labelFieldId: MetaIdField? = null,

    override var placeHolder: String? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var placeHolderFieldId: MetaIdField? = null,

    override var placeHolderVar: DefnDtoTextData? = null,

    override var prefix: String? = null,

    override var prefixVar: DefnDtoTextData? = null,

    override var required: Boolean? = null,

    @Serializable(with = MetaIdFieldSer::class)
    override var requiredFieldId: MetaIdField? = null,

    override var requiredRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) MetaIdRole>? = null,

    override var requiredVar: Boolean? = null,

    override var suffix: String? = null,

    override var suffixVar: DefnDtoTextData? = null,


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

    override var chatLabelPatternVar: DefnDtoTextData? = null,

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

    override var gridLookupMap: Map<
            @Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid,
            @Serializable(with = MetaIdGridSer::class) Types.MetaIdGrid>? = null,

    override var label: String? = null,

    @Serializable(with = MetaIdFormSer::class)
    override var metaId: Types.MetaIdForm,

    @Serializable(with = SymbolSer::class)
    override var name: Symbol
) : DefnForm
