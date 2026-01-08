// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.Types.EnumDefnPlacement

interface FieldDtoSectionLayout
{
  val alignItems: EnumDefnPlacement?
  val autoSize: Boolean?
  val backgroundColorVar: DefnDtoColor?
  val borderBottom: Boolean?
  val borderBottomLeftRadius: Long?
  val borderBottomRightRadius: Long?
  val borderColor: DefnDtoColor?
  val borderLeft: Boolean?
  val borderRight: Boolean?
  val borderTop: Boolean?
  val borderTopLeftRadius: Long?
  val borderTopRightRadius: Long?
  val flex: String?
  val flexGrow: String?
  val height: String?
  val justifyContent: EnumDefnPlacement?
  val maxHeight: String?
  val maxWidth: String?
  val minHeight: String?
  val minWidth: String?
  val overflow: String?
  val overflowX: String?
  val overflowY: String?
  val pb: Long?
  val pl: Long?
  val pr: Long?
  val pt: Long?
  val textColorVar: DefnDtoColor?
  val width: String?
}