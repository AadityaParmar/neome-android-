// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer

import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.studio.studioDrawer.msg.MsgStudioArtifactAvatarListGet
import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.PluginBundleId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.studio.studioDrawer.sig.SigStudioArtifactAvatarList
import com.neome.api.studio.studioDrawer.sig.SigStudioDeployedArtifactList
import com.neome.api.studio.studioDrawer.sig.SigStudioEntAvatar
import com.neome.api.studio.studioDrawer.sig.SigStudioPluginAvatar

class WsocStudioDrawer
{
  companion object
  {
    val SN: ServiceName = ServiceName.studioDrawer

      fun studioArtifactAvatarListGet(msg: MsgStudioArtifactAvatarListGet, sigAcceptor: ISigAcceptor<SigStudioArtifactAvatarList>)
          {
            CallFactory.wsoc.create(SigStudioArtifactAvatarList::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "studioArtifactAvatarListGet")
              .get(msg, sigAcceptor)
          }

      fun studioDeployedArtifactListGet(sigAcceptor: ISigAcceptor<SigStudioDeployedArtifactList>)
          {
            CallFactory.wsoc.create(SigStudioDeployedArtifactList::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "studioDeployedArtifactListGet")
              .get(null, sigAcceptor)
          }

      fun studioEntAvatarGet(entId: EntId, msg: MsgVersion, sigAcceptor: ISigAcceptor<SigStudioEntAvatar>)
          {
            CallFactory.wsoc.create(SigStudioEntAvatar::class.java, entId, SN, "studioEntAvatarGet")
              .get(msg, sigAcceptor)
          }

      fun studioPluginAvatarGet(pluginBundleId: PluginBundleId, msg: MsgVersion, sigAcceptor: ISigAcceptor<SigStudioPluginAvatar>)
          {
            CallFactory.wsoc.create(SigStudioPluginAvatar::class.java, pluginBundleId, SN, "studioPluginAvatarGet")
              .get(msg, sigAcceptor)
          }
  }
}