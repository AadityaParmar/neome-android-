package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDataExportKind
import com.neome.api.meta.base.Types.EnumDefnMonth
import com.neome.api.meta.base.Types.EnumDefnSyncMode
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDriveSheet
import com.neome.api.meta.base.dto.StudioEntDriveSheetMap
import com.neome.core.common.serializer.sysId.MetaIdDriveSheetSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntDriveSheetMapData(
    override val addressBookExportKindSet: Array<EnumDefnDataExportKind>? = null,
    override val beginningOfTheYear: EnumDefnMonth? = null,
    @Serializable(with = SymbolSer::class) override val driveFolderName: Symbol? = null,
    override val keys: Array<@Serializable(with = MetaIdDriveSheetSer::class) Types.MetaIdDriveSheet>,
    override val manageAdmins: Boolean? = null,
    override val manageUsers: Boolean? = null,
    override val map: Map<@Serializable(with = MetaIdDriveSheetSer::class) Types.MetaIdDriveSheet, StudioEntDriveSheet>,
    override val syncMode: EnumDefnSyncMode? = null
) : StudioEntDriveSheetMap
