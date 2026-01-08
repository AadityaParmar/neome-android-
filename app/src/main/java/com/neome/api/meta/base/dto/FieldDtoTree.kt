// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoTreeNode
import java.util.Map

interface FieldDtoTree
{
  val keys: Array<String>
  val map: Map<String, FieldDtoTreeNode>
}