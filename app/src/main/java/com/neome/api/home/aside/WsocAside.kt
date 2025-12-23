// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside

import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.home.aside.msg.MsgAsideSearch
import com.neome.api.home.aside.msg.MsgCallerChatNotificationSettingPut
import com.neome.api.core.base.msg.MsgEntUserIdNoVersion
import com.neome.api.home.aside.msg.MsgGroupInfoGet
import com.neome.api.home.aside.msg.MsgGroupInviteLink
import com.neome.api.home.aside.msg.MsgGroupMembersAdd
import com.neome.api.home.aside.msg.MsgGroupMembersRemove
import com.neome.api.home.aside.msg.MsgGroupPatch
import com.neome.api.home.main.msg.MsgOffset
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.home.drawer.sig.SigAsideSearch
import com.neome.api.nucleus.base.sig.SigDone
import com.neome.api.home.aside.sig.SigGroupIdList
import com.neome.api.home.aside.sig.SigGroupInfo
import com.neome.api.home.aside.sig.SigMessageReceiptMap
import com.neome.api.core.deeplink.sig.SigUrl

class WsocAside
{
  companion object
  {
    val SN: ServiceName = ServiceName.aside

      fun asideSearch(entId: EntId, msg: MsgAsideSearch, sigAcceptor: ISigAcceptor<SigAsideSearch>)
          {
            CallFactory.wsoc.create(SigAsideSearch::class.java, entId, SN, "asideSearch")
              .post(msg, sigAcceptor)
          }

      fun callerChatNotificationSettingPut(entId: EntId, msg: MsgCallerChatNotificationSettingPut, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, entId, SN, "callerChatNotificationSettingPut")
              .put(msg, sigAcceptor)
          }

      fun groupCommonListGet(msg: MsgEntUserIdNoVersion, sigAcceptor: ISigAcceptor<SigGroupIdList>)
          {
            CallFactory.wsoc.create(SigGroupIdList::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "groupCommonListGet")
              .get(msg, sigAcceptor)
          }

      fun groupInfoGet(entId: EntId, msg: MsgGroupInfoGet, sigAcceptor: ISigAcceptor<SigGroupInfo>)
          {
            CallFactory.wsoc.create(SigGroupInfo::class.java, entId, SN, "groupInfoGet")
              .get(msg, sigAcceptor)
          }

      fun groupInviteLinkGet(msg: MsgGroupInviteLink, sigAcceptor: ISigAcceptor<SigUrl>)
          {
            CallFactory.wsoc.create(SigUrl::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "groupInviteLinkGet")
              .get(msg, sigAcceptor)
          }

      fun groupMembersAdd(msg: MsgGroupMembersAdd, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "groupMembersAdd")
              .put(msg, sigAcceptor)
          }

      fun groupMembersRemove(msg: MsgGroupMembersRemove, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "groupMembersRemove")
              .put(msg, sigAcceptor)
          }

      fun groupPatch(msg: MsgGroupPatch, sigAcceptor: ISigAcceptor<SigDone>)
          {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "groupPatch")
              .patch(msg, sigAcceptor)
          }

      fun messageReceiptGet(entId: EntId, msg: MsgOffset, sigAcceptor: ISigAcceptor<SigMessageReceiptMap>)
          {
            CallFactory.wsoc.create(SigMessageReceiptMap::class.java, entId, SN, "messageReceiptGet")
              .get(msg, sigAcceptor)
          }
  }
}