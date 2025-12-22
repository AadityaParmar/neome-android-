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
public class StudioFieldRefReport extends StudioField
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
  public MetaIdLayoutGrid layoutGridId;

  @Nullable
  public StudioDtoLayoutOverlaySpreadsheet overlayLayoutGrid;

  @Nullable
  public MetaIdReport reportId;
}
