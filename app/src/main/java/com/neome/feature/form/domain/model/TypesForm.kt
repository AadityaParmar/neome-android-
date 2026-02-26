package com.neome.feature.form.domain.model

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCalculateFormulaMode
import com.neome.api.meta.base.Types.EnumDefnPermission
import com.neome.api.meta.base.Types.EnumDefnRoles
import com.neome.api.meta.base.dto.DefnForm
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoFormThemeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoParagraphData
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoPermissionMatrixData
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoTextData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormEventMapData
import com.neome.core.common.serializer.api.meta.base.dto.DefnLayoutFormMapData
import com.neome.core.common.serializer.api.meta.base.dto.DefnPaymentConfigData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfActionPermissionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnVisibilityRuleMapData
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Represents a permission role which can be either a predefined role or "caller".
 * Serializes as a plain string: "caller" or the EnumDefnRoles value (e.g. "$Public").
 */
@Serializable(with = TypeUiPermissionRoleSerializer::class)
sealed interface TypeUiPermissionRole {
    data class Role(val role: EnumDefnRoles) : TypeUiPermissionRole
    data object Caller : TypeUiPermissionRole
}

object TypeUiPermissionRoleSerializer : KSerializer<TypeUiPermissionRole> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("TypeUiPermissionRole", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: TypeUiPermissionRole) {
        val str = when (value) {
            is TypeUiPermissionRole.Caller -> "caller"
            is TypeUiPermissionRole.Role -> value.role.value
        }
        encoder.encodeString(str)
    }

    override fun deserialize(decoder: Decoder): TypeUiPermissionRole {
        val str = decoder.decodeString()
        if (str == "caller") return TypeUiPermissionRole.Caller
        val role = EnumDefnRoles.entries.firstOrNull { it.value == str }
            ?: throw IllegalArgumentException("Unknown TypeUiPermissionRole: $str")
        return TypeUiPermissionRole.Role(role)
    }
}

@Serializable
data class TypeUiFormPermissionMap(
    val map: Map<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp, TypeUiFormPermission>?
)

@Serializable
data class TypeUiFormParentMap(
    val map: Map<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp, List<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp>>?
)
/**
 * Maps permission roles to their corresponding permissions
 */

/**
 * Permission configuration for a form component
 */
@Serializable
data class TypeUiFormPermission(
    val permission: Map<TypeUiPermissionRole, EnumDefnPermission>? = null,
    val disabled: Map<TypeUiPermissionRole, Boolean>? = null,
    val required: Map<TypeUiPermissionRole, Boolean>? = null
)

/**
 * Managerial relationship mapping for specific role types
 * Maps EntUserId to boolean for each role category
 */
@Serializable
data class TypeUiManagerialRelationship(
    val manager: Set<@Serializable(with = EntUserIdSer::class) Types.EntUserId>? = null,
    val grandManager: Set<@Serializable(with = EntUserIdSer::class) Types.EntUserId>? = null,
    val allManagers: Set<@Serializable(with = EntUserIdSer::class) Types.EntUserId>? = null,
    val assistants: Set<@Serializable(with = EntUserIdSer::class) Types.EntUserId>? = null,
    val allAssistants: Set<@Serializable(with = EntUserIdSer::class) Types.EntUserId>? = null
)

@Serializable
data class DefnFormUi(
    override val actionPermissionMap: DefnStudioMapOfActionPermissionData? = null,
    override val allowToPrintForm: Boolean? = null,
    override val calculateFormulaMode: EnumDefnCalculateFormulaMode? = null,
    override val chatBubbleFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdFieldSer::class) override val chatLabelFieldId: Types.MetaIdField? = null,
    override val chatLabelPatternVar: DefnDtoTextData? = null,
    override val chatPatternVar: DefnDtoParagraphData? = null,
    override val commentReadOnlyRoleSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val commentRoleSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val compMap: Map<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp, DefnCompSeal>,
    override val configForm: Boolean? = null,
    @Serializable(with = MetaIdCompositeSer::class) override val displayCompositeId: Types.MetaIdComposite,
    override val formulaFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val gridLookupMap: Map<
        @Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid,
        @Serializable(with = MetaIdGridSer::class) Types.MetaIdGrid>? = null,
    override val label: String? = null,
    override val layoutMap: DefnLayoutFormMapData? = null,
    @Serializable(with = MetaIdFormSer::class) override val metaId: Types.MetaIdForm,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val paymentConfig: DefnPaymentConfigData? = null,
    override val permissionMatrix: DefnDtoPermissionMatrixData? = null,
    override val theme: DefnDtoFormThemeData? = null,
    override val visibilityRuleMap: DefnVisibilityRuleMapData? = null,
    override val eventMap: DefnFormEventMapData? = null,

    // UI-specific permission and relationship maps
    val _permissionMap: TypeUiFormPermissionMap? = null,
    val _parentMap: TypeUiFormParentMap? = null,
    val _managerialRelationship: TypeUiManagerialRelationship? = null,
) : DefnForm
