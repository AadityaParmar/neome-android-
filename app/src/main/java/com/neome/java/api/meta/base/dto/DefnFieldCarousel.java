// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnThemeImageCorner;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldCarousel extends DefnField
{
  @Nullable
  public long[] borderRadius;

  @Nullable
  public MetaIdField[] fieldIdSet;

  @Nullable
  public Long height;

  @Nullable
  public EnumDefnThemeImageCorner imageCornerVar;

  @Nullable
  public DefnDtoMedia[] mediaVarSet;

  @Nullable
  public Boolean showAsCard;

  @Nullable
  public Boolean showMediaPlaceholder;

  @Nullable
  public Long width;
}
