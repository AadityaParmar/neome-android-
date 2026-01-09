package com.neome.core.common.serializer.api.ent.agent.msg

import com.neome.api.ent.agent.msg.MsgPluginWebhookResponseAccept
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgPluginWebhookResponseAcceptData(
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    @Serializable(with = MetaIdPluginSer::class) override val pluginId: Types.MetaIdPlugin,
    override val responseFormValue: FormValueRaw
) : MsgPluginWebhookResponseAccept
