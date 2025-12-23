// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessagePayloadText

open class DtoMessagePayloadLinkText : DtoMessagePayloadText()
{
  var pageIconUrl: String? = null
  var pageSubTitle: String? = null
  var pageTitle: String? = null
  lateinit var pageUrl: String
}