// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdLayoutUser;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioDtoLayoutUser;

@SuppressWarnings("unused")
public class StudioMapOfLayoutUser extends StudioBase
{
  public MetaIdLayoutUser[] keys;

  public Map<MetaIdLayoutUser, StudioDtoLayoutUser> map;

  @Nullable
  public MetaIdLayoutUser mobileDefaultLayoutId;

  @Nullable
  public MetaIdLayoutUser webDefaultLayoutId;
}
