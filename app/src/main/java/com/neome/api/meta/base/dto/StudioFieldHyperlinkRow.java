// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldHyperlinkRow extends StudioFieldEditable
{
  @Nullable
  public StudioValueVarIdText displayTextVarId;

  @Nullable
  public MetaIdField[] hyperlinkFieldIdSet;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
