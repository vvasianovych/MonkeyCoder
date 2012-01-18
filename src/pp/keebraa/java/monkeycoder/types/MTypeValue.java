package pp.keebraa.java.monkeycoder.types;

public class MTypeValue
{
   private MType type;
   private String value;

   public MTypeValue(MType type, String value)
   {
	super();
	this.type = type;
	setValue(value);
   }
   public MType getType()
   {
      return type;
   }
   public void setType(MType type)
   {
      this.type = type;
   }
   public String getValue()
   {
      return value;
   }
   public void setValue(String value)
   {
      this.value = value;
   }
   @Override
   public int hashCode()
   {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	result = prime * result + ((value == null) ? 0 : value.hashCode());
	return result;
   }
   @Override
   public boolean equals(Object obj)
   {
	if (this == obj)
	   return true;
	if (obj == null)
	   return false;
	if (getClass() != obj.getClass())
	   return false;
	MTypeValue other = (MTypeValue) obj;
	if (type == null)
	{
	   if (other.type != null)
		return false;
	}
	else if (!type.equals(other.type))
	   return false;
	if (value == null)
	{
	   if (other.value != null)
		return false;
	}
	else if (!value.equals(other.value))
	   return false;
	return true;
   }
}
