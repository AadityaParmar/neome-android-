// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import kotlin.properties.Delegates
import com.neome.api.ent.base.dto.SpreadsheetFilterValue

open class SpreadsheetFilterValueNullable : SpreadsheetFilterValue()
{
  var isNullable: Boolean by Delegates.notNull<Boolean>()
}