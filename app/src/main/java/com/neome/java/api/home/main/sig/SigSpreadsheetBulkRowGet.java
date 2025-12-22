// neome.ai API - do not change
//

package com.neome.java.api.home.main.sig;

import com.neome.java.api.meta.base.Types.RowId;
import com.neome.java.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class SigSpreadsheetBulkRowGet extends Sig
{
  @Nullable
  public Set<RowId> expiredRowIdSet;

  @Nullable
  public Set<RowId> inProgressRowIdSet;

  @Nullable
  public Map<RowId, SigSpreadsheetRow> rowMap;
}
