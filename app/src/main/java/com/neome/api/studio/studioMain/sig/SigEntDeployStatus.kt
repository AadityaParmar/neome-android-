// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import java.util.Date
import com.neome.api.meta.base.Types.EntId
import com.neome.api.studio.base.Types.EnumEntDeployExecutionState
import com.neome.api.nucleus.base.sig.SigVersion

open class SigEntDeployStatus : SigVersion()
{
  lateinit var entId: EntId
  lateinit var executionState: EnumEntDeployExecutionState
  lateinit var jobKey: String
  lateinit var lastUpdate: String
  lateinit var message: String
}