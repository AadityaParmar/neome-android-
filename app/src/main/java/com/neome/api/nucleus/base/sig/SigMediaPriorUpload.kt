// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.sig

import com.neome.api.nucleus.base.Types.EnumMediaExchangeStatus
import com.neome.api.nucleus.base.sig.Sig

interface SigMediaPriorUpload : Sig
{
  val serverUploadLen: Long?
  val serverUploadState: EnumMediaExchangeStatus
}