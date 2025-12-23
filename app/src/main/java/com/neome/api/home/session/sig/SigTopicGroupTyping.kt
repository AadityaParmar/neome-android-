// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.session.sig

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.core.session.sig.SigTopic

open class SigTopicGroupTyping : SigTopic() {
    lateinit var targetEntUserId: EntUserId
    lateinit var targetUserText: String
}
