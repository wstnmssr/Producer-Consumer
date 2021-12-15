JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	ProducerConsumer.java \
	Producer.java \
	Consumer.java \
	Buffer.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

pack:
	zip -v Musser-Westin-HW4.zip $(CLASSES) Makefile README.txt
