// neome.ai API - do not change
//

package com.neome.api.ent.ent.sig;

import com.neome.api.meta.base.Types.RowId;
import com.neome.api.meta.base.dto.FormValueRaw;
import com.neome.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class SigEntSpreadsheetData extends Sig
{
  public Map<RowId, FormValueRaw> rowMap;

  @Nullable
  public String topGridVer;
}
