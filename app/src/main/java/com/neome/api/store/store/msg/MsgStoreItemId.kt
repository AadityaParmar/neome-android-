// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.StoreItemId

class MsgStoreItemId : MsgVersion() {
    val storeItemId: StoreItemId
}
