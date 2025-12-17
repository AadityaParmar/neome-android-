// neome.ai API - do not change
//

package com.neome.api.ent.main.sig;

import com.neome.api.home.main.sig.SigSpreadsheetRowCommentCount;
import com.neome.api.meta.base.Types.RowId;
import com.neome.api.meta.base.dto.EnvValidationError;
import com.neome.api.nucleus.base.sig.Sig;

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
