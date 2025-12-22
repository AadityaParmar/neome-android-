// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnCaptureValueKind;
import com.neome.java.api.meta.base.Types.EnumDefnPlacement;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldSwitch extends DefnFieldEditable
{
  @Nullable
  public Boolean captureLocation;

  @Nullable
  public Boolean captureTime;

  @Nullable
  public Boolean captureUser;

  @Nullable
  public DefnDtoText checkboxLabelVar;

  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public Boolean defaultValue;

  @Nullable
  public Boolean defaultVar;

  @Nullable
  public EnumDefnPlacement labelPlacement;

  @Nullable
  public EnumDefnPlacement labelPlacementVar;

  @Nullable
  public EnumDefnPlacement position;

  @Nullable
  public EnumDefnPlacement positionVar;

  @Nullable
  public Boolean showAsCheckbox;

  @Nullable
  public MetaIdField showAsCheckboxFieldId;

  @Nullable
  public Boolean showAsCheckboxVar;

  @Nullable
  public EnumDefnCaptureValueKind[] showCapturedValuesOnAside;
}
