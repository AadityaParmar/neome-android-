package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEventActionBinding
import com.neome.api.meta.base.dto.StudioEventActionBindingMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioEventActionBindingData
import com.neome.core.common.serializer.sysId.MetaIdFormEventActionBindingSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEventActionBindingMapData(
    override val keys: List<@Serializable(with = MetaIdFormEventActionBindingSer::class) Types.MetaIdFormEventActionBinding>,
    override val map: Map<@Serializable(with = MetaIdFormEventActionBindingSer::class) Types.MetaIdFormEventActionBinding, StudioEventActionBindingData>
) : StudioEventActionBindingMap
