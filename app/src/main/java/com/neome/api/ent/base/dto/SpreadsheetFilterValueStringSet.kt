// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import java.util.Set
import com.neome.api.ent.base.dto.SpreadsheetFilterValue

interface SpreadsheetFilterValueStringSet : SpreadsheetFilterValue
{
  val valueSet: Array<String>
}