// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnDataExportKind
import com.neome.api.meta.base.Types.EnumDefnMonth
import com.neome.api.meta.base.Types.EnumDefnSyncMode
import com.neome.api.meta.base.Types.MetaIdDriveSheet
import java.util.Map

open class StudioEntDriveSheetMap : StudioBase() {
    var addressBookExportKindSet: Array<EnumDefnDataExportKind>? = null
    var beginningOfTheYear: EnumDefnMonth? = null
    var driveFolderName: Symbol? = null
    lateinit var keys: Array<MetaIdDriveSheet>
    var manageAdmins: Boolean? = null
    var manageUsers: Boolean? = null
    lateinit var map: Map<MetaIdDriveSheet, StudioEntDriveSheet>
    var syncMode: EnumDefnSyncMode? = null
}
