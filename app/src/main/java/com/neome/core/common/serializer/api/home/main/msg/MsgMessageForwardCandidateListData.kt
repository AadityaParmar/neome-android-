package com.neome.core.common.serializer.api.home.main.msg

import com.neome.api.home.main.msg.MsgMessageForwardCandidateList
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgMessageForwardCandidateListData(
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null
) : MsgMessageForwardCandidateList
