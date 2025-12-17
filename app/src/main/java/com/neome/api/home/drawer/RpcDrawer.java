// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.api.home.drawer;

import com.neome.api.core.base.msg.MsgHandle;
import com.neome.api.core.base.msg.MsgVersion;
import com.neome.api.core.base.sig.SigVerifyKey;
import com.neome.api.home.base.msg.MsgChatId;
import com.neome.api.home.base.msg.MsgDeviceId;
import com.neome.api.home.base.msg.MsgEntUserId;
import com.neome.api.home.base.msg.MsgGroupId;
import com.neome.api.home.drawer.msg.MsgAddressBookContact;
import com.neome.api.home.drawer.msg.MsgCallerDeviceState;
import com.neome.api.home.drawer.msg.MsgCallerHandleChange;
import com.neome.api.home.drawer.msg.MsgCallerNotificationSettingPut;
import com.neome.api.home.drawer.msg.MsgCallerPasswordReset;
import com.neome.api.home.drawer.msg.MsgCallerProfilePatch;
import com.neome.api.home.drawer.msg.MsgDrawerSearch;
import com.neome.api.home.drawer.msg.MsgEntFilter;
import com.neome.api.home.drawer.msg.MsgGroupCandidateListGet;
import com.neome.api.home.drawer.msg.MsgGroupCreate;
import com.neome.api.home.drawer.msg.MsgLastMessageGet;
import com.neome.api.home.drawer.msg.MsgUserAvatarBulkGet;
import com.neome.api.home.drawer.msg.MsgUserNotificationId;
import com.neome.api.home.drawer.msg.MsgUserNotificationList;
import com.neome.api.home.drawer.sig.SigAddressBook;
import com.neome.api.home.drawer.sig.SigBadgeMap;
import com.neome.api.home.drawer.sig.SigBulkUserAvatar;
import com.neome.api.home.drawer.sig.SigCallerDeviceList;
import com.neome.api.home.drawer.sig.SigDrawerSearch;
import com.neome.api.home.drawer.sig.SigGroupAvatar;
import com.neome.api.home.drawer.sig.SigGroupCandidateMap;
import com.neome.api.home.drawer.sig.SigRecentList;
import com.neome.api.home.drawer.sig.SigStarMessageList;
import com.neome.api.home.drawer.sig.SigUserAvatar;
import com.neome.api.home.drawer.sig.SigUserNotificationList;
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
public class RpcDrawer
{
  public static final ServiceName SN = ServiceName.drawer;

