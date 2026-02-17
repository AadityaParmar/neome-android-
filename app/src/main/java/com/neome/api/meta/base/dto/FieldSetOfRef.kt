// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.RowId

interface FieldSetOfRef
{
  val displaySet: List<String>
  val valueSet: List<RowId>
  val versionSet: List<String>
}