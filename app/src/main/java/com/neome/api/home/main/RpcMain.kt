// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main

import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.home.main.msg.MsgChatBlock
import com.neome.api.home.base.msg.MsgChatId
import com.neome.api.core.base.msg.MsgEntUserIdNoVersion
import com.neome.api.home.base.msg.MsgGroupId
import com.neome.api.home.main.msg.MsgMessageBulkGet
import com.neome.api.home.main.msg.MsgMessageEdit
import com.neome.api.home.main.msg.MsgMessageForwardCandidateList
import com.neome.api.home.main.msg.MsgMessageList
import com.neome.api.home.main.msg.MsgMessageListJump
import com.neome.api.home.main.msg.MsgMessageListOffset
import com.neome.api.home.main.msg.MsgMessageReport
import com.neome.api.home.main.msg.MsgMessageSend
import com.neome.api.home.main.msg.MsgOffset
import com.neome.api.home.main.msg.MsgOffsetWithVersion
import com.neome.api.home.main.msg.MsgReaction
import com.neome.api.home.main.msg.MsgReverseGeocode
import com.neome.api.home.main.msg.MsgUrl
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.home.main.sig.SigChatCandidateMap
import com.neome.api.nucleus.base.sig.SigDone
import com.neome.api.home.main.sig.SigGroupMessageCandidateList
import com.neome.api.home.main.sig.SigLinkPreview
import com.neome.api.home.main.sig.SigMessage
import com.neome.api.home.main.sig.SigMessageBulk
import com.neome.api.home.main.sig.SigMessageList
import com.neome.api.home.main.sig.SigReverseGeocode
import com.neome.api.home.main.sig.SigUserLastOnline
import com.neome.api.home.main.sig.SigUserMessageCandidateList

class RpcMain {
    companion object {
        val SN: ServiceName = ServiceName.main

        fun chatBlock(msg: MsgChatBlock, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "chatBlock")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun chatClear(entId: EntId, msg: MsgChatId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "chatClear")
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }

        fun chatRemove(entId: EntId, msg: MsgChatId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "chatRemove")
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }

        fun groupJoin(msg: MsgGroupId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "groupJoin")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun groupMessageCandidateListGet(
            entId: EntId,
            sigAcceptor: ISigAcceptor<SigGroupMessageCandidateList>
        ) {
            CallFactory.rpc.create(
                SigGroupMessageCandidateList::class.java,
                entId,
                SN,
                "groupMessageCandidateListGet"
            )
                .sendBearerToken()
                .get(null, sigAcceptor)
        }

        fun linkPreviewGet(msg: MsgUrl, sigAcceptor: ISigAcceptor<SigLinkPreview>) {
            CallFactory.rpc.create(
                SigLinkPreview::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "linkPreviewGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun messageBulkGet(
            entId: EntId,
            msg: MsgMessageBulkGet,
            sigAcceptor: ISigAcceptor<SigMessageBulk>
        ) {
            CallFactory.rpc.create(SigMessageBulk::class.java, entId, SN, "messageBulkGet")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun messageEdit(entId: EntId, msg: MsgMessageEdit, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "messageEdit")
                .sendBearerToken()
                .patch(msg, sigAcceptor)
        }

        fun messageForwardCandidateListGet(
            entId: EntId,
            msg: MsgMessageForwardCandidateList,
            sigAcceptor: ISigAcceptor<SigChatCandidateMap>
        ) {
            CallFactory.rpc.create(
                SigChatCandidateMap::class.java,
                entId,
                SN,
                "messageForwardCandidateListGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun messageGet(
            entId: EntId,
            msg: MsgOffsetWithVersion,
            sigAcceptor: ISigAcceptor<SigMessage>
        ) {
            CallFactory.rpc.create(SigMessage::class.java, entId, SN, "messageGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun messageListGet(
            entId: EntId,
            msg: MsgMessageList,
            sigAcceptor: ISigAcceptor<SigMessageList>
        ) {
            CallFactory.rpc.create(SigMessageList::class.java, entId, SN, "messageListGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun messageListJump(
            entId: EntId,
            msg: MsgMessageListJump,
            sigAcceptor: ISigAcceptor<SigMessageList>
        ) {
            CallFactory.rpc.create(SigMessageList::class.java, entId, SN, "messageListJump")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun messageListNext(
            entId: EntId,
            msg: MsgMessageListOffset,
            sigAcceptor: ISigAcceptor<SigMessageList>
        ) {
            CallFactory.rpc.create(SigMessageList::class.java, entId, SN, "messageListNext")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun messageListPrev(
            entId: EntId,
            msg: MsgMessageListOffset,
            sigAcceptor: ISigAcceptor<SigMessageList>
        ) {
            CallFactory.rpc.create(SigMessageList::class.java, entId, SN, "messageListPrev")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun messageMarkRead(entId: EntId, msg: MsgOffset, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "messageMarkRead")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun messageMarkReceived(entId: EntId, msg: MsgOffset, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "messageMarkReceived")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun messageReactionPut(entId: EntId, msg: MsgReaction, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "messageReactionPut")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun messageRemoveForEveryone(
            entId: EntId,
            msg: MsgOffset,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "messageRemoveForEveryone")
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }

        fun messageRemoveForMe(entId: EntId, msg: MsgOffset, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "messageRemoveForMe")
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }

        fun messageReport(entId: EntId, msg: MsgMessageReport, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "messageReport")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun messageSend(entId: EntId, msg: MsgMessageSend, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "messageSend")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun messageTyping(entId: EntId, msg: MsgChatId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "messageTyping")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun reverseGeocode(
            entId: EntId,
            msg: MsgReverseGeocode,
            sigAcceptor: ISigAcceptor<SigReverseGeocode>
        ) {
            CallFactory.rpc.create(SigReverseGeocode::class.java, entId, SN, "reverseGeocode")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun userLastOnlineGet(
            entId: EntId,
            msg: MsgEntUserIdNoVersion,
            sigAcceptor: ISigAcceptor<SigUserLastOnline>
        ) {
            CallFactory.rpc.create(SigUserLastOnline::class.java, entId, SN, "userLastOnlineGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun userMessageCandidateListGet(sigAcceptor: ISigAcceptor<SigUserMessageCandidateList>) {
            CallFactory.rpc.create(
                SigUserMessageCandidateList::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "userMessageCandidateListGet"
            )
                .sendBearerToken()
                .get(null, sigAcceptor)
        }
    }
}
