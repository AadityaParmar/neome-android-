// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSection

interface DefnStudioPickSectionId : DefnFieldEditable {
    val excludeSectionIdSet: List<MetaIdSection>?
    val formId: MetaIdForm
}
