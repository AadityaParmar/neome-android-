// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer

import com.neome.api.core.base.msg.MsgHandle
import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.core.base.sig.SigVerifyKey
import com.neome.api.home.base.msg.MsgChatId
import com.neome.api.home.base.msg.MsgDeviceId
import com.neome.api.home.base.msg.MsgEntUserId
import com.neome.api.home.base.msg.MsgGroupId
import com.neome.api.home.drawer.msg.MsgAddressBookContact
import com.neome.api.home.drawer.msg.MsgCallerDeviceState
import com.neome.api.home.drawer.msg.MsgCallerHandleChange
import com.neome.api.home.drawer.msg.MsgCallerNotificationSettingPut
import com.neome.api.home.drawer.msg.MsgCallerPasswordReset
import com.neome.api.home.drawer.msg.MsgCallerProfilePatch
import com.neome.api.home.drawer.msg.MsgDrawerSearch
import com.neome.api.home.drawer.msg.MsgEntFilter
import com.neome.api.home.drawer.msg.MsgGroupCandidateListGet
import com.neome.api.home.drawer.msg.MsgGroupCreate
import com.neome.api.home.drawer.msg.MsgLastMessageGet
import com.neome.api.home.drawer.msg.MsgUserAvatarBulkGet
import com.neome.api.home.drawer.msg.MsgUserNotificationId
import com.neome.api.home.drawer.msg.MsgUserNotificationList
import com.neome.api.home.drawer.sig.SigAddressBook
import com.neome.api.home.drawer.sig.SigBadgeMap
import com.neome.api.home.drawer.sig.SigBulkUserAvatar
import com.neome.api.home.drawer.sig.SigCallerDeviceList
import com.neome.api.home.drawer.sig.SigDrawerSearch
import com.neome.api.home.drawer.sig.SigGroupAvatar
import com.neome.api.home.drawer.sig.SigGroupCandidateMap
import com.neome.api.home.drawer.sig.SigRecentList
import com.neome.api.home.drawer.sig.SigStarMessageList
import com.neome.api.home.drawer.sig.SigUserAvatar
import com.neome.api.home.drawer.sig.SigUserNotificationList
import com.neome.api.home.main.msg.MsgEntFilterNoVersion
import com.neome.api.home.main.msg.MsgOffset
import com.neome.api.home.main.sig.SigChatCandidateMap
import com.neome.api.home.main.sig.SigLastMessage
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.nucleus.base.sig.SigDone

class RpcDrawer {
    companion object {
        val SN: ServiceName = ServiceName.drawer

        fun addressBookContactPatch(
            msg: MsgAddressBookContact,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "addressBookContactPatch"
            )
                .sendBearerToken()
                .patch(msg, sigAcceptor)
        }

