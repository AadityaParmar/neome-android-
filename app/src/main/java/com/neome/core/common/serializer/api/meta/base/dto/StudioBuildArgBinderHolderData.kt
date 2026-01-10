package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioBuildArgBinderHolder
import com.neome.core.common.serializer.api.meta.base.dto.StudioBuildArgBinderData
import kotlinx.serialization.Serializable


@Serializable
data class StudioBuildArgBinderHolderData(
    override val argBinder: StudioBuildArgBinderData? = null
) : StudioBuildArgBinderHolder
