// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnWizardNavigationMode
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdWizard

open class DefnWizard : DefnComp() {
    var compositeIdSet: Array<MetaIdComposite>? = null
    lateinit var metaId: MetaIdWizard
    var navigationMode: EnumDefnWizardNavigationMode? = null
    var nextButtonLabel: String? = null
    var prevButtonLabel: String? = null
}
