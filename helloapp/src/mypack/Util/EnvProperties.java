package mypack.Util;
import java.io.*;
import java.util.*;

class EnvProperties implements IEnvProperties{
	private static HashMap<String, String> theProperties = new HashMap<String, String>();
	

	private static EnvProperties env;

	public static EnvProperties getInstance(){
		if(env == null){
			env = new EnvProperties();
		}
		return env;
	}
	private EnvProperties(){
	    try{
		String s = this.getClass().getClassLoader().getResource("").getPath();
		s = s.replaceAll("classes/", "env.properties");
		System.out.println("ths new class path is " + s);
		File file = new File(s);
		
		//Read the file and parse setting to hashmap
		FileReader reader = new FileReader(s);
		BufferedReader bfreader = new BufferedReader(reader);
		//char[] cbuf = new char[1024];
		String tempStr = null;
		while((tempStr = bfreader.readLine()) != null){
			//if(cbuf[0] != '#'){
			//	String set = new String(cbuf);
			//	System.out.println("-----set---   " + set);
			//	String[] result = set.split("=");
			//	System.out.println("Key is " + result[0]);
			//	System.out.println("Value is " + result[1]);
			//	if(result[0] != null && result[1] != null){
			//		theProperties.put(result[0], result[1]);
			//	}
			//}
			System.out.println("string is " + tempStr);
			if(!tempStr.startsWith("#")){
				System.out.println(" line = " + tempStr);
				String[] result = tempStr.split("=");
				System.out.println("Key is " + result[0]);
				System.out.println("Value is " + result[1]);
				if(result[0] != null && result[1] != null){
					theProperties.put(result[0], result[1]);
				}
			}
			System.out.println("done");
		}
	    }
	    catch(Exception ex){
		System.out.println(ex);
		System.out.println("error found");	
	    }
	}

	public static void main(String[] args){
		EnvProperties.getInstance();
		//System.out.println("i am done");
	}

	public String getValue(String key){
		return theProperties.get(key);
	}

        public void setValue(String key, String value){
		theProperties.put(key,value);
	}

}
