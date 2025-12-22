// neome.ai API - do not change
//

package com.neome.java.api.core.user.msg;

import com.neome.java.api.core.base.dto.DtoGeoPoint;
import com.neome.java.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgCallerLocationPut extends Msg
{
  public DtoGeoPoint[] geoPoints;
}
