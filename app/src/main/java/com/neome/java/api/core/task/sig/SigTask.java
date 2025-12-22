// neome.ai API - do not change
//

package com.neome.java.api.core.task.sig;

import com.neome.java.api.core.base.Types.EnumTaskStatus;
import com.neome.java.api.meta.base.dto.EnvValidationError;
import com.neome.java.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigTask extends Sig
{
  @Nullable
  public EnvValidationError error;

  @Nullable
  public Long progress;

  @Nullable
  public Object result;

  public EnumTaskStatus status;
}
