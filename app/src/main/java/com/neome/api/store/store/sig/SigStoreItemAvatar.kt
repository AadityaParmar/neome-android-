// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.sig

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumStoreItemArtifact
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.StoreItemId
import com.neome.api.nucleus.base.sig.SigVersion

class SigStoreItemAvatar : SigVersion() {
    var about: string? = null
    val artifactKind: EnumStoreItemArtifact
    var avatarId: MediaIdAvatar? = null
    val name: string
    val storeItemId: StoreItemId
    var updatedBy: AdminId? = null
    var updatedOn: string? = null
}
