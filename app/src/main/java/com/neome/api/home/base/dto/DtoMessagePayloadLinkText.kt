// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessagePayloadText

interface DtoMessagePayloadLinkText : DtoMessagePayloadText
{
  val pageIconUrl: String?
  val pageSubTitle: String?
  val pageTitle: String?
  val pageUrl: String
}