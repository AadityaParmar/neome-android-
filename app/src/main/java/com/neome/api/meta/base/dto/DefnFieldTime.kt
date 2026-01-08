// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnBuildTime
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldTime : DefnFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: DefnBuildTime?
  val defaultVar: DefnBuildTime?
  val displayDateFormat: String?
  val max: DefnBuildTime?
  val maxFieldId: MetaIdField?
  val maxVar: DefnBuildTime?
  val min: DefnBuildTime?
  val minFieldId: MetaIdField?
  val minVar: DefnBuildTime?
  val showSecond: Boolean?
  val showSecondFieldId: MetaIdField?
  val showSecondVar: Boolean?
}