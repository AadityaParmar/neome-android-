// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.meta.base.dto.StudioEntDeployPluginMap
import com.neome.api.meta.base.dto.StudioEntPluginMap
import com.neome.api.nucleus.base.sig.SigVersion

class SigEntPluginMap : SigVersion() {
    val deployPluginMap: StudioEntDeployPluginMap
    val errorMap: Record<MetaIdPlugin, EnvValidationError>
    val pluginMap: StudioEntPluginMap
}
