package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogItemType
import com.neome.api.meta.base.dto.DtoLogItem
import kotlinx.serialization.Serializable


@Serializable
data class DtoLogItemData(
    override val id: String,
    override val type: EnumLogItemType
) : DtoLogItem
