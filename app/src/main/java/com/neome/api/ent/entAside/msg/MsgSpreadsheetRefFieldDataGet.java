// neome.ai API - do not change
//

package com.neome.api.ent.entAside.msg;

import com.neome.api.core.base.msg.MsgVersion;
import com.neome.api.meta.base.Types.MetaIdComp;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.dto.FormValueRaw;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgSpreadsheetRefFieldDataGet extends MsgVersion
{
  @Nullable
  public Boolean ascOrder;

  public MetaIdForm formId;

  @Nullable
  public MetaIdSpreadsheet formSpreadsheetId;

  public FormValueRaw inputFormValueRaw;

  public MetaIdComp refFieldId;

  @Nullable
  public MetaIdField[] sortByFieldIdSet;
}
