// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.dto.FieldDtoImage

open class DtoChatBubbleHeader
{
  var image: FieldDtoImage? = null
  lateinit var subTitle: String
  lateinit var title: String
}