// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumFormContentPosition;
import com.neome.api.meta.base.Types.EnumLogTreeLineCollapse;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoLogTreeLine extends DtoLogTreeItem
{
  @Nullable
  public Boolean bold;

  @Nullable
  public DtoLogTreeKeyValue[] children;

  @Nullable
  public EnumLogTreeLineCollapse collapse;

  @Nullable
  public EnumFormContentPosition contentPosition;

  public String line;

  @Nullable
  public String lineColor;
}
