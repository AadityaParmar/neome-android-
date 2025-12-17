// neome.ai API - do not change
//

package com.neome.api.core.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

import com.neome.api.meta.base.Types.GeoPoint;

@SuppressWarnings("unused")
public class DtoGeoPoint
{
  @Nullable
  public Double accuracy;

  public Date dateTime;

  public GeoPoint geoPoint;
}
