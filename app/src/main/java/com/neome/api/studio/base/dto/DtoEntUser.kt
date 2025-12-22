// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.meta.base.Types.MediaId
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

class DtoEntUser {
    val active: boolean
    var avatarId: MediaId? = null
    val canRemove: boolean
    val createdOn: string
    val entUserId: EntUserId
    val handle: string
    var isCurrentUser: boolean? = null
    val isMember: boolean
    var languageKey: LanguageKey? = null
    var lastInviteSentOn: string? = null
    var lastOnline: string? = null
    var managerId: EntUserId? = null
    val nickName: string
    var online: boolean? = null
    var roleIdSet: MetaIdRole[]? = null
    val updatedOn: string
    val userColor: string
    var userSettingValueMap: Record<MetaIdVar, DtoEntUserSettingValue>? = null
}
