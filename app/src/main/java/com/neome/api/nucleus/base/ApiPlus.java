// neome.ai API - do not change
//

package com.neome.api.nucleus.base;

import com.neome.api.meta.base.SysId;
import com.neome.api.meta.base.Types.DeviceId;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.meta.base.Types.EnumMediaType;
import com.neome.api.meta.base.Types.GroupId;
import com.neome.api.meta.base.Types.MediaIdAudio;
import com.neome.api.meta.base.Types.MediaIdAvatar;
import com.neome.api.meta.base.Types.MediaIdDocument;
import com.neome.api.meta.base.Types.MediaIdImage;
import com.neome.api.meta.base.Types.MediaIdSticker;
import com.neome.api.meta.base.Types.MediaIdThumbnail;
import com.neome.api.meta.base.Types.MediaIdVideo;
import com.neome.api.meta.base.Types.MessageId;
import com.neome.api.meta.base.Types.MetaIdFieldDynamicCondition;
import com.neome.api.meta.base.Types.MetaIdFieldDynamicRule;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.RequestId;
import com.neome.api.meta.base.Types.RowId;
import com.neome.api.meta.base.Types.ServiceName;
import com.neome.api.meta.base.Types.TabId;
import com.neome.api.meta.base.Types.UserId;
import com.neome.api.nucleus.base.Types.AnyOtpValue;
import com.neome.api.nucleus.base.Types.AnyPrefixKey;
import com.neome.api.nucleus.base.Types.AppVersion;

public class ApiPlus
{
  public static final EntId ENT_ID_GLOBAL = SysId.create(SysId.GLOBAL);

  public static DeviceId nextDeviceId()
  {
    return SysId.nextId(DeviceId.class);
  }

  public static RequestId nextRequestId()
  {
    return SysId.nextId(RequestId.class);
  }

  public static RowId nextRowId()
  {
    return SysId.nextId(RowId.class);
  }

  public static UserId nextUserId()
  {
    return SysId.nextId(UserId.class);
  }

  public static EntUserId nextEntUserId()
  {
    return SysId.nextId(EntUserId.class);
  }

  public static TabId nextTabId()
  {
    return SysId.nextId(TabId.class);
  }

  public static EntId nextEntId()
  {
    return SysId.nextId(EntId.class);
  }

  public static MediaIdAudio nextMediaIdAudio()
  {
    return SysId.nextId(MediaIdAudio.class);
  }

  public static MediaIdDocument nextMediaIdDocument()
  {
    return SysId.nextId(MediaIdDocument.class);
  }

  public static MediaIdAvatar nextMediaIdAvatar()
  {
    return SysId.nextId(MediaIdAvatar.class);
  }

  public static MediaIdImage nextMediaIdImage()
  {
    return SysId.nextId(MediaIdImage.class);
  }

  public static MediaIdThumbnail nextMediaIdThumbnail()
  {
    return SysId.nextId(MediaIdThumbnail.class);
  }

  public static MediaIdVideo nextMediaIdVideo()
  {
    return SysId.nextId(MediaIdVideo.class);
  }

  public static MediaIdSticker nextMediaIdSticker()
  {
    return SysId.nextId(MediaIdSticker.class);
  }

  public static GroupId nextGroupId()
  {
    return SysId.nextId(GroupId.class);
  }

  public static MessageId nextMessageId()
  {
    return SysId.nextId(MessageId.class);
  }

  public static MetaIdRole nextMetaIdRole()
  {
    return SysId.nextId(MetaIdRole.class);
  }

  public static MetaIdFieldDynamicCondition nextMetaIdFieldDynamicCondition()
  {
    return SysId.nextId(MetaIdFieldDynamicCondition.class);
  }

  public static MetaIdFieldDynamicRule nextMetaIdFieldDynamicRule()
  {
    return SysId.nextId(MetaIdFieldDynamicRule.class);
  }

  public static ServiceName toServiceName(String serviceName)
  {
    return ServiceName.valueOf(serviceName);
  }

  public static EnumMediaType toMediaType(String mediaType)
  {
    return EnumMediaType.valueOf(mediaType);
  }

  public static AnyOtpValue createOtp(String name)
  {
    AnyOtpValue otp = new AnyOtpValue();
    otp.value = name;
    return otp;
  }

  public static AppVersion createAppVersion(String value)
  {
    AppVersion otp = new AppVersion();
    otp.value = value;
    return otp;
  }

  public static AnyPrefixKey createPrefixString(String value)
  {
    AnyPrefixKey prefixString = new AnyPrefixKey();
    prefixString.key = value;
    return prefixString;
  }
}
