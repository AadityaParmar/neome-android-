// neome.ai API - do not change
//

package com.neome.java.api.home.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdAction;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdReport;
import com.neome.java.api.meta.base.Types.RowId;
import com.neome.java.api.meta.base.dto.FormValueRaw;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoMessagePayloadReport extends DtoMessagePayload
{
  public MetaIdAction actionId;

  @Nullable
  public FormValueRaw formValueRaw;

  @Nullable
  public MetaIdForm inputFormId;

  @Nullable
  public MetaIdReport reportId;

  @Nullable
  public String reportLabel;

  @Nullable
  public String reportName;

  @Nullable
  public RowId rowId;
}
