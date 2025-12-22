// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Types.RowId;
import com.neome.java.api.meta.base.dto.EnvValidationError;

import java.util.Map;

@SuppressWarnings("unused")
public class DtoBulkOperationResult
{
  public Map<RowId, EnvValidationError> errorMap;
}
