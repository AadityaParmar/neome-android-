// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnSpreadsheetRef extends DefnComp
{
  public DefnLayoutGrid layoutSpreadsheet;

  @Nullable
  public Long maxRecords;

  public MetaIdSpreadsheetRef metaId;

  @Nullable
  public MetaIdField refTargetFieldId;

  @Nullable
  public DefnStudioMapOfActionPermission rowActionPermissionMap;

  public MetaIdSpreadsheet spreadsheetId;
}
