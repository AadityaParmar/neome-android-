// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.core.base.msg.MsgEntUserIdNoVersion
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

class MsgEntUserAdd : MsgEntUserIdNoVersion() {
    var avatarId: MediaIdAvatar? = null
    val handle: string
    var languageKey: LanguageKey? = null
    var managerId: EntUserId? = null
    val nickName: string
    var roleIdSet: MetaIdRole[]? = null
    var userVariableValueMap: Record<MetaIdVar, any>? = null
}
