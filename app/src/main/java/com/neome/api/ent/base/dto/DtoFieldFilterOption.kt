// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

interface DtoFieldFilterOption
{
  val childFilters: Array<DtoFieldFilterOption>?
  val label: String
  val value: String
}