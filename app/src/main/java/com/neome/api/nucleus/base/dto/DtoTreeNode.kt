// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

interface DtoTreeNode
{
  val children: List<DtoTreeNode>?
  val name: String
}