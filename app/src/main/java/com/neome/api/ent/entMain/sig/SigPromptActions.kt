// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.ent.base.dto.DtoPromptAction
import com.neome.api.nucleus.base.sig.Sig

class SigPromptActions : Sig() {
    var executedPromptActionList: DtoPromptAction[]? = null
    var reviewPromptActionList: DtoPromptAction[]? = null
}
