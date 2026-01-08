// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.session.sig

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.core.session.sig.SigTopic

interface SigTopicGroupTyping : SigTopic
{
  val targetEntUserId: EntUserId
  val targetUserText: String
}