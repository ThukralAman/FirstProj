package dp;
//http://www.spoj.com/problems/ACODE/
public class Acode {
	
	public void printAllDecoding(String code) {
		printAllDecoding(code, code.length(), "");
	}
	
	public void printAllDecoding(String code, int len, String res) {
		if(len==0) {
			System.out.println(res);
		}else{
			String res1 = res;
			String start1 = code.substring(0,1),
					end1 = code.substring(1);
			res1 = res1 + (char)(Integer.parseInt(start1) + 64);
			printAllDecoding(end1, len-1, res1);
			
			
			if(code.length()>=2) {
				String res2 = res;
				String start2 = code.substring(0,2),
						end2 = code.substring(2);
				if(Integer.parseInt(start2)<=26) {
					res2 = res2 + (char)(Integer.parseInt(start2) + 64);
					printAllDecoding(end2, len-2, res2);
				}
			}
			
			
			
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Acode obj = new Acode();
		obj.printAllDecoding("25114");
	}

}
