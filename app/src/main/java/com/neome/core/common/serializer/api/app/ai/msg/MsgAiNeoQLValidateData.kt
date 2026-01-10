package com.neome.core.common.serializer.api.app.ai.msg

import com.neome.api.app.ai.msg.MsgAiNeoQLValidate
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.meta.base.dto.FormRefKeyData
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgAiNeoQLValidateData(
    override val inputFormRefKey: FormRefKeyData? = null,
    override val neoQL: String,
    override val outputFormRefKey: FormRefKeyData? = null,
    override val paramMap: Map<String, FormRefKeyData>? = null,
    override val spreadsheetIdSet: List<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet>
) : MsgAiNeoQLValidate
