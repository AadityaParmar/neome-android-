// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.meta.base.Types.GeoPoint;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class FieldDtoLocation
{
  @Nullable
  public String address;

  @Nullable
  public String city;

  @Nullable
  public String country;

  @Nullable
  public Date dateTime;

  @Nullable
  public EntUserId entUserId;

  public GeoPoint geoPoint;
}
