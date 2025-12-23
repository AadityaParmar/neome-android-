// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AdminId
import java.util.Date
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EnumStoreItemArtifact
import com.neome.api.meta.base.Types.StoreItemId
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEnt
import com.neome.api.meta.base.dto.StudioPluginBundle

open class StoreItem : StudioBase()
{
  lateinit var artifactKind: EnumStoreItemArtifact
  var createdBy: AdminId? = null
  var createdOn: String? = null
  var pluginBundle: StudioPluginBundle? = null
  var seedEntId: EntId? = null
  lateinit var storeItemId: StoreItemId
  var studioEnt: StudioEnt? = null
  var updatedBy: AdminId? = null
  var updatedOn: String? = null
}