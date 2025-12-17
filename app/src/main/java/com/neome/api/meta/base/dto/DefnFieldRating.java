// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.DefnFieldEditable;
import com.neome.api.meta.base.Types.EnumDefnKindRating;

@SuppressWarnings("unused")
public class DefnFieldRating extends DefnFieldEditable
{
  @Nullable
  public EnumDefnKindRating ratingKind;

  @Nullable
  public EnumDefnKindRating ratingKindVar;
}
