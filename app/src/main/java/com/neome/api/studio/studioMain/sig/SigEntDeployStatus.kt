// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.api.studio.base.Types.EnumEntDeployExecutionState

open class SigEntDeployStatus : SigVersion() {
    lateinit var entId: EntId
    lateinit var executionState: EnumEntDeployExecutionState
    lateinit var jobKey: String
    lateinit var lastUpdate: String
    lateinit var message: String
}
