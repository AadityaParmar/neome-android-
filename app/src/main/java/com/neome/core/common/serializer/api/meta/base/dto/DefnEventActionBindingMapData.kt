package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnEventActionBinding
import com.neome.api.meta.base.dto.DefnEventActionBindingMap
import com.neome.core.common.serializer.api.meta.base.dto.DefnEventActionBindingData
import com.neome.core.common.serializer.sysId.MetaIdFormEventActionBindingSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnEventActionBindingMapData(
    override val keys: List<@Serializable(with = MetaIdFormEventActionBindingSer::class) Types.MetaIdFormEventActionBinding>,
    override val map: Map<@Serializable(with = MetaIdFormEventActionBindingSer::class) Types.MetaIdFormEventActionBinding, DefnEventActionBindingData>
) : DefnEventActionBindingMap
