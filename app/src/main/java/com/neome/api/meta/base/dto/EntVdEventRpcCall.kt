// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdEvent
import com.neome.api.meta.base.Types.EnumDefnHttpMethod
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.Types.KeychainId
import com.neome.api.meta.base.dto.StudioPluginApiBody

open class EntVdEventRpcCall : EntVdEvent()
{
  var allowedKeychainIdSet: Array<KeychainId>? = null
  var apiMethod: EnumDefnHttpMethod? = null
  var apiName: String? = null
  var executeAsync: Boolean? = null
  var inputForm: FormRefKey? = null
  var outputForm: FormRefKey? = null
  var requestBody: StudioPluginApiBody? = null
  var responseBody: StudioPluginApiBody? = null
}