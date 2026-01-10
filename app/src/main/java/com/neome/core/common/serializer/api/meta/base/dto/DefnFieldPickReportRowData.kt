package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.dto.DefnFieldPickReportRow
import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoPermissionMatrixData
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoTextData
import com.neome.core.common.serializer.api.meta.base.dto.DefnLayoutGridData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdReportSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
sealed interface DefnFieldPickReportRowSeal : DefnFieldPickReportRow


@Serializable
data class DefnFieldPickReportRowData(
    override val disabled: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val disabledFieldId: Types.MetaIdField? = null,
    override val disabledRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val disabledVar: Boolean? = null,
    override val hidden: Boolean? = null,
    override val hideDirtyIndicator: Boolean? = null,
    override val invisible: Boolean? = null,
    override val label: String? = null,
    override val maxWidth: Long? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val pb: Long? = null,
    override val permissionMatrix: DefnDtoPermissionMatrixData? = null,
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
    override val helperTextVar: DefnDtoTextData? = null,
    override val hideLabel: Boolean? = null,
    override val icon: String? = null,
    override val iconVar: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val labelFieldId: Types.MetaIdField? = null,
    override val placeHolder: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val placeHolderFieldId: Types.MetaIdField? = null,
    override val placeHolderVar: DefnDtoTextData? = null,
    override val prefix: String? = null,
    override val prefixVar: DefnDtoTextData? = null,
    override val required: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val requiredFieldId: Types.MetaIdField? = null,
    override val requiredRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val requiredVar: Boolean? = null,
    override val suffix: String? = null,
    override val suffixVar: DefnDtoTextData? = null,
    override val copyFieldMap: Map<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField, @Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val editableFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdFieldSer::class) override val gridDisplayFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdReportSer::class) override val reportId: Types.MetaIdReport,
    @Serializable(with = MetaIdGridSer::class) override val reportOutputFormGridId: Types.MetaIdGrid? = null,
    override val reportOutputFormGridLayout: DefnLayoutGridData? = null,
    override val showAsDropdown: Boolean? = null
) : DefnCompSeal, DefnFieldPickReportRow
