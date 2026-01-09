package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.DtoLogTableCell
import com.neome.api.meta.base.dto.DtoLogTableRow
import kotlinx.serialization.Serializable


@Serializable
data class DtoLogTableRowData(
    override val cellArray: Array<DtoLogTableCell>? = null
) : DtoLogTableRow
