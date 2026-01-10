package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoRowIdPointer
import com.neome.core.common.serializer.api.meta.base.dto.StudioBuildArgBinderData
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoRowIdPointerData(
    override val rowId: StudioBuildArgBinderData? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null
) : StudioDtoRowIdPointer
