// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.java.api.home.aside;

import com.neome.java.api.core.base.msg.MsgEntUserIdNoVersion;
import com.neome.java.api.core.deeplink.sig.SigUrl;
import com.neome.java.api.home.aside.msg.MsgAsideSearch;
import com.neome.java.api.home.aside.msg.MsgCallerChatNotificationSettingPut;
import com.neome.java.api.home.aside.msg.MsgGroupInfoGet;
import com.neome.java.api.home.aside.msg.MsgGroupInviteLink;
import com.neome.java.api.home.aside.msg.MsgGroupMembersAdd;
import com.neome.java.api.home.aside.msg.MsgGroupMembersRemove;
import com.neome.java.api.home.aside.msg.MsgGroupPatch;
import com.neome.java.api.home.aside.sig.SigGroupIdList;
import com.neome.java.api.home.aside.sig.SigGroupInfo;
import com.neome.java.api.home.aside.sig.SigMessageReceiptMap;
import com.neome.java.api.home.base.msg.MsgChatId;
import com.neome.java.api.home.drawer.sig.SigAsideSearch;
import com.neome.java.api.home.main.msg.MsgOffset;
import com.neome.java.api.home.main.sig.SigMediaList;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.ServiceName;
import com.neome.java.api.nucleus.base.ApiPlus;
import com.neome.java.api.nucleus.base.CallFactory;
import com.neome.java.api.nucleus.base.ISigAcceptor;
import com.neome.java.api.nucleus.base.sig.SigDone;

@SuppressWarnings("unused")
public class RpcAside
{
  public static final ServiceName SN = ServiceName.aside;

  public static void asideSearch(EntId entId, MsgAsideSearch msg,
    ISigAcceptor<SigAsideSearch> sigAcceptor)
  {
    CallFactory.rpc.create(SigAsideSearch.class, entId, SN, "asideSearch")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void callerChatNotificationSettingPut(EntId entId,
    MsgCallerChatNotificationSettingPut msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "callerChatNotificationSettingPut")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void groupCommonListGet(MsgEntUserIdNoVersion msg,
    ISigAcceptor<SigGroupIdList> sigAcceptor)
  {
    CallFactory.rpc.create(SigGroupIdList.class, ApiPlus.ENT_ID_GLOBAL, SN, "groupCommonListGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void groupInfoGet(EntId entId, MsgGroupInfoGet msg,
    ISigAcceptor<SigGroupInfo> sigAcceptor)
  {
    CallFactory.rpc.create(SigGroupInfo.class, entId, SN, "groupInfoGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void groupInviteLinkGet(MsgGroupInviteLink msg, ISigAcceptor<SigUrl> sigAcceptor)
  {
    CallFactory.rpc.create(SigUrl.class, ApiPlus.ENT_ID_GLOBAL, SN, "groupInviteLinkGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void groupMembersAdd(MsgGroupMembersAdd msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "groupMembersAdd")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void groupMembersRemove(MsgGroupMembersRemove msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "groupMembersRemove")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void groupPatch(MsgGroupPatch msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "groupPatch")
      .sendBearerToken()
      .patch(msg, sigAcceptor);
  }

  public static void mediaListGet(EntId entId, MsgChatId msg,
    ISigAcceptor<SigMediaList> sigAcceptor)
  {
    CallFactory.rpc.create(SigMediaList.class, entId, SN, "mediaListGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void messageReceiptGet(EntId entId, MsgOffset msg,
    ISigAcceptor<SigMessageReceiptMap> sigAcceptor)
  {
    CallFactory.rpc.create(SigMessageReceiptMap.class, entId, SN, "messageReceiptGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }
}
