package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutCardItem
import com.neome.api.meta.base.dto.StudioDtoLayoutOverlaySpreadsheet
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoLayoutCardItemData
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutOverlaySpreadsheetData(
    override val item: StudioDtoLayoutCardItemData? = null
) : StudioDtoLayoutOverlaySpreadsheet
