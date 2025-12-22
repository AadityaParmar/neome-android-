// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnNodeTerminateKind;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdAutoStepWithOutputAndError extends EntVdAutoStepWithOutput
{
  @Nullable
  public EnumDefnNodeTerminateKind terminateKind;
}
