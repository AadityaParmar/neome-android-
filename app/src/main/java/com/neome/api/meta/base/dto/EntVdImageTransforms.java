// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdVdImageFunc;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class EntVdImageTransforms extends EntVdAutoStep
{
  @Nullable
  public StudioDtoArgValueParameter inputField;

  public MetaIdVdImageFunc[] keys;

  public Map<MetaIdVdImageFunc, ImageXform> map;

  @Nullable
  public StudioDtoArgValueParameter outputField;
}
