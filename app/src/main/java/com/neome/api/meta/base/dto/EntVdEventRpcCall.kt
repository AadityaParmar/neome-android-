// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnHttpMethod
import com.neome.api.meta.base.Types.KeychainId

class EntVdEventRpcCall : EntVdEvent() {
    var allowedKeychainIdSet: KeychainId[]? = null
    var apiMethod: EnumDefnHttpMethod? = null
    var apiName: string? = null
    var executeAsync: boolean? = null
    var inputForm: FormRefKey? = null
    var outputForm: FormRefKey? = null
    var requestBody: StudioPluginApiBody? = null
    var responseBody: StudioPluginApiBody? = null
}
