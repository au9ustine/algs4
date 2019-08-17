#!/bin/sh

./gradlew build
time cat < src/main/resource/algs4-data/$2 | java -cp build/classes/java/main edu.princeton.cs.algs4.$1