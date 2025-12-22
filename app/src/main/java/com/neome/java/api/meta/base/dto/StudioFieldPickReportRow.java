// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdGrid;
import com.neome.java.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.java.api.meta.base.Types.MetaIdReport;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioFieldPickReportRow extends StudioFieldEditable
{
  @Nullable
  public Map<MetaIdField, MetaIdField> copyFieldMap;

  @Nullable
  public MetaIdField[] editableFieldIdSet;

  @Nullable
  public MetaIdField gridDisplayFieldId;

  @Nullable
  public MetaIdReport reportId;

  @Nullable
  public MetaIdGrid reportOutputFormGridId;

  @Nullable
  public MetaIdLayoutGrid reportOutputFormGridLayoutId;

  @Nullable
  public Boolean showAsDropdown;
}
