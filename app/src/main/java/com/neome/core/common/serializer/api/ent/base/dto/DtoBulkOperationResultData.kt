package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoBulkOperationResult
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoBulkOperationResultData(
    override val errorMap: Map<@Serializable(with = RowIdSer::class) Types.RowId, EnvValidationError>
) : DtoBulkOperationResult
