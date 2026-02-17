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
  val auditTrailFormRoleSet: List<MetaIdRole>?
  val bypassDurationRoleSet: List<MetaIdRole>?
  val clearRoleSet: List<MetaIdRole>?
  val details: StudioDetails
  val formId: MetaIdForm
  val groupForwardRolePermissionMap: StudioMapOfForwardRolePermission?
  val historyIdSet: List<MetaIdField>?
  val insertRoleSet: List<MetaIdRole>?
  val invisibleAfterDurationVarId: MetaIdVar?
  val isMasterSheet: Boolean?
  val layoutSpreadsheetMap: StudioMapOfLayoutGrid?
  val metaId: MetaIdSpreadsheet
  val partitionMap: StudioMapOfPartition?
  val queryableIdSet: List<MetaIdField>?
  val ragGroupId: MetaIdField?
  val ragIdSet: List<MetaIdField>?
  val readAfterDurationVarId: MetaIdVar?
  val readRoleSet: List<MetaIdRole>?
  val readRoleVarId: MetaIdVar?
  val removeRoleSet: List<MetaIdRole>?
  val searchableIdSet: List<MetaIdField>?
  val supportOffline: Boolean?
  val uniqueIdSet: List<MetaIdField>?
  val uniqueIndexIdSet: List<MetaIdField>?
  val uniquenessMode: EnumDefnUniquenessMode?
  val updateRoleSet: List<MetaIdRole>?
  val userForwardRolePermissionMap: StudioMapOfForwardRolePermission?
}