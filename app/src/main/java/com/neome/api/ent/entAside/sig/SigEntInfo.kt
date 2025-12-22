// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.sig

import com.neome.api.ent.base.dto.DtoEntUserAvatar
import com.neome.api.meta.base.Types.DemoAppId
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.TimeZoneKey
import com.neome.api.nucleus.base.sig.SigVersion

class SigEntInfo : SigVersion() {
    val about: string
    var avatarId: MediaIdAvatar? = null
    val demoAppId: DemoAppId
    var entUserAvatarList: DtoEntUserAvatar[]? = null
    var languageSet: LanguageKey[]? = null
    val name: string
    val timeZone: TimeZoneKey
}
