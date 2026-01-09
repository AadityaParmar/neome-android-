package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.DtoLogItem
import com.neome.api.meta.base.dto.DtoLogItemList
import kotlinx.serialization.Serializable


@Serializable
data class DtoLogItemListData(
    override val children: Array<DtoLogItem>? = null
) : DtoLogItemList
