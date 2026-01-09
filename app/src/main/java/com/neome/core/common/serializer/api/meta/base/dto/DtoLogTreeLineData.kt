package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumFormContentPosition
import com.neome.api.meta.base.Types.EnumLogTreeItemType
import com.neome.api.meta.base.Types.EnumLogTreeLineCollapse
import com.neome.api.meta.base.dto.DtoLogTreeItem
import com.neome.api.meta.base.dto.DtoLogTreeKeyValue
import com.neome.api.meta.base.dto.DtoLogTreeLine
import kotlinx.serialization.Serializable


@Serializable
data class DtoLogTreeLineData(
    override val bgColor: String? = null,
    override val id: String,
    override val type: EnumLogTreeItemType,
    override val bold: Boolean? = null,
    override val children: Array<DtoLogTreeKeyValue>? = null,
    override val collapse: EnumLogTreeLineCollapse? = null,
    override val contentPosition: EnumFormContentPosition? = null,
    override val line: String,
    override val lineColor: String? = null
) : DtoLogTreeLine
