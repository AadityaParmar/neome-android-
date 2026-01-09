package com.neome.core.common.serializer.api.app.base.dto

import com.neome.api.app.base.Types.EnumKindNeoScript
import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.app.base.dto.DtoNeoScriptDriveSheet
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdDriveSheetSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoNeoScriptDriveSheetData(
    override val kind: EnumKindNeoScript,
    @Serializable(with = MetaIdDriveSheetSer::class) override val driveSheetId: Types.MetaIdDriveSheet? = null
) : DtoNeoScriptDriveSheet
