package constants;

public final class FrameworkConstant {
	
	private FrameworkConstant()
	{
		
	}
	
	
	private static final String PROPERTYFILEPATH="C:\\Users\\navze\\eclipse-workspace\\Corsearch\\src\\test\\resources\\propertiesfile\\config.properties";

	
	public static String getPropertyfilepath() {
		return PROPERTYFILEPATH;
	}

}
