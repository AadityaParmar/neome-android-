// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EntUserId

interface FieldSetOfEntUserId
{
  val displaySet: Array<String>?
  val valueSet: Array<EntUserId>
}