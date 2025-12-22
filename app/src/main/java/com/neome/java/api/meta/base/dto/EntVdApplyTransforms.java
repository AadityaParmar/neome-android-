// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdVdAutoFunc;

import java.util.Map;

@SuppressWarnings("unused")
public class EntVdApplyTransforms extends EntVdAutoStep
{
  public MetaIdVdAutoFunc[] keys;

  public Map<MetaIdVdAutoFunc, AutoXform> map;
}
