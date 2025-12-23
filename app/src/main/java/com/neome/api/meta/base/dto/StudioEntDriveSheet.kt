// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.EnumDefnDataExportKind
import com.neome.api.meta.base.Types.EnumDefnDataPartitionPeriod
import com.neome.api.meta.base.dto.FieldDtoDuration
import com.neome.api.meta.base.Types.MetaIdDriveSheet
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfLayoutDriveSheet
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.meta.base.Symbol

open class StudioEntDriveSheet : StudioBase()
{
  var attachmentRoleIdSet: Array<MetaIdRole>? = null
  var dataPartitionPeriod: EnumDefnDataPartitionPeriod? = null
  var dataRetentionDuration: FieldDtoDuration? = null
  var exportKindSet: Array<EnumDefnDataExportKind>? = null
  var layoutMap: StudioMapOfLayoutDriveSheet? = null
  lateinit var metaId: MetaIdDriveSheet
  var modules: StudioModuleSelection? = null
  var name: Symbol? = null
  var partitionedData: Boolean by Delegates.notNull<Boolean>()
  var roleIdSet: Array<MetaIdRole>? = null
  lateinit var spreadsheetId: MetaIdSpreadsheet
}