// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdGroup;
import com.neome.java.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.java.api.meta.base.Types.MetaIdRole;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntActionSpreadsheetEditor extends StudioEntAction
{
  @Nullable
  public StudioMapOfActionPermission actionPermissionMap;

  @Nullable
  public MetaIdRole[] bulkInsertRoleSet;

  @Nullable
  public MetaIdField[] bulkUpdateFieldIdSet;

  @Nullable
  public MetaIdRole[] bulkUpdateRoleSet;

  @Nullable
  public Boolean doNotOpenAside;

  @Nullable
  public StudioValueVarIdCondition filterConditionVarId;

  @Nullable
  public MetaIdForm inputFormId;

  @Nullable
  public MetaIdLayoutGrid layoutSpreadsheetId;

  @Nullable
  public Boolean readOnly;

  @Nullable
  public MetaIdGroup sendMessageToGroupId;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
