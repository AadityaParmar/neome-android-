// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnCompType;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class StudioDtoArgValueDerived extends StudioDtoArgValue
{
  public MetaIdField derivedFieldId;

  @Nullable
  public EnumDefnCompType derivedFieldType;

  @Nullable
  public Boolean valueBoolean;

  @Nullable
  public Date valueDate;

  @Nullable
  public Double valueDouble;

  @Nullable
  public Long valueLong;

  @Nullable
  public String valueOptionId;

  @Nullable
  public String valueText;
}
