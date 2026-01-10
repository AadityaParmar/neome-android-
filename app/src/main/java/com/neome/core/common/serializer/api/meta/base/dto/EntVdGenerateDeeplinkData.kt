package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAutoNode
import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.dto.EntVdGenerateDeeplink
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.Size
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioValueParagraph
import com.neome.core.common.serializer.api.meta.base.dto.PointData
import com.neome.core.common.serializer.api.meta.base.dto.SizeData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueParameterData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueParagraphData
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdDeeplinkSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoNodeSer
import com.neome.core.common.serializer.sysId.MetaIdVdRegionSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdGenerateDeeplinkData(
    override val uiVersion: String? = null,
    override val kind: EnumDefnKindAutoNode,
    override val logMsg: StudioValueParagraphData? = null,
    @Serializable(with = MetaIdVdAutoNodeSer::class) override val metaId: Types.MetaIdVdAutoNode,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    @Serializable(with = MetaIdVdRegionSer::class) override val parentRegionId: Types.MetaIdVdRegion? = null,
    override val point: PointData? = null,
    override val size: SizeData? = null,
    @Serializable(with = MetaIdDeeplinkSer::class) override val deeplinkId: Types.MetaIdDeeplink? = null,
    override val outputField: StudioDtoArgValueParameterData? = null,
    @Serializable(with = MetaIdActionSer::class) override val spreadsheetEditorActionId: Types.MetaIdAction? = null
) : EntVdGenerateDeeplink
