// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdSsRemoveRows extends EntVdAutoStep
{
  @Nullable
  public StudioMapOfCondition filterCondition;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
