// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPluginApiMethod
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.PluginApiId
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfArgBinder
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.meta.base.dto.StudioPluginApiBody
import com.neome.api.meta.base.dto.StudioValueVarIdText
import com.neome.api.meta.base.Symbol

interface StudioPluginApi : StudioBase
{
  val apiType: EnumDefnPluginApiMethod
  val baseURLVarId: StudioValueVarIdText?
  val creationDate: String
  val description: String?
  val guaranteedInvocation: Boolean?
  val headerParamMap: StudioMapOfArgBinder?
  val inputFormId: MetaIdForm?
  val metaId: PluginApiId
  val modules: StudioModuleSelection?
  val name: Symbol
  val outputFormId: MetaIdForm?
  val queryParamMap: StudioMapOfArgBinder?
  val requestBody: StudioPluginApiBody?
  val responseBody: StudioPluginApiBody?
}