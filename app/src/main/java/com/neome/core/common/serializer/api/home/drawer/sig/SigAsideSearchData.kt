package com.neome.core.common.serializer.api.home.drawer.sig

import com.neome.api.home.drawer.sig.SigAsideSearch
import com.neome.api.home.main.sig.SigMessage
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.api.home.main.sig.SigMessageData
import kotlinx.serialization.Serializable


@Serializable
data class SigAsideSearchData(
    override val version: String,
    override val messageList: List<SigMessageData>,
    override val totalMessageCount: Long
) : SigAsideSearch
