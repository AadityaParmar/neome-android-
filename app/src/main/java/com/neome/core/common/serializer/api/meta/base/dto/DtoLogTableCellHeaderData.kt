package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogTableAlignment
import com.neome.api.meta.base.Types.EnumLogTableTextStyle
import com.neome.api.meta.base.dto.DtoLogTableCell
import com.neome.api.meta.base.dto.DtoLogTableCellHeader
import kotlinx.serialization.Serializable


@Serializable
data class DtoLogTableCellHeaderData(
    override val bgColor: String? = null,
    override val color: String? = null,
    override val style: EnumLogTableTextStyle? = null,
    override val text: String,
    override val flexWeight: Long? = null,
    override val headerAlignment: EnumLogTableAlignment? = null,
    override val rowAlignment: EnumLogTableAlignment? = null
) : DtoLogTableCellHeader
