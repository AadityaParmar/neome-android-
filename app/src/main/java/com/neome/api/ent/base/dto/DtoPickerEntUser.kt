// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MediaId
import com.neome.api.meta.base.Types.MetaIdVar

class DtoPickerEntUser {
    var avatarId: MediaId? = null
    val entUserId: EntUserId
    val nickName: string
    var userSettingValueMap: Record<MetaIdVar, any>? = null
}
