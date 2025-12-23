// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.msg

import com.neome.api.nucleus.base.msg.Msg

open class MsgStudioArtifactAvatarListGet : Msg()
{
  var deployedOnly: Boolean? = null
}