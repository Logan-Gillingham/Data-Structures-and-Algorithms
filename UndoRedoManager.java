/**
 * Implememt an application that support undo/redo functionality. Use a linked list to maintain a sequence of states.\
 * Each state change is stored as a node in the list, allowoing for easy navigation
 * 1<>2<>3<>4<>5
 */

public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;
        private Node (T state) {
            this.state = state;
        }

    }
    private Node currentState;
    //Undo operation
    public T undo(){
        if (currentState == null || currentState.prev == null) {
            return null;
        }
        currentState = currentState.prev;
        return currentState.state;
    }

    //perform an operation
    public void  addState (T newState) {
        Node newNode = new Node(newState);
        if (currentState == null) {
            currentState = newNode;
        } else {
            currentState.next = newNode;
            newNode.prev = currentState;
            currentState = newNode;
        }
    }

    //Redo Operation
    public T redo(){
        if (currentState == null || currentState.next == null) {
            return null;
        }
        currentState = currentState.next;
        return currentState.state;
    }

    public static void main(String[] args) {
        UndoRedoManager<String> manager = new UndoRedoManager<>();

        manager.addState("State 1");
        manager.addState("State 2");
        manager.addState("State 3");

        System.out.println("Current State: " + manager.currentState.state); 

        System.out.println("Undo: " + manager.undo()); 
        System.out.println("Current State: " + manager.currentState.state); 

        System.out.println("Undo: " + manager.undo()); 
        System.out.println("Current State: " + manager.currentState.state);

        System.out.println("Undo: " + manager.undo()); 
        System.out.println("Current State: " + manager.currentState.state); 

        System.out.println("Redo: " + manager.redo());
        System.out.println("Current State: " + manager.currentState.state); 

        System.out.println("Redo: " + manager.redo()); 
        System.out.println("Current State: " + manager.currentState.state); 

        System.out.println("Redo: " + manager.redo()); 
        System.out.println("Current State: " + manager.currentState.state); 

        manager.addState("State 4");
        System.out.println("Current State: " + manager.currentState.state);

        System.out.println("Undo: " + manager.undo()); 
        System.out.println("Current State: " + manager.currentState.state); 


    }
}