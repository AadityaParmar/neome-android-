package com.neome.core.common.serializer.api.home.drawer.sig

import com.neome.api.home.base.dto.DtoChatBadgeMap
import com.neome.api.home.drawer.sig.SigBadgeMap
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.api.home.base.dto.DtoChatBadgeMapData
import com.neome.core.common.serializer.sysId.EntIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigBadgeMapData(
    override val version: String,
    override val entChatBadgeMap: Map<@Serializable(with = EntIdSer::class) Types.EntId, DtoChatBadgeMapData>
) : SigBadgeMap
