// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDeviceType;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldChipSetDeviceType extends DefnFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public EnumDeviceType[] defaultValue;

  @Nullable
  public EnumDeviceType defaultVar;
}
