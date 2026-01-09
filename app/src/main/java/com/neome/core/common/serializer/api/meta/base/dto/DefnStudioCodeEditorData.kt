package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCodeEditorLanguage
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnFieldParagraph
import com.neome.api.meta.base.dto.DefnStudioCodeEditor
import com.neome.api.meta.base.dto.DefnStudioDtoCodeEditor
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
sealed interface DefnStudioCodeEditorSeal : DefnStudioCodeEditor


@Serializable
data class DefnStudioCodeEditorData(
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
    override val autoFill: Boolean? = null,
    override val autoFocus: Boolean? = null,
    override val helperText: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val helperTextFieldId: Types.MetaIdField? = null,
    override val helperTextVar: DefnDtoText? = null,
    override val hideLabel: Boolean? = null,
    override val icon: String? = null,
    override val iconVar: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val labelFieldId: Types.MetaIdField? = null,
    override val placeHolder: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val placeHolderFieldId: Types.MetaIdField? = null,
    override val placeHolderVar: DefnDtoText? = null,
    override val prefix: String? = null,
    override val prefixVar: DefnDtoText? = null,
    override val required: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val requiredFieldId: Types.MetaIdField? = null,
    override val requiredRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val requiredVar: Boolean? = null,
    override val suffix: String? = null,
    override val suffixVar: DefnDtoText? = null,
    @Serializable(with = MetaIdFieldSer::class) override val defaultFieldId: Types.MetaIdField? = null,
    override val defaultValue: String? = null,
    override val defaultVar: DefnDtoParagraph? = null,
    override val flexHeight: Boolean? = null,
    override val lineCount: Long? = null,
    @Serializable(with = MetaIdFieldSer::class) override val lineCountFieldId: Types.MetaIdField? = null,
    override val lineCountVar: Long? = null,
    override val maxCharCount: Long? = null,
    @Serializable(with = MetaIdFieldSer::class) override val maxCharCountFieldId: Types.MetaIdField? = null,
    override val maxCharCountVar: Long? = null,
    override val minCharCount: Long? = null,
    @Serializable(with = MetaIdFieldSer::class) override val minCharCountFieldId: Types.MetaIdField? = null,
    override val minCharCountVar: Long? = null,
    override val allowCopy: Boolean? = null,
    override val autoCompletePayload: DefnStudioDtoCodeEditor? = null,
    override val enableLineNumbers: Boolean? = null,
    override val enableMiniMap: Boolean? = null,
    override val excludeAiInput: Boolean? = null,
    override val language: EnumDefnCodeEditorLanguage? = null,
    override val minHeight: Long? = null,
    override val showExpandBtn: Boolean? = null,
    override val title: String? = null
) : DefnCompSeal, DefnStudioCodeEditor
