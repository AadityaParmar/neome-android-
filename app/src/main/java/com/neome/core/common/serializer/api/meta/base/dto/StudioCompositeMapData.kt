package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioComposite
import com.neome.api.meta.base.dto.StudioCompositeMap
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioCompositeMapData(
    override val keys: Array<@Serializable(with = MetaIdCompositeSer::class) Types.MetaIdComposite>,
    override val map: Map<@Serializable(with = MetaIdCompositeSer::class) Types.MetaIdComposite, StudioComposite>
) : StudioCompositeMap
