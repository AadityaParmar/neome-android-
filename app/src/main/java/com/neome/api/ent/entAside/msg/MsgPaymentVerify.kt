// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.msg

import com.neome.api.nucleus.base.msg.Msg

class MsgPaymentVerify : Msg() {
    val invoiceId: string
    val paymentId: string
    val signature: string
}
