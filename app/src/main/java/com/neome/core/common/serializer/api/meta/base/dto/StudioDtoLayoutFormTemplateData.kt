package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnFormLayoutType
import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.dto.StudioDtoLayoutForm
import com.neome.api.meta.base.dto.StudioDtoLayoutFormFooter
import com.neome.api.meta.base.dto.StudioDtoLayoutFormHeader
import com.neome.api.meta.base.dto.StudioDtoLayoutFormTemplate
import com.neome.api.meta.base.dto.StudioDtoLayoutFormWatermark
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutFormTemplateData(
    override val description: String? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val metaId: Types.MetaIdLayoutForm,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val type: EnumDefnFormLayoutType? = null,
    override val borderPositionSet: Array<EnumDefnShowBorderKind>? = null,
    override val footer: StudioDtoLayoutFormFooter? = null,
    override val header: StudioDtoLayoutFormHeader? = null,
    override val paddingPositionSet: Array<EnumDefnShowBorderKind>? = null,
    override val paddingSize: EnumDefnThemeDividerKind? = null,
    override val paperHeight: Long? = null,
    override val paperSize: EnumDefnRenderingKind? = null,
    override val paperWidth: Long? = null,
    override val watermark: StudioDtoLayoutFormWatermark? = null
) : StudioDtoLayoutFormTemplate
