package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoTableHeader
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdHeaderSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoTableHeaderData(
    override val bgColor: DefnDtoColor? = null,
    override val displayText: String,
    override val fieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>,
    @Serializable(with = MetaIdHeaderSer::class) override val metaId: Types.MetaIdHeader,
    override val textColor: DefnDtoColor? = null,
    override val textSize: EnumDefnTextSize? = null,
    override val textStyleSet: Array<EnumDefnTextStyle>? = null
) : DefnDtoTableHeader
