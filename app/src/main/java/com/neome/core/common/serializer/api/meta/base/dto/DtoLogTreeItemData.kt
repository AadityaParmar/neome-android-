package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogTreeItemType
import com.neome.api.meta.base.dto.DtoLogTreeItem
import kotlinx.serialization.Serializable


@Serializable
data class DtoLogTreeItemData(
    override val bgColor: String? = null,
    override val id: String,
    override val type: EnumLogTreeItemType
) : DtoLogTreeItem
