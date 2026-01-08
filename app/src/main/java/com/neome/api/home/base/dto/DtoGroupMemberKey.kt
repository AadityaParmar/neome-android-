// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.EntUserId

interface DtoGroupMemberKey
{
  val entUserId: EntUserId
  val handle: String
  val name: String
}