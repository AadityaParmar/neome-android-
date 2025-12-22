// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnUserSettingOptions;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioBuildUserSetting extends StudioBase
{
  @Nullable
  public Boolean doNotShowOnUserSettings;

  @Nullable
  public Boolean doNotShowValueToAdmin;

  @Nullable
  public MetaIdVar optionDataSourceVarId;

  public EnumDefnUserSettingOptions userSettingOptionKind;
}
