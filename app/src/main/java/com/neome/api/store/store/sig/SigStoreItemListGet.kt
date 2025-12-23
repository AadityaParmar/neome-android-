// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.sig

import java.util.Set
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.meta.base.Types.StoreItemId

open class SigStoreItemListGet : Sig()
{
  lateinit var storeItemIdSet: Array<StoreItemId>
}