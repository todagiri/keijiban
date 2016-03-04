package executer;

import java.util.ArrayList;
import bean.Bean;
import dba.DBAccessor;

import java.sql.ResultSet;

public abstract class Executer{
	DBAccessor accessor = new DBAccessor();
	
	public abstract Object execute(Object object);
}