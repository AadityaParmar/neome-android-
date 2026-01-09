package com.neome.core.common.serializer.api.ent.agent.sig

import com.neome.api.ent.agent.sig.SigGuaranteedRequestListGet
import com.neome.api.ent.base.dto.GuaranteedRequest
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigGuaranteedRequestListGetData(
    override val bottomOffset: Long? = null,
    override val list: Array<GuaranteedRequest>,
    override val pageBottomOffset: Long? = null
) : SigGuaranteedRequestListGet
