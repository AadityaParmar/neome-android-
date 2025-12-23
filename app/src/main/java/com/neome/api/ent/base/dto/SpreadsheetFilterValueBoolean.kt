// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import kotlin.properties.Delegates
import com.neome.api.ent.base.dto.SpreadsheetFilterValue

open class SpreadsheetFilterValueBoolean : SpreadsheetFilterValue()
{
  var value: Boolean by Delegates.notNull<Boolean>()
}