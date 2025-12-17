// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnNodeTerminateKind;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdAutoStepWithOutputAndError extends EntVdAutoStepWithOutput
{
  @Nullable
  public EnumDefnNodeTerminateKind terminateKind;
}
