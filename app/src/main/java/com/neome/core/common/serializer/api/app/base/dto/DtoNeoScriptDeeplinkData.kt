package com.neome.core.common.serializer.api.app.base.dto

import com.neome.api.app.base.Types.EnumKindNeoScript
import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.app.base.dto.DtoNeoScriptDeeplink
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdDeeplinkSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoNeoScriptDeeplinkData(
    override val kind: EnumKindNeoScript,
    @Serializable(with = MetaIdDeeplinkSer::class) override val deeplinkId: Types.MetaIdDeeplink? = null
) : DtoNeoScriptDeeplink
