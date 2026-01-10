package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioDtoLayoutCardItemLineSegment
import com.neome.api.meta.base.dto.StudioValueVarIdText
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoColorData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdTextData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutCardItemLineSegmentData(
    override val color: StudioDtoColorData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val colorFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val colorVarId: Types.MetaIdVar? = null,
    override val line: String? = null,
    override val lineFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val lineVarId: StudioValueVarIdTextData? = null,
    override val showLabels: Boolean? = null,
    override val textSize: EnumDefnTextSize? = null,
    @Serializable(with = MetaIdFieldSer::class) override val textSizeFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val textSizeVarId: Types.MetaIdVar? = null
) : StudioDtoLayoutCardItemLineSegment
