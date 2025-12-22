// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdReport;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntReportMapper extends StudioEntReport
{
  @Nullable
  public MetaIdVar inputFormMappingVarId;

  @Nullable
  public MetaIdReport mappedReportId;

  @Nullable
  public MetaIdVar outputFormMappingVarId;

  @Nullable
  public MetaIdSpreadsheet saveToSpreadsheetId;
}
