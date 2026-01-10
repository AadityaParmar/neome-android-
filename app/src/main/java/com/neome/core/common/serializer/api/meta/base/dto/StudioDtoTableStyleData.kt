package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDriveSheetFieldLayoutOn
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioDtoTableStyle
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoColorData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdConditionData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdTableStyleSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoTableStyleData(
    override val bgColor: StudioDtoColorData? = null,
    override val conditionVarId: StudioValueVarIdConditionData? = null,
    override val fieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val fieldLayoutOn: EnumDefnDriveSheetFieldLayoutOn? = null,
    @Serializable(with = MetaIdTableStyleSer::class) override val metaId: Types.MetaIdTableStyle? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val textColor: StudioDtoColorData? = null,
    override val textSize: EnumDefnTextSize? = null,
    override val textStyleSet: List<EnumDefnTextStyle>? = null
) : StudioDtoTableStyle
