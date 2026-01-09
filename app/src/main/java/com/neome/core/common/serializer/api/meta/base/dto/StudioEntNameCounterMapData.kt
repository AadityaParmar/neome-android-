package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAutoNode
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntNameCounterMap
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntNameCounterMapData(
    override val vdAutoNameGenMap: Map<EnumDefnKindAutoNode, Long>
) : StudioEntNameCounterMap
