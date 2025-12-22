// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.msg;

import com.neome.java.api.meta.base.Types.MetaIdAction;
import com.neome.java.api.meta.base.Types.MetaIdReport;
import com.neome.java.api.meta.base.dto.FormValueRaw;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgReportShare extends Msg
{
  public MetaIdAction actionId;

  @Nullable
  public FormValueRaw inputFormValueRaw;

  public MetaIdReport reportId;

  @Nullable
  public Boolean reset;
}
