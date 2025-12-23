// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutDriveSheet
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutDriveSheet

open class StudioMapOfLayoutDriveSheet : StudioBase()
{
  var includeMetaFieldIdSet: Array<MetaIdField>? = null
  lateinit var keys: Array<MetaIdLayoutDriveSheet>
  lateinit var map: Map<MetaIdLayoutDriveSheet, StudioDtoLayoutDriveSheet>
}