package com.neome.core.common.serializer.api.home.drawer.sig

import com.neome.api.home.base.dto.DtoRecentItem
import com.neome.api.home.drawer.sig.SigRecentList
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigRecentListData(
    override val recentList: Array<DtoRecentItem>,
    override val version: String? = null
) : SigRecentList
