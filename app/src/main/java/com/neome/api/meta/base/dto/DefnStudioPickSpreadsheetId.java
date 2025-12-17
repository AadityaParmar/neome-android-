// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioPickSpreadsheetId extends DefnFieldEditable
{
  @Nullable
  public MetaIdSpreadsheet[] excludeSpreadsheetIdSet;

  @Nullable
  public Boolean showAlias;
}
