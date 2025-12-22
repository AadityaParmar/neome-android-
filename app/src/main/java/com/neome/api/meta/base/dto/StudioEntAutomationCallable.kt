// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdPlugin

class StudioEntAutomationCallable : StudioEntAutomation() {
    val eventMap: StudioEntAutomationCallableEventMap
    val formId: MetaIdForm
    var metaIdPlugin: MetaIdPlugin? = null
}
