// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnDeviceSize;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldChipSetDeviceSize extends DefnFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public EnumDefnDeviceSize[] defaultValue;

  @Nullable
  public EnumDefnDeviceSize defaultVar;

  @Nullable
  public EnumDefnDeviceSize[] filterKindSet;
}
