// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.StoreItemId

open class MsgStoreItemId : MsgVersion() {
    lateinit var storeItemId: StoreItemId
}
