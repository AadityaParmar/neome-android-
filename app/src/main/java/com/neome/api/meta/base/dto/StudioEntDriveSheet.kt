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

interface StudioEntDriveSheet : StudioBase {
    val attachmentRoleIdSet: List<MetaIdRole>?
    val dataPartitionPeriod: EnumDefnDataPartitionPeriod?
    val dataRetentionDuration: FieldDtoDuration?
    val exportKindSet: List<EnumDefnDataExportKind>?
    val layoutMap: StudioMapOfLayoutDriveSheet?
    val metaId: MetaIdDriveSheet
    val modules: StudioModuleSelection?
    val name: Symbol?
    val partitionedData: Boolean
    val roleIdSet: List<MetaIdRole>?
    val spreadsheetId: MetaIdSpreadsheet
}
