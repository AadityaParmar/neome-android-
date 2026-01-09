package com.neome.core.common.serializer.api.core.user.sig

import com.neome.api.core.user.sig.SigBearerToken
import com.neome.api.core.user.sig.SigCaller
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigBearerTokenData(
    override val bearerToken: String,
    override val caller: SigCaller? = null,
    override val updateRefreshToken: Boolean
) : SigBearerToken
