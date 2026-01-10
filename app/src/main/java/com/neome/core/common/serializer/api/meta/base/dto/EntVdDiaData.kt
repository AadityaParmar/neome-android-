package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdDia
import com.neome.api.meta.base.dto.EntVdNote
import com.neome.api.meta.base.dto.EntVdRegion
import com.neome.api.meta.base.dto.EntVdViewport
import com.neome.api.meta.base.dto.StudioBase
import com.neome.core.common.serializer.api.meta.base.dto.EntVdNoteData
import com.neome.core.common.serializer.api.meta.base.dto.EntVdRegionData
import com.neome.core.common.serializer.api.meta.base.dto.EntVdViewportData
import com.neome.core.common.serializer.sysId.MetaIdModuleSer
import com.neome.core.common.serializer.sysId.MetaIdVdNoteSer
import com.neome.core.common.serializer.sysId.MetaIdVdRegionSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdDiaData(
    override val isDefault: Boolean? = null,
    @Serializable(with = MetaIdModuleSer::class) override val moduleId: Types.MetaIdModule? = null,
    override val noteMap: Map<@Serializable(with = MetaIdVdNoteSer::class) Types.MetaIdVdNote, EntVdNoteData>,
    override val regionMap: Map<@Serializable(with = MetaIdVdRegionSer::class) Types.MetaIdVdRegion, EntVdRegionData>,
    override val viewport: EntVdViewportData? = null
) : EntVdDia
