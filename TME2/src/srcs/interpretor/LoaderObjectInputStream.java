package srcs.interpretor;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class LoaderObjectInputStream extends ObjectInputStream{
	private final ClassLoader classLoader;
	
	public LoaderObjectInputStream(InputStream in, ClassLoader classe) throws IOException {
		super(in);
		this.classLoader = classe;
	}
	
	@Override
	protected Class<?> resolveClass(final ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException{
		String className = objectStreamClass.getName();
		
		try {
			return Class.forName(className, false, classLoader);
		} catch (ClassNotFoundException e) {
			
			return super.resolveClass(objectStreamClass);
		}
	}
}
