// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.DtoLogTreeKeyValueType;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoLogTreeKeyValue extends DtoLogTreeItem
{
  @Nullable
  public DtoLogTreeKeyValue[] children;

  @Nullable
  public String keyColor;

  public String keyText;

  @Nullable
  public Boolean keyTooltip;

  @Nullable
  public Long keyWidth;

  @Nullable
  public String value;

  @Nullable
  public String valueColor;

  @Nullable
  public Boolean valueTooltip;

  @Nullable
  public DtoLogTreeKeyValueType valueType;
}
