package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioActionHolder
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEventAction
import com.neome.core.common.serializer.api.meta.base.dto.StudioEventActionData
import com.neome.core.common.serializer.sysId.MetaIdFormEventActionSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioActionHolderData(
    override val map: Map<@Serializable(with = MetaIdFormEventActionSer::class) Types.MetaIdFormEventAction, StudioEventActionData>? = null
) : StudioActionHolder
