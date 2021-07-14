package cs445.rec9;

/**
 A doubly linked implemention of the ADT list based on LList by:
 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 5.0
 Modified by:
 @author William C. Garrison III
 @author Brian T. Nixon
 @author Norhan Abbas
 */
public class DoublyLinkedList<E> implements ListInterface<E> {

    private Node head;            // Reference to first node of list
    private int  numberOfEntries;

    public DoublyLinkedList() {
        head = null;
        numberOfEntries = 0;
    }

    public void clear() {
        head = null;
        numberOfEntries = 0;
    }

    public void add(E newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            head = newNode;
        } else {
            Node lastNode = getNodeAt(numberOfEntries-1);
            lastNode.setNextNode(newNode);
            // set the previous of newNode
            newNode.setPreviousNode(lastNode);
        }
        numberOfEntries++;
    }

    public void add(int givenPosition, E newEntry) {
        // check for valid index value [0:numberOfEntries]
        if ((givenPosition >= 0) && (givenPosition <= numberOfEntries)) {
            Node newNode = new Node(newEntry);
            if (givenPosition == 0) {
                // if there was a previous head node, update next/previous
                if (head != null) {
                    newNode.setNextNode(head);
                    head.setPreviousNode(newNode);
                }
                head = newNode;
            } else {
                // If list is not empty
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
                // have to update previous references
                nodeAfter.setPreviousNode(newNode);
                newNode.setPreviousNode(nodeBefore);
            }
            numberOfEntries++;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to add operation.");
        }
    }

    public E remove(int givenPosition) {
        //TODO: implement this method
        return null; //update this return
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
        private Node previous;

        private Node(E dataPortion) {
            data = dataPortion;
            next = null;
            previous = null;
        }

        private Node(E dataPortion, Node nextNode, Node previousNode) {
            data = dataPortion;
            next = nextNode;
            previous = previousNode;
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

        private Node getPreviousNode() {
            return previous;
        }

        private void setPreviousNode(Node previousNode) {
            previous = previousNode;
        }
    }

}

