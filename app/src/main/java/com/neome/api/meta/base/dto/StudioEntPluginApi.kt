// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPluginApiMethod
import com.neome.api.meta.base.Types.MetaIdAuthMethod
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.PluginApiId
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfArgBinder
import com.neome.api.meta.base.dto.StudioPluginApiBody
import com.neome.api.meta.base.Symbol

interface StudioEntPluginApi : StudioBase
{
  val apiType: EnumDefnPluginApiMethod
  val authMethodId: MetaIdAuthMethod?
  val baseURL: String?
  val guaranteedInvocation: Boolean?
  val headerParamMap: StudioMapOfArgBinder?
  val inputFormId: MetaIdForm?
  val isAuthSupported: Boolean?
  val name: Symbol
  val outputFormId: MetaIdForm?
  val pluginApiId: PluginApiId
  val queryParamMap: StudioMapOfArgBinder?
  val requestBody: StudioPluginApiBody?
  val responseBody: StudioPluginApiBody?
}