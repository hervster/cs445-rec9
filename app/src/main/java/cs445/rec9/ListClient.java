package cs445.rec9;

/**
 A simple client to display usage of LinkedList and
 DoublyLinkedList.
 @author William C. Garrison III
 @author Brian T. Nixon
 @author Norhan Abbas
 */
public class ListClient {

    public static void main(String[] args) {
        String[] testStrings = {"Data", "Structures", "and", "Algorithms", "are", "fun", "to", "learn"};
        ListInterface<String> singleLink = new LinkedList<String>();
        ListInterface<String> doubleLink = new DoublyLinkedList<String>();
        if (args.length > 1) {
            testStrings = args;
        }
        // Add all testStrings
        for (String str : testStrings) {
            singleLink.add(str);
            doubleLink.add(str);
        }
        printLists(singleLink, doubleLink);
        // remove "Data Structures and Algorithms"
        for (int i = 0; i < 4; i++) {
            singleLink.remove(0);
            doubleLink.remove(0);
        }
        // Add "Computer Science" to front
        singleLink.add(0, "Computer");
        doubleLink.add(0, "Computer");
        singleLink.add(1, "Science");
        doubleLink.add(1, "Science");
        // replace "are" with "is"
        singleLink.set(2, "is");
        doubleLink.set(2, "is");
        printLists(singleLink, doubleLink);
        // clear both lists
        singleLink.clear();
        doubleLink.clear();
        System.out.println("Singly-LinkedList is empty:\t" + (singleLink.isEmpty()));
        System.out.println("Doubly-LinkedList is empty:\t" + (doubleLink.isEmpty()));
        printLists(singleLink, doubleLink);
    }

    public static <T> void printLists(ListInterface<T> singleList, ListInterface<T> doubleList) {
        System.out.println("Contents of Singly-LinkedList:");
        printContents(singleList);
        System.out.println("Contents of Doubly-LinkedList:");
        printContents(doubleList);
        System.out.println("\n");
    }

    public static <T> void printContents(ListInterface<T> toPrint) {
        T[] contents = toPrint.toArray();
        System.out.print("[");
        for (int i = 0; i < contents.length; i++) {
            if (i == contents.length - 1) {
                System.out.print(contents[i]);
            } else {
                System.out.print(contents[i] + ", ");
            }
        }
        System.out.println("]");
    }

}

