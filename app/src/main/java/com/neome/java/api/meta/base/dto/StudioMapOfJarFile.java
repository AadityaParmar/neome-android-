// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MediaIdJar;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfJarFile extends StudioBase
{
  public MediaIdJar[] keys;

  public Map<MediaIdJar, StudioDtoJarFile> map;
}
