package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogItemType
import com.neome.api.meta.base.Types.EnumLogTableTextStyle
import com.neome.api.meta.base.dto.DtoLogItem
import com.neome.api.meta.base.dto.DtoLogTable
import com.neome.api.meta.base.dto.DtoLogTableCellHeader
import com.neome.api.meta.base.dto.DtoLogTableRow
import kotlinx.serialization.Serializable


@Serializable
data class DtoLogTableData(
    override val id: String,
    override val type: EnumLogItemType,
    override val header: Array<DtoLogTableCellHeader>? = null,
    override val headerBgColor: String,
    override val headerColor: String,
    override val headerStyle: EnumLogTableTextStyle,
    override val label: String? = null,
    override val rowBgColor: String,
    override val rowColor: String,
    override val rowStyle: EnumLogTableTextStyle,
    override val rows: Array<DtoLogTableRow>? = null,
    override val showRows: Long? = null
) : DtoLogTable
