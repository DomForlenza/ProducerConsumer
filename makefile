#JAVA MAKEFILE FOR PRODUCERCONSUMER
#DOMINICK FORLENZA - 4/12/16

JAVAC=javac
sources = $(wildcard *.java)
classes = $(sources:.java=.class)

all: $(classes)

clean :
	rm -f *.class

%.class : %.java
	$(JAVAC) $<