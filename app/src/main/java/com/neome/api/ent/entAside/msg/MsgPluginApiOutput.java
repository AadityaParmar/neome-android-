// neome.ai API - do not change
//

package com.neome.api.ent.entAside.msg;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.dto.FormValueRaw;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgPluginApiOutput extends Msg
{
  public MetaIdField fieldId;

  public MetaIdForm formId;

  @Nullable
  public FormValueRaw formValueRaw;
}
