// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdVar

class StudioGrid : StudioComposite() {
    var layoutGridMap: StudioMapOfLayoutGrid? = null
    var maxRows: number? = null
    var maxRowsVarId: MetaIdVar? = null
    val metaId: MetaIdGrid
    var minRows: number? = null
    var minRowsVarId: MetaIdVar? = null
    var rowActionPermissionMap: StudioMapOfActionPermission? = null
    var showAllRowsFieldId: MetaIdField? = null
}
