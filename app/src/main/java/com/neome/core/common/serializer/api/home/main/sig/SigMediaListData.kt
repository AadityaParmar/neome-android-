package com.neome.core.common.serializer.api.home.main.sig

import com.neome.api.home.main.sig.SigMediaList
import com.neome.api.home.main.sig.SigMessageBase
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigMediaListData(
    override val documentList: Array<SigMessageBase>,
    override val linkList: Array<SigMessageBase>,
    override val mediaCount: Long? = null,
    override val mediaList: Array<SigMessageBase>
) : SigMediaList
