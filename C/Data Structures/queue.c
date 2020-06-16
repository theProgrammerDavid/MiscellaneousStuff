#include <stdlib.h>
#include <stdio.h>
#include <limits.h>

typedef struct node
{

    int val;
    struct node *next;

} node;

typedef struct
{
    node *head;
    node *tail;

} queue;

void init_queue(queue *q)
{
    q->head = NULL;
    q->tail = NULL;
}

int enqueue(queue *q, int value)
{
    // create a new node
    node *newNode = (node *)malloc(sizeof(node));
    if (newNode == NULL)
        return 0;
    newNode->val = value;
    newNode->next = NULL;

    //if  atail exists, then add it after that tail
    if (q->tail != NULL)
    {
        q->tail->next = newNode;
    }

    q->tail = newNode;

    //update the head pointer
    if (q->head == NULL)
    {
        q->head = newNode;
    }

    return 1;
}

int dequeue(queue *q)
{
    if (q->head == NULL)
    {
        return INT_MIN;
    }

    node *tmp = q->head;
    int val = tmp->val;
    q->head = q->head->next;
    
    if (q->head == NULL)
    {
        q->tail = NULL;
    }

    free(tmp);
    return val;
}

int main()
{
    queue q1;
    init_queue(&q1);

    enqueue(&q1,10);
    enqueue(&q1,11);
    enqueue(&q1,12);
    enqueue(&q1,13);
    enqueue(&q1,14);
    enqueue(&q1,15);

    int i;

    while((i = dequeue(&q1))!=INT_MIN){
        printf("%d ", i);
    }

    return 0;
}