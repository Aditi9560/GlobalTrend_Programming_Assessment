package assesmentsolutions;
import java.util.ArrayList;
import java.util.Iterator;
public class HandleConcurrentException{
		  public static void main(String[] args) {  
		        ArrayList<Integer> li = new ArrayList<>();  
		        li.add(1);  
		        li.add(2);  
		        li.add(3);  
		        li.add(4);  
		        li.add(5);  
		  
		        Iterator<Integer> it = li.iterator();  
		        while (it.hasNext()) {                   
		        Integer value = it.next();              
		            System.out.println("List Value:" + value);  
		            if (value.equals(3))  
		                it.remove();  
		        }  
		        
		        System.out.println("values after iteration" +li);
		     }  
		  }  




