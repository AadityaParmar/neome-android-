// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.ent.base.dto.DtoWorkflowDebugConfig
import com.neome.api.nucleus.base.sig.SigVersion

class SigWorkflowDebugConfig : SigVersion() {
    val config: DtoWorkflowDebugConfig
}
