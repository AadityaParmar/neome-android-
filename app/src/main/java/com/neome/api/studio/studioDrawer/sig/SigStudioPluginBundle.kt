// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.sig

import com.neome.api.meta.base.dto.StudioPluginBundle
import com.neome.api.meta.base.dto.ValidationResult
import com.neome.api.nucleus.base.sig.SigVersion

class SigStudioPluginBundle : SigVersion() {
    val studioPluginBundle: StudioPluginBundle
    var validationResult: ValidationResult? = null
}
