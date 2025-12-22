// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.java.api.ent.entDrawer;

import com.neome.java.api.core.base.msg.MsgVersion;
import com.neome.java.api.ent.entDrawer.msg.MsgEntVariableUpdate;
import com.neome.java.api.ent.entDrawer.sig.SigEntAvatarUser;
import com.neome.java.api.ent.entDrawer.sig.SigEntCaller;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.ServiceName;
import com.neome.java.api.nucleus.base.CallFactory;
import com.neome.java.api.nucleus.base.ISigAcceptor;
import com.neome.java.api.nucleus.base.sig.SigDone;

@SuppressWarnings("unused")
public class WsocEntDrawer
{
  public static final ServiceName SN = ServiceName.entDrawer;

  public static void entAvatarUserGet(EntId entId, MsgVersion msg,
    ISigAcceptor<SigEntAvatarUser> sigAcceptor)
  {
    CallFactory.wsoc.create(SigEntAvatarUser.class, entId, SN, "entAvatarUserGet")
      .get(msg, sigAcceptor);
  }

  public static void entCallerGet(EntId entId, MsgVersion msg,
    ISigAcceptor<SigEntCaller> sigAcceptor)
  {
    CallFactory.wsoc.create(SigEntCaller.class, entId, SN, "entCallerGet")
      .get(msg, sigAcceptor);
  }

  public static void entCallerVariableUpdate(EntId entId, MsgEntVariableUpdate msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "entCallerVariableUpdate")
      .put(msg, sigAcceptor);
  }
}
