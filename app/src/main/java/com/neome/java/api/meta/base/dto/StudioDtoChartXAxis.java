// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.MetaIdChartXAxis;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoChartXAxis extends StudioBase
{
  @Nullable
  public StudioDtoColor color;

  @Nullable
  public MetaIdField colorFieldId;

  @Nullable
  public MetaIdVar colorVarId;

  @Nullable
  public String label;

  public MetaIdChartXAxis metaId;

  @Nullable
  public Symbol name;

  @Nullable
  public String valueOptionId;
}
