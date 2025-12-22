// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.core.base.dto.NotificationCustomData

class DtoUserNotification {
    val body: string
    var createdOn: string? = null
    var customData: NotificationCustomData? = null
    val id: string
    var isRead: boolean? = null
    val title: string
}
