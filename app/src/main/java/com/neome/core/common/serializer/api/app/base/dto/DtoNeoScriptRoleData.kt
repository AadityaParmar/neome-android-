package com.neome.core.common.serializer.api.app.base.dto

import com.neome.api.app.base.Types.EnumKindNeoScript
import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.app.base.dto.DtoNeoScriptRole
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoNeoScriptRoleData(
    override val kind: EnumKindNeoScript,
    @Serializable(with = MetaIdRoleSer::class) override val roleId: Types.MetaIdRole? = null
) : DtoNeoScriptRole
