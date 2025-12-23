// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import kotlin.properties.Delegates

open class DtoCarouselTemplateGroup {
    var numberOfCardParams: Number by Delegates.notNull<Number>()
    var numberOfCards: Number by Delegates.notNull<Number>()
    var numberOfHeaderMessageParams: Number by Delegates.notNull<Number>()
}
