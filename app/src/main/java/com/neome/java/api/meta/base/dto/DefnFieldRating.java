// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnKindRating;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldRating extends DefnFieldEditable
{
  @Nullable
  public EnumDefnKindRating ratingKind;

  @Nullable
  public EnumDefnKindRating ratingKindVar;
}
