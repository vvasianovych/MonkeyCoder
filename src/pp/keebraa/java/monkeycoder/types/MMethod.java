package pp.keebraa.java.monkeycoder.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pp.keebraa.java.monkeycoder.types.def.DefTypes;

public class MMethod implements MCode
{
   private MType clazz;
   
   private String name;
   
   private MType returnedType;
   
   private MModificator modificator;
   
   private boolean isStatic;
   
   private List<MTypeValue> arguments;
   
   private List<MAnnotation> annotations;

   private String code;
   
   public MMethod(MType clazz, String name)
   {
	super();
	this.clazz = clazz;
	this.name = name;
	this.modificator = MModificator.PUBLIC;
	this.returnedType = DefTypes.VOID;
	this.isStatic = false;
	this.code = "";
	this.arguments = new ArrayList<MTypeValue>();
	this.annotations = new ArrayList<MAnnotation>();
   }

   public List<MAnnotation> getAnnotations()
   {
      return annotations;
   }

   public void setAnnotations(List<MAnnotation> annotations)
   {
      this.annotations = annotations;
   }
   
   public void addAnnotation(MAnnotation annotation)
   {
	annotations.add(annotation);
   }

   public MType getClazz()
   {
      return clazz;
   }

   public void setClazz(MType clazz)
   {
      this.clazz = clazz;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public MType getReturnedType()
   {
      return returnedType;
   }

   public void setReturnedType(MType returnedType)
   {
      this.returnedType = returnedType;
   }

   public MModificator getModificator()
   {
      return modificator;
   }

   public void setModificator(MModificator modificator)
   {
      this.modificator = modificator;
   }

   public boolean isStatic()
   {
      return isStatic;
   }

   public void setStatic(boolean isStatic)
   {
      this.isStatic = isStatic;
   }

   public List<MTypeValue> getArguments()
   {
      return arguments;
   }

   public void setArguments(List<MTypeValue> arguments)
   {
      this.arguments = arguments;
   }
   
   public void addArgument(MTypeValue argument)
   {
	arguments.add(argument);
   }
   
   public String getCode()
   {
      return code;
   }

   public void setCode(String code)
   {
      this.code = code;
   }

   @Override
   public int hashCode()
   {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((arguments == null) ? 0 : arguments.hashCode());
	result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
	result = prime * result + (isStatic ? 1231 : 1237);
	result = prime * result + ((modificator == null) ? 0 : modificator.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((returnedType == null) ? 0 : returnedType.hashCode());
	return result;
   }

   @Override
   public void generateCode(StringBuilder codeBuilder)
   {
	MethodCodeGenerator generator = new MethodCodeGenerator(this, codeBuilder);
	generator.buildCode();
   }
   
   @Override
   public Set<MType> getUsedTypes()
   {
	Set<MType> types = new HashSet<MType>();
	types.add(returnedType);
	for(MTypeValue arg : arguments)
	{
	   types.add(arg.getType());
	}
      return types;
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
	MMethod other = (MMethod) obj;
	if (arguments == null)
	{
	   if (other.arguments != null)
		return false;
	}
	else if (!arguments.equals(other.arguments))
	   return false;
	if (clazz == null)
	{
	   if (other.clazz != null)
		return false;
	}
	else if (!clazz.equals(other.clazz))
	   return false;
	if (isStatic != other.isStatic)
	   return false;
	if (modificator != other.modificator)
	   return false;
	if (name == null)
	{
	   if (other.name != null)
		return false;
	}
	else if (!name.equals(other.name))
	   return false;
	if (returnedType == null)
	{
	   if (other.returnedType != null)
		return false;
	}
	else if (!returnedType.equals(other.returnedType))
	   return false;
	return true;
   }
}
