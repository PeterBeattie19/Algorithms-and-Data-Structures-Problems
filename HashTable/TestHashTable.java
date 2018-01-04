public class TestHashTable {
  public static void main(String[] args) {

    HashTable table = new HashTable(10);

    for(int i = 1; i<=10; i++){
      table.insert(new DataItem(i));
    }

    table.displayTable();
  }
}
