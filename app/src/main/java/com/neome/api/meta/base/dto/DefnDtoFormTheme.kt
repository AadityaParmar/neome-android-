// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeButtonSize
import com.neome.api.meta.base.Types.EnumDefnThemeButtonVariant
import com.neome.api.meta.base.Types.EnumDefnThemeFieldMargin
import com.neome.api.meta.base.Types.EnumDefnThemeFieldSize
import com.neome.api.meta.base.Types.EnumDefnThemeFieldVariant
import com.neome.api.meta.base.Types.EnumDefnThemeFormVariant

interface DefnDtoFormTheme
{
  val buttonSize: EnumDefnThemeButtonSize?
  val buttonVariant: EnumDefnThemeButtonVariant?
  val colSpacing: Long?
  val fieldMargin: EnumDefnThemeFieldMargin?
  val fieldSize: EnumDefnThemeFieldSize?
  val fieldVariant: EnumDefnThemeFieldVariant?
  val formVariant: EnumDefnThemeFormVariant?
  val rowSpacing: Long?
}