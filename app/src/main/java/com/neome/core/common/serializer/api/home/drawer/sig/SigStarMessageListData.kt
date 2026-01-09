package com.neome.core.common.serializer.api.home.drawer.sig

import com.neome.api.home.base.dto.DtoStarMessage
import com.neome.api.home.drawer.sig.SigStarMessageList
import com.neome.api.nucleus.base.sig.SigVersion
import kotlinx.serialization.Serializable


@Serializable
data class SigStarMessageListData(
    override val version: String,
    override val starMessageList: Array<DtoStarMessage>
) : SigStarMessageList
