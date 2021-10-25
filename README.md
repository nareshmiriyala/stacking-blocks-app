# Stacking Blocks Application

This application stacks the given blocks and provides the maximum height.

## Use case

```
Stacking blocks Application
Press CTRL+Z on windows and CTRL+D on Mac OS to exit...
Please input blocks:
[[50,45,20],[95,37,53],[45,23,12]]
Total height is: 190
Please input blocks:
[[38,25,45],[76,35,3]]
Total height is: 76
Please input blocks:
[[7,11,17],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]
Total height is: 102
```

## Build and run instructions

- build

```
./gradlew build
```

- package

```
jar: ./gradlew jar
```

- run

```
java -jar /build/libs/stacking-blocks-app-0.0.1-SNAPSHOT.jar
```