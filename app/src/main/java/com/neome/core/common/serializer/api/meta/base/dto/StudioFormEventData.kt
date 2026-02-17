package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindFormEvent
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEventActionBindingMap
import com.neome.api.meta.base.dto.StudioFormEvent
import com.neome.core.common.serializer.api.meta.base.dto.StudioEventActionBindingMapData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormEventSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioFormEventData(
    override val actionBindingMap: StudioEventActionBindingMapData? = null,
    override val eventFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val kind: EnumDefnKindFormEvent,
    @Serializable(with = MetaIdFormEventSer::class) override val metaId: Types.MetaIdFormEvent,
    @Serializable(with = SymbolSer::class) override val name: Symbol
) : StudioFormEvent
