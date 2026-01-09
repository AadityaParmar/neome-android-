package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.dto.DtoGroupMemberMetaData
import kotlinx.serialization.Serializable


@Serializable
data class DtoGroupMemberMetaDataData(
    override val date: String
) : DtoGroupMemberMetaData
