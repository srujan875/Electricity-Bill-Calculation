package com.wipro.eb.entity;

public class Domestic extends Connection{

	public Domestic(int previousReading, int currentReading,float slabs[])
	{
	super(previousReading, currentReading, slabs);
	this.currentReading=currentReading;
	this.previousReading=previousReading;
	this.slabs=slabs;
	}


		public float computeBill()
		{
			
			if(currentReading-previousReading<50)
			{
				return (currentReading-previousReading)*slabs[0];
			}
			else if(currentReading-previousReading<=100)
			{
				return (50*slabs[0])+((currentReading-previousReading-50)*slabs[1]);
			}
			else
			{
				return (50*slabs[0])+(50*slabs[1])+((currentReading-previousReading-100)*slabs[2]);
			}
			
		}
	}

