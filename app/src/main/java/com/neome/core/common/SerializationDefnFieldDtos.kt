package com.neome.core.common

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCalculateFormulaMode
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnDtoFormTheme
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.api.meta.base.dto.DefnDtoTextValidationPattern
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.dto.DefnFieldEditableText
import com.neome.api.meta.base.dto.DefnFieldNumber
import com.neome.api.meta.base.dto.DefnFieldText
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnLayoutFormMap
import com.neome.api.meta.base.dto.DefnPaymentConfig
import com.neome.api.meta.base.dto.DefnStudioMapOfActionPermission
import com.neome.api.meta.base.dto.DefnVisibilityRuleMap
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


// ===== Serializable classes for polymorphic serialization =====


// Sealed class hierarchy for DefnComp
@Serializable
sealed class DefnCompSeal : DefnComp
sealed class DefnFieldSeal : DefnField
sealed class DefnFieldEditableSeal : DefnFieldEditable
sealed class DefnFieldEditableTextSeal : DefnFieldEditableText

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


    @Serializable(with = SymbolSer::class)
    override var name: Symbol,


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

    @Serializable(with = MetaIdFieldSer::class)
    override var maxCharCountFieldId: MetaIdField? = null,


    @Serializable(with = MetaIdFieldSer::class)
    override var minCharCountFieldId: MetaIdField? = null,

    override val permissionMatrix: DefnDtoPermissionMatrix?,
    override val maxWidth: Long?,
    override val pb: Long?,
    override val pl: Long?,
    override val pr: Long?,
    override val pt: Long?,
    override val maxCharCount: Long?,
    override val maxCharCountVar: Long?,
    override val minCharCount: Long?,
    override val minCharCountVar: Long?,
    override val validationPattern: DefnDtoTextValidationPattern?,

    ) : DefnFieldEditableTextSeal(),
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


    @Serializable(with = SymbolSer::class)
    override var name: Symbol,

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


    @Serializable(with = MetaIdFieldSer::class)
    override var maxFieldId: MetaIdField? = null,


    @Serializable(with = MetaIdFieldSer::class)
    override var minFieldId: MetaIdField? = null,


    override var numberFormat: String? = null,
    override val maxWidth: Long?,
    override val pb: Long?,
    override val permissionMatrix: DefnDtoPermissionMatrix?,
    override val pl: Long?,
    override val pr: Long?,
    override val pt: Long?,
    override val defaultValue: Long?,
    override val defaultVar: Long?,
    override val max: Long?,
    override val maxVar: Long?,
    override val min: Long?,
    override val minDisplayValue: Long?,
    override val minVar: Long?
) : DefnFieldEditableSeal(),
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
    override var name: Symbol,
    override val actionPermissionMap: DefnStudioMapOfActionPermission?,
    override val chatPatternVar: DefnDtoParagraph?,
    override val layoutMap: DefnLayoutFormMap?,
    override val paymentConfig: DefnPaymentConfig?,
    override val permissionMatrix: DefnDtoPermissionMatrix?,
    override val theme: DefnDtoFormTheme?,
    override val visibilityRuleMap: DefnVisibilityRuleMap?
) : DefnForm
