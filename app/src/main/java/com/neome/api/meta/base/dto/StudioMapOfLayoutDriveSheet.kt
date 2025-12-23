// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutDriveSheet
import java.util.Map

open class StudioMapOfLayoutDriveSheet : StudioBase() {
    var includeMetaFieldIdSet: Array<MetaIdField>? = null
    lateinit var keys: Array<MetaIdLayoutDriveSheet>
    lateinit var map: Map<MetaIdLayoutDriveSheet, StudioDtoLayoutDriveSheet>
}
