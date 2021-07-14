package cs445.rec9;

/**
 A linked implemention of the ADT list based on LList by:
 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 5.0
 Modified by:
 @author William C. Garrison III
 @author Brian T. Nixon
 @author Norhan Abbas
 */
public class LinkedList<E> implements ListInterface<E> {

    private Node head;            // Reference to first node of list
    private int  numberOfEntries;

    public LinkedList() {
        head = null;
        numberOfEntries = 0;
    }

    public void clear() {
        head = null;
        numberOfEntries = 0;
    }

    public void add(E newEntry) {
        //TODO: implement this method
    }

    public void add(int givenPosition, E newEntry) {
        //TODO: implement this method
    }

    public E remove(int givenPosition) {
        E result = null;
        // check for valid index value [0:numberOfEntries - 1]
        if ((givenPosition >= 0) && (givenPosition <= (numberOfEntries - 1) )) {
            assert !isEmpty();
            if (givenPosition == 0) {
                result = head.getData();
                head = head.getNextNode();
            } else {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                result = nodeToRemove.getData();
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter); //remove nodeToRemove from the list
            }
            numberOfEntries--;
            return result;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
        }
    }

    public E set(int givenPosition, E newEntry) {
        if ((givenPosition >= 0) && (givenPosition <= (numberOfEntries - 1))) {
            assert !isEmpty();
            Node desiredNode = getNodeAt(givenPosition);
            E originalEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
            return originalEntry;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to set operation");
        }
    }

    public E get(int givenPosition) {
        if ((givenPosition >= 0) && (givenPosition <= (numberOfEntries - 1))) {
            assert !isEmpty();
            return getNodeAt(givenPosition).getData();
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to get operation.");
        }
    }

    public E[] toArray() {
        @SuppressWarnings("unchecked")
        E[] result = (E[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = head;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        return result;
    }

    public boolean contains(E anEntry) {
        return indexOf(anEntry) >= 0;
    }

    public int indexOf(E entry) {
        if (entry == null || isEmpty()) {
            return -1;
        }
        int result = -1;
        int counter = 0;
        Node currentNode = head;

        while ((result == -1) && (currentNode != null)) {
            if (entry.equals(currentNode.getData())) {
                result = counter;
            } else {
                currentNode = currentNode.getNextNode();
                counter++;
            }
        }
        return result;
    }

    public int getSize() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * Returns a reference to the node at a given position.
     * Asserts that list is not empty and a valid index is given
     * @param givenPosition the index for the node to reference
     * @return the reference to the node at givenPosition
     */
    private Node getNodeAt(int givenPosition) {
        assert ((head != null) && (0 <= givenPosition) && (givenPosition <= (numberOfEntries - 1)));
        Node currentNode = head;

        // Traverse the list to locate the desired node
        // skipped if givenPosition is 0
        for (int counter = 0; counter < givenPosition; counter++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    /**
     * Inner Node class for use in LinkedList
    * Note that Node need not be defined as generic
    */
    private class Node {
        private E data;
        private Node next;

        private Node(E dataPortion) {
            data = dataPortion;
            next = null;
        }

        private Node(E dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        private E getData() {
            return data;
        }

        private void setData(E newData) {
            data = newData;
        }

        private Node getNextNode() {
            return next;
        }

        private void setNextNode(Node nextNode) {
            next = nextNode;
        }
    }

}

