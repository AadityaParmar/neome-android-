package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntAction
import com.neome.api.meta.base.dto.StudioEntActionMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntActionData
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntActionMapData(
    override val keys: List<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction>,
    override val map: Map<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction, StudioEntActionData>
) : StudioEntActionMap
