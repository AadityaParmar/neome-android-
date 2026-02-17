package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindFormEvent
import com.neome.api.meta.base.dto.DefnEventActionBindingMap
import com.neome.api.meta.base.dto.DefnFormEvent
import com.neome.core.common.serializer.api.meta.base.dto.DefnEventActionBindingMapData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormEventSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnFormEventData(
    override val actionBindingMap: DefnEventActionBindingMapData? = null,
    override val eventFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val kind: EnumDefnKindFormEvent,
    @Serializable(with = MetaIdFormEventSer::class) override val metaId: Types.MetaIdFormEvent,
    @Serializable(with = SymbolSer::class) override val name: Symbol
) : DefnFormEvent
