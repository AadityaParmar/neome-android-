// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.msg

import com.neome.api.home.base.dto.DtoGroupSettings
import com.neome.api.home.base.Types.EnumGroupPatchPropName
import com.neome.api.meta.base.Types.GroupId
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.core.base.msg.MsgVersion
import java.util.Set

open class MsgGroupPatch : MsgVersion()
{
  var about: String? = null
  lateinit var groupId: GroupId
  var mediaIdAvatar: MediaIdAvatar? = null
  var name: String? = null
  lateinit var patchPropNameSet: Array<EnumGroupPatchPropName>
  var settings: DtoGroupSettings? = null
}