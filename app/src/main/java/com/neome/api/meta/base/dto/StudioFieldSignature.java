// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldSignature extends StudioFieldEditable
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
