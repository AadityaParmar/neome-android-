package com.neome.core.common.serializer.api.app.base.dto

import com.neome.api.app.base.Types.EnumKindNeoScript
import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.app.base.dto.DtoNeoScriptAction
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoNeoScriptActionData(
    override val kind: EnumKindNeoScript,
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction? = null
) : DtoNeoScriptAction
