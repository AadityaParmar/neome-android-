// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoLogTree extends DtoLogItem
{
  public String bgColor;

  @Nullable
  public DtoLogTreeItem[] children;

  public String keyColor;

  public long keyWidth;

  public String lineColor;

  public long tabWidth;

  public String valueColor;
}
