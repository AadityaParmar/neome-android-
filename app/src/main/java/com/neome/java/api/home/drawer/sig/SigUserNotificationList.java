// neome.ai API - do not change
//

package com.neome.java.api.home.drawer.sig;

import com.neome.java.api.home.base.dto.DtoUserNotification;
import com.neome.java.api.nucleus.base.sig.SigVersion;

@SuppressWarnings("unused")
public class SigUserNotificationList extends SigVersion
{
  public DtoUserNotification[] notificationList;
}
