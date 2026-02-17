package com.neome.core.common.serializer.api.home.main.sig

import com.neome.api.home.main.sig.SigMediaList
import com.neome.api.home.main.sig.SigMessageBase
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.home.main.sig.SigMessageBaseData
import kotlinx.serialization.Serializable


@Serializable
data class SigMediaListData(
    override val documentList: List<SigMessageBaseData>,
    override val linkList: List<SigMessageBaseData>,
    override val mediaCount: Long,
    override val mediaList: List<SigMessageBaseData>
) : SigMediaList
