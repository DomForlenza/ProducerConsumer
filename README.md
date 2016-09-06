README for Producer/Consumer Java Program
==============

-----Created by Dominick Forlenza-----

|--Buffer.java--|
Buffer.java implements the FIFO circular buffer and has implemented the consume and produce functions.

|--Consumer.java--|
Implementation of the consumer - includes a running count of consumed doubles and prints appropriately.

|--Producer.java--|
Implementation of the producer - includes a running count of produced doubles and prints appropriately.

|--ProducerConsumer.java--|
Main driver program that creates producer and consumer threads and starts them.

|--Makefile--|

   --The Makefile runs the following:
     --"make all"
     --"make clean"


To compile:
    Type "make all" in terminal

To run:
    java ProducerConsumer
    

