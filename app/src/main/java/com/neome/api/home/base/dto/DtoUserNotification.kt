// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.core.base.dto.NotificationCustomData

interface DtoUserNotification
{
  val body: String
  val createdOn: String?
  val customData: NotificationCustomData?
  val id: String
  val isRead: Boolean?
  val title: String
}