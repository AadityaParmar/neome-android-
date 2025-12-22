// neome.ai API - do not change
//

package com.neome.java.api.home.session.sig;

import com.neome.java.api.core.session.sig.SigTopic;
import com.neome.java.api.home.base.Types.EnumReceiptStatus;
import com.neome.java.api.meta.base.Types.MessageId;

@SuppressWarnings("unused")
public class SigTopicMessageProps extends SigTopic
{
  public MessageId messageId;

  public EnumReceiptStatus receiptStatus;
}
