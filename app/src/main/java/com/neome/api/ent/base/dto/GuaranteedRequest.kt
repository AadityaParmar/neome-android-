// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import kotlin.properties.Delegates
import com.neome.api.ent.base.dto.DtoGuaranteedRequest

open class GuaranteedRequest
{
  var offset: Number by Delegates.notNull<Number>()
  lateinit var payload: DtoGuaranteedRequest
}