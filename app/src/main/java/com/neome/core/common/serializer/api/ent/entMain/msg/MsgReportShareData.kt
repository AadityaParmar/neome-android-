package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgReportShare
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdReportSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgReportShareData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction,
    override val inputFormValueRaw: FormValueRaw? = null,
    @Serializable(with = MetaIdReportSer::class) override val reportId: Types.MetaIdReport,
    override val reset: Boolean? = null
) : MsgReportShare
