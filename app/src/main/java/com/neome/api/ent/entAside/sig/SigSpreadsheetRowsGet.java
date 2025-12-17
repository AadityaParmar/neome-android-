// neome.ai API - do not change
//

package com.neome.api.ent.entAside.sig;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.RowId;
import com.neome.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class SigSpreadsheetRowsGet extends Sig
{
  @Nullable
  public Map<String, Set<RowId>> dateRowIdSetMap;

  @Nullable
  public Map<String, Set<RowId>> groupByRowIdSetMap;

  public MetaIdForm outputFormId;

  @Nullable
  public RowId[] rowIdSet;
}
