// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionPlugin
import kotlin.properties.Delegates

open class DtoPluginAdmin {
    lateinit var adminId: AdminId
    lateinit var doNotEditOptionSet: Array<EnumDefnAdminDoNotOptionPlugin>
    lateinit var doNotShowOptionSet: Array<EnumDefnAdminDoNotOptionPlugin>
    lateinit var handle: String
    var hasLock: Boolean by Delegates.notNull<Boolean>()
    var isCurrentUser: Boolean? = null
    var isMember: Boolean by Delegates.notNull<Boolean>()
    lateinit var nickName: String
}
