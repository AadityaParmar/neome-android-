// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.DefnDtoLayoutOverlaySpreadsheet;
import com.neome.api.meta.base.dto.DefnField;
import com.neome.api.meta.base.dto.DefnLayoutGrid;
import com.neome.api.meta.base.Types.EnumDefnRefreshOn;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.MetaIdVar;

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
