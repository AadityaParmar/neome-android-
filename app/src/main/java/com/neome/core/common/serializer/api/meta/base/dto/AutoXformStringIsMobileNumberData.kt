package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAutoXform
import com.neome.api.meta.base.dto.AutoXform
import com.neome.api.meta.base.dto.AutoXformStringIsMobileNumber
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import kotlinx.serialization.Serializable


@Serializable
data class AutoXformStringIsMobileNumberData(
    override val kind: EnumDefnKindAutoXform? = null,
    override val outputField: StudioDtoArgValueParameter? = null,
    override val sourceField: StudioBuildArgBinder? = null
) : AutoXformStringIsMobileNumber
