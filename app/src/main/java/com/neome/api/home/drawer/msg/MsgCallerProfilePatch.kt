// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.core.base.dto.DtoNotificationSetting
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.msg.Msg

class MsgCallerProfilePatch : Msg() {
    var about: string? = null
    var enterIsSendDesktop: boolean? = null
    var enterIsSendMobile: boolean? = null
    val firstName: string
    var globalNotificationSetting: DtoNotificationSetting? = null
    var languageKey: LanguageKey? = null
    val lastName: string
    var mediaIdAvatar: MediaIdAvatar? = null
}
