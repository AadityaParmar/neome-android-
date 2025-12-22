// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutDriveSheet

class StudioMapOfLayoutDriveSheet : StudioBase() {
    var includeMetaFieldIdSet: MetaIdField[]? = null
    val keys: MetaIdLayoutDriveSheet[]
    val map: Record<MetaIdLayoutDriveSheet, StudioDtoLayoutDriveSheet>
}
