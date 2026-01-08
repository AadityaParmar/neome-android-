// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.extn.sig

import com.neome.api.nucleus.base.sig.Sig

interface SigExtnGstinDetails : Sig
{
  val data: Object?
  val errorCode: Long?
  val errorMessage: String?
}