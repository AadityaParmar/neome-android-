package com.neome.core.common.serializer.api.core.deeplink.sig

import com.neome.api.core.deeplink.sig.SigDeeplinkPreview
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigDeeplinkPreviewData(
    override val htmlContent: String? = null
) : SigDeeplinkPreview
