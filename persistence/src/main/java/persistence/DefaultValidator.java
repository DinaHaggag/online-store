package persistence;

import java.lang.reflect.Field;

public class DefaultValidator implements Validator {

	@Override
	public boolean isValid(Object obj) {
		for(Field field :obj.getClass().getDeclaredFields()) {
			Validate annotation = field.getAnnotation(Validate.class);
			if(annotation != null) {
				field.setAccessible(true);
				Object fieldValue = null;
				
				try {
					fieldValue = field.get(obj);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(((String) fieldValue).matches(annotation.pattern())) {
					return true;
				}
			}
		}
		
		return false;
	}
		

}
