// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioMapOfValueText
import com.neome.api.meta.base.dto.StudioPluginAuthBase
import com.neome.api.meta.base.dto.StudioValueText

interface StudioPluginAuthOAuth : StudioPluginAuthBase
{
  val additionalProperties: StudioMapOfValueText?
  val authEndPoint: StudioValueText?
  val clientId: StudioValueText?
  val clientSecret: StudioValueText?
  val scopes: StudioValueText?
  val tokenEndPoint: StudioValueText?
}