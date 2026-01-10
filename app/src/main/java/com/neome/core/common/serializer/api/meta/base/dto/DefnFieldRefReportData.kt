package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.dto.DefnDtoLayoutOverlaySpreadsheet
import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.dto.DefnFieldRefReport
import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoLayoutOverlaySpreadsheetData
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoPermissionMatrixData
import com.neome.core.common.serializer.api.meta.base.dto.DefnLayoutGridData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdReportSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
sealed interface DefnFieldRefReportSeal : DefnFieldRefReport


@Serializable
data class DefnFieldRefReportData(
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
    override val copyFieldMap: Map<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField, @Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val editableFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val forceOpenOnFormCreate: Boolean? = null,
    override val forceOpenOnGridRowCreate: Boolean? = null,
    @Serializable(with = MetaIdGridSer::class) override val gridId: Types.MetaIdGrid? = null,
    override val keyFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val layoutGrid: DefnLayoutGridData? = null,
    override val mobileLayoutGrid: DefnLayoutGridData? = null,
    override val mobileOverlayLayoutGrid: DefnDtoLayoutOverlaySpreadsheetData? = null,
    override val overlayLayoutGrid: DefnDtoLayoutOverlaySpreadsheetData? = null,
    @Serializable(with = MetaIdReportSer::class) override val reportId: Types.MetaIdReport
) : DefnCompSeal, DefnFieldRefReport
