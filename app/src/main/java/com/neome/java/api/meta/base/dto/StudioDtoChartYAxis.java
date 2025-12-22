// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.MetaIdChartYAxis;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoChartYAxis extends StudioBase
{
  @Nullable
  public StudioDtoColor color;

  @Nullable
  public MetaIdField colorFieldId;

  @Nullable
  public MetaIdVar colorVarId;

  @Nullable
  public MetaIdField fieldId;

  @Nullable
  public String label;

  public MetaIdChartYAxis metaId;

  @Nullable
  public Symbol name;
}
