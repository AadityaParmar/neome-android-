// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.sig

import com.neome.api.meta.base.Types.AdminId
import java.util.Date
import com.neome.api.meta.base.Types.EnumStoreItemArtifact
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.api.meta.base.Types.StoreItemId

open class SigStoreItemAvatar : SigVersion()
{
  var about: String? = null
  lateinit var artifactKind: EnumStoreItemArtifact
  var avatarId: MediaIdAvatar? = null
  lateinit var name: String
  lateinit var storeItemId: StoreItemId
  var updatedBy: AdminId? = null
  var updatedOn: String? = null
}