package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Connection;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {

	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException{
		
		if((currentReading<previousReading) || (currentReading<0 && previousReading<0))
			throw new InvalidReadingException();
		if(!type.equals("Domestic")&& !type.equals("Commercial"))
			throw new InvalidConnectionException();
		return true;
	}
	
	public float calculateBillAmt(int currentReading, int previousReading, String type)
	{
		try
	    {
	      validate(currentReading,previousReading,type);
	    }
	    catch(InvalidReadingException r)
	    {
	      
	      return -1;
	    }
	    catch(InvalidConnectionException c)
	    {
	      
	      return -2;
	    }
		  Connection con;
		    if(type.equals("Domestic"))
		    {
		      float[] f= {(float) 2.3,(float) 4.2,(float) 5.5}; 
		      con=new Domestic(previousReading,currentReading,f);
		
		      return con.computeBill();
		    }
		    else
		    {
		      float[] f= {(float)5.2,(float)6.8,(float)8.3};
		      con=new Commercial(previousReading,currentReading,f);
		      float f1=con.computeBill();
		     
		     float e=0.0f;
		      if(f1>=10000)
		      {
		    	  e=(float) ((float)f1*0.09);
		    	  f1=e+f1;
		      }
		      else if(f1>=5000)
		      {
		    	  e=(float) ((float)f1*0.06);
		    	  f1=e+f1;
		      }
		      else if(f1<5000)
		      {
		    	  e=(float) ((float)f1*0.02);
		    	  f1=e+f1;
		      }
		      
		      return f1;
		    }
		  }
	public String generateBill(int currentReading,int previousReading,String type)
	  {
	    if(calculateBillAmt(currentReading,previousReading,type)==-1)
	    {
	      InvalidReadingException r=new InvalidReadingException();
	      return r.toString();
	    }
	    else if(calculateBillAmt(currentReading,previousReading,type)==-2)
	    {
	      
	      InvalidConnectionException c=new InvalidConnectionException();
	      return c.toString();
	    }
	    else
	    {
	      return "Amount to be paid "+Float.toString(calculateBillAmt(currentReading,previousReading,type));
	    }
	    
	  }
	}

