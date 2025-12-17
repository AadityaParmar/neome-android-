// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldScanCode extends DefnFieldEditable
{
  @Nullable
  public Boolean barCode;

  @Nullable
  public Boolean captureLocation;

  @Nullable
  public Boolean captureTime;

  @Nullable
  public Boolean captureUser;

  @Nullable
  public Boolean qrCode;

  @Nullable
  public EnumDefnCaptureValueKind[] showCapturedValuesOnAside;
}
