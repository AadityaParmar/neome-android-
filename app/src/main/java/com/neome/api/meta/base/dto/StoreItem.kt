// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EnumStoreItemArtifact
import com.neome.api.meta.base.Types.StoreItemId

class StoreItem : StudioBase() {
    val artifactKind: EnumStoreItemArtifact
    var createdBy: AdminId? = null
    var createdOn: string? = null
    var pluginBundle: StudioPluginBundle? = null
    var seedEntId: EntId? = null
    val storeItemId: StoreItemId
    var studioEnt: StudioEnt? = null
    var updatedBy: AdminId? = null
    var updatedOn: string? = null
}
