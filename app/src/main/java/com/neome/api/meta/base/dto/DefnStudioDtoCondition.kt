// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnMapOfCondition

interface DefnStudioDtoCondition : DefnMapOfCondition
{
  val negation: Boolean?
}