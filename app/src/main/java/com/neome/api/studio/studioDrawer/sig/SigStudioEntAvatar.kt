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

class SigStudioEntAvatar : SigVersion() {
    var about: string? = null
    var activityState: EnumEntActivityState? = null
    var avatarId: MediaIdAvatar? = null
    var entConfig: DtoEntConfig? = null
    val entId: EntId
    var errorCount: number? = null
    var hasLock: boolean? = null
    var isDirty: boolean? = null
    var isEverDeployed: boolean? = null
    val lastUpdateTime: string
    val name: string
    var storeLabelSet: EnumStoreLabel[]? = null
}
