package testData;

public class DataRowCheck {

	public static int setDataRows () throws Exception
	{
		int currDataRow = 1;
		int prevDataRow = 0;
		int setDataRows = 0;
		String dataCheck = ExcelUtils.getCellData(1, 5);
		
		for (currDataRow = 1; currDataRow <=100; currDataRow++)
		{
			prevDataRow = currDataRow-1;
			dataCheck = ExcelUtils.getCellData(currDataRow, 5);
			
			if (dataCheck.matches(""))
			{
				//System.out.println("Data Check Ends at row "+prevDataRow);
				setDataRows = prevDataRow;
				break;
			}
			
			//System.out.println("Current Row = "+currDataRow);
			//System.out.println("Data on Current Row = "+dataCheck);
			//System.out.println("Moving to next row");
									
		}
		
		//System.out.println("Data Set has "+setDataRows+" Rows"); 
				
		return setDataRows;
	}
	
}
