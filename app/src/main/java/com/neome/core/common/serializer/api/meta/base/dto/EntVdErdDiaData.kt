package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdDia
import com.neome.api.meta.base.dto.EntVdErdDia
import com.neome.api.meta.base.dto.EntVdErdEntity
import com.neome.api.meta.base.dto.EntVdErdRef
import com.neome.api.meta.base.dto.EntVdNote
import com.neome.api.meta.base.dto.EntVdRegion
import com.neome.api.meta.base.dto.EntVdViewport
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdModuleSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdVdErdDiaSer
import com.neome.core.common.serializer.sysId.MetaIdVdNoteSer
import com.neome.core.common.serializer.sysId.MetaIdVdRegionSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdErdDiaData(
    override val isDefault: Boolean? = null,
    @Serializable(with = MetaIdModuleSer::class) override val moduleId: Types.MetaIdModule? = null,
    override val noteMap: Map<@Serializable(with = MetaIdVdNoteSer::class) Types.MetaIdVdNote, EntVdNote>,
    override val regionMap: Map<@Serializable(with = MetaIdVdRegionSer::class) Types.MetaIdVdRegion, EntVdRegion>,
    override val viewport: EntVdViewport? = null,
    override val entityMap: Map<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet, EntVdErdEntity>? = null,
    override val label: String? = null,
    @Serializable(with = MetaIdVdErdDiaSer::class) override val metaId: Types.MetaIdVdErdDia,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val refMap: Map<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField, EntVdErdRef>? = null
) : EntVdErdDia
