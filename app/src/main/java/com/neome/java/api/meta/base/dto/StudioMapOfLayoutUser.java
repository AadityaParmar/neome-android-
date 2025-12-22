// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdLayoutUser;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

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
