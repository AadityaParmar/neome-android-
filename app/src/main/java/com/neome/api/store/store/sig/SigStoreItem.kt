// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.sig

import com.neome.api.store.store.sig.SigStoreItemAvatar
import com.neome.api.meta.base.dto.StoreItem

open class SigStoreItem : SigStoreItemAvatar()
{
  lateinit var storeItem: StoreItem
}