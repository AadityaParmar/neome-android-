// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioGrid : StudioComposite() {
    var layoutGridMap: StudioMapOfLayoutGrid? = null
    var maxRows: Number? = null
    var maxRowsVarId: MetaIdVar? = null
    lateinit var metaId: MetaIdGrid
    var minRows: Number? = null
    var minRowsVarId: MetaIdVar? = null
    var rowActionPermissionMap: StudioMapOfActionPermission? = null
    var showAllRowsFieldId: MetaIdField? = null
}
