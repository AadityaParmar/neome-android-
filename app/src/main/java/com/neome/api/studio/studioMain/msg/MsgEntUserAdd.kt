// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.EntUserId
import com.google.gson.JsonElement
import com.neome.api.meta.base.Types.LanguageKey
import java.util.Map
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.core.base.msg.MsgEntUserIdNoVersion

open class MsgEntUserAdd : MsgEntUserIdNoVersion()
{
  var avatarId: MediaIdAvatar? = null
  lateinit var handle: String
  var languageKey: LanguageKey? = null
  var managerId: EntUserId? = null
  lateinit var nickName: String
  var roleIdSet: Array<MetaIdRole>? = null
  var userVariableValueMap: Map<MetaIdVar, Any>? = null
}