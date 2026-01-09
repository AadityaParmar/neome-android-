package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogTableTextStyle
import com.neome.api.meta.base.dto.DtoLogTableCell
import kotlinx.serialization.Serializable


@Serializable
data class DtoLogTableCellData(
    override val bgColor: String? = null,
    override val color: String? = null,
    override val style: EnumLogTableTextStyle? = null,
    override val text: String
) : DtoLogTableCell
