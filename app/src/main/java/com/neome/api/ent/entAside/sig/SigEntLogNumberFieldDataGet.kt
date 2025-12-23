// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.sig

import com.neome.api.ent.base.dto.DtoEntLogNumberFieldTransaction
import com.neome.api.nucleus.base.sig.Sig

open class SigEntLogNumberFieldDataGet : Sig()
{
  lateinit var transactionList: Array<DtoEntLogNumberFieldTransaction>
}