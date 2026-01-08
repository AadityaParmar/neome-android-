// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDataExportKind
import com.neome.api.meta.base.Types.EnumDefnMonth
import com.neome.api.meta.base.Types.EnumDefnSyncMode
import com.neome.api.meta.base.Types.MetaIdDriveSheet
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDriveSheet
import com.neome.api.meta.base.Symbol

interface StudioEntDriveSheetMap : StudioBase
{
  val addressBookExportKindSet: Array<EnumDefnDataExportKind>?
  val beginningOfTheYear: EnumDefnMonth?
  val driveFolderName: Symbol?
  val keys: Array<MetaIdDriveSheet>
  val manageAdmins: Boolean?
  val manageUsers: Boolean?
  val map: Map<MetaIdDriveSheet, StudioEntDriveSheet>
  val syncMode: EnumDefnSyncMode?
}