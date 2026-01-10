package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnMapPinShape
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoLayoutLocmapPin
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoColorData
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoParagraphData
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoTextData
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoImageData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoLayoutLocmapPinData(
    override val avatar: FieldDtoImageData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val avatarFieldId: Types.MetaIdField? = null,
    override val avatarVar: FieldDtoImageData? = null,
    override val color: DefnDtoColorData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val colorFieldId: Types.MetaIdField? = null,
    override val colorVar: DefnDtoColorData? = null,
    override val label: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val labelFieldId: Types.MetaIdField? = null,
    override val labelVar: DefnDtoTextData? = null,
    override val shape: EnumDefnMapPinShape? = null,
    @Serializable(with = MetaIdFieldSer::class) override val shapeFieldId: Types.MetaIdField? = null,
    override val shapeVar: EnumDefnMapPinShape? = null,
    override val toolTip: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val toolTipFieldId: Types.MetaIdField? = null,
    override val toolTipVar: DefnDtoParagraphData? = null
) : DefnDtoLayoutLocmapPin
