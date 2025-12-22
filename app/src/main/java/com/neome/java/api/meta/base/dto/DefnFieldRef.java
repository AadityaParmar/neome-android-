// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnRefreshOn;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnFieldRef extends DefnField
{
  @Nullable
  public Boolean canCreateRefRecord;

  @Nullable
  public MetaIdField categoryFilterDisplayFieldId;

  @Nullable
  public Map<MetaIdField, MetaIdField> copyFieldMap;

  @Nullable
  public MetaIdVar createRefRecordMappingVarId;

  @Nullable
  public MetaIdField[] editableFieldIdSet;

  @Nullable
  public Boolean forceOpenOnFormCreate;

  @Nullable
  public Boolean forceOpenOnGridRowCreate;

  @Nullable
  public MetaIdField[] keyFieldIdSet;

  @Nullable
  public DefnLayoutGrid layoutSpreadsheet;

  @Nullable
  public MetaIdField lookupFieldId;

  @Nullable
  public DefnDtoLayoutOverlaySpreadsheet overlayLayoutSpreadsheet;

  @Nullable
  public EnumDefnRefreshOn refreshOn;

  @Nullable
  public Boolean showRefreshInMenu;

  @Nullable
  public MetaIdField[] showRefreshOnFieldIdSet;

  public MetaIdSpreadsheet spreadsheetId;
}
