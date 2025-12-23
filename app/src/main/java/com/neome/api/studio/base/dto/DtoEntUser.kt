// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.meta.base.Types.MediaId
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar
import java.util.Map
import kotlin.properties.Delegates

open class DtoEntUser {
    var active: Boolean by Delegates.notNull<Boolean>()
    var avatarId: MediaId? = null
    var canRemove: Boolean by Delegates.notNull<Boolean>()
    lateinit var createdOn: String
    lateinit var entUserId: EntUserId
    lateinit var handle: String
    var isCurrentUser: Boolean? = null
    var isMember: Boolean by Delegates.notNull<Boolean>()
    var languageKey: LanguageKey? = null
    var lastInviteSentOn: String? = null
    var lastOnline: String? = null
    var managerId: EntUserId? = null
    lateinit var nickName: String
    var online: Boolean? = null
    var roleIdSet: Array<MetaIdRole>? = null
    lateinit var updatedOn: String
    lateinit var userColor: String
    var userSettingValueMap: Map<MetaIdVar, DtoEntUserSettingValue>? = null
}
