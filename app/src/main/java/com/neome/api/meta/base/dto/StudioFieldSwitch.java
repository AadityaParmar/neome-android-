// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind;
import com.neome.api.meta.base.Types.EnumDefnPlacement;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldSwitch extends StudioFieldEditable
{
  @Nullable
  public Boolean captureLocation;

  @Nullable
  public Boolean captureTime;

  @Nullable
  public Boolean captureUser;

  @Nullable
  public StudioValueVarIdText checkboxLabelVarId;

  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public Boolean defaultValue;

  @Nullable
  public MetaIdVar defaultVarId;

  @Nullable
  public EnumDefnPlacement labelPlacement;

  @Nullable
  public MetaIdVar labelPlacementVarId;

  @Nullable
  public EnumDefnPlacement position;

  @Nullable
  public MetaIdVar positionVarId;

  @Nullable
  public Boolean showAsCheckbox;

  @Nullable
  public MetaIdField showAsCheckboxFieldId;

  @Nullable
  public MetaIdVar showAsCheckboxVarId;

  @Nullable
  public EnumDefnCaptureValueKind[] showCapturedValuesOnAside;
}
