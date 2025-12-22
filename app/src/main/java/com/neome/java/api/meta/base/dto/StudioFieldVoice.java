// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnCaptureValueKind;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldVoice extends StudioFieldEditable
{
  @Nullable
  public Boolean captureLocation;

  @Nullable
  public Boolean captureTime;

  @Nullable
  public Boolean captureUser;

  @Nullable
  public Long maxSize;

  @Nullable
  public MetaIdField maxSizeFieldId;

  @Nullable
  public MetaIdVar maxSizeVarId;

  @Nullable
  public EnumDefnCaptureValueKind[] showCapturedValuesOnAside;
}
