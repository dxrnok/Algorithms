import java.util.*;
public class Link{
    public String data;
    public Link next;

    public Link(String datain){
        data = datain;
        // 'next' is automatically set to null
    }

    public static void main(String[] args){
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        String word;
        do{
            System.out.print("Enter a word: ");
            word = sc.nextLine();
            if(!word.toLowerCase().equals("end") && !word.toLowerCase().equals("")){
                list.addData(word);
            }
        }while(!word.toLowerCase().equals("end")); 
        sc.close();
        
        if(!list.isEmpty()){
            System.out.println("\n\u001B[35mWords in the linked list:\u001B[37m");
            list.displayList();
        }else{
            System.out.println("\n\u001B[31mLinked list is empty!\u001B[37m");
        }
    }
}