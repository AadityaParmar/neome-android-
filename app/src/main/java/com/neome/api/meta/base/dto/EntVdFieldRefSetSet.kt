// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.Types.EnumDefnRefSetOperationKind
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

interface EntVdFieldRefSetSet : EntVdAutoStep
{
  val inputField: StudioDtoArgValueParameter?
  val operation: EnumDefnRefSetOperationKind?
  val outputField: StudioDtoArgValueParameter?
  val outputSortOrder: EnumDefnSortOrder?
}