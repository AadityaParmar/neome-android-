// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.RowId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class FieldValueRefTarget
{
  @Nullable
  public String displayValue;

  public String token;

  public RowId value;

  @Nullable
  public String version;
}
