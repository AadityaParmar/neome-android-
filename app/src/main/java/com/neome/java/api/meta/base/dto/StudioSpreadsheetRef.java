// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheetRef;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioSpreadsheetRef extends StudioComposite
{
  @Nullable
  public StudioValueVarIdCondition filterConditionVarId;

  @Nullable
  public MetaIdLayoutGrid layoutSpreadsheetId;

  @Nullable
  public Long maxRecords;

  public MetaIdSpreadsheetRef metaId;

  @Nullable
  public MetaIdField refTargetFieldId;

  @Nullable
  public StudioMapOfActionPermission rowActionPermissionMap;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
