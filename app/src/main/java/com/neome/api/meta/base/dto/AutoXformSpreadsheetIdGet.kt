// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.AutoXform
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

interface AutoXformSpreadsheetIdGet : AutoXform
{
  val source: StudioDtoArgValueParameter?
  val target: StudioDtoArgValueParameter?
}