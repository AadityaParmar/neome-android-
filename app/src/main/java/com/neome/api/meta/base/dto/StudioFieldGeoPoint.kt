// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.GeoPoint
import com.neome.api.meta.base.Types.MetaIdField

open class StudioFieldGeoPoint : StudioFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: GeoPoint? = null
}
