package com.company;
/*
Ali Alsaedi
Rick King
CS 3354.255 Object-Oriented design and programming
Pizza Queue
2/7/2022
 */
public class Pizza {
        public String ingrediants; // data type needed to defeine one of the objects being placed into pizza
        public String address; // data type needed to defeine one of the objects being placed into pizza
        Pizza next = null; // item of pizza with nothing in it used to traverse between first and last queue position
        Pizza(String ingrediants, String address)
        {

            this.address = address;
            this.ingrediants = ingrediants;
        }
    }

