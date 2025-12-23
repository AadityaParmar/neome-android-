// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.msg

import com.neome.api.meta.base.Types.EnumStoreItemArtifact
import com.neome.api.meta.base.Types.EnumStoreLabel
import com.neome.api.meta.base.Types.StoreItemId
import com.neome.api.nucleus.base.msg.Msg

open class MsgStoreSearch : Msg() {
    var artifactKind: EnumStoreItemArtifact? = null
    var filterStoreItemIdSet: Array<StoreItemId>? = null
    lateinit var query: String
    lateinit var searchId: String
    var storeLabelSet: Array<EnumStoreLabel>? = null
}
