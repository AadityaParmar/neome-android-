// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.home.base.dto.DtoUserNotification
import com.neome.api.nucleus.base.sig.SigVersion

class SigUserNotificationList : SigVersion() {
    val notificationList: DtoUserNotification[]
}
