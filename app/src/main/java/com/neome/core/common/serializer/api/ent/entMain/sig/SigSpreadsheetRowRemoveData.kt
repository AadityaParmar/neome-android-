package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.entMain.sig.SigSpreadsheetRowRemove
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigSpreadsheetRowRemoveData(
    override val errorMap: Map<@Serializable(with = RowIdSer::class) Types.RowId, EnvValidationError>
) : SigSpreadsheetRowRemove
