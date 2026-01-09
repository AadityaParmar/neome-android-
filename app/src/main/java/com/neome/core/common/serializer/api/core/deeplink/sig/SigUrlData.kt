package com.neome.core.common.serializer.api.core.deeplink.sig

import com.neome.api.core.deeplink.sig.SigUrl
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigUrlData(
    override val url: String
) : SigUrl
