// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnCaptureValueKind;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldSignature extends DefnFieldEditable
{
  @Nullable
  public Boolean captureLocation;

  @Nullable
  public Boolean captureTime;

  @Nullable
  public Boolean captureUser;

  @Nullable
  public EnumDefnCaptureValueKind[] showCapturedValuesOnAside;
}