  public static void addressBookContactPatch(MsgAddressBookContact msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "addressBookContactPatch")
      .sendBearerToken()
      .patch(msg, sigAcceptor);
  }

  public static void addressBookContactPut(MsgAddressBookContact msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "addressBookContactPut")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void addressBookContactRemove(MsgHandle msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "addressBookContactRemove")
      .sendBearerToken()
      .delete(msg, sigAcceptor);
  }

  public static void addressBookGet(MsgVersion msg, ISigAcceptor<SigAddressBook> sigAcceptor)
  {
    CallFactory.rpc.create(SigAddressBook.class, ApiPlus.ENT_ID_GLOBAL, SN, "addressBookGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void addressBookInvite(MsgHandle msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "addressBookInvite")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void badgeMapGet(MsgVersion msg, ISigAcceptor<SigBadgeMap> sigAcceptor)
  {
    CallFactory.rpc.create(SigBadgeMap.class, ApiPlus.ENT_ID_GLOBAL, SN, "badgeMapGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void callerAccountRemove(ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "callerAccountRemove")
      .sendRefreshToken()
      .delete(null, sigAcceptor);
  }

  public static void callerDeviceListGet(ISigAcceptor<SigCallerDeviceList> sigAcceptor)
  {
    CallFactory.rpc.create(SigCallerDeviceList.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "callerDeviceListGet")
      .sendBearerToken()
      .get(null, sigAcceptor);
  }

  public static void callerDeviceRemove(MsgDeviceId msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "callerDeviceRemove")
      .sendRefreshToken()
      .delete(msg, sigAcceptor);
  }

  public static void callerDeviceStatePut(MsgCallerDeviceState msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "callerDeviceStatePut")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void callerHandleChange(MsgCallerHandleChange msg,
    ISigAcceptor<SigVerifyKey> sigAcceptor)
  {
    CallFactory.rpc.create(SigVerifyKey.class, ApiPlus.ENT_ID_GLOBAL, SN, "callerHandleChange")
      .sendRefreshToken()
      .patch(msg, sigAcceptor);
  }

  public static void callerNotificationSettingPut(EntId entId, MsgCallerNotificationSettingPut msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "callerNotificationSettingPut")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void callerPasswordReset(MsgCallerPasswordReset msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "callerPasswordReset")
      .sendRefreshToken()
      .patch(msg, sigAcceptor);
  }

  public static void callerProfilePatch(MsgCallerProfilePatch msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "callerProfilePatch")
      .sendBearerToken()
      .patch(msg, sigAcceptor);
  }

  public static void drawerSearch(MsgDrawerSearch msg, ISigAcceptor<SigDrawerSearch> sigAcceptor)
  {
    CallFactory.rpc.create(SigDrawerSearch.class, ApiPlus.ENT_ID_GLOBAL, SN, "drawerSearch")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void groupAvatarGet(EntId entId, MsgGroupId msg,
    ISigAcceptor<SigGroupAvatar> sigAcceptor)
  {
    CallFactory.rpc.create(SigGroupAvatar.class, entId, SN, "groupAvatarGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void groupCandidateListGet(MsgGroupCandidateListGet msg,
    ISigAcceptor<SigGroupCandidateMap> sigAcceptor)
  {
    CallFactory.rpc.create(SigGroupCandidateMap.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "groupCandidateListGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void groupCreate(MsgGroupCreate msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "groupCreate")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void groupExit(MsgGroupId msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "groupExit")
      .sendBearerToken()
      .delete(msg, sigAcceptor);
  }

  public static void lastMessageGet(EntId entId, MsgLastMessageGet msg,
    ISigAcceptor<SigLastMessage> sigAcceptor)
  {
    CallFactory.rpc.create(SigLastMessage.class, entId, SN, "lastMessageGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void messageStar(EntId entId, MsgOffset msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "messageStar")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void messageUnStar(EntId entId, MsgOffset msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "messageUnStar")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void newChatCandidateListGet(MsgEntFilterNoVersion msg,
    ISigAcceptor<SigChatCandidateMap> sigAcceptor)
  {
    CallFactory.rpc.create(SigChatCandidateMap.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "newChatCandidateListGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void recentItemPin(EntId entId, MsgChatId msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "recentItemPin")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void recentItemUnPin(EntId entId, MsgChatId msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "recentItemUnPin")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void recentListGet(MsgEntFilter msg, ISigAcceptor<SigRecentList> sigAcceptor)
  {
    CallFactory.rpc.create(SigRecentList.class, ApiPlus.ENT_ID_GLOBAL, SN, "recentListGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void starMessageListGet(MsgEntFilter msg,
    ISigAcceptor<SigStarMessageList> sigAcceptor)
  {
    CallFactory.rpc.create(SigStarMessageList.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "starMessageListGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void userAvatarBulkGet(EntId entId, MsgUserAvatarBulkGet msg,
    ISigAcceptor<SigBulkUserAvatar> sigAcceptor)
  {
    CallFactory.rpc.create(SigBulkUserAvatar.class, entId, SN, "userAvatarBulkGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void userAvatarGet(EntId entId, MsgEntUserId msg,
    ISigAcceptor<SigUserAvatar> sigAcceptor)
  {
    CallFactory.rpc.create(SigUserAvatar.class, entId, SN, "userAvatarGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void userNotificationListGet(MsgUserNotificationList msg,
    ISigAcceptor<SigUserNotificationList> sigAcceptor)
  {
    CallFactory.rpc.create(SigUserNotificationList.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "userNotificationListGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void userNotificationMarkRead(MsgUserNotificationId msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "userNotificationMarkRead")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void userNotificationRemove(MsgUserNotificationId msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "userNotificationRemove")
      .sendBearerToken()
      .delete(msg, sigAcceptor);
  }
}
