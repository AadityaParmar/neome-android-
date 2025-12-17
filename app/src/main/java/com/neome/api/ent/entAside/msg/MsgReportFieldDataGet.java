// neome.ai API - do not change
//

package com.neome.api.ent.entAside.msg;

import com.neome.api.meta.base.Types.MetaIdComposite;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.RowId;
import com.neome.api.meta.base.dto.FormValueRaw;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgReportFieldDataGet extends Msg
{
  public MetaIdForm formId;

  @Nullable
  public MetaIdComposite inputFormCompositeId;

  @Nullable
  public RowId inputFormGridRowId;

  public FormValueRaw inputFormValue;

  public MetaIdField reportFieldId;
}
