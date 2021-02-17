# base32h.java

## What is it?

It's the Java implementation for  https://base32h.github.io/

In Work in Progress

- Encode Binary 
- Decode Binary
- Clean Up and Test Cases


## How to use?

```
base32h.encode(17854910)
--> [H, 0, W, D, Y]

base32h.decode("88pzd")
--> 8675309

base32h.encodeBin([227,169,72,131,141,245,213,150,217,217])
-->[W, E, L, L, H, 0, W, D, Y, P, A, R, D, N, E, R]

base32h.decodeBin("2060W2G6009")
-->[0, 0, 0, 8, 6, 7, 5, 3, 0, 9]
```
