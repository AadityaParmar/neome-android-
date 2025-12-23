// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.core.base.dto.DtoNotificationSetting
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.msg.Msg

open class MsgCallerProfilePatch : Msg() {
    var about: String? = null
    var enterIsSendDesktop: Boolean? = null
    var enterIsSendMobile: Boolean? = null
    lateinit var firstName: String
    var globalNotificationSetting: DtoNotificationSetting? = null
    var languageKey: LanguageKey? = null
    lateinit var lastName: String
    var mediaIdAvatar: MediaIdAvatar? = null
}
