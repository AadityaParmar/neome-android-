package com.neome.core.common.serializer.api.app.base.dto

import com.neome.api.app.base.Types.EnumKindNeoScript
import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.app.base.dto.DtoNeoScriptVar
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoNeoScriptVarData(
    override val kind: EnumKindNeoScript,
    @Serializable(with = MetaIdVarSer::class) override val varId: Types.MetaIdVar? = null
) : DtoNeoScriptVar
