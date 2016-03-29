package based;
import java.util.Scanner;
public class Main2{
    @SuppressWarnings("resource")
	public static void main(String args[]){
          Scanner reader=new Scanner(System.in);
          while(reader.hasNextInt()){
              int n=reader.nextInt();
              int m=reader.nextInt();
              if(n<10000&&m<1000){
            	  double sum=n;
            	  double num=n;
            	  m--;
            	  while(m>0){
            		  num=Math.sqrt(num);
            		  sum=sum+num;
            		  m--;
            	  }
                  System.out.printf("%.2f",sum);
              }
          }
    }
}