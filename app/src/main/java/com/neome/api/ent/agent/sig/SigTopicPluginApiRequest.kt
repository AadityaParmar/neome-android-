// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.sig

import com.neome.api.core.session.sig.SigTopic
import com.neome.api.ent.base.dto.DtoPluginApiRequestPayload

class SigTopicPluginApiRequest : SigTopic() {
    val payload: DtoPluginApiRequestPayload
}
