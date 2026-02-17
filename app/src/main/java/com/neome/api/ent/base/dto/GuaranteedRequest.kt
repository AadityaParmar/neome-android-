// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoGuaranteedRequest

interface GuaranteedRequest
{
  val offset: Long
  val payload: DtoGuaranteedRequest
}