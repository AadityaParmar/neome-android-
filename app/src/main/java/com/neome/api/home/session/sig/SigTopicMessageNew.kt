// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.session.sig

import kotlin.properties.Delegates
import com.neome.api.core.session.sig.SigTopic

open class SigTopicMessageNew : SigTopic()
{
  var messageOffset: Number by Delegates.notNull<Number>()
}