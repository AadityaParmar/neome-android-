// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.home.base.Types.EnumReceiptStatus
import com.neome.api.home.main.sig.SigMessageBase

interface SigMessage : SigMessageBase
{
  val receiptStatus: EnumReceiptStatus?
  val version: String?
}