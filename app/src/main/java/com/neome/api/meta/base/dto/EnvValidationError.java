// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumEnvValidationError;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EnvValidationError
{
  @Nullable
  public EnvValidationError[] children;

  @Nullable
  public EnumEnvValidationError errorCode;

  @Nullable
  public String errorMessage;

  @Nullable
  public String[] errorParams;

  @Nullable
  public String paramName;

  @Nullable
  public String[] paramNameSet;
}
