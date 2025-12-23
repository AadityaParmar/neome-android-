// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.meta.base.dto.StudioEntDeployPluginMap
import com.neome.api.meta.base.dto.StudioEntPluginMap
import com.neome.api.nucleus.base.sig.SigVersion
import java.util.Map

open class SigEntPluginMap : SigVersion() {
    lateinit var deployPluginMap: StudioEntDeployPluginMap
    lateinit var errorMap: Map<MetaIdPlugin, EnvValidationError>
    lateinit var pluginMap: StudioEntPluginMap
}
