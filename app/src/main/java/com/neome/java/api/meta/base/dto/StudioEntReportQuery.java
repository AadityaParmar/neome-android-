// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntReportQuery extends StudioEntReport
{
  @Nullable
  public MetaIdSpreadsheet[] fromSpreadsheetIdSet;

  @Nullable
  public StudioValueCodeNeoQL neoQL;
}
