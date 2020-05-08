# For Loops

This week, since there is not going to be a live discussion, we will only be reviewing material from this past week, and spending a bit of time putting everything we've learned so far together to see how, without learning about any new features, we can write some pretty cool things in Java! But as usual, let's start with the review:

## For-in loops
"For-in" loops, which we also called "for-each" loops, run the body of their loops once per element in a given array, in the other that they appear in the array, with the "loop variable" assigned to that element. (Side note: they are called that because we can read them as "*for each* element *in* the array, do ...")

Their syntax looks like:

```java
for (/* element type: */ /* variable name */: /* array */) {
    /* loop body */
}
```

For example, the following code snippet:

```java
String[] messages = {"Hello", "CSE11"};

for (String message: messages) {
    System.out.println(message);
}
```

prints

```log
Hello
CSE11
```

to the terminal. Notice that the element in the loop must match the type of the elements in the given array (`String` in the example above), but the loop variable name (`message` in the example above) can be any valid variable name in Java.

## Counted for loops
What we called "Counted for loop" in the readings is the other kind of loop that we have seen. Unlike for-in loops, these are not limited to running once per element in an array, and contrary to what their name might suggest, they are not even limited to counting!

Their syntax looks like:

```java
for (/* initializer */; /* condition */; /* update */) {
    /* body */
}
```

where:

- The loop "initializer" or "initialization statement" is run once at the very start of the loop. It _can_ be any Java statement, but we typically use it to create a loop variable that we can use in each iteration of the loop.

- The loop "condition" or "test" is checked _at the start_ of each iteration of the loop, and the loop exits when this condition is `false`. It _can_ be any boolean expression, but we typically use it to check some condition about the loop variable.

- The "update expression" is run _at the end_ of each iteration of the loop. It _can_ be any Java statement, but we typically use it to update the loop variable.

- The "loop body" is run for each iteration of the loop. It can be any block of code, similar to method bodies, and if statement bodies. In fact, as we will soon see, it can contain other loops!

For example, this loop:

```java
String[] messages = {"Hello", "CSE11"};

for (int i = 0; i < messages.length; i += 1) {
    System.out.println(messages[i]);
}
```

prints

```log
Hello
CSE11
```

to the terminal. Just like the for-in loop above!

Note that since the condition is checked at the start of each iteration, if it evalutes to `false` before the first iteration, a loop may not execute at all. For example this code:

```java
String[] messages = {"Hello", "CSE11"};

// Notice the new initilization statement
for (int i = 2; i < messages.length; i += 1) {
    System.out.println(messages[i]);
}
```

will not print anything, because before the first iteration, `i` is 2, and the condition `i < message.length` (which, if we replace each expression with its value becomes `2 < 2`) is `false`.

Counted for loops are much more powerful than for-in loops, because they allow us to define any looping that we want. For instance, we saw in lecture how we can use them to define a factorial method:

```java
int factorial(int n) {
    int result = 1;
    for (int i = n; i > 1; i -= 1) {
        result *= i;
    }
    return result;
}
```

While this example still created a loop variable named `i`, this time:
1. We initialize it to the number we are calculating the factorial of: `int i = n`
2. In each iteration, we update it to be one smaller than the previous value: `i -= 1`
3. We exit the loop when the loop variable is no greater than 1: `i > 1`
4. And instead of using the loop variable as an index to access array element, we use it to perform a math operation and store the results in an "accumulator" variable: `result *= i`

To summarize, counted for loops are executed like so:

1. Run the initialization statement.
2. Evaluate the loop condition. If it evaluates to false, exit the loop.
3. Evaluate the loop body.
4. Evaluate the update expression.
5. Go back to step 2.

which can be pictorially represented as:

```
                         (exit)
                            ^
                            | (false)
                            |
 ---------------      -------------   (true)   --------      ----------
|  initializer  | -> |  condition  | -------> |  body  | -> |  update  | -
 ---------------      -------------            --------      ----------   |
                           ^                                              |
                           |                                              |
                            ----------------------------------------------
```

## A Note on Loop Variable names
As we have seen multiple times in this class so far, picking meaningful variable names is a super importing part of keeping good code style, and it still applies to loop variables. With that in mind, here are some useful tips/conventions you might use when writing your own loop variables:

1. The loop variable of a for-in loop represents each element of the given array. So typically, we tend to name the arrays with a plural name (e.g. `messages`) and give the singular name to the loop variable (e.g. `message`).
2. Counted-for loop variables are often (though not always!) used as an _index_ of an array, or for keeping track of the _iteration_ of the loop. So frequently, especially when they are of the form `for (int i = 0; i < /* some value */; i += 1)`, we simply name them `i`, which is short of either `index` or `iteration`. If, however, you are _not_ simply going over indices of an array, or keeping track of iterations, but doing something more complicated or interesting, then it may be worthwhile to pick a better name for the loop variable to make it easier to understand.

# Problems
Write the contents of the method `visualize` in the `ARegion` abstract class.

It should return a `String` containing a visualization of that `Region` in a view spanning `xMin` to `xMax` in the _x_ direction, and `yMin` to `yMax` in the _y_ direction. In this view, any point that is `contain`ed in the `Region` should be represented as two `#` characters, and any point _not_ in the `Region` should be represented as two `_` characters. We have already implemented an example of calling this method in `Discussion06.java`, so when you are done, running

```log
$ javac -cp tester.jar:. Discussion06.java
$ java Discussion06
```

On Mac and Repl.it, or running:

```log
$ javac -cp tester.jar:%cd% Discussion06.java
$ java Discussion06
```

on Windows should print the following to the terminal:

```log
________________________________________
________________________________________
________________________________________
________________________________________
________________________________________
______________##############____________
____________##################__________
__________######################________
__________######################________
__________######################________
__________######################________
__________######################________
__________######################________
__________######################________
____________##################__________
______________##############____________
________________________________________
________________________________________
________________________________________
________________________________________
```

We have also implemented this as a test, so you can check your implementation by running:

```log
$ ./run Discussion06
```

on Mac and Repl.it, or

```log
$ .\run.bat Discussion06
```

on Windows.

Hint: This is a _very_ slight modification of [this](https://drive.google.com/file/d/157v75MQE_k0h-z9S3_tCVvaHIP-nvWFs/view?usp=sharing) lecture video. If you are stuck, I recommend watching the video until it reaches the point at which you are stuck, but pausing it immediately afterwards to continue work on the problem on your own.
