// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import kotlin.properties.Delegates
import com.neome.api.meta.base.dto.DtoCarouselTemplateGroup
import com.neome.api.meta.base.Types.EnumWhatsAppTemplateHeaderType
import java.util.Set

open class DtoWhatsAppTemplateGroup
{
  var carouselCardFormat: String? = null
  var carouselCardSample: String? = null
  var carouselTemplateGroup: DtoCarouselTemplateGroup? = null
  lateinit var format: String
  lateinit var groupId: String
  lateinit var groupName: String
  var isCarouselTemplate: Boolean by Delegates.notNull<Boolean>()
  var numberOfButtonParams: Number? = null
  var numberOfParams: Number by Delegates.notNull<Number>()
  lateinit var sample: String
  lateinit var supportedHeaders: Array<EnumWhatsAppTemplateHeaderType>
}