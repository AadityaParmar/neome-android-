package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoLayoutCardItemLineSegment
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoLayoutCardItemLineSegmentData(
    override val color: DefnDtoColor? = null,
    @Serializable(with = MetaIdFieldSer::class) override val colorFieldId: Types.MetaIdField? = null,
    override val colorVar: DefnDtoColor? = null,
    override val line: String? = null,
    override val lineFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val lineVar: DefnDtoText? = null,
    override val showLabels: Boolean? = null,
    override val textSize: EnumDefnTextSize? = null,
    @Serializable(with = MetaIdFieldSer::class) override val textSizeFieldId: Types.MetaIdField? = null,
    override val textSizeVar: EnumDefnTextSize? = null
) : DefnDtoLayoutCardItemLineSegment
