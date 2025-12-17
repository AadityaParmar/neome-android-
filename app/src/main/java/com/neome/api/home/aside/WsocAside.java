// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.home.aside;

import com.neome.api.core.base.msg.MsgEntUserIdNoVersion;
import com.neome.api.core.deeplink.sig.SigUrl;
import com.neome.api.home.aside.msg.MsgAsideSearch;
import com.neome.api.home.aside.msg.MsgCallerChatNotificationSettingPut;
import com.neome.api.home.aside.msg.MsgGroupInfoGet;
import com.neome.api.home.aside.msg.MsgGroupInviteLink;
import com.neome.api.home.aside.msg.MsgGroupMembersAdd;
import com.neome.api.home.aside.msg.MsgGroupMembersRemove;
import com.neome.api.home.aside.msg.MsgGroupPatch;
import com.neome.api.home.aside.sig.SigGroupIdList;
import com.neome.api.home.aside.sig.SigGroupInfo;
import com.neome.api.home.aside.sig.SigMessageReceiptMap;
import com.neome.api.home.drawer.sig.SigAsideSearch;
import com.neome.api.home.main.msg.MsgOffset;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.nucleus.base.ApiPlus;
import com.neome.api.nucleus.base.CallFactory;
import com.neome.api.nucleus.base.ISigAcceptor;
import com.neome.api.nucleus.base.sig.SigDone;

@SuppressWarnings("unused")
public class WsocAside
{
  public static final ServiceName SN = ServiceName.aside;

  public static void asideSearch(EntId entId, MsgAsideSearch msg,
    ISigAcceptor<SigAsideSearch> sigAcceptor)
  {
    CallFactory.wsoc.create(SigAsideSearch.class, entId, SN, "asideSearch")
      .post(msg, sigAcceptor);
  }

  public static void callerChatNotificationSettingPut(EntId entId,
    MsgCallerChatNotificationSettingPut msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "callerChatNotificationSettingPut")
      .put(msg, sigAcceptor);
  }

  public static void groupCommonListGet(MsgEntUserIdNoVersion msg,
    ISigAcceptor<SigGroupIdList> sigAcceptor)
  {
    CallFactory.wsoc.create(SigGroupIdList.class, ApiPlus.ENT_ID_GLOBAL, SN, "groupCommonListGet")
      .get(msg, sigAcceptor);
  }

  public static void groupInfoGet(EntId entId, MsgGroupInfoGet msg,
    ISigAcceptor<SigGroupInfo> sigAcceptor)
  {
    CallFactory.wsoc.create(SigGroupInfo.class, entId, SN, "groupInfoGet")
      .get(msg, sigAcceptor);
  }

  public static void groupInviteLinkGet(MsgGroupInviteLink msg, ISigAcceptor<SigUrl> sigAcceptor)
  {
    CallFactory.wsoc.create(SigUrl.class, ApiPlus.ENT_ID_GLOBAL, SN, "groupInviteLinkGet")
      .get(msg, sigAcceptor);
  }

  public static void groupMembersAdd(MsgGroupMembersAdd msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "groupMembersAdd")
      .put(msg, sigAcceptor);
  }

  public static void groupMembersRemove(MsgGroupMembersRemove msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "groupMembersRemove")
      .put(msg, sigAcceptor);
  }

  public static void groupPatch(MsgGroupPatch msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "groupPatch")
      .patch(msg, sigAcceptor);
  }

  public static void messageReceiptGet(EntId entId, MsgOffset msg,
    ISigAcceptor<SigMessageReceiptMap> sigAcceptor)
  {
    CallFactory.wsoc.create(SigMessageReceiptMap.class, entId, SN, "messageReceiptGet")
      .get(msg, sigAcceptor);
  }
}
