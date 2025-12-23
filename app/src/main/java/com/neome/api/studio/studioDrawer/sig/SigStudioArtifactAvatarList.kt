// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.sig

import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.studio.studioDrawer.sig.SigStudioEntAvatar
import com.neome.api.studio.studioDrawer.sig.SigStudioPluginAvatar

open class SigStudioArtifactAvatarList : Sig()
{
  var entAvatarList: Array<SigStudioEntAvatar>? = null
  var pluginBundleAvatarList: Array<SigStudioPluginAvatar>? = null
}