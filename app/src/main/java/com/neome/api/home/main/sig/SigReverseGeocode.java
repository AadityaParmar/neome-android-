// neome.ai API - do not change
//

package com.neome.api.home.main.sig;

import com.neome.api.meta.base.Types.GeoPoint;
import com.neome.api.meta.base.dto.FieldDtoLocation;
import com.neome.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigReverseGeocode extends Sig
{
  public Map<GeoPoint, FieldDtoLocation> map;
}
