package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoLayoutCardItem
import com.neome.api.meta.base.dto.DefnDtoLayoutOverlaySpreadsheet
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoLayoutOverlaySpreadsheetData(
    override val item: DefnDtoLayoutCardItem? = null
) : DefnDtoLayoutOverlaySpreadsheet
