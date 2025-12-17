// neome.ai API - do not change
//

package com.neome.api.nucleus.base.dto;

import com.neome.api.meta.base.dto.EnvValidationError;
import com.neome.api.nucleus.base.Types.EnumEnvErrorCode;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EnvError
{
  @Nullable
  public EnumEnvErrorCode errorCode;

  @Nullable
  public String errorMessage;

  @Nullable
  public String[] errorParams;

  @Nullable
  public EnvValidationError[] validationErrors;
}
