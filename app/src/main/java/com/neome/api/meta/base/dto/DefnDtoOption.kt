// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor

interface DefnDtoOption
{
  val color: DefnDtoColor?
  val disabled: Boolean?
  val hint: String?
  val isRemoved: Boolean?
  val metaId: String
  val value: String
}