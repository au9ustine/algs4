#!/bin/sh

./gradlew build
java -cp build/classes/java/main edu.princeton.cs.algs4.$1