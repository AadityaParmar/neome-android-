// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioBuildArgBinderHolder;

@SuppressWarnings("unused")
public class StudioMapOfText extends StudioBase
{
  public String[] keys;

  public Map<String, StudioBuildArgBinderHolder> map;

  @Nullable
  public MetaIdForm sourceFormId;
}
