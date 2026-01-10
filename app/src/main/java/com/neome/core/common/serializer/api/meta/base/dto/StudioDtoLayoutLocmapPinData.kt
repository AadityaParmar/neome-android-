package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnMapPinShape
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioDtoLayoutLocmapPin
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph
import com.neome.api.meta.base.dto.StudioValueVarIdText
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoImageData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoColorData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdParagraphData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdTextData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutLocmapPinData(
    override val avatar: FieldDtoImageData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val avatarFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val avatarVarId: Types.MetaIdVar? = null,
    override val color: StudioDtoColorData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val colorFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val colorVarId: Types.MetaIdVar? = null,
    override val label: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val labelFieldId: Types.MetaIdField? = null,
    override val labelVarId: StudioValueVarIdTextData? = null,
    override val shape: EnumDefnMapPinShape? = null,
    @Serializable(with = MetaIdFieldSer::class) override val shapeFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val shapeVarId: Types.MetaIdVar? = null,
    override val toolTip: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val toolTipFieldId: Types.MetaIdField? = null,
    override val toolTipVarId: StudioValueVarIdParagraphData? = null
) : StudioDtoLayoutLocmapPin
