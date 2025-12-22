// neome.ai API - do not change
//

package com.neome.java.api.meta.base;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({
  "unused",
  "ClassWithTooManyMethods"
})
public abstract class SysId implements Comparable<SysId>
{
  public static final String GLOBAL = "global"; // global ent Id

  public static final String SEP_PREFIX = "-";

  public static final String SEP_EXT = ".";

  private static final Map<String, SysId> systemIdMap = new HashMap<>();

  static
  {
    for(Types.EnumDefnRoles value : Types.EnumDefnRoles.values())
    {
      final SysId sysId = SysId.create(value.name(), Types.MetaIdRole.class);
      systemIdMap.put(value.name(), sysId);
    }

    for(Types.EnumDefnFields value : Types.EnumDefnFields.values())
    {
      final SysId sysId = SysId.create(value.name(), Types.MetaIdField.class);
      systemIdMap.put(value.name(), sysId);
    }

    for(Types.EnumDefnForms value : Types.EnumDefnForms.values())
    {
      final SysId sysId = SysId.create(value.name(), Types.MetaIdForm.class);
      systemIdMap.put(value.name(), sysId);
    }

    for(Types.EnumDefnPipelineSystem value : Types.EnumDefnPipelineSystem.values())
    {
      final SysId sysId = SysId.create(value.name(), Types.MetaIdPipelineSystem.class);
      systemIdMap.put(value.name(), sysId);
    }
  }

  private String id;

  public static <T extends SysId> T create(String id)
  {
    if(id == null)
    {
      return null;
    }

    if(GLOBAL.equals(id))
    {
      //noinspection unchecked,ClassReferencesSubclass
      return (T) create(id, Types.EntId.class);
    }

    final SysId systemSysId = systemIdMap.get(id);
    if(systemSysId != null)
    {
      return (T) systemSysId;
    }

    if(id == null || id.isEmpty())
    {
      throw new IllegalArgumentException("Invalid sys id: " + id + " - must not be empty");
    }
    if(id.contains(" ") || id.contains("\t") || id.contains("\n"))
    {
      throw new IllegalArgumentException(
        "Invalid sys id: " + id + " - must not contain whitespaces");
    }
    if(!id.contains(SEP_PREFIX))
    {
      throw new IllegalArgumentException("Invalid sys id: " + id + " - must contain separator");
    }
    if(!id.matches("^[a-zA-Z0-9._-]*$"))
    {
      throw new IllegalArgumentException(
        "Invalid sys id: " + id + " - contains invalid characters");
    }

    String prefix = id.split(SEP_PREFIX, 2)[0];
    if(prefix.isEmpty())
    {
      throw new IllegalArgumentException("Prefix must not be empty");
    }

    Class<? extends SysId> clsSysId = Types.getSysIdClass(prefix);
    if(clsSysId == null)
    {
      throw new IllegalArgumentException("Prefix not supported: " + prefix);
    }

    String newPrefix = Types.getSysIdPrefix(clsSysId);
    if(newPrefix != null && !prefix.equals(newPrefix))
    {
      id = id.replaceFirst(prefix, newPrefix);
    }

    //noinspection unchecked
    return (T) create(id, clsSysId);
  }

  public static SysId[] create(String[] ids)
  {
    if(ids == null)
    {
      return null;
    }

    SysId[] array = new SysId[ids.length];
    for(int i = 0; i < ids.length; i++)
    {
      array[i] = create(ids[i]);
    }
    return array;
  }

  public static <T extends SysId> T nextId(Class<T> clsSysId)
  {
    return nextId(clsSysId, null);
  }

  @SuppressWarnings("ClassReferencesSubclass")
  public static <T extends SysId> T nextId(Class<T> clsSysId, String ext)
  {
    String guid;
    if(clsSysId == Types.RequestId.class || clsSysId == Types.RowId.class)
    {
      guid = NanoId.newGuidBig();
    }
    else if(clsSysId != null && Types.MetaId.class.isAssignableFrom(clsSysId))
    {
      guid = NanoId.newMetaId();
    }
    else
    {
      guid = NanoId.newGuid();
    }

    return nextId(clsSysId, guid, ext);
  }

  public static <T extends SysId> T nextId(Class<T> clsSysId, String guid, String ext)
  {
    if(clsSysId == null)
    {
      throw new IllegalArgumentException("clsSysId must not be null");
    }
    if(guid == null)
    {
      throw new IllegalArgumentException("guid must not be null");
    }

    String prefix = Types.getSysIdPrefix(clsSysId);
    if(prefix == null)
    {
      throw new IllegalArgumentException("prefix must not be null");
    }

    String id = prefix + SEP_PREFIX + guid;
    if(ext != null)
    {
      id += SEP_EXT + ext;
    }
    //noinspection unchecked
    return (T) create(id, clsSysId);
  }

  public static String toString(SysId id)
  {
    return id == null
      ? null
      : id.getId();
  }

  private static SysId create(String id, Class<? extends SysId> clsSysId)
  {
    if(clsSysId == null)
    {
      throw new IllegalArgumentException("clsSysId must not be null");
    }

    if(id == null)
    {
      return null;
    }

    try
    {
      SysId sysId = clsSysId.getConstructor().newInstance();
      sysId.id = id;
      return sysId;
    }
    catch(Exception e)
    {
      throw new AssertionError(e);
    }
  }

  public static boolean isSystemId(SysId sysId)
  {
    return systemIdMap.containsKey(sysId.getId());
  }

  public boolean isSystem()
  {
    return systemIdMap.containsValue(this);
  }

  @Override
  public final int compareTo(SysId sysId)
  {
    return id.compareTo(sysId.getId());
  }

  @Override
  public final boolean equals(Object obj)
  {
    return obj instanceof SysId && id.equals(((SysId) obj).id);
  }

  @Override
  public final int hashCode()
  {
    return id.hashCode();
  }

  @Override
  public final String toString()
  {
    return id;
  }

  public final String getExt()
  {
    int index = id.indexOf(SEP_EXT);
    return index < 0
      ? null
      : id.substring(index + 1);
  }

  public final String getId()
  {
    return id;
  }

  public final String getIdWithoutPrefix()
  {
    if(isSystem())
    {
      return getId();
    }
    return getId().substring(getPrefix().length() + SEP_PREFIX.length());
  }

  public final String getPrefix()
  {
    return Types.getSysIdPrefix(getClass());
  }

  public final String getSuffix()
  {
    int index = id.indexOf(SEP_PREFIX);
    return id.substring(index + 1);
  }

  public final boolean is(Class<? extends SysId> sysIdClass)
  {
    return sysIdClass.isAssignableFrom(getClass());
  }
}
