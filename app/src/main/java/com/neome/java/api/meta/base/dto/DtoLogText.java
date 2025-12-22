// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumFormContentPosition;
import com.neome.java.api.meta.base.Types.EnumLogTextType;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoLogText extends DtoLogItem
{
  public String bgColor;

  @Nullable
  public Boolean bold;

  @Nullable
  public String caption;

  @Nullable
  public DtoLogItem child;

  @Nullable
  public EnumFormContentPosition contentPosition;

  @Nullable
  public Boolean executable;

  @Nullable
  public String iconEnd;

  @Nullable
  public String iconEndColor;

  @Nullable
  public String iconStart;

  @Nullable
  public String iconStartColor;

  @Nullable
  public Boolean showChildDivider;

  public String text;

  @Nullable
  public String textColor;

  @Nullable
  public EnumLogTextType textType;
}
