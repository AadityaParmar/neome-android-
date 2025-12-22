// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumWhatsAppTemplateHeaderType

class DtoWhatsAppTemplateGroup {
    var carouselCardFormat: string? = null
    var carouselCardSample: string? = null
    var carouselTemplateGroup: DtoCarouselTemplateGroup? = null
    val format: string
    val groupId: string
    val groupName: string
    val isCarouselTemplate: boolean
    var numberOfButtonParams: number? = null
    val numberOfParams: number
    val sample: string
    val supportedHeaders: EnumWhatsAppTemplateHeaderType[]
}
