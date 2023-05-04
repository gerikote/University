package genericLinkedList;

public class GenericLinkedList<T> {
    private GenericNode<T> head;
    private int size;

    public GenericLinkedList() {
        this.head = null;
        size = 0;
    }

    public void addFirst(T data) {
        GenericNode newGenericNode = new GenericNode<>(data);
        newGenericNode.next = head;
        head = newGenericNode;
        size++;
    }

    public void addLast(T data) {
        GenericNode<T> newGenericNode = new GenericNode<>(data);
        if (head == null) {
            head = newGenericNode;
        } else {
            GenericNode<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newGenericNode;
        }
    }

    public void removeFirst() throws Exception {
        if (head == null) {
            throw new Exception("Linked list is empty");
        }
        head = head.next;
        size--;
    }

    public void removeLast() throws Exception {
        if (head == null) {
            throw new Exception("Linked list is empty");
        }
        if (head.next == null) {
            head = null;
        } else {
            GenericNode<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = null;
        }
        size--;
    }

    public T getFirst() throws Exception {
        if (head == null) {
            throw new Exception("Linked list is empty");
        }
        return head.data;
    }

    public T getLast() throws Exception {
        if (head == null) {
            throw new Exception("Linked list is empty");
        }
        GenericNode<T> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr.data;
    }

    public int size() {
        return size;
    }

    public String printList() {
        StringBuilder sb = new StringBuilder();
        GenericNode<T> curr = head;
        while (curr != null) {
            sb.append(curr.data).append(" ");
            curr = curr.next;
        }
        return sb.toString().trim();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAt(int index, T data) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bound for list of size " + size());
        }
        if (index == 0) {
            head = new GenericNode<T>(data);
        }else{
            GenericNode<T> prev= null;
            GenericNode<T> curr=head;
            for (int i=0;i<index;i++){
                prev=curr;
                curr=curr.next;
            }
            prev.next=new GenericNode<T>(data);
            prev.next.next=curr;
        }
    }

    public T get(int index){
        if(index<0|| index>=size()){
            throw new IndexOutOfBoundsException("Index " + index + " is out of bound for list of size " + size());
        }
        GenericNode<T> curr = head;
        for(int i=0; i<index;i++){
            curr=curr.next;
        }
        return curr.data;
    }

    public boolean remove(T data) {
        if (head == null) {
            return false;
        }

        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }

        GenericNode<T> curr = head;
        while (curr.next != null) {
            if (curr.next.data.equals(data)) {
                curr.next = curr.next.next;
                size--;
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

}
