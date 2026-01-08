// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.session.sig

import com.neome.api.core.session.sig.SigTopic

interface SigTopicMessageNew : SigTopic
{
  val messageOffset: Long?
}