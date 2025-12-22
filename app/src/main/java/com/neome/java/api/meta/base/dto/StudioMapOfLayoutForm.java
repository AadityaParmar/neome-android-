// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfLayoutForm extends StudioBase
{
  @Nullable
  public MetaIdLayoutForm asideDefaultLayoutId;

  public MetaIdLayoutForm[] keys;

  public Map<MetaIdLayoutForm, StudioDtoLayoutForm> map;

  @Nullable
  public MetaIdLayoutForm mobileDefaultLayoutId;
}
