// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumLogTableAlignment;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoLogTableCellHeader extends DtoLogTableCell
{
  @Nullable
  public Long flexWeight;

  @Nullable
  public EnumLogTableAlignment headerAlignment;

  @Nullable
  public EnumLogTableAlignment rowAlignment;
}
