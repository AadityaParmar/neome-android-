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
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoColorData
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoLayoutFormContentItemData
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnLayoutFormContentData(
    @Serializable(with = MetaIdLayoutFormSer::class) override val metaId: Types.MetaIdLayoutForm,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val type: EnumDefnFormLayoutType? = null,
    override val allowToSwitchLayoutIdSet: List<@Serializable(with = MetaIdLayoutFormSer::class) Types.MetaIdLayoutForm>? = null,
    override val backgroundColor: DefnDtoColorData? = null,
    override val backgroundColorVar: DefnDtoColorData? = null,
    override val borderColor: DefnDtoColorData? = null,
    override val borderColorVar: DefnDtoColorData? = null,
    override val borderPositionSet: List<EnumDefnShowBorderKind>? = null,
    override val borderRadiusSet: List<EnumDefnShowBorderRadiusKind>? = null,
    override val borderRadiusSize: EnumDefnThemeDividerKind? = null,
    override val direction: EnumDefnThemeDirection? = null,
    override val displayLabel: String? = null,
    override val end: DefnDtoLayoutFormContentItemData? = null,
    override val flexCenter: DefnDtoLayoutFormContentItemData? = null,
    override val paddingPositionSet: List<EnumDefnShowBorderKind>? = null,
    override val paddingSize: EnumDefnThemeDividerKind? = null,
    override val renderingMode: EnumDefnRenderingKind? = null,
    override val start: DefnDtoLayoutFormContentItemData? = null
) : DefnLayoutFormContent
