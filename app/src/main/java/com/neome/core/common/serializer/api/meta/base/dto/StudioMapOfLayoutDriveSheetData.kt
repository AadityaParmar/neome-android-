package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutDriveSheet
import com.neome.api.meta.base.dto.StudioMapOfLayoutDriveSheet
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoLayoutDriveSheetData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutDriveSheetSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfLayoutDriveSheetData(
    override val includeMetaFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val keys: List<@Serializable(with = MetaIdLayoutDriveSheetSer::class) Types.MetaIdLayoutDriveSheet>,
    override val map: Map<@Serializable(with = MetaIdLayoutDriveSheetSer::class) Types.MetaIdLayoutDriveSheet, StudioDtoLayoutDriveSheetData>
) : StudioMapOfLayoutDriveSheet
