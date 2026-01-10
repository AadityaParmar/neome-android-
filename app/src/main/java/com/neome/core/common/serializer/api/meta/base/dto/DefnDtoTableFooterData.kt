package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoTableFooter
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoColorData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFooterSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoTableFooterData(
    override val alignment: EnumDefnPlacement? = null,
    override val bgColor: DefnDtoColorData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val displayFieldId: Types.MetaIdField,
    override val fieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>,
    @Serializable(with = MetaIdFooterSer::class) override val metaId: Types.MetaIdFooter,
    override val showLabel: Boolean? = null,
    override val textColor: DefnDtoColorData? = null,
    override val textSize: EnumDefnTextSize? = null,
    override val textStyleSet: List<EnumDefnTextStyle>? = null
) : DefnDtoTableFooter
