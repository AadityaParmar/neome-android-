package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgFormResultCalc
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgFormResultCalcData(
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    override val formValueRaw: FormValueRawData
) : MsgFormResultCalc
