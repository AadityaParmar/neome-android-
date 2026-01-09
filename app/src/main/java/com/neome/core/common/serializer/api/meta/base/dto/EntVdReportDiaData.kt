package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdDia
import com.neome.api.meta.base.dto.EntVdNote
import com.neome.api.meta.base.dto.EntVdRegion
import com.neome.api.meta.base.dto.EntVdReport
import com.neome.api.meta.base.dto.EntVdReportDia
import com.neome.api.meta.base.dto.EntVdReportIOForm
import com.neome.api.meta.base.dto.EntVdViewport
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdModuleSer
import com.neome.core.common.serializer.sysId.MetaIdReportSer
import com.neome.core.common.serializer.sysId.MetaIdVdNoteSer
import com.neome.core.common.serializer.sysId.MetaIdVdRegionSer
import com.neome.core.common.serializer.sysId.MetaIdVdReportDiaSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdReportDiaData(
    override val isDefault: Boolean? = null,
    @Serializable(with = MetaIdModuleSer::class) override val moduleId: Types.MetaIdModule? = null,
    override val noteMap: Map<@Serializable(with = MetaIdVdNoteSer::class) Types.MetaIdVdNote, EntVdNote>,
    override val regionMap: Map<@Serializable(with = MetaIdVdRegionSer::class) Types.MetaIdVdRegion, EntVdRegion>,
    override val viewport: EntVdViewport? = null,
    override val ioFormMap: Map<@Serializable(with = MetaIdFormSer::class) Types.MetaIdForm, EntVdReportIOForm>? = null,
    override val label: String? = null,
    @Serializable(with = MetaIdVdReportDiaSer::class) override val metaId: Types.MetaIdVdReportDia,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val reportMap: Map<@Serializable(with = MetaIdReportSer::class) Types.MetaIdReport, EntVdReport>? = null
) : EntVdReportDia
