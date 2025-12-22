// neome.ai API - do not change
//
/* eslint-disable @typescript-eslint/no-unused-vars */
// noinspection UnusedGlobalSymbols,ES6UnusedImports,JSUnusedGlobalSymbols,JSUnusedLocalSymbols

package com.neome.java.api.home.main;

import com.neome.java.api.core.base.msg.MsgEntUserIdNoVersion;
import com.neome.java.api.home.base.msg.MsgChatId;
import com.neome.java.api.home.base.msg.MsgGroupId;
import com.neome.java.api.home.main.msg.MsgChatBlock;
import com.neome.java.api.home.main.msg.MsgMessageBulkGet;
import com.neome.java.api.home.main.msg.MsgMessageEdit;
import com.neome.java.api.home.main.msg.MsgMessageForwardCandidateList;
import com.neome.java.api.home.main.msg.MsgMessageList;
import com.neome.java.api.home.main.msg.MsgMessageListJump;
import com.neome.java.api.home.main.msg.MsgMessageListOffset;
import com.neome.java.api.home.main.msg.MsgMessageReport;
import com.neome.java.api.home.main.msg.MsgMessageSend;
import com.neome.java.api.home.main.msg.MsgOffset;
import com.neome.java.api.home.main.msg.MsgOffsetWithVersion;
import com.neome.java.api.home.main.msg.MsgReaction;
import com.neome.java.api.home.main.msg.MsgReverseGeocode;
import com.neome.java.api.home.main.msg.MsgUrl;
import com.neome.java.api.home.main.sig.SigChatCandidateMap;
import com.neome.java.api.home.main.sig.SigGroupMessageCandidateList;
import com.neome.java.api.home.main.sig.SigLinkPreview;
import com.neome.java.api.home.main.sig.SigMessage;
import com.neome.java.api.home.main.sig.SigMessageBulk;
import com.neome.java.api.home.main.sig.SigMessageList;
import com.neome.java.api.home.main.sig.SigReverseGeocode;
import com.neome.java.api.home.main.sig.SigUserLastOnline;
import com.neome.java.api.home.main.sig.SigUserMessageCandidateList;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.ServiceName;
import com.neome.java.api.nucleus.base.ApiPlus;
import com.neome.java.api.nucleus.base.CallFactory;
import com.neome.java.api.nucleus.base.ISigAcceptor;
import com.neome.java.api.nucleus.base.sig.SigDone;

@SuppressWarnings("unused")
public class RpcMain
{
  public static final ServiceName SN = ServiceName.main;

  public static void chatBlock(MsgChatBlock msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "chatBlock")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void chatClear(EntId entId, MsgChatId msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "chatClear")
      .sendBearerToken()
      .delete(msg, sigAcceptor);
  }

  public static void chatRemove(EntId entId, MsgChatId msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "chatRemove")
      .sendBearerToken()
      .delete(msg, sigAcceptor);
  }

  public static void groupJoin(MsgGroupId msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "groupJoin")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void groupMessageCandidateListGet(EntId entId,
    ISigAcceptor<SigGroupMessageCandidateList> sigAcceptor)
  {
    CallFactory.rpc.create(SigGroupMessageCandidateList.class, entId, SN,
        "groupMessageCandidateListGet")
      .sendBearerToken()
      .get(null, sigAcceptor);
  }

  public static void linkPreviewGet(MsgUrl msg, ISigAcceptor<SigLinkPreview> sigAcceptor)
  {
    CallFactory.rpc.create(SigLinkPreview.class, ApiPlus.ENT_ID_GLOBAL, SN, "linkPreviewGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void messageBulkGet(EntId entId, MsgMessageBulkGet msg,
    ISigAcceptor<SigMessageBulk> sigAcceptor)
  {
    CallFactory.rpc.create(SigMessageBulk.class, entId, SN, "messageBulkGet")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void messageEdit(EntId entId, MsgMessageEdit msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "messageEdit")
      .sendBearerToken()
      .patch(msg, sigAcceptor);
  }

  public static void messageForwardCandidateListGet(EntId entId, MsgMessageForwardCandidateList msg,
    ISigAcceptor<SigChatCandidateMap> sigAcceptor)
  {
    CallFactory.rpc.create(SigChatCandidateMap.class, entId, SN, "messageForwardCandidateListGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void messageGet(EntId entId, MsgOffsetWithVersion msg,
    ISigAcceptor<SigMessage> sigAcceptor)
  {
    CallFactory.rpc.create(SigMessage.class, entId, SN, "messageGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void messageListGet(EntId entId, MsgMessageList msg,
    ISigAcceptor<SigMessageList> sigAcceptor)
  {
    CallFactory.rpc.create(SigMessageList.class, entId, SN, "messageListGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void messageListJump(EntId entId, MsgMessageListJump msg,
    ISigAcceptor<SigMessageList> sigAcceptor)
  {
    CallFactory.rpc.create(SigMessageList.class, entId, SN, "messageListJump")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void messageListNext(EntId entId, MsgMessageListOffset msg,
    ISigAcceptor<SigMessageList> sigAcceptor)
  {
    CallFactory.rpc.create(SigMessageList.class, entId, SN, "messageListNext")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void messageListPrev(EntId entId, MsgMessageListOffset msg,
    ISigAcceptor<SigMessageList> sigAcceptor)
  {
    CallFactory.rpc.create(SigMessageList.class, entId, SN, "messageListPrev")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void messageMarkRead(EntId entId, MsgOffset msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "messageMarkRead")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void messageMarkReceived(EntId entId, MsgOffset msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "messageMarkReceived")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void messageReactionPut(EntId entId, MsgReaction msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "messageReactionPut")
      .sendBearerToken()
      .put(msg, sigAcceptor);
  }

  public static void messageRemoveForEveryone(EntId entId, MsgOffset msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "messageRemoveForEveryone")
      .sendBearerToken()
      .delete(msg, sigAcceptor);
  }

  public static void messageRemoveForMe(EntId entId, MsgOffset msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "messageRemoveForMe")
      .sendBearerToken()
      .delete(msg, sigAcceptor);
  }

  public static void messageReport(EntId entId, MsgMessageReport msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "messageReport")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void messageSend(EntId entId, MsgMessageSend msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "messageSend")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void messageTyping(EntId entId, MsgChatId msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.rpc.create(SigDone.class, entId, SN, "messageTyping")
      .sendBearerToken()
      .post(msg, sigAcceptor);
  }

  public static void reverseGeocode(EntId entId, MsgReverseGeocode msg,
    ISigAcceptor<SigReverseGeocode> sigAcceptor)
  {
    CallFactory.rpc.create(SigReverseGeocode.class, entId, SN, "reverseGeocode")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void userLastOnlineGet(EntId entId, MsgEntUserIdNoVersion msg,
    ISigAcceptor<SigUserLastOnline> sigAcceptor)
  {
    CallFactory.rpc.create(SigUserLastOnline.class, entId, SN, "userLastOnlineGet")
      .sendBearerToken()
      .get(msg, sigAcceptor);
  }

  public static void userMessageCandidateListGet(
    ISigAcceptor<SigUserMessageCandidateList> sigAcceptor)
  {
    CallFactory.rpc.create(SigUserMessageCandidateList.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "userMessageCandidateListGet")
      .sendBearerToken()
      .get(null, sigAcceptor);
  }
}
