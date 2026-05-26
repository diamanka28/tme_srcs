package Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Deploy {

	public static void main(String[] args) throws Exception {
        
		Toto t = new Toto();
		t = deploy(Toto.class);
		t.f();
    }
	
	
	public static <T> T deploy(Class<T> cl) throws InstantiationException, IllegalAccessException, 
												   IllegalArgumentException, InvocationTargetException, 
												   NoSuchMethodException, SecurityException
	{
		T res = cl.getConstructor().newInstance();
		
		for(Method m : cl.getMethods()) {
			ExecuteOnBuilding v  = m.getAnnotation(ExecuteOnBuilding.class);
			if(v != null) {
				int nbtime = v.v();
				for(int i=0; i<nbtime; i++) {
					m.invoke(res);
				}
			}
		}
		return res;
	}
}