// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnMapPinShape;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoLayoutLocmapPin
{
  @Nullable
  public FieldDtoImage avatar;

  @Nullable
  public MetaIdField avatarFieldId;

  @Nullable
  public FieldDtoImage avatarVar;

  @Nullable
  public DefnDtoColor color;

  @Nullable
  public MetaIdField colorFieldId;

  @Nullable
  public DefnDtoColor colorVar;

  @Nullable
  public String label;

  @Nullable
  public MetaIdField labelFieldId;

  @Nullable
  public DefnDtoText labelVar;

  @Nullable
  public EnumDefnMapPinShape shape;

  @Nullable
  public MetaIdField shapeFieldId;

  @Nullable
  public EnumDefnMapPinShape shapeVar;

  @Nullable
  public String toolTip;

  @Nullable
  public MetaIdField toolTipFieldId;

  @Nullable
  public DefnDtoParagraph toolTipVar;
}
