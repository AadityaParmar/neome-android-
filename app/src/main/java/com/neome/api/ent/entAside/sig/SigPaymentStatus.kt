// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.sig

import com.neome.api.meta.base.Types.EnumDefnPaymentStatus
import com.neome.api.nucleus.base.sig.Sig

open class SigPaymentStatus : Sig()
{
  lateinit var paymentStatus: EnumDefnPaymentStatus
}