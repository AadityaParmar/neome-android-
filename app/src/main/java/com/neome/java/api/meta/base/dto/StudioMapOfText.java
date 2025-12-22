// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdForm;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfText extends StudioBase
{
  public String[] keys;

  public Map<String, StudioBuildArgBinderHolder> map;

  @Nullable
  public MetaIdForm sourceFormId;
}
