// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.meta.base.Types.ServiceName

class DescApiPushSigs {
    val importMap: Record<string, string>
    val pushSigs: Record<string, ServiceName>
}
