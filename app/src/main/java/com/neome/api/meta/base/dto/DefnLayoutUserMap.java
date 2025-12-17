// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdLayoutUser;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnLayoutUserMap
{
  public MetaIdLayoutUser[] keys;

  public Map<MetaIdLayoutUser, DefnLayoutUser> map;

  @Nullable
  public MetaIdLayoutUser mobileDefaultLayoutId;

  @Nullable
  public MetaIdLayoutUser webDefaultLayoutId;
}
