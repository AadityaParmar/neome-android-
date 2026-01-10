package com.neome.core.common.serializer.api.ent.ent.sig

import com.neome.api.ent.ent.sig.SigEntSpreadsheetPartitionRowIdList
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigEntSpreadsheetPartitionRowIdListData(
    override val bottomRowOrderVer: String,
    override val rowIdList: List<@Serializable(with = RowIdSer::class) Types.RowId>
) : SigEntSpreadsheetPartitionRowIdList
