// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import java.util.Date
import com.neome.api.core.base.dto.NotificationCustomData

open class DtoUserNotification
{
  lateinit var body: String
  var createdOn: String? = null
  var customData: NotificationCustomData? = null
  lateinit var id: String
  var isRead: Boolean? = null
  lateinit var title: String
}