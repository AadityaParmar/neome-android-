// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.sig

import com.neome.api.meta.base.Types.StoreItemId
import com.neome.api.nucleus.base.sig.Sig

class SigStoreItemListGet : Sig() {
    val storeItemIdSet: StoreItemId[]
}
