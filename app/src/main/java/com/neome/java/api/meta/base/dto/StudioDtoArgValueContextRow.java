// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnArgBinderContextRow;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoArgValueContextRow extends StudioDtoArgValueContext
{
  public EnumDefnArgBinderContextRow attribute;

  @Nullable
  public String fromAlias;
}
