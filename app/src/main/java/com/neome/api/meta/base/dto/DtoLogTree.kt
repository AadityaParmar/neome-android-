// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DtoLogItem
import com.neome.api.meta.base.dto.DtoLogTreeItem

interface DtoLogTree : DtoLogItem
{
  val bgColor: String
  val children: List<DtoLogTreeItem>?
  val keyColor: String
  val keyWidth: Long
  val lineColor: String
  val tabWidth: Long
  val valueColor: String
}