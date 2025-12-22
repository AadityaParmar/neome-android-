// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnRenderingKind;
import com.neome.java.api.meta.base.Types.EnumDefnShowBorderKind;
import com.neome.java.api.meta.base.Types.EnumDefnShowBorderRadiusKind;
import com.neome.java.api.meta.base.Types.EnumDefnThemeDirection;
import com.neome.java.api.meta.base.Types.EnumDefnThemeDividerKind;
import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnLayoutFormContent extends DefnLayoutForm
{
  @Nullable
  public MetaIdLayoutForm[] allowToSwitchLayoutIdSet;

  @Nullable
  public DefnDtoColor backgroundColor;

  @Nullable
  public DefnDtoColor backgroundColorVar;

  @Nullable
  public DefnDtoColor borderColor;

  @Nullable
  public DefnDtoColor borderColorVar;

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
  public DefnDtoLayoutFormContentItem end;

  @Nullable
  public DefnDtoLayoutFormContentItem flexCenter;

  @Nullable
  public EnumDefnShowBorderKind[] paddingPositionSet;

  @Nullable
  public EnumDefnThemeDividerKind paddingSize;

  @Nullable
  public EnumDefnRenderingKind renderingMode;

  @Nullable
  public DefnDtoLayoutFormContentItem start;
}
