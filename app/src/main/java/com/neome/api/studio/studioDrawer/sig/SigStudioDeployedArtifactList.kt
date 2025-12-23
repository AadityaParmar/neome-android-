// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.sig

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.PluginBundleId
import com.neome.api.nucleus.base.sig.Sig

open class SigStudioDeployedArtifactList : Sig() {
    var entIdSet: Array<EntId>? = null
    var pluginBundleIdSet: Array<PluginBundleId>? = null
}
