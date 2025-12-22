// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.dto.StudioEnt
import com.neome.api.meta.base.dto.TranslateResult
import com.neome.api.meta.base.dto.ValidationResult
import com.neome.api.nucleus.base.sig.SigVersion

class SigStudioEnt : SigVersion() {
    val ent: StudioEnt
    var isEverDeployed: boolean? = null
    var translateResult: TranslateResult? = null
    var validationResult: ValidationResult? = null
}
