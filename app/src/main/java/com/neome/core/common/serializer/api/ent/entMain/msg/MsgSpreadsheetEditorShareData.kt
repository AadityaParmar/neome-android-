package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgSpreadsheetEditorShare
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgSpreadsheetEditorShareData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction,
    override val reset: Boolean? = null
) : MsgSpreadsheetEditorShare
