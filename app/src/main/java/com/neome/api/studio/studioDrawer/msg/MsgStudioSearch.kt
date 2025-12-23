// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.msg

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.nucleus.base.msg.Msg
import java.util.Set

open class MsgStudioSearch : Msg()
{
  var filterArtifactIdSet: Array<ArtifactId>? = null
  lateinit var query: String
  lateinit var searchId: String
}