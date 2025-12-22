// neome.ai API - do not change
//

package com.neome.java.api.ent.entAside.msg;

import com.neome.java.api.meta.base.Types.MetaIdComposite;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.RowId;
import com.neome.java.api.meta.base.dto.FormValueRaw;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgButtonFieldReportDataGet extends Msg
{
  public MetaIdField buttonFieldId;

  public MetaIdForm formId;

  public FormValueRaw formValue;

  @Nullable
  public MetaIdComposite fromCompositeId;

  @Nullable
  public RowId fromGridRowId;
}
