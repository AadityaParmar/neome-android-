// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnMapPinShape;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutLocmapPin extends StudioBase
{
  @Nullable
  public FieldDtoImage avatar;

  @Nullable
  public MetaIdField avatarFieldId;

  @Nullable
  public MetaIdVar avatarVarId;

  @Nullable
  public StudioDtoColor color;

  @Nullable
  public MetaIdField colorFieldId;

  @Nullable
  public MetaIdVar colorVarId;

  @Nullable
  public String label;

  @Nullable
  public MetaIdField labelFieldId;

  @Nullable
  public StudioValueVarIdText labelVarId;

  @Nullable
  public EnumDefnMapPinShape shape;

  @Nullable
  public MetaIdField shapeFieldId;

  @Nullable
  public MetaIdVar shapeVarId;

  @Nullable
  public String toolTip;

  @Nullable
  public MetaIdField toolTipFieldId;

  @Nullable
  public StudioValueVarIdParagraph toolTipVarId;
}
