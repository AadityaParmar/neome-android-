// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.DefnFieldEditable;
import com.neome.api.meta.base.dto.DefnLayoutGrid;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdReport;

@SuppressWarnings("unused")
public class DefnFieldPickReportRow extends DefnFieldEditable
{
  @Nullable
  public Map<MetaIdField, MetaIdField> copyFieldMap;

  @Nullable
  public MetaIdField[] editableFieldIdSet;

  @Nullable
  public MetaIdField gridDisplayFieldId;

  public MetaIdReport reportId;

  @Nullable
  public MetaIdGrid reportOutputFormGridId;

  @Nullable
  public DefnLayoutGrid reportOutputFormGridLayout;

  @Nullable
  public Boolean showAsDropdown;
}
