// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.StoreItemId

class StudioStoreItemDetail : StudioBase() {
    val storeItemId: StoreItemId
    val storeName: string
}
