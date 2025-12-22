// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnThemeStroke;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutLocmapLineStroke extends StudioBase
{
  @Nullable
  public StudioDtoColor color;

  @Nullable
  public MetaIdField colorFieldId;

  @Nullable
  public MetaIdVar colorVarId;

  @Nullable
  public MetaIdField groupByFieldId;

  @Nullable
  public EnumDefnThemeStroke stroke;

  @Nullable
  public MetaIdField strokeFieldId;

  @Nullable
  public MetaIdVar strokeVarId;
}
