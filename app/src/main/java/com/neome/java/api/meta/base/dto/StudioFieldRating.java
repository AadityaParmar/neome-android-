// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnKindRating;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldRating extends StudioFieldEditable
{
  @Nullable
  public EnumDefnKindRating ratingKind;

  @Nullable
  public MetaIdVar ratingKindVarId;
}
