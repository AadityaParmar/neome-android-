package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnEventAction
import com.neome.api.meta.base.dto.DefnEventActionHolder
import com.neome.core.common.serializer.api.meta.base.dto.DefnEventActionData
import com.neome.core.common.serializer.sysId.MetaIdFormEventActionSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnEventActionHolderData(
    override val map: Map<@Serializable(with = MetaIdFormEventActionSer::class) Types.MetaIdFormEventAction, DefnEventActionData>? = null
) : DefnEventActionHolder
