// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnLayoutGridKind;
import com.neome.java.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioPickLayoutSpreadsheetId extends DefnFieldEditable
{
  @Nullable
  public MetaIdLayoutGrid[] excludeLayoutSpreadsheetIdSet;

  @Nullable
  public EnumDefnLayoutGridKind[] filterLayoutKindSet;

  @Nullable
  public Boolean showAlias;

  public MetaIdSpreadsheet spreadsheetId;
}
