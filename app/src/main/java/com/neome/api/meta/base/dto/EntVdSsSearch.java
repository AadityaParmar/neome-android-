// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdSsSearch extends EntVdAutoStepWithOutput
{
  @Nullable
  public Long maxResultCount;

  @Nullable
  public MetaIdSpreadsheet[] searchSpreadsheetIdSet;

  @Nullable
  public StudioBuildArgBinder searchText;
}
