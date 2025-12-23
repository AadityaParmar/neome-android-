// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnLayoutGridKind
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

open class DefnStudioPickLayoutGridId : DefnFieldEditable() {
    lateinit var excludeLayoutGridIdSet: Array<MetaIdLayoutGrid>
    var filterLayoutKindSet: Array<EnumDefnLayoutGridKind>? = null
    lateinit var formId: MetaIdForm
    var gridId: MetaIdGrid? = null
}
