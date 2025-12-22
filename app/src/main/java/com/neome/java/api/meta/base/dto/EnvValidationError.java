// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumEnvValidationError;

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
