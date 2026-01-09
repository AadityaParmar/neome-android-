package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDeviceSize
import com.neome.api.meta.base.dto.DefnStudioDtoActionPermission
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdGroupSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnStudioDtoActionPermissionData(
    override val deviceSizeSet: Array<EnumDefnDeviceSize>? = null,
    override val groupIdSet: Array<@Serializable(with = MetaIdGroupSer::class) Types.MetaIdGroup>? = null,
    override val hidden: Boolean? = null,
    @Serializable(with = MetaIdVarSer::class) override val inputMappingVarId: Types.MetaIdVar? = null,
    override val menuGroup: String? = null,
    @Serializable(with = MetaIdActionSer::class) override val metaId: Types.MetaIdAction,
    override val notAllowedRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val outputMappingVarId: Types.MetaIdVar? = null,
    override val roleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>,
    override val showMessageTooltip: Boolean? = null
) : DefnStudioDtoActionPermission
