// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumLogTableTextStyle;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoLogTable extends DtoLogItem
{
  @Nullable
  public DtoLogTableCellHeader[] header;

  public String headerBgColor;

  public String headerColor;

  public EnumLogTableTextStyle headerStyle;

  @Nullable
  public String label;

  public String rowBgColor;

  public String rowColor;

  public EnumLogTableTextStyle rowStyle;

  @Nullable
  public DtoLogTableRow[] rows;

  @Nullable
  public Long showRows;
}
