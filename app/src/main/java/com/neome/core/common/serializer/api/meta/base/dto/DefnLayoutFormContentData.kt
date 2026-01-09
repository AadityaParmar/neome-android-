package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnFormLayoutType
import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnShowBorderRadiusKind
import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoLayoutFormContentItem
import com.neome.api.meta.base.dto.DefnLayoutForm
import com.neome.api.meta.base.dto.DefnLayoutFormContent
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnLayoutFormContentData(
    @Serializable(with = MetaIdLayoutFormSer::class) override val metaId: Types.MetaIdLayoutForm,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val type: EnumDefnFormLayoutType? = null,
    override val allowToSwitchLayoutIdSet: Array<@Serializable(with = MetaIdLayoutFormSer::class) Types.MetaIdLayoutForm>? = null,
    override val backgroundColor: DefnDtoColor? = null,
    override val backgroundColorVar: DefnDtoColor? = null,
    override val borderColor: DefnDtoColor? = null,
    override val borderColorVar: DefnDtoColor? = null,
    override val borderPositionSet: Array<EnumDefnShowBorderKind>? = null,
    override val borderRadiusSet: Array<EnumDefnShowBorderRadiusKind>? = null,
    override val borderRadiusSize: EnumDefnThemeDividerKind? = null,
    override val direction: EnumDefnThemeDirection? = null,
    override val displayLabel: String? = null,
    override val end: DefnDtoLayoutFormContentItem? = null,
    override val flexCenter: DefnDtoLayoutFormContentItem? = null,
    override val paddingPositionSet: Array<EnumDefnShowBorderKind>? = null,
    override val paddingSize: EnumDefnThemeDividerKind? = null,
    override val renderingMode: EnumDefnRenderingKind? = null,
    override val start: DefnDtoLayoutFormContentItem? = null
) : DefnLayoutFormContent
