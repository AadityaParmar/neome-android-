// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldCamera extends DefnFieldImage
{
  @Nullable
  public Boolean allowPickImage;

  @Nullable
  public Boolean captureLocation;

  @Nullable
  public Boolean captureTime;

  @Nullable
  public Boolean captureUser;

  @Nullable
  public MetaIdRole[] pickImageRoleSet;

  @Nullable
  public EnumDefnCaptureValueKind[] showCapturedValuesOnAside;
}
