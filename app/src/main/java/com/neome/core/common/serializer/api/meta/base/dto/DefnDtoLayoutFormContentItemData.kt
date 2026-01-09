package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoLayoutFormContentItem
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoLayoutFormContentItemData(
    override val borderColorVar: DefnDtoColor? = null,
    override val borderPositionSet: Array<EnumDefnShowBorderKind>? = null,
    override val fieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val formLayoutIdSet: Array<@Serializable(with = MetaIdLayoutFormSer::class) Types.MetaIdLayoutForm>? = null,
    override val gridLayoutIdSet: Array<@Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid>? = null,
    override val paddingPositionSet: Array<EnumDefnShowBorderKind>? = null,
    override val paddingSize: EnumDefnThemeDividerKind? = null,
    override val showGridSwitcher: Array<@Serializable(with = MetaIdGridSer::class) Types.MetaIdGrid>? = null
) : DefnDtoLayoutFormContentItem
