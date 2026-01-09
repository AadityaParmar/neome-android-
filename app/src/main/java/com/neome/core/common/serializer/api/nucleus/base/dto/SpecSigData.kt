package com.neome.core.common.serializer.api.nucleus.base.dto

import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.dto.SpecSig
import kotlinx.serialization.Serializable


@Serializable
data class SpecSigData(
    override val module: String,
    override val serverPush: Boolean,
    override val serviceName: ServiceName
) : SpecSig
