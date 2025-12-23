// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.StoreItemId
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioStoreItemDetail

open class StudioStoreItemDetailMap : StudioBase()
{
  lateinit var keys: Array<StoreItemId>
  lateinit var map: Map<StoreItemId, StudioStoreItemDetail>
}