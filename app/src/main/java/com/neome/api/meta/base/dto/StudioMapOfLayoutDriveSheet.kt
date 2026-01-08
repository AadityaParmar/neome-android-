// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutDriveSheet
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutDriveSheet

interface StudioMapOfLayoutDriveSheet : StudioBase
{
  val includeMetaFieldIdSet: Array<MetaIdField>?
  val keys: Array<MetaIdLayoutDriveSheet>
  val map: Map<MetaIdLayoutDriveSheet, StudioDtoLayoutDriveSheet>
}