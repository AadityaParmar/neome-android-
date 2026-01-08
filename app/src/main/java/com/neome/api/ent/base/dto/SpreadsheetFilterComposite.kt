// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.SpreadsheetFilterValue

interface SpreadsheetFilterComposite
{
  val andOr: Boolean?
  val filter: SpreadsheetFilterValue?
  val filterList: Array<SpreadsheetFilterComposite>?
}