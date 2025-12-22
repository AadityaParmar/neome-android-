// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.home.drawer.sig.SigUserAvatar
import com.neome.api.meta.base.Types.EnumDefnLogOperationKind

class DtoEntLogNumberFieldTransaction {
    val createdOn: string
    var message: string? = null
    val operationKind: EnumDefnLogOperationKind
    val transactionId: string
    val userAvatar: SigUserAvatar
    val value: number
}
