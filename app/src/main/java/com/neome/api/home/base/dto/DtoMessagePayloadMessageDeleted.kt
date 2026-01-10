// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.core.common.IPayload

interface DtoMessagePayloadMessageDeleted : DtoMessagePayload {
    val arr: List<IPayload>
    val map: Map<String, IPayload>
}
