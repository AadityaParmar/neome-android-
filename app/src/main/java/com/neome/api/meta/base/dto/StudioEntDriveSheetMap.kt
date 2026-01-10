// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnDataExportKind
import com.neome.api.meta.base.Types.EnumDefnMonth
import com.neome.api.meta.base.Types.EnumDefnSyncMode
import com.neome.api.meta.base.Types.MetaIdDriveSheet

interface StudioEntDriveSheetMap : StudioBase {
    val addressBookExportKindSet: List<EnumDefnDataExportKind>?
    val beginningOfTheYear: EnumDefnMonth?
    val driveFolderName: Symbol?
    val keys: List<MetaIdDriveSheet>
    val manageAdmins: Boolean?
    val manageUsers: Boolean?
    val map: Map<MetaIdDriveSheet, StudioEntDriveSheet>
    val syncMode: EnumDefnSyncMode?
}
