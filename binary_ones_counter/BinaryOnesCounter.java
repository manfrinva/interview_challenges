public class BinaryOnesCounter{

    public static void main(String args[]){
        int a = 10;
        int b = 25;
	int result = countOnesInBinaryNumber(a, b);
        System.out.println(result);
    }

    public static int countOnesInBinaryNumber(int a, int b){
        if((a>0 || a<1000000000)&&(b>0 || b<1000000000)){
		String binary = Integer.toBinaryString(a+b);
            	char[] item = binary.toCharArray();
            	String binaryResult = "";
		for(int i = 0; i<item.length; i++){
			if(item[i] == '1'){
				binaryResult = binaryResult +"1";
			}
		}
            	return Integer.valueOf(binaryResult);

        } else{
            return 0;
        }
    }
	
}
