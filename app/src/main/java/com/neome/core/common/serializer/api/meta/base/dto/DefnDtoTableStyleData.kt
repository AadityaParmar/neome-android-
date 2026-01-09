package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDriveSheetFieldLayoutOn
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoTableStyle
import com.neome.api.meta.base.dto.DefnStudioDtoCondition
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdTableStyleSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoTableStyleData(
    override val bgColor: DefnDtoColor? = null,
    override val conditionVar: DefnStudioDtoCondition? = null,
    override val fieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val fieldLayoutOn: EnumDefnDriveSheetFieldLayoutOn? = null,
    @Serializable(with = MetaIdTableStyleSer::class) override val metaId: Types.MetaIdTableStyle? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val textColor: DefnDtoColor? = null,
    override val textSize: EnumDefnTextSize? = null,
    override val textStyleSet: Array<EnumDefnTextStyle>? = null
) : DefnDtoTableStyle
