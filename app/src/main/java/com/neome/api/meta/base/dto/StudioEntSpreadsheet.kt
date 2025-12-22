// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar

class StudioEntSpreadsheet : StudioBase() {
    val alias: string
    var auditTrailFormRoleSet: MetaIdRole[]? = null
    var bypassDurationRoleSet: MetaIdRole[]? = null
    var clearRoleSet: MetaIdRole[]? = null
    val details: StudioDetails
    val formId: MetaIdForm
    var groupForwardRolePermissionMap: StudioMapOfForwardRolePermission? = null
    var historyIdSet: MetaIdField[]? = null
    var insertRoleSet: MetaIdRole[]? = null
    var invisibleAfterDurationVarId: MetaIdVar? = null
    var isMasterSheet: boolean? = null
    var layoutSpreadsheetMap: StudioMapOfLayoutGrid? = null
    val metaId: MetaIdSpreadsheet
    var partitionMap: StudioMapOfPartition? = null
    var queryableIdSet: MetaIdField[]? = null
    var ragIdSet: MetaIdField[]? = null
    var readAfterDurationVarId: MetaIdVar? = null
    var readRoleSet: MetaIdRole[]? = null
    var readRoleVarId: MetaIdVar? = null
    var removeRoleSet: MetaIdRole[]? = null
    var searchableIdSet: MetaIdField[]? = null
    var supportOffline: boolean? = null
    var uniqueIdSet: MetaIdField[]? = null
    var uniqueIndexIdSet: MetaIdField[]? = null
    var updateRoleSet: MetaIdRole[]? = null
    var userForwardRolePermissionMap: StudioMapOfForwardRolePermission? = null
}
