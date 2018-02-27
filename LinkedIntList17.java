// Class LinkedIntList can be used to store a list of integers.

public class LinkedIntList17 {

    /*
    Write a method called removeRange that accepts a starting and ending index as parameters and removes the elements at
    those indexes (inclusive) from the list. For example, if a variable list stores the values
    [8, 13, 17, 4, 9, 12, 98, 41, 7, 23, 0, 92] , the call of listRange.removeRange(3, 8); should remove values between
    index 3 and index 8 (the values 4 and 7 ), leaving the list of [8, 13, 17, 23, 0, 92] . The method should throw an
    IllegalArgumentException if either of the positions is negative. Otherwise you may assume that the positions
    represent a legal range of the list (0 ⱕ start ⱕ end ⬍ size).
     */

    public void removeRange(int iStart, int iEnd) {
        ListNode17 current = front;
        ListNode17 before;
        int counter = 0;

        while (counter < iStart - 1) {
            current = current.next;
            counter++;
        }

        before = current;

        while (counter <= iEnd) {
            current = current.next;
            counter++;
        }

        before.next = current;
    }

    // Everything below is copied from the book

    private ListNode17 front; // first value in the list

    // post: constructs an empty list
    public LinkedIntList17() {
        front = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode17 current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: returns comma-separated, bracketed version of list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode17 current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post: returns the position of the first occurrence of the
    // given value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode17 current = front;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode17(value);
        } else {
            ListNode17 current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode17(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode17(value, front);
        } else {
            ListNode17 current = nodeAt(index - 1);
            current.next = new ListNode17(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode17 current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode17 nodeAt(int index) {
        ListNode17 current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

}