// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

interface DtoTreeNode
{
  val children: Array<DtoTreeNode>?
  val name: String
}