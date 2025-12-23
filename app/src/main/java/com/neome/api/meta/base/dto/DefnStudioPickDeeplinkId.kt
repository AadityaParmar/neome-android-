// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdDeeplink

open class DefnStudioPickDeeplinkId : DefnFieldEditable()
{
  var includeDeeplinkIdSet: Array<MetaIdDeeplink>? = null
}