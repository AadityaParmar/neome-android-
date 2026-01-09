// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.sig

import kotlinx.serialization.json.JsonElement
import com.neome.api.nucleus.base.sig.SigVersion

interface SigUserSetting : SigVersion
{
  val userSetting: JsonElement?
}