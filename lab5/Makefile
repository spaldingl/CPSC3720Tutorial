default: cpsc2150/setFun/MultiSetApp.java cpsc2150/setFun/DoubleSetApp.java cpsc2150/setFun/ListSet.java cpsc2150/setFun/ArraySet.java cpsc2150/setFun/ISet.java cpsc2150/setFun/SetAbs.java
	javac -Xlint cpsc2150/setFun/MultiSetApp.java cpsc2150/setFun/DoubleSetApp.java cpsc2150/setFun/ListSet.java cpsc2150/setFun/ArraySet.java cpsc2150/setFun/ISet.java cpsc2150/setFun/SetAbs.java

runInt: cpsc2150/setFun/MultiSetApp.class cpsc2150/setFun/ListSet.class cpsc2150/setFun/ArraySet.class cpsc2150/setFun/ISet.class cpsc2150/setFun/SetAbs.java
	java cpsc2150.setFun.MultiSetApp

runDouble: cpsc2150/setFun/DoubleSetApp.class cpsc2150/setFun/ListSet.class cpsc2150/setFun/ArraySet.class cpsc2150/setFun/ISet.class cpsc2150/setFun/SetAbs.java
	java cpsc2150.setFun.DoubleSetApp

clean:
	rm -f cpsc2150/setFun/*.class
