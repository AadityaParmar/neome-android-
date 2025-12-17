// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdGroup;
import com.neome.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.dto.StudioEntAction;
import com.neome.api.meta.base.dto.StudioMapOfActionPermission;
import com.neome.api.meta.base.dto.StudioValueVarIdCondition;

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
