// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.sig

import com.neome.api.home.base.dto.DtoGroupMemberMetaData
import com.neome.api.home.base.dto.DtoGroupSettings
import com.neome.api.home.base.dto.DtoUserGroupConfiguration
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.GroupId
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.sig.SigVersion

interface SigGroupInfo : SigVersion
{
  val about: String
  val adminMap: Map<EntUserId, DtoGroupMemberMetaData>
  val allowPromptAssistant: Boolean?
  val avatarId: MediaIdAvatar?
  val entId: EntId
  val groupConfiguration: DtoUserGroupConfiguration
  val groupId: GroupId
  val label: String?
  val memberMap: Map<EntUserId, DtoGroupMemberMetaData>
  val name: String
  val settings: DtoGroupSettings
}