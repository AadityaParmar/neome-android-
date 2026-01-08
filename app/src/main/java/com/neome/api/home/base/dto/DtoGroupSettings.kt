// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

interface DtoGroupSettings
{
  val anyOneCanJoin: Boolean
  val onlyAdminCanSendMessages: Boolean
  val onlyAdminCanUpdateGroupInfo: Boolean
}