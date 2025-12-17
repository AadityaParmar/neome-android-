// neome.ai API - do not change
//

package com.neome.api.core.task.sig;

import com.neome.api.core.base.Types.EnumTaskStatus;
import com.neome.api.meta.base.dto.EnvValidationError;
import com.neome.api.nucleus.base.sig.Sig;

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
