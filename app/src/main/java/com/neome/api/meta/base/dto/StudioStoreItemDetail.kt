// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.StoreItemId
import com.neome.api.meta.base.dto.StudioBase

open class StudioStoreItemDetail : StudioBase() {
    lateinit var storeItemId: StoreItemId
    lateinit var storeName: String
}
