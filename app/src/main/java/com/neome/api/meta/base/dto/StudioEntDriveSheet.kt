// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnDataExportKind
import com.neome.api.meta.base.Types.EnumDefnDataPartitionPeriod
import com.neome.api.meta.base.Types.MetaIdDriveSheet
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class StudioEntDriveSheet : StudioBase() {
    var attachmentRoleIdSet: MetaIdRole[]? = null
    var dataPartitionPeriod: EnumDefnDataPartitionPeriod? = null
    var dataRetentionDuration: FieldDtoDuration? = null
    var exportKindSet: EnumDefnDataExportKind[]? = null
    var layoutMap: StudioMapOfLayoutDriveSheet? = null
    val metaId: MetaIdDriveSheet
    var modules: StudioModuleSelection? = null
    var name: Symbol? = null
    val partitionedData: boolean
    var roleIdSet: MetaIdRole[]? = null
    val spreadsheetId: MetaIdSpreadsheet
}
