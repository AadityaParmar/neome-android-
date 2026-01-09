package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAutoXform
import com.neome.api.meta.base.dto.AutoXform
import com.neome.api.meta.base.dto.AutoXformStringIsEmail
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import kotlinx.serialization.Serializable


@Serializable
data class AutoXformStringIsEmailData(
    override val kind: EnumDefnKindAutoXform? = null,
    override val outputField: StudioDtoArgValueParameter? = null,
    override val sourceField: StudioBuildArgBinder? = null
) : AutoXformStringIsEmail
