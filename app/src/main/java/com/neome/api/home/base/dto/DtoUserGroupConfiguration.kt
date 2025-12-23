// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import kotlin.properties.Delegates

open class DtoUserGroupConfiguration {
    var canAddMember: Boolean by Delegates.notNull<Boolean>()
    var canDeleteGroup: Boolean by Delegates.notNull<Boolean>()
    var canExitGroup: Boolean by Delegates.notNull<Boolean>()
    var canInvite: Boolean by Delegates.notNull<Boolean>()
    var canMakeAdmin: Boolean by Delegates.notNull<Boolean>()
    var canRemoveAdmin: Boolean by Delegates.notNull<Boolean>()
    var canRemoveMember: Boolean by Delegates.notNull<Boolean>()
}
