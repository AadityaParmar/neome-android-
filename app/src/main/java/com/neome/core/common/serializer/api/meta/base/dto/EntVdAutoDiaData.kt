package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdAutoDia
import com.neome.api.meta.base.dto.EntVdAutoEdge
import com.neome.api.meta.base.dto.EntVdAutoNode
import com.neome.api.meta.base.dto.EntVdDia
import com.neome.api.meta.base.dto.EntVdNote
import com.neome.api.meta.base.dto.EntVdRegion
import com.neome.api.meta.base.dto.EntVdViewport
import com.neome.core.common.serializer.sysId.MetaIdModuleSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoDiaSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoEdgeSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoNodeSer
import com.neome.core.common.serializer.sysId.MetaIdVdNoteSer
import com.neome.core.common.serializer.sysId.MetaIdVdRegionSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdAutoDiaData(
    override val isDefault: Boolean? = null,
    @Serializable(with = MetaIdModuleSer::class) override val moduleId: Types.MetaIdModule? = null,
    override val noteMap: Map<@Serializable(with = MetaIdVdNoteSer::class) Types.MetaIdVdNote, EntVdNote>,
    override val regionMap: Map<@Serializable(with = MetaIdVdRegionSer::class) Types.MetaIdVdRegion, EntVdRegion>,
    override val viewport: EntVdViewport? = null,
    override val description: String? = null,
    override val edgeMap: Map<@Serializable(with = MetaIdVdAutoEdgeSer::class) Types.MetaIdVdAutoEdge, EntVdAutoEdge>,
    override val label: String? = null,
    @Serializable(with = MetaIdVdAutoDiaSer::class) override val metaId: Types.MetaIdVdAutoDia,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val nodeMap: Map<@Serializable(with = MetaIdVdAutoNodeSer::class) Types.MetaIdVdAutoNode, EntVdAutoNode>
) : EntVdAutoDia
