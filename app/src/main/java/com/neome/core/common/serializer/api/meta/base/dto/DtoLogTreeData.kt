package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogItemType
import com.neome.api.meta.base.dto.DtoLogItem
import com.neome.api.meta.base.dto.DtoLogTree
import com.neome.api.meta.base.dto.DtoLogTreeItem
import com.neome.core.common.serializer.api.meta.base.dto.DtoLogTreeItemData
import kotlinx.serialization.Serializable


@Serializable
data class DtoLogTreeData(
    override val id: String,
    override val type: EnumLogItemType,
    override val bgColor: String,
    override val children: List<DtoLogTreeItemData>? = null,
    override val keyColor: String,
    override val keyWidth: Long,
    override val lineColor: String,
    override val tabWidth: Long,
    override val valueColor: String
) : DtoLogTree
