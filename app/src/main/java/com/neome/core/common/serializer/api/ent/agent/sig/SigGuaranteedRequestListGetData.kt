package com.neome.core.common.serializer.api.ent.agent.sig

import com.neome.api.ent.agent.sig.SigGuaranteedRequestListGet
import com.neome.api.ent.base.dto.GuaranteedRequest
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.ent.base.dto.GuaranteedRequestData
import kotlinx.serialization.Serializable


@Serializable
data class SigGuaranteedRequestListGetData(
    override val bottomOffset: Long,
    override val list: List<GuaranteedRequestData>,
    override val pageBottomOffset: Long
) : SigGuaranteedRequestListGet
