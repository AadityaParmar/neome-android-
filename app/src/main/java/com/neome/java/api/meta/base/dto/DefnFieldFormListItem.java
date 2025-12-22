// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldFormListItem extends DefnFieldLabel
{
  @Nullable
  public MetaIdField[] editableFieldIdSet;

  @Nullable
  public Boolean isCard;

  @Nullable
  public DefnDtoLayoutCardItem layout;
}
