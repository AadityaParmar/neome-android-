// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPermission
import com.neome.api.meta.base.Types.MetaIdRole
import java.util.Map

open class StudioDtoPermissionMatrix : StudioBase() {
    var defaultPermission: EnumDefnPermission? = null
    lateinit var keys: Array<MetaIdRole>
    lateinit var map: Map<MetaIdRole, EnumDefnPermission>
}
