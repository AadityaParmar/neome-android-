package com.neome.core.common.serializer.api.core.deeplink.sig

import com.neome.api.core.deeplink.sig.SigUrl
import com.neome.api.core.deeplink.sig.SigUrlPassword
import kotlinx.serialization.Serializable


@Serializable
data class SigUrlPasswordData(
    override val url: String,
    override val password: String? = null
) : SigUrlPassword
