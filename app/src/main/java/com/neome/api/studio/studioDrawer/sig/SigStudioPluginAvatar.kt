// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.sig

import com.neome.api.meta.base.Types.EnumDefnPluginMode
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.PluginBundleId
import com.neome.api.nucleus.base.sig.SigVersion

class SigStudioPluginAvatar : SigVersion() {
    var about: string? = null
    var avatarId: MediaIdAvatar? = null
    var errorCount: number? = null
    var hasLock: boolean? = null
    var isDirty: boolean? = null
    var isEverDeployed: boolean? = null
    val lastUpdateTime: string
    var mode: EnumDefnPluginMode? = null
    val name: string
    val pluginBundleId: PluginBundleId
}
