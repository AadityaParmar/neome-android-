package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoCompiledCode
import com.neome.api.meta.base.dto.StudioMapOfArgBinder
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoCompiledCodeData(
    override val argBinderMap: StudioMapOfArgBinder? = null,
    override val value: String? = null
) : StudioDtoCompiledCode
