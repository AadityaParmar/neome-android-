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

interface StoreItem : StudioBase
{
  val artifactKind: EnumStoreItemArtifact
  val createdBy: AdminId?
  val createdOn: String?
  val pluginBundle: StudioPluginBundle?
  val seedEntId: EntId?
  val storeItemId: StoreItemId
  val studioEnt: StudioEnt?
  val updatedBy: AdminId?
  val updatedOn: String?
}