package com.neome.core.common.serializer.api.core.deeplink.sig

import com.neome.api.core.deeplink.sig.SigDeeplinkHtml
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigDeeplinkHtmlData(
    override val content: String? = null,
    override val contentHeaders: Map<String, String>? = null,
    override val contentType: String? = null,
    override val isBase64Content: Boolean? = null
) : SigDeeplinkHtml
