package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgReportOutputFormGet
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgReportOutputFormGetData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction,
    @Serializable(with = MetaIdCompositeSer::class) override val inputFormCompositeId: Types.MetaIdComposite? = null,
    @Serializable(with = RowIdSer::class) override val inputFormGridRowId: Types.RowId? = null,
    override val inputFormValue: FormValueRaw? = null
) : MsgReportOutputFormGet
