// neome.ai API - do not change
//

package com.neome.java.api.core.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoCloneConfig
{
  @Nullable
  public Boolean cloneAdmin;

  @Nullable
  public Boolean cloneEntUser;

  @Nullable
  public MetaIdSpreadsheet[] cloneSpreadsheetIdSet;
}
