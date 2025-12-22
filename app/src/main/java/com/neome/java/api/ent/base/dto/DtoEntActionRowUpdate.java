// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.dto.StudioValueVarIdCondition;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoEntActionRowUpdate extends DtoEntAction
{
  @Nullable
  public StudioValueVarIdCondition filterConditionVarId;

  @Nullable
  public MetaIdLayoutGrid layoutSpreadsheetId;

  @Nullable
  public MetaIdField lookupFieldId;

  public MetaIdForm spreadsheetFormId;

  public MetaIdSpreadsheet spreadsheetId;
}
