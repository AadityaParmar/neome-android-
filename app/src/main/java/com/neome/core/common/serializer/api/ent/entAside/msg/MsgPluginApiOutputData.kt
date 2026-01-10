package com.neome.core.common.serializer.api.ent.entAside.msg

import com.neome.api.ent.entAside.msg.MsgPluginApiOutput
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgPluginApiOutputData(
    @Serializable(with = MetaIdFieldSer::class) override val fieldId: Types.MetaIdField,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    override val formValueRaw: FormValueRawData? = null
) : MsgPluginApiOutput
