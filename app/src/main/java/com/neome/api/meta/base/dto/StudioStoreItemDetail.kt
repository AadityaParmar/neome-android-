// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.StoreItemId
import com.neome.api.meta.base.dto.StudioBase

interface StudioStoreItemDetail : StudioBase
{
  val storeItemId: StoreItemId
  val storeName: String
}