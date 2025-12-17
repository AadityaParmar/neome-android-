// neome.ai API - do not change
//

package com.neome.api.home.main.msg;

import com.neome.api.meta.base.Types.GeoPoint;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgReverseGeocode extends Msg
{
  public GeoPoint[] geoPoints;
}