// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.sig

import com.neome.api.home.base.dto.DtoReceipt
import com.neome.api.meta.base.Types.EntUserId
import java.util.Map
import com.neome.api.nucleus.base.sig.Sig

interface SigMessageReceiptMap : Sig
{
  val entUserReceiptMap: Map<EntUserId, DtoReceipt>
}