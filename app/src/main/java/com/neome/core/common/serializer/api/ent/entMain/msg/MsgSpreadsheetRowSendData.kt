package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowSend
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgSpreadsheetRowSendData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction? = null,
    override val formValueRaw: FormValueRaw,
    @Serializable(with = MetaIdVarSer::class) override val mappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val targetSpreadsheetId: Types.MetaIdSpreadsheet? = null,
    override val transactionId: String? = null
) : MsgSpreadsheetRowSend
