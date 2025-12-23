// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.msg

import com.neome.api.core.base.dto.DtoCloneConfig
import com.neome.api.meta.base.Types.StoreItemId
import com.neome.api.nucleus.base.msg.Msg

open class MsgStoreItemProvision : Msg() {
    var cloneConfig: DtoCloneConfig? = null
    var includeData: Boolean? = null
    lateinit var storeItemId: StoreItemId
}
