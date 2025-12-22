// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnWizardNavigationMode
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdWizard

class DefnWizard : DefnComp() {
    var compositeIdSet: MetaIdComposite[]? = null
    val metaId: MetaIdWizard
    var navigationMode: EnumDefnWizardNavigationMode? = null
    var nextButtonLabel: string? = null
    var prevButtonLabel: string? = null
}
