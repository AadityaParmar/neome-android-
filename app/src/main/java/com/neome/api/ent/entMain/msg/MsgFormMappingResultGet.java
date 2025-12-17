// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdVar;
import com.neome.api.meta.base.Types.RowId;
import com.neome.api.meta.base.dto.FormValueRaw;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgFormMappingResultGet extends Msg
{
  @Nullable
  public RowId inputFormGridRowId;

  public MetaIdForm inputFormId;

  public FormValueRaw inputFormValueRaw;

  public MetaIdVar mappingVarId;

  @Nullable
  public RowId outputFormGridRowId;

  public MetaIdForm outputFormId;

  @Nullable
  public FormValueRaw outputFormValueRaw;
}
