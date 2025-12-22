// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.meta.base.Types.GeoPoint
import com.neome.api.nucleus.base.msg.Msg

class MsgReverseGeocode : Msg() {
    val geoPoints: GeoPoint[]
}
