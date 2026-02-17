// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnLayoutCardFilterKind
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.MetaIdField

interface DefnDtoLayoutCardFilter
{
  val advanceFilterFieldIdSet: List<MetaIdField>?
  val categoryFieldIdSet: List<MetaIdField>?
  val kind: EnumDefnLayoutCardFilterKind?
  val showSearchBar: Boolean?
  val sortByFieldIdSet: List<MetaIdField>?
  val sortOrder: EnumDefnSortOrder?
}