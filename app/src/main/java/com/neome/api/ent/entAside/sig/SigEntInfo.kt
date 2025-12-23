// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.sig

import com.neome.api.meta.base.Types.DemoAppId
import com.neome.api.ent.base.dto.DtoEntUserAvatar
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.api.meta.base.Types.TimeZoneKey

open class SigEntInfo : SigVersion()
{
  lateinit var about: String
  var avatarId: MediaIdAvatar? = null
  lateinit var demoAppId: DemoAppId
  var entUserAvatarList: Array<DtoEntUserAvatar>? = null
  var languageSet: Array<LanguageKey>? = null
  lateinit var name: String
  lateinit var timeZone: TimeZoneKey
}