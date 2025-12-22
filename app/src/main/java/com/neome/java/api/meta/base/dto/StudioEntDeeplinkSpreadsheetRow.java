// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntDeeplinkSpreadsheetRow extends StudioEntDeeplinkWithHeader
{
  @Nullable
  public MetaIdLayoutForm formContentLayoutId;

  @Nullable
  public MetaIdLayoutForm formTemplateLayoutId;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
