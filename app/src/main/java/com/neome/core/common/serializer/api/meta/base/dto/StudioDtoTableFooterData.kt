package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioDtoTableFooter
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoColorData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFooterSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoTableFooterData(
    override val alignment: EnumDefnPlacement? = null,
    override val bgColor: StudioDtoColorData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val displayFieldId: Types.MetaIdField? = null,
    override val fieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>,
    @Serializable(with = MetaIdFooterSer::class) override val metaId: Types.MetaIdFooter,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val showLabel: Boolean? = null,
    override val textColor: StudioDtoColorData? = null,
    override val textSize: EnumDefnTextSize? = null,
    override val textStyleSet: List<EnumDefnTextStyle>? = null
) : StudioDtoTableFooter
