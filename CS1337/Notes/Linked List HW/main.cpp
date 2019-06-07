// This program implements the NumberList class and shows
// How linked lists perform
// Mario Bolivar - mjb160330 - CE
// CE 1337.501

#include <iostream>

using namespace std;


class NumberList
{
    private:
        // Declare a structure for the list
        struct ListNode{
            double value; // The value in this node
            struct ListNode *next; // To point to the next node
        };

        ListNode *head; // List head pointer 

    public:
        // Constructor
        NumberList()
        { head = NULL; }

        // Destructor
        ~NumberList();

        // Linked list operations
        void appendNode(double);
        void insertNode(double);
        void deleteNode(double);
        void displayList() const;
 };

 void NumberList::appendNode(double num){
    ListNode *newNode; // To point to a new node
    ListNode *nodePtr; // To move through the list

    // Allocate a new node and store num there.
    newNode = new ListNode;
    newNode->value = num;
    newNode->next = NULL;

    // If there are no nodes in the list
    // make newNode the first node.
    if (!head)
    head = newNode;
    else // Otherwise, insert newNode at end.
    {
        // Initialize nodePtr to head of list.
        nodePtr = head;

        // Find the last node in the list.
        while (nodePtr->next)
        nodePtr = nodePtr->next;

        // Insert newNode as the last node.
        nodePtr->next = newNode;
    }
 }

 void NumberList::insertNode(double num)
 {
    ListNode *newNode; // A new node
    ListNode *nodePtr; // To traverse the list
    ListNode *previousNode = NULL; // The previous node

    // Allocate a new node and store num there.
    newNode = new ListNode;
    newNode->value = num;

    // If there are no nodes in the list
    // make newNode the first node
    if (!head){
        head = newNode;
        newNode->next = NULL;
    }
    else // Otherwise, insert newNode
    {
        // Position nodePtr at the head of list.
        nodePtr = head;

        // Initialize previousNode to NULL.
        previousNode = NULL;

        // Skip all nodes whose value is less than num.
        while (nodePtr != NULL && nodePtr->value < num)
        {
            previousNode = nodePtr;
            nodePtr = nodePtr->next;
        }

        // If the new node is to be the 1st in the list,
        // insert it before all other nodes.
        if (previousNode == NULL)
        {
            head = newNode;
            newNode->next = nodePtr;
        }
        else // Otherwise insert after the previous node.
        {
            previousNode->next = newNode;
            newNode->next = nodePtr;
        }
    }
}

void NumberList::deleteNode(double num){
    ListNode *nodePtr; // To traverse the list
    ListNode *previousNode; // To point to the previous node

    // If the list is empty, do nothing.
    if (!head)
        return;
    // Determine if the first node is the one.
    if (head->value == num){
        nodePtr = head->next;
        delete head;
        head = nodePtr;
    }
    else{
        // Initialize nodePtr to head of list
        nodePtr = head;

        // Skip all nodes whose value member is
        // not equal to num.
        while (nodePtr != NULL && nodePtr->value != num){
            previousNode = nodePtr;
            nodePtr = nodePtr->next;
        }

        // If nodePtr is not at the end of the list,
        // link the previous node to the node after
        // nodePtr, then delete nodePtr.
        if (nodePtr){
           previousNode->next = nodePtr->next;
           delete nodePtr;
        }
    }
}

 void NumberList::displayList() const{
    ListNode *nodePtr; // To move through the list

    // Position nodePtr at the head of the list.
    nodePtr = head;

    // While nodePtr points to a node, traverse
    // the list.
    while (nodePtr){
        // Display the value in this node.
        cout << nodePtr->value << endl;

        // Move to the next node.
        nodePtr = nodePtr->next;
    }
}

NumberList::~NumberList(){
    ListNode *nodePtr; // To traverse the list
    ListNode *nextNode; // To point to the next node

     // Position nodePtr at the head of the list.
    nodePtr = head;

    // While nodePtr is not at the end of the list...
    while (nodePtr != NULL){
        // Save a pointer to the next node.
        nextNode = nodePtr->next;

        // Delete the current node.
        delete nodePtr;
        
        // Position nodePtr at the next node.
        nodePtr = nextNode;
    }
}

int main(){


    //Testing the class
    NumberList testList;

    testList.appendNode(1);
    testList.insertNode(2);
    testList.appendNode(3);
    testList.insertNode(4);
    testList.displayList();

    cout << endl;
    //deleting and displaying change
    testList.deleteNode(4);
    testList.displayList();
    
    cout << endl;
    testList.deleteNode(3);
    testList.displayList();
    
    cout << endl;
    testList.deleteNode(2);
    testList.displayList();
    
    cout << endl;
    testList.deleteNode(1);
    testList.displayList();
    
    testList.displayList();

    return 0;
}

