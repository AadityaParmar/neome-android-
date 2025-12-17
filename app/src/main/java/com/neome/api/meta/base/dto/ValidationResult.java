// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.SearchPath;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class ValidationResult
{
  @Nullable
  public Map<SearchPath, Long> errorCountMap;

  @Nullable
  public Map<SearchPath, EnvValidationError> errorMap;
}
