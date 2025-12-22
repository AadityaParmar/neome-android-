// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.msg

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg

class MsgPluginWebhookResponseAccept : Msg() {
    val entId: EntId
    val formId: MetaIdForm
    val pluginId: MetaIdPlugin
    val responseFormValue: FormValueRaw
}
