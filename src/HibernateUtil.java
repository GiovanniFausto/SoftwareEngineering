

import org.hibernate.*;

import org.hibernate.cfg.Configuration;
;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	static {
		try{
			Configuration cfg=new Configuration();  
			cfg.configure("hibernate.cfg.xml");
			cfg.setProperty("hibernate.temp.use_jdbc_metadata_defaults","false");
			factory = cfg.buildSessionFactory();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return factory;
	}
	
	public static void kill(){
		factory.close();
	}
}
