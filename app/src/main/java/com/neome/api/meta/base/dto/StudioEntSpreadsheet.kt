// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnUniquenessMode
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

interface StudioEntSpreadsheet : StudioBase
{
  val alias: String
  val auditTrailFormRoleSet: Array<MetaIdRole>?
  val bypassDurationRoleSet: Array<MetaIdRole>?
  val clearRoleSet: Array<MetaIdRole>?
  val details: StudioDetails
  val formId: MetaIdForm
  val groupForwardRolePermissionMap: StudioMapOfForwardRolePermission?
  val historyIdSet: Array<MetaIdField>?
  val insertRoleSet: Array<MetaIdRole>?
  val invisibleAfterDurationVarId: MetaIdVar?
  val isMasterSheet: Boolean?
  val layoutSpreadsheetMap: StudioMapOfLayoutGrid?
  val metaId: MetaIdSpreadsheet
  val partitionMap: StudioMapOfPartition?
  val queryableIdSet: Array<MetaIdField>?
  val ragIdSet: Array<MetaIdField>?
  val readAfterDurationVarId: MetaIdVar?
  val readRoleSet: Array<MetaIdRole>?
  val readRoleVarId: MetaIdVar?
  val removeRoleSet: Array<MetaIdRole>?
  val searchableIdSet: Array<MetaIdField>?
  val supportOffline: Boolean?
  val uniqueIdSet: Array<MetaIdField>?
  val uniqueIndexIdSet: Array<MetaIdField>?
  val uniquenessMode: EnumDefnUniquenessMode?
  val updateRoleSet: Array<MetaIdRole>?
  val userForwardRolePermissionMap: StudioMapOfForwardRolePermission?
}