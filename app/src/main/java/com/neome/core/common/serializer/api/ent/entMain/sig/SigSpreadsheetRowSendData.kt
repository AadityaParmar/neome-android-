package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.entMain.sig.SigSpreadsheetRowSend
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.RowIdSer
import com.neome.core.common.serializer.sysId.SpreadsheetPartitionIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigSpreadsheetRowSendData(
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    @Serializable(with = RowIdSer::class) override val rowId: Types.RowId,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet,
    @Serializable(with = SpreadsheetPartitionIdSer::class) override val spreadsheetPartitionId: Types.SpreadsheetPartitionId
) : SigSpreadsheetRowSend
