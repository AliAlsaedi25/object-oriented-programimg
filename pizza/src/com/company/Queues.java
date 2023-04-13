package com.company;
/*
Ali Alsaedi
Rick King
CS 3354.255 Object-Oriented design and programming
Pizza Queue
2/7/2022
 */
public class Queues {
    private Pizza head = null; // first position in the queue is empty
    private Pizza tail = null; // last position in the queue is empty

    public void enqueue(Pizza thispizza)
    {
        if (head == null) head = thispizza; // if the first position is empty fill it in with the first order placed
	    else tail.next = thispizza; // otherwise the next order is now the last order in the queue before delivery
	    tail = thispizza; // last potion should always be filled with the last order placed
    }

    public Pizza dequeue()
    {
        Pizza pizzatodeliver = null; // no pizzas to deliver
        if (head != null)
        {
            /*
            if the first position is not empty you place that pizza at the head of the Queue than set the
            next pizza to the firt position so it can delivered next since we are using a queue
             */
            pizzatodeliver = head;
		    head = head.next;
        }
        if (head == null) tail = null; // if the first poition is empty that means all orders have been taken out
        return pizzatodeliver;
    }

    public void deliver()
    {
        Pizza thispizza = dequeue(); // calls the method and associates  it with pizza class
        if (thispizza == null) // if there are no pizzas to deliver than their are no deliveries
        {
            System.out.println ("No deliveries pending");
            return;
        }
        //otherwise say where and what pizza is delivered
        System.out.println ("Deliver a pizza with " + thispizza.ingrediants + " to " + thispizza.address);
    }
}
