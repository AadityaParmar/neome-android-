package com.neome.core.common.serializer.api.ent.entAside.sig

import com.neome.api.ent.entAside.sig.SigPluginOAuthUrl
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigPluginOAuthUrlData(
    override val oauthUrl: String
) : SigPluginOAuthUrl
