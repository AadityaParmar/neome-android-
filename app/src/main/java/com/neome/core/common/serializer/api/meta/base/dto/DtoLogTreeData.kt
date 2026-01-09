package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogItemType
import com.neome.api.meta.base.dto.DtoLogItem
import com.neome.api.meta.base.dto.DtoLogTree
import com.neome.api.meta.base.dto.DtoLogTreeItem
import kotlinx.serialization.Serializable


@Serializable
data class DtoLogTreeData(
    override val id: String,
    override val type: EnumLogItemType,
    override val bgColor: String,
    override val children: Array<DtoLogTreeItem>? = null,
    override val keyColor: String,
    override val keyWidth: Long? = null,
    override val lineColor: String,
    override val tabWidth: Long? = null,
    override val valueColor: String
) : DtoLogTree
