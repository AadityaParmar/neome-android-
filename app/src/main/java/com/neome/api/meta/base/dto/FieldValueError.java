// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnErrorSeverity;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class FieldValueError
{
  public long errorCounter;

  @Nullable
  public String[] errorParameterSet;

  public String errorReason;

  public EnumDefnErrorSeverity severity;
}
