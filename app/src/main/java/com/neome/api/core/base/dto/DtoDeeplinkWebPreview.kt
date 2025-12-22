// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.core.base.Types.EnumDeeplinkActionType
import com.neome.api.meta.base.Types.MediaIdAvatar

class DtoDeeplinkWebPreview {
    var avatarId: MediaIdAvatar? = null
    var deeplinkActionType: EnumDeeplinkActionType? = null
    var desc: string? = null
    var info: string? = null
    var senderName: string? = null
    var targetName: string? = null
    var title: string? = null
}
