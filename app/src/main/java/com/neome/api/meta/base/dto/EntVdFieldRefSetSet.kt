// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.Types.EnumDefnRefSetOperationKind
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

open class EntVdFieldRefSetSet : EntVdAutoStep()
{
  var inputField: StudioDtoArgValueParameter? = null
  var operation: EnumDefnRefSetOperationKind? = null
  var outputField: StudioDtoArgValueParameter? = null
  var outputSortOrder: EnumDefnSortOrder? = null
}