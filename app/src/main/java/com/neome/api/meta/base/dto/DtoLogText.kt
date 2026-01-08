// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DtoLogItem
import com.neome.api.meta.base.Types.EnumFormContentPosition
import com.neome.api.meta.base.Types.EnumLogTextType

interface DtoLogText : DtoLogItem
{
  val bgColor: String
  val bold: Boolean?
  val caption: String?
  val child: DtoLogItem?
  val contentPosition: EnumFormContentPosition?
  val executable: Boolean?
  val iconEnd: String?
  val iconEndColor: String?
  val iconStart: String?
  val iconStartColor: String?
  val showChildDivider: Boolean?
  val text: String
  val textColor: String?
  val textType: EnumLogTextType?
}