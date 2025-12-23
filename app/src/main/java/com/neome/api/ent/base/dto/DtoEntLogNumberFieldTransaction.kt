// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.home.drawer.sig.SigUserAvatar
import com.neome.api.meta.base.Types.EnumDefnLogOperationKind
import kotlin.properties.Delegates

open class DtoEntLogNumberFieldTransaction {
    lateinit var createdOn: String
    var message: String? = null
    lateinit var operationKind: EnumDefnLogOperationKind
    lateinit var transactionId: String
    lateinit var userAvatar: SigUserAvatar
    var value: Number by Delegates.notNull<Number>()
}
