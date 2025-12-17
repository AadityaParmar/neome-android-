// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoRowIdPointer extends StudioBase
{
  @Nullable
  public StudioBuildArgBinder rowId;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
