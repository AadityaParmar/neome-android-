// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.dto.TranslatePath

open class TranslateResult
{
  lateinit var translateMap: Map<String, Array<TranslatePath>>
}