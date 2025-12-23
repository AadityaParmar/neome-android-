// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.ent.base.dto.DtoEntConfig
import com.neome.api.nucleus.base.sig.SigVersion

open class SigStudioEntConfig : SigVersion() {
    var config: DtoEntConfig? = null
}
