// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.meta.base.Types.RowId;
import com.neome.api.meta.base.dto.EnvValidationError;

import java.util.Map;

@SuppressWarnings("unused")
public class DtoBulkOperationResult
{
  public Map<RowId, EnvValidationError> errorMap;
}
