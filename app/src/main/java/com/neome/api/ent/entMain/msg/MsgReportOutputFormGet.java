// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.meta.base.Types.MetaIdAction;
import com.neome.api.meta.base.Types.MetaIdComposite;
import com.neome.api.meta.base.Types.RowId;
import com.neome.api.meta.base.dto.FormValueRaw;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgReportOutputFormGet extends Msg
{
  public MetaIdAction actionId;

  @Nullable
  public MetaIdComposite inputFormCompositeId;

  @Nullable
  public RowId inputFormGridRowId;

  @Nullable
  public FormValueRaw inputFormValue;
}
