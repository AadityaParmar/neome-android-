package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnRefreshOn
import com.neome.api.meta.base.Types.EnumStudioCompType
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioDtoLayoutOverlaySpreadsheet
import com.neome.api.meta.base.dto.StudioDtoPermissionMatrix
import com.neome.api.meta.base.dto.StudioField
import com.neome.api.meta.base.dto.StudioFieldRef
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioFieldRefData(
    override val aiInstructions: String? = null,
    override val details: StudioDetails,
    override val disabled: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val disabledFieldId: Types.MetaIdField? = null,
    override val disabledRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val disabledVarId: Types.MetaIdVar? = null,
    override val permissionMatrix: StudioDtoPermissionMatrix? = null,
    override val type: EnumStudioCompType? = null,
    @Serializable(with = MetaIdFieldSer::class) override val metaId: Types.MetaIdField,
    override val canCreateRefRecord: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val categoryFilterDisplayFieldId: Types.MetaIdField? = null,
    override val copyFieldMap: Map<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField, @Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdVarSer::class) override val createRefRecordMappingVarId: Types.MetaIdVar? = null,
    override val editableFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val filterConditionVarId: StudioValueVarIdCondition? = null,
    override val forceOpenOnFormCreate: Boolean? = null,
    override val forceOpenOnGridRowCreate: Boolean? = null,
    override val keyFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdLayoutGridSer::class) override val layoutSpreadsheetId: Types.MetaIdLayoutGrid? = null,
    @Serializable(with = MetaIdFieldSer::class) override val lookupFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdLayoutGridSer::class) override val mobileLayoutSpreadsheetId: Types.MetaIdLayoutGrid? = null,
    override val mobileOverlayLayoutSpreadsheet: StudioDtoLayoutOverlaySpreadsheet? = null,
    override val overlayLayoutSpreadsheet: StudioDtoLayoutOverlaySpreadsheet? = null,
    override val refreshOn: EnumDefnRefreshOn? = null,
    override val showRefreshInMenu: Boolean? = null,
    override val showRefreshOnFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null
) : StudioFieldRef
