package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgSpreadsheetInsertShare
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.ChatIdSer
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgSpreadsheetInsertShareData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction,
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId,
    override val formValueRaw: FormValueRaw? = null,
    override val reset: Boolean? = null
) : MsgSpreadsheetInsertShare
