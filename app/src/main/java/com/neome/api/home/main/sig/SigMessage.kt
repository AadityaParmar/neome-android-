// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.home.base.Types.EnumReceiptStatus

open class SigMessage : SigMessageBase() {
    var receiptStatus: EnumReceiptStatus? = null
    var version: String? = null
}
