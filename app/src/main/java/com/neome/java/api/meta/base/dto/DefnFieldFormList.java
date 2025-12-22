// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdSection;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldFormList extends DefnField
{
  @Nullable
  public MetaIdField bgColorFieldId;

  @Nullable
  public Boolean cardLayoutItemHideBorders;

  @Nullable
  public Long cardLayoutNumOfColumns;

  @Nullable
  public MetaIdField displayItemId;

  @Nullable
  public MetaIdSection displaySectionId;

  @Nullable
  public MetaIdField[] editableFieldIdSet;

  @Nullable
  public Boolean hideMenu;

  @Nullable
  public Boolean ignoreSelection;

  @Nullable
  public Boolean isPickMany;

  @Nullable
  public Long itemHeight;

  @Nullable
  public DefnDtoLayoutCardItem layout;

  @Nullable
  public MetaIdField[] pickRowOnFieldIdSet;

  @Nullable
  public Boolean showAsCardLayout;
}
