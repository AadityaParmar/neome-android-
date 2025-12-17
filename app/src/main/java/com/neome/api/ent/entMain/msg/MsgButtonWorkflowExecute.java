// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.RowId;
import com.neome.api.meta.base.dto.FormValueRaw;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgButtonWorkflowExecute extends Msg
{
  public MetaIdField buttonFieldId;

  public MetaIdForm buttonFormId;

  public FormValueRaw formValue;

  @Nullable
  public MetaIdGrid fromGridId;

  @Nullable
  public RowId fromGridRowId;
}
