package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoGuaranteedRequest
import com.neome.api.ent.base.dto.GuaranteedRequest
import kotlinx.serialization.Serializable


@Serializable
data class GuaranteedRequestData(
    override val offset: Long? = null,
    override val payload: DtoGuaranteedRequest
) : GuaranteedRequest
