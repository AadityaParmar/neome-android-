// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.sig

import kotlin.properties.Delegates
import com.neome.api.nucleus.base.Types.EnumMediaExchangeStatus
import com.neome.api.nucleus.base.sig.Sig

open class SigMediaPriorUpload : Sig()
{
  var serverUploadLen: Number by Delegates.notNull<Number>()
  lateinit var serverUploadState: EnumMediaExchangeStatus
}