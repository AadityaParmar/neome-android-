// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioMapOfForwardRolePermission
import com.neome.api.meta.base.dto.StudioMapOfLayoutGrid
import com.neome.api.meta.base.dto.StudioMapOfPartition

open class StudioEntSpreadsheet : StudioBase()
{
  lateinit var alias: String
  var auditTrailFormRoleSet: Array<MetaIdRole>? = null
  var bypassDurationRoleSet: Array<MetaIdRole>? = null
  var clearRoleSet: Array<MetaIdRole>? = null
  lateinit var details: StudioDetails
  lateinit var formId: MetaIdForm
  var groupForwardRolePermissionMap: StudioMapOfForwardRolePermission? = null
  var historyIdSet: Array<MetaIdField>? = null
  var insertRoleSet: Array<MetaIdRole>? = null
  var invisibleAfterDurationVarId: MetaIdVar? = null
  var isMasterSheet: Boolean? = null
  var layoutSpreadsheetMap: StudioMapOfLayoutGrid? = null
  lateinit var metaId: MetaIdSpreadsheet
  var partitionMap: StudioMapOfPartition? = null
  var queryableIdSet: Array<MetaIdField>? = null
  var ragIdSet: Array<MetaIdField>? = null
  var readAfterDurationVarId: MetaIdVar? = null
  var readRoleSet: Array<MetaIdRole>? = null
  var readRoleVarId: MetaIdVar? = null
  var removeRoleSet: Array<MetaIdRole>? = null
  var searchableIdSet: Array<MetaIdField>? = null
  var supportOffline: Boolean? = null
  var uniqueIdSet: Array<MetaIdField>? = null
  var uniqueIndexIdSet: Array<MetaIdField>? = null
  var updateRoleSet: Array<MetaIdRole>? = null
  var userForwardRolePermissionMap: StudioMapOfForwardRolePermission? = null
}