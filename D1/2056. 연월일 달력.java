import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		int input[] = new int[testcase];
		int month, day;
		String result[] = new String[testcase];
		for(int i=0; i<testcase; i++) {
			result[i] = "0";
			input[i] = s.nextInt();
			month = (input[i]%10000)/100;
			if(month<1 || month>12)
				result[i] = "-1";
			day = (input[i]%10000)%100;
			switch(month) {	
				case 1:
					if(day<1 || day>31)
						result[i] = "-1";
						break;
				case 2:
					if(day<1 || day>28)
						result[i] = "-1";
						break;
				case 3:
					if(day<1 || day>31)
						result[i] = "-1";
						break;
				case 4:
					if(day<1 || day>30)
						result[i] = "-1";
						break;
				case 5:
					if(day<1 || day>31)
						result[i] = "-1";
						break;
				case 6:
					if(day<1 || day>30)
						result[i] = "-1";
						break;
				case 7:
					if(day<1 || day>31)
						result[i] = "-1";
						break;
				case 8:
					if(day<1 || day>31)
						result[i] = "-1";
						break;
				case 9:
					if(day<1 || day>30)
						result[i] = "-1";
						break;
				case 10:
					if(day<1 || day>31)
						result[i] = "-1";
						break;
				case 11:
					if(day<1 || day>30)
						result[i] = "-1";
						break;
				case 12:
					if(day<1 || day>31)
						result[i] = "-1";
						break;
				default:
					break;
			}
			if(result[i].contentEquals("-1")) {
				result[i] =  "#"+(i+1)+" "+"-1";
				continue;
			}
			else {
				int y = input[i]/10000;
				int m = (input[i]-(y*10000))/100;
				int d = (input[i]-(y*10000)-(m*100));
				String sy="", sm="", sd="";
				if(y<1000) {
					if(y<100) {
						if(y<10) {
							sy = "000"+Integer.toString(y);
						}
						sy = "00"+Integer.toString(y);
					}
					sy = "0"+Integer.toString(y);
				}
				else {
					sy = Integer.toString(y);
				}
				if(m<10) {
					sm = "0"+Integer.toString(m);
				}
				else {
					sm = Integer.toString(m);
				}
				if(d<10) {
					sd = "0"+Integer.toString(d);
				}
				else {
					sd = Integer.toString(d);
				}
				result[i] =  "#"+(i+1)+" "+sy+"/"+sm+"/"+sd;
			}
		}
		for(int k=0; k<testcase; k++) {
			System.out.println(result[k]);
		}
	}
}