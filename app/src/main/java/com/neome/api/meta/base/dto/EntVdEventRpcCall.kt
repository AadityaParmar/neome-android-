// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnHttpMethod
import com.neome.api.meta.base.Types.KeychainId

interface EntVdEventRpcCall : EntVdEvent {
    val allowedKeychainIdSet: List<KeychainId>?
    val apiMethod: EnumDefnHttpMethod?
    val apiName: String?
    val executeAsync: Boolean?
    val inputForm: FormRefKey?
    val outputForm: FormRefKey?
    val requestBody: StudioPluginApiBody?
    val responseBody: StudioPluginApiBody?
}
