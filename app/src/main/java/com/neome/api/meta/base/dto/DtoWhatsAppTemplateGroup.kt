// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DtoCarouselTemplateGroup
import com.neome.api.meta.base.Types.EnumWhatsAppTemplateHeaderType

interface DtoWhatsAppTemplateGroup
{
  val carouselCardFormat: String?
  val carouselCardSample: String?
  val carouselTemplateGroup: DtoCarouselTemplateGroup?
  val format: String
  val groupId: String
  val groupName: String
  val isCarouselTemplate: Boolean
  val numberOfButtonParams: Long?
  val numberOfParams: Long?
  val sample: String
  val supportedHeaders: Array<EnumWhatsAppTemplateHeaderType>
}