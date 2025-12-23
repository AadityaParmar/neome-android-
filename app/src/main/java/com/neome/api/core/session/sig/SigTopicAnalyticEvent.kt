// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.session.sig

import com.neome.api.nucleus.base.Types.EnumAnalyticEventFilterKind
import com.neome.api.core.session.sig.SigTopic

open class SigTopicAnalyticEvent : SigTopic()
{
  lateinit var analyticEvent: EnumAnalyticEventFilterKind
}