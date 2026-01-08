// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnLayoutCardFilterKind
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioBase

interface StudioDtoLayoutCardFilter : StudioBase
{
  val advanceFilterFieldIdSet: Array<MetaIdField>?
  val categoryFieldIdSet: Array<MetaIdField>?
  val kind: EnumDefnLayoutCardFilterKind?
  val showSearchBar: Boolean?
  val sortByFieldIdSet: Array<MetaIdField>?
  val sortOrder: EnumDefnSortOrder?
}