// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnLayoutFormMap
{
  @Nullable
  public MetaIdLayoutForm asideDefaultLayoutId;

  public MetaIdLayoutForm[] keys;

  public Map<MetaIdLayoutForm, DefnLayoutForm> map;

  @Nullable
  public MetaIdLayoutForm mobileDefaultLayoutId;
}
