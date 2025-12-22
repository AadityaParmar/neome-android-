// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnRefreshOn;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioFieldRef extends StudioField
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
  public StudioValueVarIdCondition filterConditionVarId;

  @Nullable
  public Boolean forceOpenOnFormCreate;

  @Nullable
  public Boolean forceOpenOnGridRowCreate;

  @Nullable
  public MetaIdField[] keyFieldIdSet;

  @Nullable
  public MetaIdLayoutGrid layoutSpreadsheetId;

  @Nullable
  public MetaIdField lookupFieldId;

  @Nullable
  public StudioDtoLayoutOverlaySpreadsheet overlayLayoutSpreadsheet;

  @Nullable
  public EnumDefnRefreshOn refreshOn;

  @Nullable
  public Boolean showRefreshInMenu;

  @Nullable
  public MetaIdField[] showRefreshOnFieldIdSet;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
