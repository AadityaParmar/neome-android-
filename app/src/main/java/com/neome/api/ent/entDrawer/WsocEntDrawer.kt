// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entDrawer

import com.neome.api.nucleus.base.CallFactory
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.ent.entDrawer.msg.MsgEntVariableUpdate
import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.sig.SigDone
import com.neome.api.ent.entDrawer.sig.SigEntAvatarUser
import com.neome.api.ent.entDrawer.sig.SigEntCaller

class WsocEntDrawer
{
  companion object
  {
    val SN: ServiceName = ServiceName.entDrawer

      fun entAvatarUserGet(entId: EntId, msg: MsgVersion, sigAcceptor: ISigAcceptor<SigEntAvatarUser>)
          {
            CallFactory.wsoc.create(SigEntAvatarUser::class.java, entId, SN, "entAvatarUserGet")
              .get(msg, sigAcceptor)
          }

      fun entCallerGet(entId: EntId, msg: MsgVersion, sigAcceptor: ISigAcceptor<SigEntCaller>)
          {
            CallFactory.wsoc.create(SigEntCaller::class.java, entId, SN, "entCallerGet")
              .get(msg, sigAcceptor)
          }

      fun entCallerVariableUpdate(entId: EntId, msg: MsgEntVariableUpdate, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "entCallerVariableUpdate")
              .put(msg, sigAcceptor)
          }
  }
}