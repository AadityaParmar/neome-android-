package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.dto.DefnFieldLabel
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
sealed interface DefnFieldLabelSeal : DefnFieldLabel


@Serializable
data class DefnFieldLabelData(
    override val disabled: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val disabledFieldId: Types.MetaIdField? = null,
    override val disabledRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val disabledVar: Boolean? = null,
    override val hidden: Boolean? = null,
    override val hideDirtyIndicator: Boolean? = null,
    override val invisible: Boolean? = null,
    override val label: String? = null,
    override val maxWidth: Long? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val pb: Long? = null,
    override val permissionMatrix: DefnDtoPermissionMatrix? = null,
    override val pl: Long? = null,
    override val pr: Long? = null,
    override val pt: Long? = null,
    override val readOnly: Boolean? = null,
    override val type: EnumDefnCompType,
    @Serializable(with = MetaIdFieldSer::class) override val metaId: Types.MetaIdField,
    override val bgColor: DefnDtoColor? = null,
    override val bgColorVar: DefnDtoColor? = null,
    override val bold: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val boldFieldId: Types.MetaIdField? = null,
    override val boldVar: Boolean? = null,
    override val colorVar: DefnDtoColor? = null,
    override val italic: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val italicFieldId: Types.MetaIdField? = null,
    override val italicVar: Boolean? = null,
    override val justifyText: EnumDefnPlacement? = null,
    override val justifyTextVar: EnumDefnPlacement? = null,
    override val opacity: Long? = null,
    @Serializable(with = MetaIdFieldSer::class) override val opacityFieldId: Types.MetaIdField? = null,
    override val opacityVar: Long? = null,
    override val strikeThrough: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val strikeThroughFieldId: Types.MetaIdField? = null,
    override val strikeThroughVar: Boolean? = null,
    override val textPattern: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val textPatternFieldId: Types.MetaIdField? = null,
    override val textPatternVar: DefnDtoText? = null,
    override val textSize: EnumDefnTextSize? = null,
    @Serializable(with = MetaIdFieldSer::class) override val textSizeFieldId: Types.MetaIdField? = null,
    override val textSizeVar: EnumDefnTextSize? = null,
    override val underline: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val underlineFieldId: Types.MetaIdField? = null,
    override val underlineVar: Boolean? = null
) : DefnCompSeal, DefnFieldLabel
