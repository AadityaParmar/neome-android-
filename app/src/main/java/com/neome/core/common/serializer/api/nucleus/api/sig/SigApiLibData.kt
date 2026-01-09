package com.neome.core.common.serializer.api.nucleus.api.sig

import com.neome.api.nucleus.api.sig.SigApiLib
import com.neome.api.nucleus.base.dto.DescApiModule
import com.neome.api.nucleus.base.dto.DescApiPushSigs
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigApiLibData(
    override val api: Map<String, DescApiModule>,
    override val pushSigs: DescApiPushSigs
) : SigApiLib
