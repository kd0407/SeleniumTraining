package Demo;

import java.util.List;

public class DataReader {

	public static void main(String[] args) {
		
		//readCSV();
		readXLS();
	}
	public static void readCSV() {
		String filename="D:\\MBNG\\automation_framework\\Checkout.csv";
		List <String[]> records=utilities.CSV.get(filename);
		for(String[] record:records) {
			for (String field:record) {
				System.out.println(field);
			}
			
		}
	}

	public static void readXLS(){
		String filename="D:\\MBNG\\automation_framework\\Checkout.xls";
		String[][] dataFile=utilities.Excel.get(filename);
		for(String[] record:dataFile) {
			System.out.println(record[0]);
			System.out.println(record[1]);
			System.out.println(record[2]);

		}
	}
}
