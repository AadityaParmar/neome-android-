// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPlugin

interface DefnStudioMapOfMapping : DefnFieldEditable
{
  val fromFormId: MetaIdForm?
  val fromGridId: MetaIdGrid?
  val fromPluginId: MetaIdPlugin?
  val toFormId: MetaIdForm
  val toGridId: MetaIdGrid?
  val toPluginId: MetaIdPlugin?
}