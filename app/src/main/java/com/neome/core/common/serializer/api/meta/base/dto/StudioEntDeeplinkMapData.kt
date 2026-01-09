package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDeeplink
import com.neome.api.meta.base.dto.StudioEntDeeplinkMap
import com.neome.core.common.serializer.sysId.MetaIdDeeplinkSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntDeeplinkMapData(
    override val keys: Array<@Serializable(with = MetaIdDeeplinkSer::class) Types.MetaIdDeeplink>,
    override val map: Map<@Serializable(with = MetaIdDeeplinkSer::class) Types.MetaIdDeeplink, StudioEntDeeplink>
) : StudioEntDeeplinkMap
