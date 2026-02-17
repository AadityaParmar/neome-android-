// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.msg

import com.neome.api.home.base.dto.DtoGroupSettings
import com.neome.api.home.base.Types.EnumGroupPatchPropName
import com.neome.api.meta.base.Types.GroupId
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.core.base.msg.MsgVersion

interface MsgGroupPatch : MsgVersion
{
  val about: String?
  val groupId: GroupId
  val mediaIdAvatar: MediaIdAvatar?
  val name: String?
  val patchPropNameSet: Set<EnumGroupPatchPropName>
  val settings: DtoGroupSettings?
}