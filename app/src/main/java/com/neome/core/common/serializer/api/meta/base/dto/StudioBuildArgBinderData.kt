package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinder
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoArgValue
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueData
import kotlinx.serialization.Serializable


@Serializable
data class StudioBuildArgBinderData(
    override val argName: String,
    override val kind: EnumDefnArgBinder,
    override val value: StudioDtoArgValueData
) : StudioBuildArgBinder
