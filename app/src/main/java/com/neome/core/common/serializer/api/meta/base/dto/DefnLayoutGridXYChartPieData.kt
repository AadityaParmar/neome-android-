package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnLayoutGridKind
import com.neome.api.meta.base.dto.DefnLayoutGridXYChart
import com.neome.api.meta.base.dto.DefnLayoutGridXYChartPie
import com.neome.api.meta.base.dto.DefnStudioMapOfChartXAxis
import com.neome.api.meta.base.dto.DefnStudioMapOfChartYAxis
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnLayoutGridXYChartPieData(
    override val allowToSwitchLayoutIdSet: Array<@Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid>? = null,
    @Serializable(with = MetaIdFieldSer::class) override val bgColorFieldId: Types.MetaIdField? = null,
    override val description: String? = null,
    override val kind: EnumDefnLayoutGridKind,
    override val label: String? = null,
    @Serializable(with = MetaIdLayoutGridSer::class) override val metaId: Types.MetaIdLayoutGrid,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    @Serializable(with = MetaIdFieldSer::class) override val toolTipFieldId: Types.MetaIdField? = null,
    override val hideLegend: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val xAxis: Types.MetaIdField,
    override val xAxisMap: DefnStudioMapOfChartXAxis? = null,
    override val yAxisMap: DefnStudioMapOfChartYAxis? = null,
    override val alwaysShowSliceValues: Boolean? = null
) : DefnLayoutGridXYChartPie
