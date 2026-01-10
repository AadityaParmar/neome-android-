package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnArgBinder
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.dto.DefnStudioBuildArgBinder
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoPermissionMatrixData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDtoOptionData
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
sealed interface DefnStudioBuildArgBinderSeal : DefnStudioBuildArgBinder


@Serializable
data class DefnStudioBuildArgBinderData(
    override val disabled: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val disabledFieldId: Types.MetaIdField? = null,
    override val disabledRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val disabledVar: Boolean? = null,
    override val hidden: Boolean? = null,
    override val hideDirtyIndicator: Boolean? = null,
    override val invisible: Boolean? = null,
    override val label: String? = null,
    override val maxWidth: Long? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val pb: Long? = null,
    override val permissionMatrix: DefnDtoPermissionMatrixData? = null,
    override val pl: Long? = null,
    override val pr: Long? = null,
    override val pt: Long? = null,
    override val readOnly: Boolean? = null,
    override val type: EnumDefnCompType,
    @Serializable(with = MetaIdFieldSer::class) override val metaId: Types.MetaIdField,
    override val compositeIdSet: List<@Serializable(with = MetaIdCompositeSer::class) Types.MetaIdComposite>? = null,
    override val derivedCompositeIdSet: List<@Serializable(with = MetaIdCompositeSer::class) Types.MetaIdComposite>? = null,
    @Serializable(with = MetaIdFormSer::class) override val derivedFormId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdPluginSer::class) override val derivedPluginId: Types.MetaIdPlugin? = null,
    override val direction: EnumDefnThemeDirection? = null,
    override val excludeFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val excludeVarIdSet: List<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar>? = null,
    override val filterConstantFieldTypeSet: List<EnumDefnCompType>? = null,
    override val filterContextCallerSet: List<String>? = null,
    override val filterContextCallerSettingSet: List<String>? = null,
    override val filterContextEntSet: List<String>? = null,
    override val filterContextOptionSet: List<String>? = null,
    override val filterContextRowSet: List<String>? = null,
    override val filterDerivedFieldTypeSet: List<EnumDefnCompType>? = null,
    override val filterFieldTypeSet: List<EnumDefnCompType>? = null,
    override val filterKindSet: List<EnumDefnArgBinder>? = null,
    override val filterVarKindSet: List<EnumStudioVarKind>? = null,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdGridSer::class) override val gridId: Types.MetaIdGrid? = null,
    override val includeOptionMap: DefnStudioMapOfDtoOptionData? = null,
    @Serializable(with = MetaIdFormSer::class) override val inputFormId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdFieldSer::class) override val peerFieldId: Types.MetaIdField? = null,
    override val peerKind: EnumDefnArgBinder? = null,
    @Serializable(with = MetaIdFormSer::class) override val pluginConfigFormId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdPluginSer::class) override val pluginId: Types.MetaIdPlugin? = null,
    @Serializable(with = MetaIdFieldSer::class) override val refTargetFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdFormSer::class) override val refTargetFormId: Types.MetaIdForm? = null,
    override val required: Boolean? = null
) : DefnCompSeal, DefnStudioBuildArgBinder
