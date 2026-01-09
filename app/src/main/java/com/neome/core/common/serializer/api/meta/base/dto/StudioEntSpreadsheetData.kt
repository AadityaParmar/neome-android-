package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnUniquenessMode
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioEntSpreadsheet
import com.neome.api.meta.base.dto.StudioMapOfForwardRolePermission
import com.neome.api.meta.base.dto.StudioMapOfLayoutGrid
import com.neome.api.meta.base.dto.StudioMapOfPartition
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntSpreadsheetData(
    override val alias: String,
    override val auditTrailFormRoleSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val bypassDurationRoleSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val clearRoleSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val details: StudioDetails,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    override val groupForwardRolePermissionMap: StudioMapOfForwardRolePermission? = null,
    override val historyIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val insertRoleSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val invisibleAfterDurationVarId: Types.MetaIdVar? = null,
    override val isMasterSheet: Boolean? = null,
    override val layoutSpreadsheetMap: StudioMapOfLayoutGrid? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val metaId: Types.MetaIdSpreadsheet,
    override val partitionMap: StudioMapOfPartition? = null,
    override val queryableIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val ragIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdVarSer::class) override val readAfterDurationVarId: Types.MetaIdVar? = null,
    override val readRoleSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val readRoleVarId: Types.MetaIdVar? = null,
    override val removeRoleSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val searchableIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val supportOffline: Boolean? = null,
    override val uniqueIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val uniqueIndexIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val uniquenessMode: EnumDefnUniquenessMode? = null,
    override val updateRoleSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val userForwardRolePermissionMap: StudioMapOfForwardRolePermission? = null
) : StudioEntSpreadsheet
