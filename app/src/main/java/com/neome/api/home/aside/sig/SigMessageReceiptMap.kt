// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.sig

import com.neome.api.home.base.dto.DtoReceipt
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.nucleus.base.sig.Sig

class SigMessageReceiptMap : Sig() {
    val entUserReceiptMap: Record<EntUserId, DtoReceipt>
}
