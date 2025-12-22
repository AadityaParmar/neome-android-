// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdGrid;
import com.neome.java.api.meta.base.Types.MetaIdReport;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

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
