// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdReport;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnFieldRefReport extends DefnField
{
  @Nullable
  public Map<MetaIdField, MetaIdField> copyFieldMap;

  @Nullable
  public MetaIdField[] editableFieldIdSet;

  @Nullable
  public Boolean forceOpenOnFormCreate;

  @Nullable
  public Boolean forceOpenOnGridRowCreate;

  @Nullable
  public MetaIdGrid gridId;

  @Nullable
  public MetaIdField[] keyFieldIdSet;

  @Nullable
  public DefnLayoutGrid layoutGrid;

  @Nullable
  public DefnDtoLayoutOverlaySpreadsheet overlayLayoutGrid;

  public MetaIdReport reportId;
}
