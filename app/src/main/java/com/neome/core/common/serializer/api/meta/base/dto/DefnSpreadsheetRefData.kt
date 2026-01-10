package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.dto.DefnSpreadsheetRef
import com.neome.api.meta.base.dto.DefnStudioMapOfActionPermission
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoPermissionMatrixData
import com.neome.core.common.serializer.api.meta.base.dto.DefnLayoutGridData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfActionPermissionData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetRefSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
sealed interface DefnSpreadsheetRefSeal : DefnSpreadsheetRef


@Serializable
data class DefnSpreadsheetRefData(
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
    override val layoutSpreadsheet: DefnLayoutGridData,
    override val maxRecords: Long? = null,
    @Serializable(with = MetaIdSpreadsheetRefSer::class) override val metaId: Types.MetaIdSpreadsheetRef,
    @Serializable(with = MetaIdFieldSer::class) override val refTargetFieldId: Types.MetaIdField? = null,
    override val rowActionPermissionMap: DefnStudioMapOfActionPermissionData? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet
) : DefnCompSeal, DefnSpreadsheetRef
