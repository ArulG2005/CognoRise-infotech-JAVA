import java.util.ArrayList;

public class Books {

    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> author = new ArrayList<>();
    ArrayList<Integer> stock = new ArrayList<>();

    void Add_book(String title, String author, int stock) {
        if (!this.title.contains(title) || !this.author.contains(author)) {
            this.title.add(title);
            this.author.add(author);
            this.stock.add(stock);
            System.out.println("");
            System.out.println("Add Successfuly....");
            System.out.println("");
        }

    }

    void del(String name) {
        int index = this.title.indexOf(name);
        if (index != -1) {
            title.remove(index);
            author.remove(index);
            stock.remove(index);
            System.out.println("");
            System.out.println("Remove Successfully....");
            System.out.println("");
        } else {
            System.out.println("Title not found. Remove failed.");
            System.out.println("");
        }
    }
    void search(String query, String searchBy) {
        int index = -1;

        if ("title".equalsIgnoreCase(searchBy)) {
            index = this.title.indexOf(query);
        } else if ("author".equalsIgnoreCase(searchBy)) {
            index = this.author.indexOf(query);
        }

        if (index != -1) {
            System.out.println("");
            System.out.println("Title\t" + "      " + "Author\t" + "       " + "Stock\t");
            System.out.println("");
            System.out.println(this.title.get(index) + "              " + this.author.get(index) + "          " + this.stock.get(index));
            System.out.println("");
        } else {
            System.out.println("Not Available");
            System.out.println("");
        }
    }

   
    void ingstock(String name,int n){
        int index=this.title.indexOf(name);
        if(index!=-1){
        this.stock.add(index,n);
        System.out.println("");
        System.out.println("Update Successfully");
        System.out.println("");
        }
    }
    void upgrade(String title,String newtitle,String author,int stock){
        int index=this.title.indexOf(title);
        this.title.add(index,newtitle);
        this.author.add(index,author);
        this.stock.add(index,stock);
         System.out.println("");
        System.out.println("Upgrade Successfully");
        System.out.println("");
    }
}