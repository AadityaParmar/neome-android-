// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnBuildDate
import com.neome.api.meta.base.dto.DefnFieldDate
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldDateRange : DefnFieldDate
{
  val allowSingleDate: Boolean?
  val fromDefault: DefnBuildDate?
  val fromDefaultFieldId: MetaIdField?
  val fromDefaultVar: DefnBuildDate?
  val toDefault: DefnBuildDate?
  val toDefaultFieldId: MetaIdField?
  val toDefaultVar: DefnBuildDate?
}