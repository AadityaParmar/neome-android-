// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.core.base.dto.DtoGeoPoint
import com.neome.api.nucleus.base.msg.Msg

open class MsgCallerLocationPut : Msg() {
    lateinit var geoPoints: Array<DtoGeoPoint>
}
