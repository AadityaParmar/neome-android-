// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnCaptureValueKind;
import com.neome.java.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldCamera extends StudioFieldImage
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
