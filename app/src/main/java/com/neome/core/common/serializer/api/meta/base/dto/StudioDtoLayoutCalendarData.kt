package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindDefaultCalendarView
import com.neome.api.meta.base.Types.EnumDefnLayoutGridKind
import com.neome.api.meta.base.dto.StudioDtoLayoutCalendar
import com.neome.api.meta.base.dto.StudioDtoLayoutGrid
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutCalendarData(
    override val allowToSwitchLayoutIdSet: List<@Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid>? = null,
    @Serializable(with = MetaIdFieldSer::class) override val bgColorFieldId: Types.MetaIdField? = null,
    override val description: String? = null,
    override val kind: EnumDefnLayoutGridKind,
    override val label: String? = null,
    @Serializable(with = MetaIdLayoutGridSer::class) override val metaId: Types.MetaIdLayoutGrid,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    @Serializable(with = MetaIdFieldSer::class) override val toolTipFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdFieldSer::class) override val colorFieldId: Types.MetaIdField? = null,
    override val defaultCalendarView: EnumDefnKindDefaultCalendarView? = null,
    @Serializable(with = MetaIdFieldSer::class) override val fromDateFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdFieldSer::class) override val fromTimeFieldId: Types.MetaIdField? = null,
    override val showFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdFieldSer::class) override val titleFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdFieldSer::class) override val toDateFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdFieldSer::class) override val toTimeFieldId: Types.MetaIdField? = null
) : StudioDtoLayoutCalendar
