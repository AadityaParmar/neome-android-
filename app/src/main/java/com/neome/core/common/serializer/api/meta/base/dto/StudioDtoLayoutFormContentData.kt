package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnFormLayoutType
import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderRadiusKind
import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioDtoLayoutForm
import com.neome.api.meta.base.dto.StudioDtoLayoutFormContent
import com.neome.api.meta.base.dto.StudioDtoLayoutFormContentItem
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutFormContentData(
    override val description: String? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val metaId: Types.MetaIdLayoutForm,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val type: EnumDefnFormLayoutType? = null,
    override val allowToSwitchLayoutIdSet: Array<@Serializable(with = MetaIdLayoutFormSer::class) Types.MetaIdLayoutForm>? = null,
    override val backgroundColor: StudioDtoColor? = null,
    @Serializable(with = MetaIdVarSer::class) override val backgroundColorVarId: Types.MetaIdVar? = null,
    override val borderColor: StudioDtoColor? = null,
    @Serializable(with = MetaIdVarSer::class) override val borderColorVarId: Types.MetaIdVar? = null,
    override val borderPositionSet: Array<EnumDefnShowBorderKind>? = null,
    override val borderRadiusSet: Array<EnumDefnShowBorderRadiusKind>? = null,
    override val borderRadiusSize: EnumDefnThemeDividerKind? = null,
    override val direction: EnumDefnThemeDirection? = null,
    override val displayLabel: String? = null,
    override val end: StudioDtoLayoutFormContentItem? = null,
    override val flexCenter: StudioDtoLayoutFormContentItem? = null,
    override val paddingPositionSet: Array<EnumDefnShowBorderKind>? = null,
    override val paddingSize: EnumDefnThemeDividerKind? = null,
    override val renderingMode: EnumDefnRenderingKind? = null,
    override val rootLayout: Boolean? = null,
    override val start: StudioDtoLayoutFormContentItem? = null
) : StudioDtoLayoutFormContent
