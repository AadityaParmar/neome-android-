package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgSpreadsheetHistoryFormValue
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgSpreadsheetHistoryFormValueData(
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    override val formValueRefKey: String,
    override val version: String
) : MsgSpreadsheetHistoryFormValue
