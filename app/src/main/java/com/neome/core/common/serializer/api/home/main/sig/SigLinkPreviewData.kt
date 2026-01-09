package com.neome.core.common.serializer.api.home.main.sig

import com.neome.api.home.main.sig.SigLinkPreview
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigLinkPreviewData(
    override val description: String? = null,
    override val imageUrl: String? = null,
    override val title: String
) : SigLinkPreview
