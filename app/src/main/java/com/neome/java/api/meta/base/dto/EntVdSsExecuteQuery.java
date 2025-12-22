// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdSsExecuteQuery extends EntVdAutoStepWithOutput
{
  @Nullable
  public StudioValueCodeNeoQL neoQL;

  @Nullable
  public FormRefKey outputForm;

  @Nullable
  public MetaIdSpreadsheet[] spreadsheetIdSet;
}
