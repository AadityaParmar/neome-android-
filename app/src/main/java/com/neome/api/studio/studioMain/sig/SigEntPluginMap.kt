// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.dto.EnvValidationError
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.api.meta.base.dto.StudioEntDeployPluginMap
import com.neome.api.meta.base.dto.StudioEntPluginMap

open class SigEntPluginMap : SigVersion()
{
  lateinit var deployPluginMap: StudioEntDeployPluginMap
  lateinit var errorMap: Map<MetaIdPlugin, EnvValidationError>
  lateinit var pluginMap: StudioEntPluginMap
}