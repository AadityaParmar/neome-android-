// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SpreadsheetFilterComposite
{
  @Nullable
  public Boolean andOr;

  @Nullable
  public SpreadsheetFilterValue filter;

  @Nullable
  public SpreadsheetFilterComposite[] filterList;
}
