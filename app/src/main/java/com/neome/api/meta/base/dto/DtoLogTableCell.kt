// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumLogTableTextStyle

interface DtoLogTableCell
{
  val bgColor: String?
  val color: String?
  val style: EnumLogTableTextStyle?
  val text: String
}