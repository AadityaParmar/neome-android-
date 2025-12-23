// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain

import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.studio.studioMain.msg.MsgEntUserGet
import com.neome.api.core.base.msg.MsgEntUserIdNoVersion
import com.neome.api.studio.studioMain.msg.MsgNeoQLResult
import com.neome.api.studio.studioMain.msg.MsgPluginApiSpecGet
import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.studio.studioMain.msg.MsgWebhookCodeGet
import com.neome.api.studio.studioMain.msg.MsgWorkflowDebugStart
import com.neome.api.meta.base.Types.PluginBundleId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.sig.SigDone
import com.neome.api.studio.studioMain.sig.SigEntDeployStatus
import com.neome.api.studio.studioMain.sig.SigEntUser
import com.neome.api.studio.studioMain.sig.SigEntUserDeviceList
import com.neome.api.studio.studioEnt.sig.SigMediaIdDocument
import com.neome.api.studio.studioMain.sig.SigNeoQLResult
import com.neome.api.studio.studioMain.sig.SigPluginApiSpec
import com.neome.api.studio.studioMain.sig.SigSysDefnFormMapGet
import com.neome.api.studio.studioMain.sig.SigWebhookId

class WsocStudioMain
{
  companion object
  {
    val SN: ServiceName = ServiceName.studioMain

      fun entUserDeviceListGet(entId: EntId, msg: MsgEntUserIdNoVersion, sigAcceptor: ISigAcceptor<SigEntUserDeviceList>)
          {
            CallFactory.wsoc.create(SigEntUserDeviceList::class.java, entId, SN, "entUserDeviceListGet")
              .get(msg, sigAcceptor)
          }

      fun entUserGet(msg: MsgEntUserGet, sigAcceptor: ISigAcceptor<SigEntUser>)
          {
            CallFactory.wsoc.create(SigEntUser::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "entUserGet")
              .get(msg, sigAcceptor)
          }

      fun entWebhookCodeGet(entId: EntId, msg: MsgWebhookCodeGet, sigAcceptor: ISigAcceptor<SigWebhookId>)
          {
            CallFactory.wsoc.create(SigWebhookId::class.java, entId, SN, "entWebhookCodeGet")
              .post(msg, sigAcceptor)
          }

      fun neoQLResultGet(entId: EntId, msg: MsgNeoQLResult, sigAcceptor: ISigAcceptor<SigNeoQLResult>)
          {
            CallFactory.wsoc.create(SigNeoQLResult::class.java, entId, SN, "neoQLResultGet")
              .post(msg, sigAcceptor)
          }

      fun pluginApiSpecGet(entId: EntId, msg: MsgPluginApiSpecGet, sigAcceptor: ISigAcceptor<SigPluginApiSpec>)
          {
            CallFactory.wsoc.create(SigPluginApiSpec::class.java, entId, SN, "pluginApiSpecGet")
              .get(msg, sigAcceptor)
          }

      fun pluginSourceCodeDownload(pluginBundleId: PluginBundleId, sigAcceptor: ISigAcceptor<SigMediaIdDocument>)
          {
            CallFactory.wsoc.create(SigMediaIdDocument::class.java, pluginBundleId, SN, "pluginSourceCodeDownload")
              .get(null, sigAcceptor)
          }

      fun studioEntDeployStatusGet(entId: EntId, msg: MsgVersion, sigAcceptor: ISigAcceptor<SigEntDeployStatus>)
          {
            CallFactory.wsoc.create(SigEntDeployStatus::class.java, entId, SN, "studioEntDeployStatusGet")
              .get(msg, sigAcceptor)
          }

      fun sysDefnFormMapGet(sigAcceptor: ISigAcceptor<SigSysDefnFormMapGet>)
          {
            CallFactory.wsoc.create(SigSysDefnFormMapGet::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "sysDefnFormMapGet")
              .get(null, sigAcceptor)
          }

      fun workflowDebugStart(entId: EntId, msg: MsgWorkflowDebugStart, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "workflowDebugStart")
              .put(msg, sigAcceptor)
          }

      fun workflowDebugStop(entId: EntId, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "workflowDebugStop")
              .put(null, sigAcceptor)
          }
  }
}