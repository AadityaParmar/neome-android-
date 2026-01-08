// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnBuildDateTime
import com.neome.api.meta.base.dto.DefnFieldDateTime
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldDateTimeRange : DefnFieldDateTime
{
  val allowSingleDate: Boolean?
  val fromDefault: DefnBuildDateTime?
  val fromDefaultFieldId: MetaIdField?
  val fromDefaultVar: DefnBuildDateTime?
  val toDefault: DefnBuildDateTime?
  val toDefaultFieldId: MetaIdField?
  val toDefaultVar: DefnBuildDateTime?
}