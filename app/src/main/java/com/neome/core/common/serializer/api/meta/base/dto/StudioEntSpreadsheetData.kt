package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnUniquenessMode
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioEntSpreadsheet
import com.neome.api.meta.base.dto.StudioMapOfForwardRolePermission
import com.neome.api.meta.base.dto.StudioMapOfLayoutGrid
import com.neome.api.meta.base.dto.StudioMapOfPartition
import com.neome.core.common.serializer.api.meta.base.dto.StudioDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfForwardRolePermissionData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfLayoutGridData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfPartitionData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntSpreadsheetData(
    override val alias: String,
    override val auditTrailFormRoleSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val bypassDurationRoleSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val clearRoleSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val details: StudioDetailsData,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    override val groupForwardRolePermissionMap: StudioMapOfForwardRolePermissionData? = null,
    override val historyIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val insertRoleSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val invisibleAfterDurationVarId: Types.MetaIdVar? = null,
    override val isMasterSheet: Boolean? = null,
    override val layoutSpreadsheetMap: StudioMapOfLayoutGridData? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val metaId: Types.MetaIdSpreadsheet,
    override val partitionMap: StudioMapOfPartitionData? = null,
    override val queryableIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val ragIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdVarSer::class) override val readAfterDurationVarId: Types.MetaIdVar? = null,
    override val readRoleSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val readRoleVarId: Types.MetaIdVar? = null,
    override val removeRoleSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val searchableIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val supportOffline: Boolean? = null,
    override val uniqueIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val uniqueIndexIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val uniquenessMode: EnumDefnUniquenessMode? = null,
    override val updateRoleSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val userForwardRolePermissionMap: StudioMapOfForwardRolePermissionData? = null
) : StudioEntSpreadsheet
