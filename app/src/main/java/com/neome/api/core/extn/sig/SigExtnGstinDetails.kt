// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.extn.sig

import kotlinx.serialization.json.JsonElement
import com.neome.api.nucleus.base.sig.Sig

interface SigExtnGstinDetails : Sig
{
  val data: JsonElement?
  val errorCode: Long?
  val errorMessage: String?
}