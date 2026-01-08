// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

interface DtoUserGroupConfiguration
{
  val canAddMember: Boolean
  val canDeleteGroup: Boolean
  val canExitGroup: Boolean
  val canInvite: Boolean
  val canMakeAdmin: Boolean
  val canRemoveAdmin: Boolean
  val canRemoveMember: Boolean
}