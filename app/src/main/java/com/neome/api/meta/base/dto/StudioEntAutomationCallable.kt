// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.dto.StudioEntAutomation
import com.neome.api.meta.base.dto.StudioEntAutomationCallableEventMap

open class StudioEntAutomationCallable : StudioEntAutomation()
{
  lateinit var eventMap: StudioEntAutomationCallableEventMap
  lateinit var formId: MetaIdForm
  var metaIdPlugin: MetaIdPlugin? = null
}