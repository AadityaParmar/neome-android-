// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldHyperlinkRow extends DefnFieldEditable
{
  @Nullable
  public DefnDtoText displayTextVar;

  @Nullable
  public MetaIdField[] hyperlinkFieldIdSet;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
