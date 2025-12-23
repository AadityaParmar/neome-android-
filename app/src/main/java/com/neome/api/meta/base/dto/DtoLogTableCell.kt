// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogTableTextStyle

open class DtoLogTableCell
{
  var bgColor: String? = null
  var color: String? = null
  var style: EnumLogTableTextStyle? = null
  lateinit var text: String
}