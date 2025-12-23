// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.sig

import com.neome.api.ent.base.dto.DtoPluginApiRequestPayload
import com.neome.api.core.session.sig.SigTopic

open class SigTopicPluginApiRequest : SigTopic()
{
  lateinit var payload: DtoPluginApiRequestPayload
}