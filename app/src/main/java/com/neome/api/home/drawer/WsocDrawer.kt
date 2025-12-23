// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer

import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.home.drawer.msg.MsgAddressBookContact
import com.neome.api.home.drawer.msg.MsgCallerDeviceState
import com.neome.api.home.drawer.msg.MsgCallerNotificationSettingPut
import com.neome.api.home.drawer.msg.MsgCallerProfilePatch
import com.neome.api.home.base.msg.MsgChatId
import com.neome.api.home.base.msg.MsgDeviceId
import com.neome.api.home.drawer.msg.MsgDrawerSearch
import com.neome.api.home.drawer.msg.MsgEntFilter
import com.neome.api.home.main.msg.MsgEntFilterNoVersion
import com.neome.api.home.base.msg.MsgEntUserId
import com.neome.api.home.drawer.msg.MsgGroupCandidateListGet
import com.neome.api.home.drawer.msg.MsgGroupCreate
import com.neome.api.home.base.msg.MsgGroupId
import com.neome.api.core.base.msg.MsgHandle
import com.neome.api.home.drawer.msg.MsgLastMessageGet
import com.neome.api.home.main.msg.MsgOffset
import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.home.drawer.sig.SigAddressBook
import com.neome.api.home.drawer.sig.SigBadgeMap
import com.neome.api.home.drawer.sig.SigCallerDeviceList
import com.neome.api.home.main.sig.SigChatCandidateMap
import com.neome.api.nucleus.base.sig.SigDone
import com.neome.api.home.drawer.sig.SigDrawerSearch
import com.neome.api.home.drawer.sig.SigGroupAvatar
import com.neome.api.home.drawer.sig.SigGroupCandidateMap
import com.neome.api.home.main.sig.SigLastMessage
import com.neome.api.home.drawer.sig.SigRecentList
import com.neome.api.home.drawer.sig.SigStarMessageList
import com.neome.api.home.drawer.sig.SigUserAvatar

class WsocDrawer
{
  companion object
  {
    val SN: ServiceName = ServiceName.drawer

      fun addressBookContactPatch(msg: MsgAddressBookContact, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "addressBookContactPatch")
              .patch(msg, sigAcceptor)
          }

      fun addressBookContactPut(msg: MsgAddressBookContact, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "addressBookContactPut")
              .put(msg, sigAcceptor)
          }

      fun addressBookContactRemove(msg: MsgHandle, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "addressBookContactRemove")
              .delete(msg, sigAcceptor)
          }

      fun addressBookGet(msg: MsgVersion, sigAcceptor: ISigAcceptor<SigAddressBook>)
          {
            CallFactory.wsoc.create(SigAddressBook::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "addressBookGet")
              .get(msg, sigAcceptor)
          }

      fun addressBookInvite(msg: MsgHandle, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "addressBookInvite")
              .post(msg, sigAcceptor)
          }

      fun badgeMapGet(msg: MsgVersion, sigAcceptor: ISigAcceptor<SigBadgeMap>)
          {
            CallFactory.wsoc.create(SigBadgeMap::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "badgeMapGet")
              .get(msg, sigAcceptor)
          }

      fun callerDeviceListGet(sigAcceptor: ISigAcceptor<SigCallerDeviceList>)
          {
            CallFactory.wsoc.create(SigCallerDeviceList::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "callerDeviceListGet")
              .get(null, sigAcceptor)
          }

      fun callerDeviceRemove(msg: MsgDeviceId, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "callerDeviceRemove")
              .delete(msg, sigAcceptor)
          }

      fun callerDeviceStatePut(msg: MsgCallerDeviceState, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "callerDeviceStatePut")
              .put(msg, sigAcceptor)
          }

      fun callerNotificationSettingPut(entId: EntId, msg: MsgCallerNotificationSettingPut, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "callerNotificationSettingPut")
              .put(msg, sigAcceptor)
          }

      fun callerProfilePatch(msg: MsgCallerProfilePatch, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "callerProfilePatch")
              .patch(msg, sigAcceptor)
          }

      fun drawerSearch(msg: MsgDrawerSearch, sigAcceptor: ISigAcceptor<SigDrawerSearch>)
          {
            CallFactory.wsoc.create(SigDrawerSearch::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "drawerSearch")
              .get(msg, sigAcceptor)
          }

      fun groupAvatarGet(entId: EntId, msg: MsgGroupId, sigAcceptor: ISigAcceptor<SigGroupAvatar>)
          {
            CallFactory.wsoc.create(SigGroupAvatar::class.java, entId, SN, "groupAvatarGet")
              .get(msg, sigAcceptor)
          }

      fun groupCandidateListGet(msg: MsgGroupCandidateListGet, sigAcceptor: ISigAcceptor<SigGroupCandidateMap>)
          {
            CallFactory.wsoc.create(SigGroupCandidateMap::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "groupCandidateListGet")
              .get(msg, sigAcceptor)
          }

      fun groupCreate(msg: MsgGroupCreate, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "groupCreate")
              .post(msg, sigAcceptor)
          }

      fun groupExit(msg: MsgGroupId, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "groupExit")
              .delete(msg, sigAcceptor)
          }

      fun lastMessageGet(entId: EntId, msg: MsgLastMessageGet, sigAcceptor: ISigAcceptor<SigLastMessage>)
          {
            CallFactory.wsoc.create(SigLastMessage::class.java, entId, SN, "lastMessageGet")
              .get(msg, sigAcceptor)
          }

      fun messageStar(entId: EntId, msg: MsgOffset, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "messageStar")
              .put(msg, sigAcceptor)
          }

      fun messageUnStar(entId: EntId, msg: MsgOffset, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "messageUnStar")
              .put(msg, sigAcceptor)
          }

      fun newChatCandidateListGet(msg: MsgEntFilterNoVersion, sigAcceptor: ISigAcceptor<SigChatCandidateMap>)
          {
            CallFactory.wsoc.create(SigChatCandidateMap::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "newChatCandidateListGet")
              .get(msg, sigAcceptor)
          }

      fun recentItemPin(entId: EntId, msg: MsgChatId, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "recentItemPin")
              .put(msg, sigAcceptor)
          }

      fun recentItemUnPin(entId: EntId, msg: MsgChatId, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "recentItemUnPin")
              .put(msg, sigAcceptor)
          }

      fun recentListGet(msg: MsgEntFilter, sigAcceptor: ISigAcceptor<SigRecentList>)
          {
            CallFactory.wsoc.create(SigRecentList::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "recentListGet")
              .get(msg, sigAcceptor)
          }

      fun starMessageListGet(msg: MsgEntFilter, sigAcceptor: ISigAcceptor<SigStarMessageList>)
          {
            CallFactory.wsoc.create(SigStarMessageList::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "starMessageListGet")
              .get(msg, sigAcceptor)
          }

      fun userAvatarGet(entId: EntId, msg: MsgEntUserId, sigAcceptor: ISigAcceptor<SigUserAvatar>)
          {
            CallFactory.wsoc.create(SigUserAvatar::class.java, entId, SN, "userAvatarGet")
              .get(msg, sigAcceptor)
          }
  }
}