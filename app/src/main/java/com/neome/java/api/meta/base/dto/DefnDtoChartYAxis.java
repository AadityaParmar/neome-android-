// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdChartYAxis;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoChartYAxis
{
  @Nullable
  public DefnDtoColor color;

  @Nullable
  public MetaIdField colorFieldId;

  @Nullable
  public DefnDtoColor colorVar;

  public MetaIdField fieldId;

  @Nullable
  public String label;

  public MetaIdChartYAxis metaId;
}
