package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoSwimlane
import com.neome.api.meta.base.dto.StudioMapOfSwimlane
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoSwimlaneData
import com.neome.core.common.serializer.sysId.MetaIdSwimlaneSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfSwimlaneData(
    override val keys: List<@Serializable(with = MetaIdSwimlaneSer::class) Types.MetaIdSwimlane>? = null,
    override val map: Map<@Serializable(with = MetaIdSwimlaneSer::class) Types.MetaIdSwimlane, StudioDtoSwimlaneData>
) : StudioMapOfSwimlane
