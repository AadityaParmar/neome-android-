// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.google.gson.JsonElement;
import com.neome.api.meta.base.Types.MetaIdAction;
import com.neome.api.meta.base.Types.MetaIdComp;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdGroup;
import com.neome.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DtoEntActionSpreadsheetEditor extends DtoEntAction
{
  @Nullable
  public Map<MetaIdAction, DtoEntActionPermission> actionPermissionMap;

  @Nullable
  public MetaIdRole[] bulkInsertRoleSet;

  @Nullable
  public MetaIdField[] bulkUpdateFieldIdSet;

  @Nullable
  public MetaIdRole[] bulkUpdateRoleSet;

  @Nullable
  public Map<MetaIdComp, JsonElement> defaultValueMap;

  @Nullable
  public Boolean doNotOpenAside;

  @Nullable
  public MetaIdForm inputFormId;

  public MetaIdLayoutGrid layoutSpreadsheetId;

  @Nullable
  public Boolean readOnly;

  @Nullable
  public MetaIdGroup sendMessageToGroupId;

  public MetaIdForm spreadsheetFormId;

  public MetaIdSpreadsheet spreadsheetId;
}
