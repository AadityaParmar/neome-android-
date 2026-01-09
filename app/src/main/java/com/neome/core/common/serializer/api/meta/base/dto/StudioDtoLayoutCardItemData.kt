package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnThemeImageRenderingMode
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioDtoLayoutCardItem
import com.neome.api.meta.base.dto.StudioDtoLayoutCardItemLine
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutCardItemData(
    override val fifthLine: StudioDtoLayoutCardItemLine? = null,
    override val firstLine: StudioDtoLayoutCardItemLine? = null,
    override val fourthLine: StudioDtoLayoutCardItemLine? = null,
    override val imageBackgroundColor: StudioDtoColor? = null,
    @Serializable(with = MetaIdVarSer::class) override val imageCornerVarId: Types.MetaIdVar? = null,
    override val imageHeight: Long? = null,
    @Serializable(with = MetaIdVarSer::class) override val imageHeightVarId: Types.MetaIdVar? = null,
    override val imageRenderingMode: EnumDefnThemeImageRenderingMode? = null,
    override val imageWidth: Long? = null,
    @Serializable(with = MetaIdVarSer::class) override val imageWidthVarId: Types.MetaIdVar? = null,
    override val mediaFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val mediaVarIdSet: Array<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar>? = null,
    override val secondLine: StudioDtoLayoutCardItemLine? = null,
    override val thirdLine: StudioDtoLayoutCardItemLine? = null
) : StudioDtoLayoutCardItem
