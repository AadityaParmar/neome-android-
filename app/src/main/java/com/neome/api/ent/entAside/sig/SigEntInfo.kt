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

interface SigEntInfo : SigVersion
{
  val about: String
  val avatarId: MediaIdAvatar?
  val demoAppId: DemoAppId
  val entUserAvatarList: List<DtoEntUserAvatar>?
  val languageSet: List<LanguageKey>?
  val name: String
  val timeZone: TimeZoneKey
}