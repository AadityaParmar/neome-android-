package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCodeEditorLanguage
import com.neome.api.meta.base.Types.EnumStudioCompType
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioDtoPermissionMatrix
import com.neome.api.meta.base.dto.StudioFieldCodeEditor
import com.neome.api.meta.base.dto.StudioFieldParagraph
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph
import com.neome.api.meta.base.dto.StudioValueVarIdText
import com.neome.core.common.serializer.api.meta.base.dto.StudioDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoPermissionMatrixData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdParagraphData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdTextData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioFieldCodeEditorData(
    override val aiInstructions: String? = null,
    override val details: StudioDetailsData,
    override val disabled: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val disabledFieldId: Types.MetaIdField? = null,
    override val disabledRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val disabledVarId: Types.MetaIdVar? = null,
    override val permissionMatrix: StudioDtoPermissionMatrixData? = null,
    override val type: EnumStudioCompType? = null,
    @Serializable(with = MetaIdFieldSer::class) override val metaId: Types.MetaIdField,
    override val autoFill: Boolean? = null,
    override val autoFocus: Boolean? = null,
    override val helperText: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val helperTextFieldId: Types.MetaIdField? = null,
    override val helperTextVarId: StudioValueVarIdTextData? = null,
    override val hideLabel: Boolean? = null,
    override val icon: String? = null,
    @Serializable(with = MetaIdVarSer::class) override val iconVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdFieldSer::class) override val labelFieldId: Types.MetaIdField? = null,
    override val placeHolder: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val placeHolderFieldId: Types.MetaIdField? = null,
    override val placeHolderVarId: StudioValueVarIdTextData? = null,
    override val prefix: String? = null,
    override val prefixVarId: StudioValueVarIdTextData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val refFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdSer::class) override val refTargetId: Types.MetaId? = null,
    override val required: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val requiredFieldId: Types.MetaIdField? = null,
    override val requiredRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val requiredVarId: Types.MetaIdVar? = null,
    override val suffix: String? = null,
    override val suffixVarId: StudioValueVarIdTextData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val defaultFieldId: Types.MetaIdField? = null,
    override val defaultValue: String? = null,
    override val defaultVarId: StudioValueVarIdParagraphData? = null,
    override val flexHeight: Boolean? = null,
    override val lineCount: Long? = null,
    @Serializable(with = MetaIdFieldSer::class) override val lineCountFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val lineCountVarId: Types.MetaIdVar? = null,
    override val maxCharCount: Long? = null,
    @Serializable(with = MetaIdFieldSer::class) override val maxCharCountFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val maxCharCountVarId: Types.MetaIdVar? = null,
    override val minCharCount: Long? = null,
    @Serializable(with = MetaIdFieldSer::class) override val minCharCountFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val minCharCountVarId: Types.MetaIdVar? = null,
    override val enableLineNumbers: Boolean? = null,
    override val enableMiniMap: Boolean? = null,
    override val language: EnumDefnCodeEditorLanguage? = null,
    override val showExpandBtn: Boolean? = null,
    override val title: String? = null
) : StudioFieldCodeEditor
