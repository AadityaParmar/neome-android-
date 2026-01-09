package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioDtoTableHeader
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdHeaderSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoTableHeaderData(
    override val bgColor: StudioDtoColor? = null,
    override val displayText: String,
    override val fieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>,
    @Serializable(with = MetaIdHeaderSer::class) override val metaId: Types.MetaIdHeader,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val textColor: StudioDtoColor? = null,
    override val textSize: EnumDefnTextSize? = null,
    override val textStyleSet: Array<EnumDefnTextStyle>? = null
) : StudioDtoTableHeader
