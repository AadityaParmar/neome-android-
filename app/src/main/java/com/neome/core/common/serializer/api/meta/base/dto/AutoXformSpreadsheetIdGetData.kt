package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAutoXform
import com.neome.api.meta.base.dto.AutoXform
import com.neome.api.meta.base.dto.AutoXformSpreadsheetIdGet
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueParameterData
import kotlinx.serialization.Serializable


@Serializable
data class AutoXformSpreadsheetIdGetData(
    override val kind: EnumDefnKindAutoXform? = null,
    override val source: StudioDtoArgValueParameterData? = null,
    override val target: StudioDtoArgValueParameterData? = null
) : AutoXformSpreadsheetIdGet
