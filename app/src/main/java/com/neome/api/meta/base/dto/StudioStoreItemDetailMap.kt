// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.StoreItemId
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioStoreItemDetail

interface StudioStoreItemDetailMap : StudioBase
{
  val keys: Array<StoreItemId>
  val map: Map<StoreItemId, StudioStoreItemDetail>
}