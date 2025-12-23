// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map

open class TranslateResult {
    lateinit var translateMap: Map<String, Array<TranslatePath>>
}
