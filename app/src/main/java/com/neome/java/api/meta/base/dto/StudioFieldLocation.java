// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnCaptureMode;
import com.neome.java.api.meta.base.Types.EnumDefnCaptureValueKind;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldLocation extends StudioFieldEditable
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
  public MetaIdVar defaultVarId;

  @Nullable
  public EnumDefnCaptureValueKind[] showCapturedValuesOnAside;
}
