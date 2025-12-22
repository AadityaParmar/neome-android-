// neome.ai API - do not change
//

package com.neome.java.api.core.base.dto;

import com.neome.java.api.meta.base.Types.GeoPoint;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class DtoGeoPoint
{
  @Nullable
  public Double accuracy;

  public Date dateTime;

  public GeoPoint geoPoint;
}
