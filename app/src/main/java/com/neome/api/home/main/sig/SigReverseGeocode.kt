// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.meta.base.dto.FieldDtoLocation
import com.neome.api.meta.base.Types.GeoPoint
import com.neome.api.nucleus.base.sig.Sig

interface SigReverseGeocode : Sig
{
  val map: Map<GeoPoint, FieldDtoLocation>
}