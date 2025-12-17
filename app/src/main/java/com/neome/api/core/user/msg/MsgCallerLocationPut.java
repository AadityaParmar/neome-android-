// neome.ai API - do not change
//

package com.neome.api.core.user.msg;

import com.neome.api.core.base.dto.DtoGeoPoint;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgCallerLocationPut extends Msg
{
  public DtoGeoPoint[] geoPoints;
}