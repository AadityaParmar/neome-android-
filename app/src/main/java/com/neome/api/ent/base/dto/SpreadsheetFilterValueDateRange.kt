// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import java.util.Date
import com.neome.api.ent.base.dto.SpreadsheetFilterValue

interface SpreadsheetFilterValueDateRange : SpreadsheetFilterValue
{
  val from: String?
  val to: String?
}