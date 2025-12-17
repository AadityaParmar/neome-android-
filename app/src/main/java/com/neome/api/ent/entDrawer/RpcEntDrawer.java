// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.ent.entDrawer;

import com.neome.api.core.base.msg.MsgVersion;
import com.neome.api.ent.entDrawer.msg.MsgEntVariableUpdate;
import com.neome.api.ent.entDrawer.sig.SigEntAvatarUser;
import com.neome.api.ent.entDrawer.sig.SigEntCaller;
import com.neome.api.ent.entDrawer.sig.SigEntDeployListGet;
import com.neome.api.ent.entDrawer.sig.SigEntFreezeGroupListGet;
import com.neome.api.home.drawer.msg.MsgEntFilter;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.nucleus.base.ApiPlus;
import com.neome.api.nucleus.base.CallFactory;
import com.neome.api.nucleus.base.ISigAcceptor;
import com.neome.api.nucleus.base.sig.SigDone;

@SuppressWarnings("unused")
public class RpcEntDrawer
{
  public static final ServiceName SN = ServiceName.entDrawer;

  public static void entAvatarUserGet(EntId entId, MsgVersion msg,
    ISigAcceptor<SigEntAvatarUser> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntAvatarUser.class, entId, SN, "entAvatarUserGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void entCallerGet(EntId entId, MsgVersion msg,
    ISigAcceptor<SigEntCaller> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntCaller.class, entId, SN, "entCallerGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void entCallerVariableUpdate(EntId entId, MsgEntVariableUpdate msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "entCallerVariableUpdate")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void entDeployListGet(ISigAcceptor<SigEntDeployListGet> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntDeployListGet.class, ApiPlus.ENT_ID_GLOBAL, SN, "entDeployListGet")
      .sendBearerToken()
      .get(null, sigAcceptor);
  }

  public static void entFreezeGroupListGet(MsgEntFilter msg,
    ISigAcceptor<SigEntFreezeGroupListGet> sigAcceptor)
  {
    CallFactory.rpc.create(SigEntFreezeGroupListGet.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "entFreezeGroupListGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }
}
