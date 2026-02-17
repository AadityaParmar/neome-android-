// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnLogOperationKind
import com.neome.api.home.drawer.sig.SigUserAvatar

interface DtoEntLogNumberFieldTransaction
{
  val createdOn: String
  val message: String?
  val operationKind: EnumDefnLogOperationKind
  val transactionId: String
  val userAvatar: SigUserAvatar
  val value: Double
}