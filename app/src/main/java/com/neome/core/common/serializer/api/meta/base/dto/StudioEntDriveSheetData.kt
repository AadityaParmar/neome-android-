package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDataExportKind
import com.neome.api.meta.base.Types.EnumDefnDataPartitionPeriod
import com.neome.api.meta.base.dto.FieldDtoDuration
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDriveSheet
import com.neome.api.meta.base.dto.StudioMapOfLayoutDriveSheet
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoDurationData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfLayoutDriveSheetData
import com.neome.core.common.serializer.api.meta.base.dto.StudioModuleSelectionData
import com.neome.core.common.serializer.sysId.MetaIdDriveSheetSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntDriveSheetData(
    override val attachmentRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val dataPartitionPeriod: EnumDefnDataPartitionPeriod? = null,
    override val dataRetentionDuration: FieldDtoDurationData? = null,
    override val exportKindSet: List<EnumDefnDataExportKind>? = null,
    override val layoutMap: StudioMapOfLayoutDriveSheetData? = null,
    @Serializable(with = MetaIdDriveSheetSer::class) override val metaId: Types.MetaIdDriveSheet,
    override val modules: StudioModuleSelectionData? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val partitionedData: Boolean,
    override val roleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet
) : StudioEntDriveSheet
