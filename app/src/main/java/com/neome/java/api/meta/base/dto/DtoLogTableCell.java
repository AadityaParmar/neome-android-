// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumLogTableTextStyle;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoLogTableCell
{
  @Nullable
  public String bgColor;

  @Nullable
  public String color;

  @Nullable
  public EnumLogTableTextStyle style;

  public String text;
}
