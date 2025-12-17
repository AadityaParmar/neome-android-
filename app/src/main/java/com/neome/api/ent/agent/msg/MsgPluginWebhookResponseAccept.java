// neome.ai API - do not change
//

package com.neome.api.ent.agent.msg;

import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdPlugin;
import com.neome.api.meta.base.dto.FormValueRaw;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgPluginWebhookResponseAccept extends Msg
{
  public EntId entId;

  public MetaIdForm formId;

  public MetaIdPlugin pluginId;

  public FormValueRaw responseFormValue;
}
