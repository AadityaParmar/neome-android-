// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.GroupId
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.sig.SigVersion

open class SigGroupAvatar : SigVersion()
{
  var about: String? = null
  var avatarId: MediaIdAvatar? = null
  lateinit var entId: EntId
  lateinit var groupId: GroupId
  var isAdmin: Boolean? = null
  var isMember: Boolean by Delegates.notNull<Boolean>()
  var label: String? = null
  lateinit var name: String
}