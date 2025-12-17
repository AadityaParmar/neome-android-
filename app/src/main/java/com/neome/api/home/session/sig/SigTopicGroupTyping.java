// neome.ai API - do not change
//

package com.neome.api.home.session.sig;

import com.neome.api.core.session.sig.SigTopic;
import com.neome.api.meta.base.Types.EntUserId;

@SuppressWarnings("unused")
public class SigTopicGroupTyping extends SigTopic
{
  public EntUserId targetEntUserId;

  public String targetUserText;
}
