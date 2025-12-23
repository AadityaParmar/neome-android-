// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import java.util.Date
import com.neome.api.ent.base.dto.SpreadsheetFilterValue

open class SpreadsheetFilterValueDateRange : SpreadsheetFilterValue()
{
  var from: String? = null
  var to: String? = null
}