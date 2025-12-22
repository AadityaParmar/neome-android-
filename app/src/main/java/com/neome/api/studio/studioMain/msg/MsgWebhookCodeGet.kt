// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.meta.base.dto.EntVdWorkflowPointer
import com.neome.api.nucleus.base.msg.Msg

class MsgWebhookCodeGet : Msg() {
    var automationId: MetaIdAutomation? = null
    var workflowPointer: EntVdWorkflowPointer? = null
}
