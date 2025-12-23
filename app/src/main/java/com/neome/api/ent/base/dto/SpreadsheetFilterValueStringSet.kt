// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import java.util.Set
import com.neome.api.ent.base.dto.SpreadsheetFilterValue

open class SpreadsheetFilterValueStringSet : SpreadsheetFilterValue()
{
  lateinit var valueSet: Array<String>
}