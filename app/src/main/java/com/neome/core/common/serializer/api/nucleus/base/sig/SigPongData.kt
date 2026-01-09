package com.neome.core.common.serializer.api.nucleus.base.sig

import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.nucleus.base.sig.SigPong
import kotlinx.serialization.Serializable


@Serializable
data class SigPongData(
    override val randomText: String,
    override val triggerPing: Boolean? = null
) : SigPong
