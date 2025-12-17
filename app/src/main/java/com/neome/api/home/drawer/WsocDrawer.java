// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.home.drawer;

import com.neome.api.core.base.msg.MsgHandle;
import com.neome.api.core.base.msg.MsgVersion;
import com.neome.api.home.base.msg.MsgChatId;
import com.neome.api.home.base.msg.MsgDeviceId;
import com.neome.api.home.base.msg.MsgEntUserId;
import com.neome.api.home.base.msg.MsgGroupId;
import com.neome.api.home.drawer.msg.MsgAddressBookContact;
import com.neome.api.home.drawer.msg.MsgCallerDeviceState;
import com.neome.api.home.drawer.msg.MsgCallerNotificationSettingPut;
import com.neome.api.home.drawer.msg.MsgCallerProfilePatch;
import com.neome.api.home.drawer.msg.MsgDrawerSearch;
import com.neome.api.home.drawer.msg.MsgEntFilter;
import com.neome.api.home.drawer.msg.MsgGroupCandidateListGet;
import com.neome.api.home.drawer.msg.MsgGroupCreate;
import com.neome.api.home.drawer.msg.MsgLastMessageGet;
import com.neome.api.home.drawer.sig.SigAddressBook;
import com.neome.api.home.drawer.sig.SigBadgeMap;
import com.neome.api.home.drawer.sig.SigCallerDeviceList;
import com.neome.api.home.drawer.sig.SigDrawerSearch;
import com.neome.api.home.drawer.sig.SigGroupAvatar;
import com.neome.api.home.drawer.sig.SigGroupCandidateMap;
import com.neome.api.home.drawer.sig.SigRecentList;
import com.neome.api.home.drawer.sig.SigStarMessageList;
import com.neome.api.home.drawer.sig.SigUserAvatar;
import com.neome.api.home.main.msg.MsgEntFilterNoVersion;
import com.neome.api.home.main.msg.MsgOffset;
import com.neome.api.home.main.sig.SigChatCandidateMap;
import com.neome.api.home.main.sig.SigLastMessage;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.nucleus.base.ApiPlus;
import com.neome.api.nucleus.base.CallFactory;
import com.neome.api.nucleus.base.ISigAcceptor;
import com.neome.api.nucleus.base.sig.SigDone;

@SuppressWarnings("unused")
public class WsocDrawer
{
  public static final ServiceName SN = ServiceName.drawer;

  public static void addressBookContactPatch(MsgAddressBookContact msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "addressBookContactPatch")
      .patch(msg, sigAcceptor);
  }

  public static void addressBookContactPut(MsgAddressBookContact msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "addressBookContactPut")
      .put(msg, sigAcceptor);
  }

  public static void addressBookContactRemove(MsgHandle msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "addressBookContactRemove")
      .delete(msg, sigAcceptor);
  }

  public static void addressBookGet(MsgVersion msg, ISigAcceptor<SigAddressBook> sigAcceptor)
  {
    CallFactory.wsoc.create(SigAddressBook.class, ApiPlus.ENT_ID_GLOBAL, SN, "addressBookGet")
      .get(msg, sigAcceptor);
  }

  public static void addressBookInvite(MsgHandle msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "addressBookInvite")
      .post(msg, sigAcceptor);
  }

  public static void badgeMapGet(MsgVersion msg, ISigAcceptor<SigBadgeMap> sigAcceptor)
  {
    CallFactory.wsoc.create(SigBadgeMap.class, ApiPlus.ENT_ID_GLOBAL, SN, "badgeMapGet")
      .get(msg, sigAcceptor);
  }

  public static void callerDeviceListGet(ISigAcceptor<SigCallerDeviceList> sigAcceptor)
  {
    CallFactory.wsoc.create(SigCallerDeviceList.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "callerDeviceListGet")
      .get(null, sigAcceptor);
  }

  public static void callerDeviceRemove(MsgDeviceId msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "callerDeviceRemove")
      .delete(msg, sigAcceptor);
  }

  public static void callerDeviceStatePut(MsgCallerDeviceState msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "callerDeviceStatePut")
      .put(msg, sigAcceptor);
  }

  public static void callerNotificationSettingPut(EntId entId, MsgCallerNotificationSettingPut msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "callerNotificationSettingPut")
      .put(msg, sigAcceptor);
  }

  public static void callerProfilePatch(MsgCallerProfilePatch msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "callerProfilePatch")
      .patch(msg, sigAcceptor);
  }

  public static void drawerSearch(MsgDrawerSearch msg, ISigAcceptor<SigDrawerSearch> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDrawerSearch.class, ApiPlus.ENT_ID_GLOBAL, SN, "drawerSearch")
      .get(msg, sigAcceptor);
  }

  public static void groupAvatarGet(EntId entId, MsgGroupId msg,
    ISigAcceptor<SigGroupAvatar> sigAcceptor)
  {
    CallFactory.wsoc.create(SigGroupAvatar.class, entId, SN, "groupAvatarGet")
      .get(msg, sigAcceptor);
  }

  public static void groupCandidateListGet(MsgGroupCandidateListGet msg,
    ISigAcceptor<SigGroupCandidateMap> sigAcceptor)
  {
    CallFactory.wsoc.create(SigGroupCandidateMap.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "groupCandidateListGet")
      .get(msg, sigAcceptor);
  }

  public static void groupCreate(MsgGroupCreate msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "groupCreate")
      .post(msg, sigAcceptor);
  }

  public static void groupExit(MsgGroupId msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "groupExit")
      .delete(msg, sigAcceptor);
  }

  public static void lastMessageGet(EntId entId, MsgLastMessageGet msg,
    ISigAcceptor<SigLastMessage> sigAcceptor)
  {
    CallFactory.wsoc.create(SigLastMessage.class, entId, SN, "lastMessageGet")
      .get(msg, sigAcceptor);
  }

  public static void messageStar(EntId entId, MsgOffset msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "messageStar")
      .put(msg, sigAcceptor);
  }

  public static void messageUnStar(EntId entId, MsgOffset msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "messageUnStar")
      .put(msg, sigAcceptor);
  }

  public static void newChatCandidateListGet(MsgEntFilterNoVersion msg,
    ISigAcceptor<SigChatCandidateMap> sigAcceptor)
  {
    CallFactory.wsoc.create(SigChatCandidateMap.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "newChatCandidateListGet")
      .get(msg, sigAcceptor);
  }

  public static void recentItemPin(EntId entId, MsgChatId msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "recentItemPin")
      .put(msg, sigAcceptor);
  }

  public static void recentItemUnPin(EntId entId, MsgChatId msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "recentItemUnPin")
      .put(msg, sigAcceptor);
  }

  public static void recentListGet(MsgEntFilter msg, ISigAcceptor<SigRecentList> sigAcceptor)
  {
    CallFactory.wsoc.create(SigRecentList.class, ApiPlus.ENT_ID_GLOBAL, SN, "recentListGet")
      .get(msg, sigAcceptor);
  }

  public static void starMessageListGet(MsgEntFilter msg,
    ISigAcceptor<SigStarMessageList> sigAcceptor)
  {
    CallFactory.wsoc.create(SigStarMessageList.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "starMessageListGet")
      .get(msg, sigAcceptor);
  }

  public static void userAvatarGet(EntId entId, MsgEntUserId msg,
    ISigAcceptor<SigUserAvatar> sigAcceptor)
  {
    CallFactory.wsoc.create(SigUserAvatar.class, entId, SN, "userAvatarGet")
      .get(msg, sigAcceptor);
  }
}
