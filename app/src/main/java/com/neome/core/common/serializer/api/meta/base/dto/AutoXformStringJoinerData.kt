package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAutoXform
import com.neome.api.meta.base.dto.AutoXform
import com.neome.api.meta.base.dto.AutoXformStringJoiner
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioMapOfArgBinder
import com.neome.core.common.serializer.api.meta.base.dto.StudioBuildArgBinderData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueParameterData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfArgBinderData
import kotlinx.serialization.Serializable


@Serializable
data class AutoXformStringJoinerData(
    override val kind: EnumDefnKindAutoXform? = null,
    override val outputField: StudioDtoArgValueParameterData? = null,
    override val separator: StudioBuildArgBinderData? = null,
    override val sourceFieldMap: StudioMapOfArgBinderData? = null
) : AutoXformStringJoiner
