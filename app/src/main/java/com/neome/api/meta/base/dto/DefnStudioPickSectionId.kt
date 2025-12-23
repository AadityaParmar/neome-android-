// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSection

open class DefnStudioPickSectionId : DefnFieldEditable() {
    var excludeSectionIdSet: Array<MetaIdSection>? = null
    lateinit var formId: MetaIdForm
}
