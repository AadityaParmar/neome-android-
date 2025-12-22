// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnRenderingKind;
import com.neome.java.api.meta.base.Types.EnumDefnShowBorderKind;
import com.neome.java.api.meta.base.Types.EnumDefnShowBorderRadiusKind;
import com.neome.java.api.meta.base.Types.EnumDefnThemeDirection;
import com.neome.java.api.meta.base.Types.EnumDefnThemeDividerKind;
import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutFormContent extends StudioDtoLayoutForm
{
  @Nullable
  public MetaIdLayoutForm[] allowToSwitchLayoutIdSet;

  @Nullable
  public StudioDtoColor backgroundColor;

  @Nullable
  public MetaIdVar backgroundColorVarId;

  @Nullable
  public StudioDtoColor borderColor;

  @Nullable
  public MetaIdVar borderColorVarId;

  @Nullable
  public EnumDefnShowBorderKind[] borderPositionSet;

  @Nullable
  public EnumDefnShowBorderRadiusKind[] borderRadiusSet;

  @Nullable
  public EnumDefnThemeDividerKind borderRadiusSize;

  @Nullable
  public EnumDefnThemeDirection direction;

  @Nullable
  public String displayLabel;

  @Nullable
  public StudioDtoLayoutFormContentItem end;

  @Nullable
  public StudioDtoLayoutFormContentItem flexCenter;

  @Nullable
  public EnumDefnShowBorderKind[] paddingPositionSet;

  @Nullable
  public EnumDefnThemeDividerKind paddingSize;

  @Nullable
  public EnumDefnRenderingKind renderingMode;

  @Nullable
  public Boolean rootLayout;

  @Nullable
  public StudioDtoLayoutFormContentItem start;
}
