// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.RowId

open class FieldSetOfRef
{
  lateinit var displaySet: Array<String>
  lateinit var valueSet: Array<RowId>
  lateinit var versionSet: Array<String>
}