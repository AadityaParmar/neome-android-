package com.neome.core.common.serializer.api.app.base.dto

import com.neome.api.app.base.Types.EnumKindNeoScript
import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.app.base.dto.DtoNeoScriptGroup
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdGroupSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoNeoScriptGroupData(
    override val kind: EnumKindNeoScript,
    @Serializable(with = MetaIdGroupSer::class) override val groupId: Types.MetaIdGroup? = null
) : DtoNeoScriptGroup
