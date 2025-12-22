// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnCaptureMode;
import com.neome.java.api.meta.base.Types.EnumDefnCaptureValueKind;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldLocation extends DefnFieldEditable
{
  @Nullable
  public EnumDefnCaptureMode captureMode;

  @Nullable
  public Boolean captureTime;

  @Nullable
  public Boolean captureUser;

  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public FieldDtoLocation defaultValue;

  @Nullable
  public FieldDtoLocation defaultVar;

  @Nullable
  public EnumDefnCaptureValueKind[] showCapturedValuesOnAside;

  @Nullable
  public Boolean showProgressBar;
}
