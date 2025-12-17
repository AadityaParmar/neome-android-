// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioDtoLayoutForm;

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
