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
import com.neome.java.api.home.main.msg.MsgTopic;
import com.neome.java.api.home.main.msg.MsgTopicList;
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
import com.neome.java.api.meta.base.Types.ArtifactId;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.ServiceName;
import com.neome.java.api.nucleus.base.ApiPlus;
import com.neome.java.api.nucleus.base.CallFactory;
import com.neome.java.api.nucleus.base.ISigAcceptor;
import com.neome.java.api.nucleus.base.sig.SigDone;

@SuppressWarnings("unused")
public class WsocMain
{
  public static final ServiceName SN = ServiceName.main;

  public static void chatBlock(MsgChatBlock msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "chatBlock")
      .put(msg, sigAcceptor);
  }

  public static void chatClear(EntId entId, MsgChatId msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "chatClear")
      .delete(msg, sigAcceptor);
  }

  public static void chatRemove(EntId entId, MsgChatId msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "chatRemove")
      .delete(msg, sigAcceptor);
  }

  public static void groupJoin(MsgGroupId msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "groupJoin")
      .put(msg, sigAcceptor);
  }

  public static void groupMessageCandidateListGet(EntId entId,
    ISigAcceptor<SigGroupMessageCandidateList> sigAcceptor)
  {
    CallFactory.wsoc.create(SigGroupMessageCandidateList.class, entId, SN,
        "groupMessageCandidateListGet")
      .get(null, sigAcceptor);
  }

  public static void linkPreviewGet(MsgUrl msg, ISigAcceptor<SigLinkPreview> sigAcceptor)
  {
    CallFactory.wsoc.create(SigLinkPreview.class, ApiPlus.ENT_ID_GLOBAL, SN, "linkPreviewGet")
      .get(msg, sigAcceptor);
  }

  public static void messageBulkGet(EntId entId, MsgMessageBulkGet msg,
    ISigAcceptor<SigMessageBulk> sigAcceptor)
  {
    CallFactory.wsoc.create(SigMessageBulk.class, entId, SN, "messageBulkGet")
      .post(msg, sigAcceptor);
  }

  public static void messageEdit(EntId entId, MsgMessageEdit msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "messageEdit")
      .patch(msg, sigAcceptor);
  }

  public static void messageForwardCandidateListGet(EntId entId, MsgMessageForwardCandidateList msg,
    ISigAcceptor<SigChatCandidateMap> sigAcceptor)
  {
    CallFactory.wsoc.create(SigChatCandidateMap.class, entId, SN, "messageForwardCandidateListGet")
      .get(msg, sigAcceptor);
  }

  public static void messageGet(EntId entId, MsgOffsetWithVersion msg,
    ISigAcceptor<SigMessage> sigAcceptor)
  {
    CallFactory.wsoc.create(SigMessage.class, entId, SN, "messageGet")
      .get(msg, sigAcceptor);
  }

  public static void messageListGet(EntId entId, MsgMessageList msg,
    ISigAcceptor<SigMessageList> sigAcceptor)
  {
    CallFactory.wsoc.create(SigMessageList.class, entId, SN, "messageListGet")
      .get(msg, sigAcceptor);
  }

  public static void messageListJump(EntId entId, MsgMessageListJump msg,
    ISigAcceptor<SigMessageList> sigAcceptor)
  {
    CallFactory.wsoc.create(SigMessageList.class, entId, SN, "messageListJump")
      .get(msg, sigAcceptor);
  }

  public static void messageListNext(EntId entId, MsgMessageListOffset msg,
    ISigAcceptor<SigMessageList> sigAcceptor)
  {
    CallFactory.wsoc.create(SigMessageList.class, entId, SN, "messageListNext")
      .get(msg, sigAcceptor);
  }

  public static void messageListPrev(EntId entId, MsgMessageListOffset msg,
    ISigAcceptor<SigMessageList> sigAcceptor)
  {
    CallFactory.wsoc.create(SigMessageList.class, entId, SN, "messageListPrev")
      .get(msg, sigAcceptor);
  }

  public static void messageMarkRead(EntId entId, MsgOffset msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "messageMarkRead")
      .put(msg, sigAcceptor);
  }

  public static void messageMarkReceived(EntId entId, MsgOffset msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "messageMarkReceived")
      .put(msg, sigAcceptor);
  }

  public static void messageReactionPut(EntId entId, MsgReaction msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "messageReactionPut")
      .put(msg, sigAcceptor);
  }

  public static void messageRemoveForEveryone(EntId entId, MsgOffset msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "messageRemoveForEveryone")
      .delete(msg, sigAcceptor);
  }

  public static void messageRemoveForMe(EntId entId, MsgOffset msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "messageRemoveForMe")
      .delete(msg, sigAcceptor);
  }

  public static void messageReport(EntId entId, MsgMessageReport msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "messageReport")
      .post(msg, sigAcceptor);
  }

  public static void messageSend(EntId entId, MsgMessageSend msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "messageSend")
      .post(msg, sigAcceptor);
  }

  public static void messageTyping(EntId entId, MsgChatId msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, entId, SN, "messageTyping")
      .post(msg, sigAcceptor);
  }

  public static void reverseGeocode(EntId entId, MsgReverseGeocode msg,
    ISigAcceptor<SigReverseGeocode> sigAcceptor)
  {
    CallFactory.wsoc.create(SigReverseGeocode.class, entId, SN, "reverseGeocode")
      .get(msg, sigAcceptor);
  }

  public static void subscribe(ArtifactId artifactId, MsgTopic msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, artifactId, SN, "subscribe")
      .put(msg, sigAcceptor);
  }

  public static void topicSubscribe(MsgTopicList msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "topicSubscribe")
      .put(msg, sigAcceptor);
  }

  public static void topicSubscriptionCheck(ArtifactId artifactId, MsgTopic msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, artifactId, SN, "topicSubscriptionCheck")
      .get(msg, sigAcceptor);
  }

  public static void topicUnsubscribe(MsgTopicList msg, ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, ApiPlus.ENT_ID_GLOBAL, SN, "topicUnsubscribe")
      .put(msg, sigAcceptor);
  }

  public static void unsubscribe(ArtifactId artifactId, MsgTopic msg,
    ISigAcceptor<SigDone> sigAcceptor)
  {
    CallFactory.wsoc.create(SigDone.class, artifactId, SN, "unsubscribe")
      .delete(msg, sigAcceptor);
  }

  public static void userLastOnlineGet(EntId entId, MsgEntUserIdNoVersion msg,
    ISigAcceptor<SigUserLastOnline> sigAcceptor)
  {
    CallFactory.wsoc.create(SigUserLastOnline.class, entId, SN, "userLastOnlineGet")
      .get(msg, sigAcceptor);
  }

  public static void userMessageCandidateListGet(
    ISigAcceptor<SigUserMessageCandidateList> sigAcceptor)
  {
    CallFactory.wsoc.create(SigUserMessageCandidateList.class, ApiPlus.ENT_ID_GLOBAL, SN,
        "userMessageCandidateListGet")
      .get(null, sigAcceptor);
  }
}
