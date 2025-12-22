// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.sig;

import com.neome.java.api.meta.base.Types.RowId;
import com.neome.java.api.meta.base.dto.EnvValidationError;
import com.neome.java.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigSpreadsheetRowRemove extends Sig
{
  public Map<RowId, EnvValidationError> errorMap;
}
