import java.util.HashMap;

class Node {

    char Data; /// data  me charactyer ayga
    HashMap<Character,Node> Children = new HashMap<>(); // hashmap me child and uska node 
    boolean isTerminal= false; // ya pe word bn rha hai ke nhi
    int count=0;  // to count the frequenct of word


    Node(Character c)
    {
    this.Data=c;
    count=1;
    }

}

class Trie{

    Node Root;

    Trie(){
    this.Root = new Node('*');
    }

    public void insert(String s)
    {
        Node Root=this.Root;
        for(int i=0;i<s.length();i++){
        Character ch = s.charAt(i);
      
        if(Root.Children.containsKey(ch))
        {
            Root= Root.Children.get(ch);
            Root.count=Root.count+1;
           
        }
        else{
            Node nn= new Node(ch);
            Root.Children.put(ch,nn);
            Root=nn;
        }

        }
        Root.isTerminal=true;


        System.out.println("string dl gai");

    }
    


    public boolean search(String s)  // Raj
    {
        Node Root=this.Root;
        for(int i=0;i<s.length();i++){
            Character ch = s.charAt(i);
        
            if(Root.Children.containsKey(ch))
            {
                Root= Root.Children.get(ch);
                Root.count=Root.count+1;
            
            }
            else{
            return false;
            }
        }

        return Root.isTerminal;

    }


    public boolean startsWith(String s)  // Raj
    {
        Node Root=this.Root;
        for(int i=0;i<s.length();i++){
            Character ch = s.charAt(i);
        
            if(Root.Children.containsKey(ch))
            {
                Root= Root.Children.get(ch);
            
            }
            else{
            return false;
            }
        }


        return true;

    }


    public int CountWord(String s)  // Raj
    {
        Node Root=this.Root;
        for(int i=0;i<s.length();i++){
            Character ch = s.charAt(i);
        
            if(Root.Children.containsKey(ch))
            {
                Root= Root.Children.get(ch);
            
            }
            else{
            return 0;
            }
        }

        return Root.count;

    }



    public static void main(String[] args) {


        Trie tt = new Trie();

        tt.insert("Rajat");
        tt.insert("Ravi");
        tt.insert("Ram");
        tt.insert("Raj");
        tt.insert("Raju");
        tt.insert("Rahul");
        tt.insert("Mity Raju");




        System.out.println(tt.CountWord("R"));

        System.out.println(tt.startsWith("Ram"));
        
    }




    



    
}
