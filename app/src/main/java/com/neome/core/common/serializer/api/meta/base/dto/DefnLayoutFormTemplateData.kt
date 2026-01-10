package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnFormLayoutType
import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.dto.DefnLayoutForm
import com.neome.api.meta.base.dto.DefnLayoutFormFooter
import com.neome.api.meta.base.dto.DefnLayoutFormHeader
import com.neome.api.meta.base.dto.DefnLayoutFormTemplate
import com.neome.api.meta.base.dto.DefnLayoutFormWatermark
import com.neome.core.common.serializer.api.meta.base.dto.DefnLayoutFormFooterData
import com.neome.core.common.serializer.api.meta.base.dto.DefnLayoutFormHeaderData
import com.neome.core.common.serializer.api.meta.base.dto.DefnLayoutFormWatermarkData
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnLayoutFormTemplateData(
    @Serializable(with = MetaIdLayoutFormSer::class) override val metaId: Types.MetaIdLayoutForm,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val type: EnumDefnFormLayoutType? = null,
    override val borderPositionSet: List<EnumDefnShowBorderKind>? = null,
    override val footer: DefnLayoutFormFooterData? = null,
    override val header: DefnLayoutFormHeaderData? = null,
    override val paddingPositionSet: List<EnumDefnShowBorderKind>? = null,
    override val paddingSize: EnumDefnThemeDividerKind? = null,
    override val paperHeight: Long? = null,
    override val paperSize: EnumDefnRenderingKind? = null,
    override val paperWidth: Long? = null,
    override val watermark: DefnLayoutFormWatermarkData? = null
) : DefnLayoutFormTemplate
