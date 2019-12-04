default: cpsc2150/setFun/MultiSetApp.java cpsc2150/setFun/DoubleSetApp.java cpsc2150/setFun/ListSet.java cpsc2150/setFun/ArraySet.java cpsc2150/setFun/ISet.java cpsc2150/setFun/SetAbs.java
	javac -Xlint cpsc2150/setFun/MultiSetApp.java cpsc2150/setFun/DoubleSetApp.java cpsc2150/setFun/ListSet.java cpsc2150/setFun/ArraySet.java cpsc2150/setFun/ISet.java cpsc2150/setFun/SetAbs.java

runInt: cpsc2150/setFun/MultiSetApp.class cpsc2150/setFun/ListSet.class cpsc2150/setFun/ArraySet.class cpsc2150/setFun/ISet.class cpsc2150/setFun/SetAbs.java
	java cpsc2150.setFun.MultiSetApp

runDouble: cpsc2150/setFun/DoubleSetApp.class cpsc2150/setFun/ListSet.class cpsc2150/setFun/ArraySet.class cpsc2150/setFun/ISet.class cpsc2150/setFun/SetAbs.java
	java cpsc2150.setFun.DoubleSetApp

test: cpsc2150/setFun/TestListSet.java cpsc2150/setFun/TestArraySet.java cpsc2150/setFun/DoubleSetApp.java cpsc2150/setFun/ListSet.java cpsc2150/setFun/ArraySet.java cpsc2150/setFun/ISet.java cpsc2150/setFun/SetAbs.java
	javac -cp .:/usr/share/java/junit4.jar cpsc2150/setFun/TestListSet.java cpsc2150/setFun/TestArraySet.java cpsc2150/setFun/DoubleSetApp.java cpsc2150/setFun/ListSet.java cpsc2150/setFun/ArraySet.java cpsc2150/setFun/ISet.java cpsc2150/setFun/SetAbs.java

testList: cpsc2150/setFun/TestListSet.class cpsc2150/setFun/DoubleSetApp.class cpsc2150/setFun/ListSet.class cpsc2150/setFun/ArraySet.class cpsc2150/setFun/ISet.class cpsc2150/setFun/SetAbs.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.setFun.TestListSet

testArr:cpsc2150/setFun/TestArraySet.class cpsc2150/setFun/DoubleSetApp.class cpsc2150/setFun/ListSet.class cpsc2150/setFun/ArraySet.class cpsc2150/setFun/ISet.class cpsc2150/setFun/SetAbs.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.setFun.TestArraySet

clean:
	rm -f cpsc2150/setFun/*.class

