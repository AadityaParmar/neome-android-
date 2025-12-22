// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.api.studio.base.Types.EnumEntDeployExecutionState

class SigEntDeployStatus : SigVersion() {
    val entId: EntId
    val executionState: EnumEntDeployExecutionState
    val jobKey: string
    val lastUpdate: string
    val message: string
}
