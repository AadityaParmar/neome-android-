// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnArgBinderArgument;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoArgValueArgument extends StudioDtoArgValue
{
  public EnumDefnArgBinderArgument arg1;

  @Nullable
  public EnumDefnArgBinderArgument arg2;

  public MetaIdField fieldId;

  @Nullable
  public String[] valuePathArray;
}
