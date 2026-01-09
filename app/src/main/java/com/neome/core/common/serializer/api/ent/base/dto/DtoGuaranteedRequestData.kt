package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.Types.EnumGuaranteedRequestType
import com.neome.api.ent.base.dto.DtoGuaranteedRequest
import kotlinx.serialization.Serializable


@Serializable
data class DtoGuaranteedRequestData(
    override val type: EnumGuaranteedRequestType
) : DtoGuaranteedRequest
