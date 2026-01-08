// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.dto.FieldDtoImage

interface DtoChatBubbleHeader
{
  val image: FieldDtoImage?
  val subTitle: String
  val title: String
}