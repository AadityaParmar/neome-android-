package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnConditionOperator
import com.neome.api.meta.base.Types.EnumDefnContentAlignment
import com.neome.api.meta.base.Types.EnumDefnDriveSheetFieldLayoutOn
import com.neome.api.meta.base.Types.EnumDefnDriveSheetLayoutFor
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoLayoutDriveSheet
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoColorData
import com.neome.core.common.serializer.api.meta.base.dto.StudioBuildArgBinderData
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutDriveSheetSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutDriveSheetData(
    override val alignment: EnumDefnContentAlignment? = null,
    override val bgColor: DefnDtoColorData? = null,
    override val borderSet: List<EnumDefnShowBorderKind>? = null,
    @Serializable(with = MetaIdCompositeSer::class) override val compositeId: Types.MetaIdComposite? = null,
    override val conditionOperator: EnumDefnConditionOperator? = null,
    override val conditionValue: StudioBuildArgBinderData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val fieldId: Types.MetaIdField? = null,
    override val fieldLayoutOn: EnumDefnDriveSheetFieldLayoutOn? = null,
    override val fontSize: Long? = null,
    override val layoutFor: EnumDefnDriveSheetLayoutFor,
    @Serializable(with = MetaIdLayoutDriveSheetSer::class) override val metaId: Types.MetaIdLayoutDriveSheet,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val textColor: DefnDtoColorData? = null,
    override val textStyleSet: List<EnumDefnTextStyle>? = null,
    override val width: Long? = null
) : StudioDtoLayoutDriveSheet
