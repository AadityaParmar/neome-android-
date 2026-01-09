package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.Types.EnumStudioCompType
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioDtoPermissionMatrix
import com.neome.api.meta.base.dto.StudioFieldInfo
import com.neome.api.meta.base.dto.StudioFieldLabel
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph
import com.neome.api.meta.base.dto.StudioValueVarIdText
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioFieldInfoData(
    override val aiInstructions: String? = null,
    override val details: StudioDetails,
    override val disabled: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val disabledFieldId: Types.MetaIdField? = null,
    override val disabledRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val disabledVarId: Types.MetaIdVar? = null,
    override val permissionMatrix: StudioDtoPermissionMatrix? = null,
    override val type: EnumStudioCompType? = null,
    @Serializable(with = MetaIdFieldSer::class) override val metaId: Types.MetaIdField,
    override val bgColor: StudioDtoColor? = null,
    @Serializable(with = MetaIdVarSer::class) override val bgColorVarId: Types.MetaIdVar? = null,
    override val bold: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val boldFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val boldVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdVarSer::class) override val colorVarId: Types.MetaIdVar? = null,
    override val italic: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val italicFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val italicVarId: Types.MetaIdVar? = null,
    override val justifyText: EnumDefnPlacement? = null,
    @Serializable(with = MetaIdVarSer::class) override val justifyTextVarId: Types.MetaIdVar? = null,
    override val opacity: Long? = null,
    @Serializable(with = MetaIdFieldSer::class) override val opacityFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val opacityVarId: Types.MetaIdVar? = null,
    override val strikeThrough: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val strikeThroughFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val strikeThroughVarId: Types.MetaIdVar? = null,
    override val textPattern: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val textPatternFieldId: Types.MetaIdField? = null,
    override val textPatternVarId: StudioValueVarIdText? = null,
    override val textSize: EnumDefnTextSize? = null,
    @Serializable(with = MetaIdFieldSer::class) override val textSizeFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val textSizeVarId: Types.MetaIdVar? = null,
    override val underline: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val underlineFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val underlineVarId: Types.MetaIdVar? = null,
    override val bottomPadding: EnumDefnThemeDividerKind? = null,
    @Serializable(with = MetaIdVarSer::class) override val bottomPaddingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdFieldSer::class) override val defaultFieldId: Types.MetaIdField? = null,
    override val defaultValue: String? = null,
    override val defaultVarId: StudioValueVarIdParagraph? = null,
    override val flexGrow: Boolean? = null,
    override val labelPatternVarId: StudioValueVarIdText? = null,
    override val leftPadding: EnumDefnThemeDividerKind? = null,
    @Serializable(with = MetaIdVarSer::class) override val leftPaddingVarId: Types.MetaIdVar? = null,
    override val lineCount: Long? = null,
    @Serializable(with = MetaIdFieldSer::class) override val lineCountFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val lineCountVarId: Types.MetaIdVar? = null,
    override val rightPadding: EnumDefnThemeDividerKind? = null,
    @Serializable(with = MetaIdVarSer::class) override val rightPaddingVarId: Types.MetaIdVar? = null,
    override val showBorder: Boolean? = null,
    override val showCloseButton: Boolean? = null,
    override val showLabel: Boolean? = null,
    override val topPadding: EnumDefnThemeDividerKind? = null,
    @Serializable(with = MetaIdVarSer::class) override val topPaddingVarId: Types.MetaIdVar? = null
) : StudioFieldInfo
