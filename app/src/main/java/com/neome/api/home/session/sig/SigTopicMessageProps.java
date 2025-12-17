// neome.ai API - do not change
//

package com.neome.api.home.session.sig;

import com.neome.api.core.session.sig.SigTopic;
import com.neome.api.home.base.Types.EnumReceiptStatus;
import com.neome.api.meta.base.Types.MessageId;

@SuppressWarnings("unused")
public class SigTopicMessageProps extends SigTopic
{
  public MessageId messageId;

  public EnumReceiptStatus receiptStatus;
}
