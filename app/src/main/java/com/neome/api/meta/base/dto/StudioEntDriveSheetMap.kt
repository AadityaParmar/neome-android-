// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnDataExportKind
import com.neome.api.meta.base.Types.EnumDefnMonth
import com.neome.api.meta.base.Types.EnumDefnSyncMode
import com.neome.api.meta.base.Types.MetaIdDriveSheet

class StudioEntDriveSheetMap : StudioBase() {
    var addressBookExportKindSet: EnumDefnDataExportKind[]? = null
    var beginningOfTheYear: EnumDefnMonth? = null
    var driveFolderName: Symbol? = null
    val keys: MetaIdDriveSheet[]
    var manageAdmins: boolean? = null
    var manageUsers: boolean? = null
    val map: Record<MetaIdDriveSheet, StudioEntDriveSheet>
    var syncMode: EnumDefnSyncMode? = null
}
