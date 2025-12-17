// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoEntDeeplinkSpreadsheetRow extends DtoEntDeeplink
{
  @Nullable
  public MetaIdLayoutForm formContentLayoutId;

  @Nullable
  public MetaIdLayoutForm formTemplateLayoutId;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
