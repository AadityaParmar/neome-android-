// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.sig

import com.neome.api.nucleus.base.Types.EnumMediaExchangeStatus

class SigMediaPriorUpload : Sig() {
    val serverUploadLen: number
    val serverUploadState: EnumMediaExchangeStatus
}
