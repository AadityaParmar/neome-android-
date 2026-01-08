// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.msg

import com.neome.api.nucleus.base.msg.Msg

interface MsgPaymentVerify : Msg
{
  val invoiceId: String
  val paymentId: String
  val signature: String
}