// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.sig

import com.neome.api.meta.base.Types.EnumDefnPluginMode
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.PluginBundleId
import com.neome.api.nucleus.base.sig.SigVersion

open class SigStudioPluginAvatar : SigVersion() {
    var about: String? = null
    var avatarId: MediaIdAvatar? = null
    var errorCount: Number? = null
    var hasLock: Boolean? = null
    var isDirty: Boolean? = null
    var isEverDeployed: Boolean? = null
    lateinit var lastUpdateTime: String
    var mode: EnumDefnPluginMode? = null
    lateinit var name: String
    lateinit var pluginBundleId: PluginBundleId
}
