// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entDrawer

import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.home.drawer.msg.MsgEntFilter
import com.neome.api.ent.entDrawer.msg.MsgEntVariableUpdate
import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.sig.SigDone
import com.neome.api.ent.entDrawer.sig.SigEntAvatarUser
import com.neome.api.ent.entDrawer.sig.SigEntCaller
import com.neome.api.ent.entDrawer.sig.SigEntDeployListGet
import com.neome.api.ent.entDrawer.sig.SigEntFreezeGroupListGet

class RpcEntDrawer
{
  companion object
  {
    val SN: ServiceName = ServiceName.entDrawer

      fun entAvatarUserGet(entId: EntId, msg: MsgVersion, sigAcceptor: ISigAcceptor<SigEntAvatarUser>)
          {
            CallFactory.rpc.create(SigEntAvatarUser::class.java, entId, SN, "entAvatarUserGet")
              .sendBearerToken()
              .get(msg, sigAcceptor)
          }

      fun entCallerGet(entId: EntId, msg: MsgVersion, sigAcceptor: ISigAcceptor<SigEntCaller>)
          {
            CallFactory.rpc.create(SigEntCaller::class.java, entId, SN, "entCallerGet")
              .sendBearerToken()
              .get(msg, sigAcceptor)
          }

      fun entCallerVariableUpdate(entId: EntId, msg: MsgEntVariableUpdate, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entCallerVariableUpdate")
              .sendBearerToken()
              .put(msg, sigAcceptor)
          }

      fun entDeployListGet(sigAcceptor: ISigAcceptor<SigEntDeployListGet>)
          {
            CallFactory.rpc.create(SigEntDeployListGet::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "entDeployListGet")
              .sendBearerToken()
              .get(null, sigAcceptor)
          }

      fun entFreezeGroupListGet(msg: MsgEntFilter, sigAcceptor: ISigAcceptor<SigEntFreezeGroupListGet>)
          {
            CallFactory.rpc.create(SigEntFreezeGroupListGet::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "entFreezeGroupListGet")
              .sendBearerToken()
              .get(msg, sigAcceptor)
          }
  }
}