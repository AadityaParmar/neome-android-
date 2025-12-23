// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.SpreadsheetFilterValue

open class SpreadsheetFilterValueDoubleRange : SpreadsheetFilterValue()
{
  var max: Number? = null
  var min: Number? = null
}