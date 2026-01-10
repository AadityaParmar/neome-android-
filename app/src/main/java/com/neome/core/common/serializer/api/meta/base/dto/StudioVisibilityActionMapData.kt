package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioVisibilityAction
import com.neome.api.meta.base.dto.StudioVisibilityActionMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioVisibilityActionData
import com.neome.core.common.serializer.sysId.MetaIdVisibilityActionSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVisibilityActionMapData(
    override val keys: List<@Serializable(with = MetaIdVisibilityActionSer::class) Types.MetaIdVisibilityAction>,
    override val map: Map<@Serializable(with = MetaIdVisibilityActionSer::class) Types.MetaIdVisibilityAction, StudioVisibilityActionData>
) : StudioVisibilityActionMap
