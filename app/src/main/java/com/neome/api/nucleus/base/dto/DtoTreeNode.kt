// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

open class DtoTreeNode
{
  var children: Array<DtoTreeNode>? = null
  lateinit var name: String
}