        fun addressBookContactPut(msg: MsgAddressBookContact, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "addressBookContactPut"
            )
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun addressBookContactRemove(msg: MsgHandle, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "addressBookContactRemove"
            )
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }

        fun addressBookGet(msg: MsgVersion, sigAcceptor: ISigAcceptor<SigAddressBook>) {
            CallFactory.rpc.create(
                SigAddressBook::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "addressBookGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun addressBookInvite(msg: MsgHandle, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "addressBookInvite"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun badgeMapGet(msg: MsgVersion, sigAcceptor: ISigAcceptor<SigBadgeMap>) {
            CallFactory.rpc.create(
                SigBadgeMap::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "badgeMapGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun callerAccountRemove(sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "callerAccountRemove"
            )
                .sendRefreshToken()
                .delete(null, sigAcceptor)
        }

        fun callerDeviceListGet(sigAcceptor: ISigAcceptor<SigCallerDeviceList>) {
            CallFactory.rpc.create(
                SigCallerDeviceList::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "callerDeviceListGet"
            )
                .sendBearerToken()
                .get(null, sigAcceptor)
        }

        fun callerDeviceRemove(msg: MsgDeviceId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "callerDeviceRemove"
            )
                .sendRefreshToken()
                .delete(msg, sigAcceptor)
        }

        fun callerDeviceStatePut(msg: MsgCallerDeviceState, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "callerDeviceStatePut"
            )
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun callerHandleChange(
            msg: MsgCallerHandleChange,
            sigAcceptor: ISigAcceptor<SigVerifyKey>
        ) {
            CallFactory.rpc.create(
                SigVerifyKey::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "callerHandleChange"
            )
                .sendRefreshToken()
                .patch(msg, sigAcceptor)
        }

        fun callerNotificationSettingPut(
            entId: EntId,
            msg: MsgCallerNotificationSettingPut,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "callerNotificationSettingPut")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun callerPasswordReset(msg: MsgCallerPasswordReset, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "callerPasswordReset"
            )
                .sendRefreshToken()
                .patch(msg, sigAcceptor)
        }

        fun callerProfilePatch(msg: MsgCallerProfilePatch, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "callerProfilePatch"
            )
                .sendBearerToken()
                .patch(msg, sigAcceptor)
        }

        fun drawerSearch(msg: MsgDrawerSearch, sigAcceptor: ISigAcceptor<SigDrawerSearch>) {
            CallFactory.rpc.create(
                SigDrawerSearch::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "drawerSearch"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun groupAvatarGet(
            entId: EntId,
            msg: MsgGroupId,
            sigAcceptor: ISigAcceptor<SigGroupAvatar>
        ) {
            CallFactory.rpc.create(SigGroupAvatar::class.java, entId, SN, "groupAvatarGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun groupCandidateListGet(
            msg: MsgGroupCandidateListGet,
            sigAcceptor: ISigAcceptor<SigGroupCandidateMap>
        ) {
            CallFactory.rpc.create(
                SigGroupCandidateMap::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "groupCandidateListGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun groupCreate(msg: MsgGroupCreate, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "groupCreate")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun groupExit(msg: MsgGroupId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "groupExit")
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }

        fun lastMessageGet(
            entId: EntId,
            msg: MsgLastMessageGet,
            sigAcceptor: ISigAcceptor<SigLastMessage>
        ) {
            CallFactory.rpc.create(SigLastMessage::class.java, entId, SN, "lastMessageGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun messageStar(entId: EntId, msg: MsgOffset, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "messageStar")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun messageUnStar(entId: EntId, msg: MsgOffset, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "messageUnStar")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun newChatCandidateListGet(
            msg: MsgEntFilterNoVersion,
            sigAcceptor: ISigAcceptor<SigChatCandidateMap>
        ) {
            CallFactory.rpc.create(
                SigChatCandidateMap::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "newChatCandidateListGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun recentItemPin(entId: EntId, msg: MsgChatId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "recentItemPin")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun recentItemUnPin(entId: EntId, msg: MsgChatId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "recentItemUnPin")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun recentListGet(msg: MsgEntFilter, sigAcceptor: ISigAcceptor<SigRecentList>) {
            CallFactory.rpc.create(
                SigRecentList::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "recentListGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun starMessageListGet(msg: MsgEntFilter, sigAcceptor: ISigAcceptor<SigStarMessageList>) {
            CallFactory.rpc.create(
                SigStarMessageList::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "starMessageListGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun userAvatarBulkGet(
            entId: EntId,
            msg: MsgUserAvatarBulkGet,
            sigAcceptor: ISigAcceptor<SigBulkUserAvatar>
        ) {
            CallFactory.rpc.create(SigBulkUserAvatar::class.java, entId, SN, "userAvatarBulkGet")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun userAvatarGet(
            entId: EntId,
            msg: MsgEntUserId,
            sigAcceptor: ISigAcceptor<SigUserAvatar>
        ) {
            CallFactory.rpc.create(SigUserAvatar::class.java, entId, SN, "userAvatarGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun userNotificationListGet(
            msg: MsgUserNotificationList,
            sigAcceptor: ISigAcceptor<SigUserNotificationList>
        ) {
            CallFactory.rpc.create(
                SigUserNotificationList::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "userNotificationListGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun userNotificationMarkRead(
            msg: MsgUserNotificationId,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "userNotificationMarkRead"
            )
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun userNotificationRemove(msg: MsgUserNotificationId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "userNotificationRemove"
            )
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }
    }
}
