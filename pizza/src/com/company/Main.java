package com.company;
/*
Ali Alsaedi
Rick King
CS 3354.255 Object-Oriented design and programming
Pizza Queue
2/7/2022
 */

public class Main {

    public static void main(String[] args) {
            Queues X = new Queues(); // first object decleration for the Queues class to run 2 queues at once
            /*
            both X1 and X2 have access to the methods created in the Queues class, since I declared them as
            "new Queues()"  we can now place objects in either queue, and object "thispizza" of the pizza class
            has places for these objects to be stored.
             */
            X.enqueue(new Pizza("pepperoni", "1234 Bobcat Trail"));
            X.enqueue(new Pizza("sausage", "2345 University Drive"));
            X.deliver();
            X.enqueue(new Pizza("extra cheese", "3456 Rickster Road"));
            X.enqueue(new Pizza("everything", "4567 King Court"));
            X.enqueue(new Pizza("coffee beans", "5678 Java Circle"));
            X.deliver();
            X.deliver();
            X.deliver();
            X.deliver();
            X.deliver();
            /*
            since we are using 2 queues at once the order for when X1 and X2 is used depends entirly on which pizza
            queue you want to deliver from
             */

    }
}
