package hw3.OneWayLnList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Однонаправленный связанный список");

        MyLnListOneWay<Integer> myList = new MyLnListOneWay<>();
        myList.add(17);
        myList.add(19);
        myList.add(21);
        myList.add(47);
        myList.add(53);
        myList.add(19);
        System.out.println(myList.toString());

        myList.revert();
        System.out.println(myList.toString());

        System.out.println("Двунаправленный связанный список");
        MyLnListTwoWay<Integer> myList1 = new MyLnListTwoWay<>();
        myList1.addFirst(117);
        myList1.addLast(119);
        myList1.addLast(121);
        myList1.addLast(147);
        myList1.addLast(153);
        myList1.addLast(119);
        System.out.println(myList1.toString());

        myList1.delLast();
        myList1.delFirst();
        System.out.println(myList1.toString());

        myList1.revert();
        System.out.println(myList1.toString());
    }
}
