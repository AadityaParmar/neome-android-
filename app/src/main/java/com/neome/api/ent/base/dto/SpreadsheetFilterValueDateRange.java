// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class SpreadsheetFilterValueDateRange extends SpreadsheetFilterValue
{
  @Nullable
  public Date from;

  @Nullable
  public Date to;
}
