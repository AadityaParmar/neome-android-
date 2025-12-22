// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside

import com.neome.api.core.base.msg.MsgEntUserIdNoVersion
import com.neome.api.core.deeplink.sig.SigUrl
import com.neome.api.home.aside.msg.MsgAsideSearch
import com.neome.api.home.aside.msg.MsgCallerChatNotificationSettingPut
import com.neome.api.home.aside.msg.MsgGroupInfoGet
import com.neome.api.home.aside.msg.MsgGroupInviteLink
import com.neome.api.home.aside.msg.MsgGroupMembersAdd
import com.neome.api.home.aside.msg.MsgGroupMembersRemove
import com.neome.api.home.aside.msg.MsgGroupPatch
import com.neome.api.home.aside.sig.SigGroupIdList
import com.neome.api.home.aside.sig.SigGroupInfo
import com.neome.api.home.aside.sig.SigMessageReceiptMap
import com.neome.api.home.base.msg.MsgChatId
import com.neome.api.home.drawer.sig.SigAsideSearch
import com.neome.api.home.main.msg.MsgOffset
import com.neome.api.home.main.sig.SigMediaList
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.nucleus.base.sig.SigDone

class RpcAside {
    companion object {
        val SN: ServiceName = ServiceName.aside

        fun asideSearch(
            entId: EntId,
            msg: MsgAsideSearch,
            sigAcceptor: ISigAcceptor<SigAsideSearch>
        ) {
            CallFactory.rpc.create(SigAsideSearch::class.java, entId, SN, "asideSearch")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun callerChatNotificationSettingPut(
            entId: EntId,
            msg: MsgCallerChatNotificationSettingPut,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(
                SigDone::class.java,
                entId,
                SN,
                "callerChatNotificationSettingPut"
            )
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun groupCommonListGet(
            msg: MsgEntUserIdNoVersion,
            sigAcceptor: ISigAcceptor<SigGroupIdList>
        ) {
            CallFactory.rpc.create(
                SigGroupIdList::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "groupCommonListGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun groupInfoGet(
            entId: EntId,
            msg: MsgGroupInfoGet,
            sigAcceptor: ISigAcceptor<SigGroupInfo>
        ) {
            CallFactory.rpc.create(SigGroupInfo::class.java, entId, SN, "groupInfoGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun groupInviteLinkGet(msg: MsgGroupInviteLink, sigAcceptor: ISigAcceptor<SigUrl>) {
            CallFactory.rpc.create(
                SigUrl::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "groupInviteLinkGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun groupMembersAdd(msg: MsgGroupMembersAdd, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "groupMembersAdd"
            )
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun groupMembersRemove(msg: MsgGroupMembersRemove, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "groupMembersRemove"
            )
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun groupPatch(msg: MsgGroupPatch, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "groupPatch")
                .sendBearerToken()
                .patch(msg, sigAcceptor)
        }

        fun mediaListGet(entId: EntId, msg: MsgChatId, sigAcceptor: ISigAcceptor<SigMediaList>) {
            CallFactory.rpc.create(SigMediaList::class.java, entId, SN, "mediaListGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun messageReceiptGet(
            entId: EntId,
            msg: MsgOffset,
            sigAcceptor: ISigAcceptor<SigMessageReceiptMap>
        ) {
            CallFactory.rpc.create(SigMessageReceiptMap::class.java, entId, SN, "messageReceiptGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }
    }
}
