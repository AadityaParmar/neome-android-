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
import java.util.Map
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.sig.SigVersion

open class SigGroupInfo : SigVersion()
{
  lateinit var about: String
  lateinit var adminMap: Map<EntUserId, DtoGroupMemberMetaData>
  var allowPromptAssistant: Boolean? = null
  var avatarId: MediaIdAvatar? = null
  lateinit var entId: EntId
  lateinit var groupConfiguration: DtoUserGroupConfiguration
  lateinit var groupId: GroupId
  var label: String? = null
  lateinit var memberMap: Map<EntUserId, DtoGroupMemberMetaData>
  lateinit var name: String
  lateinit var settings: DtoGroupSettings
}