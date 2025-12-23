// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.sig

import com.neome.api.ent.base.dto.DtoEntConfig
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EnumStoreLabel
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.api.studio.base.Types.EnumEntActivityState

open class SigStudioEntAvatar : SigVersion() {
    var about: String? = null
    var activityState: EnumEntActivityState? = null
    var avatarId: MediaIdAvatar? = null
    var entConfig: DtoEntConfig? = null
    lateinit var entId: EntId
    var errorCount: Number? = null
    var hasLock: Boolean? = null
    var isDirty: Boolean? = null
    var isEverDeployed: Boolean? = null
    lateinit var lastUpdateTime: String
    lateinit var name: String
    var storeLabelSet: Array<EnumStoreLabel>? = null
}
