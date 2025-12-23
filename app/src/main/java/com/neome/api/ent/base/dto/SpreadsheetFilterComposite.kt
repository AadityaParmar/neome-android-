// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.SpreadsheetFilterValue

open class SpreadsheetFilterComposite
{
  var andOr: Boolean? = null
  var filter: SpreadsheetFilterValue? = null
  var filterList: Array<SpreadsheetFilterComposite>? = null
}