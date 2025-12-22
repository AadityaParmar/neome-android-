// neome.ai API - do not change
//

package com.neome.java.api.ent.main.sig;

import com.neome.java.api.home.main.sig.SigSpreadsheetRowCommentCount;
import com.neome.java.api.meta.base.Types.RowId;
import com.neome.java.api.meta.base.dto.EnvValidationError;
import com.neome.java.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class SigSpreadsheetBulkRowCommentCount extends Sig
{
  @Nullable
  public Map<RowId, EnvValidationError> errorMap;

  @Nullable
  public Map<RowId, SigSpreadsheetRowCommentCount> rowCommentCountMap;
}
