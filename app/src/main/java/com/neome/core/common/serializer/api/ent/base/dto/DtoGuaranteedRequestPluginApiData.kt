package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.Types.EnumGuaranteedRequestType
import com.neome.api.ent.base.dto.DtoGuaranteedRequest
import com.neome.api.ent.base.dto.DtoGuaranteedRequestPluginApi
import com.neome.api.ent.base.dto.DtoPluginApiRequestPayload
import com.neome.core.common.serializer.api.ent.base.dto.DtoPluginApiRequestPayloadData
import kotlinx.serialization.Serializable


@Serializable
data class DtoGuaranteedRequestPluginApiData(
    override val type: EnumGuaranteedRequestType,
    override val pluginApiRequest: DtoPluginApiRequestPayloadData
) : DtoGuaranteedRequestPluginApi
