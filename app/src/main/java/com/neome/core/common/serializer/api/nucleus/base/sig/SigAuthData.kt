package com.neome.core.common.serializer.api.nucleus.base.sig

import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.nucleus.base.sig.SigAuth
import kotlinx.serialization.Serializable


@Serializable
data class SigAuthData(
    override val unauthorizedBearerToken: Boolean
) : SigAuth
