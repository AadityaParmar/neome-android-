// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.dto.StudioBase

open class FieldDtoTreeNode : StudioBase()
{
  lateinit var keys: Array<String>
  lateinit var map: Map<String, FieldDtoTreeNode>
  lateinit var metaId: String
  var value: String? = null
}