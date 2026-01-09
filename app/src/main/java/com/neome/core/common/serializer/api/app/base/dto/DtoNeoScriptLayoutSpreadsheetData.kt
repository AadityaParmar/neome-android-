package com.neome.core.common.serializer.api.app.base.dto

import com.neome.api.app.base.Types.EnumKindNeoScript
import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.app.base.dto.DtoNeoScriptLayoutSpreadsheet
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoNeoScriptLayoutSpreadsheetData(
    override val kind: EnumKindNeoScript,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null,
    @Serializable(with = MetaIdLayoutGridSer::class) override val spreadsheetLayoutId: Types.MetaIdLayoutGrid? = null
) : DtoNeoScriptLayoutSpreadsheet
