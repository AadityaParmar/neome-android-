// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.session.sig

import com.neome.api.nucleus.base.Types.EnumAnalyticEventFilterKind

class SigTopicAnalyticEvent : SigTopic() {
    val analyticEvent: EnumAnalyticEventFilterKind
}
